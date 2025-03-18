package com.sm.view;

import com.sm.controller.Controller;

import java.util.HashMap;
import java.util.Scanner;

public class View {
    private Scanner scanner;
    private static int id = 0;

    public View(){
        this.scanner = new Scanner(System.in);
    }

    public void welcome() {
        System.out.println("\nWelcome to Student Management System");
    }

    public int mainOptions() {
        System.out.println("\nSelect a number for the option you require");
        System.out.println("[1] Register Student");
        System.out.println("[2] View Student Information");
        System.out.println("[3] Edit Student Information");
        System.out.println("[4] Delete Student Information");
        System.out.println("[5] View All Students Information");
        System.out.println("[6] Save");
        System.out.println("[0] Exit Program");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public Object[] registerStudent() {
        System.out.print("\nEnter student ID: ");
        int studentID = scanner.nextInt();
        System.out.print("Enter Student Name: ");
        String studentName = scanner.next();
        System.out.print("Enter Student age: ");
        int studentAge = scanner.nextInt();
        return new Object[]{studentID, studentName, studentAge};
    }

    public int updateStudent() {
        System.out.print("Enter updated Student age: ");
        return scanner.nextInt();
    }

    public void viewStudent(Object[] data) {
        // implement the retrieved data into a view:
        System.out.println("\nStudent Name: " + data[0]);
        System.out.println("Student ID: " + data[1]);
        System.out.println("Student Age: " + data[2]);
    }

    public String getName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        return scanner.next();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayAllEntries(HashMap<String, HashMap<String, Integer>> database) {
        for (HashMap.Entry<String, HashMap<String, Integer>> entry : database.entrySet()) {
            System.out.println("-----------------------------");
            System.out.println("studentName: " + entry.getKey());
            for (HashMap.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
                System.out.println(entry2.getKey() + ": " + entry2.getValue());
            }
        }
        System.out.println("-----------------------------");
    }

    public void closeScanner() {
        scanner.close();
    }
}
