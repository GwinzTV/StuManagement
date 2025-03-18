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

    // get all entries
    public HashMap<String, HashMap<String, Integer>> getAllEntries() {
        return database;
    }

    public boolean deleteEntry(String key) {
        return database.remove(key) != null;
    }

    public boolean checkExists(String key) {
        return database.containsKey(key);
    }

    // Method to serialize (save) the database to a file
    public void saveDatabase(File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(database);
        } catch (IOException e) {
            System.out.println("Error saving database: " + e.getMessage());
        }
    }

    // Method to deserialize (load) the database from a file
    @SuppressWarnings("unchecked")
    public void loadDatabase(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            database = (HashMap<String, HashMap<String, Integer>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading database: " + e.getMessage());
        }
    }
}
