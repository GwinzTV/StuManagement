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
                    String studentName = View.getName();
                    // pull info from database then insert into data
                    HashMap<String, Integer> info = model.getEntry(studentName);
                    int studentID = info.get("studentID");
                    int studentAge = info.get("studentAge");
                    View.viewStudent(new Object[]{studentName, studentID, studentAge});
                    break;
                case 3:
                    // edit student info
                    break;
                case 4:
                    // delete student info
                    break;
                case 5:
                    // view all student info
                    break;
                case 6:
                    // save info
                    model.saveDatabase(file);
                    view.displayMessage("Database saved to file.");
                    break;
                case 7:
                    // exit:
                    view.closeScanner();
                    return;
                default:
                    System.out.println("Invalid choice, please try again");
            }
        }
    }
}
