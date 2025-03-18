package com.sm.model;

import java.io.*;
import java.util.HashMap;

public class Model implements Serializable {
    // To avoid "invalid class" errors during deserialization
    private static final long serialVersionUID = 1L;
    private HashMap<String, HashMap<String, Integer>> database;

    public Model() {
        this.database = new HashMap<>();
    }

    // add to database
    public void addEntry(String name, HashMap<String, Integer> values) {
        database.put(name, values);
    }

    // retrieve from database
    public HashMap<String, Integer> getEntry(String key) {
        return database.get(key);
    }

    // Method to serialize (save) the database to a file
    public void saveDatabase(File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(database);  // Serialize the HashMap object to a file
        } catch (IOException e) {
            System.out.println("Error saving database: " + e.getMessage());
        }
    }

    // Method to deserialize (load) the database from a file
    @SuppressWarnings("unchecked")
    public HashMap<String, HashMap<String, Integer>> loadDatabase(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (HashMap<String, HashMap<String, Integer>>) ois.readObject();  // Deserialize the HashMap from the file
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading database: " + e.getMessage());
            return null;  // Return null if loading fails
        }
    }
}
