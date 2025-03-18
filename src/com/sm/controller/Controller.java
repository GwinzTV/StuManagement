package com.sm.controller;

import com.sm.model.Model;
import com.sm.view.View;

import java.io.File;
import java.util.HashMap;

public class Controller {
    private Model model;
    private View view;
    private File file;

    public Controller(Model model, View view, File file) {
        this.model = model;
        this.view = view;
        this.file = file;

        if (file.exists()) {
            model.loadDatabase(file);
        }
    }

    public void Start() {
        view.welcome();
        while (true) {
            int choice = view.mainOptions();
            switch (choice) {
                case 1:
                    Object[] data = view.registerStudent();
                    int id = (Integer) data[0];
                    String name = (String) data[1];
                    int age = (Integer) data[2];
                    HashMap <String, Integer> values = new HashMap<>();
                    values.put("studentID", id);
                    values.put("studentAge", age);
                    model.addEntry(name, values);
                    break;
                case 2:
                    String studentName = view.getName();
                    // pull info from database then insert into data
                    if (model.checkExists(studentName)) {
                        HashMap<String, Integer> info = model.getEntry(studentName);
                        int studentID = info.get("studentID");
                        int studentAge = info.get("studentAge");
                        view.viewStudent(new Object[]{studentName, studentID, studentAge});
                    } else {
                        view.displayMessage("Student Not Found");
                    }
                    break;
                case 3:
                    // edit student info
                    String key = view.getName();
                    if (model.checkExists(key)) {
                        HashMap <String, Integer> info2 = model.getEntry(key);
                        info2.put("studentAge", view.updateStudent());
                    } else {
                        view.displayMessage("Key not found.");
                    }
                    break;
                case 4:
                    // delete student info
                    if (model.deleteEntry(view.getName())) {
                        view.displayMessage("Entry deleted.");
                    } else {
                        view.displayMessage("Key not found.");
                    }
                    break;
                case 5:
                    // view all student info
                    view.displayAllEntries(model.getAllEntries());
                    break;
                case 6:
                    // save info
                    model.saveDatabase(file);
                    view.displayMessage("Database saved to file.");
                    break;
                case 0:
                    // exit:
                    model.saveDatabase(file);
                    view.displayMessage("Exiting Program and saving database...");
                    view.closeScanner();
                    return;
                default:
                    view.displayMessage("Invalid choice, please try again");
            }
        }
    }
}
