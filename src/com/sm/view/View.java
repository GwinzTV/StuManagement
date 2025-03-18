package com.sm.view;

import com.sm.controller.Controller;
import java.util.Scanner;

public class View {
    private Scanner scanner;
    private static int id = 0;

    public void welcome() {
        System.out.println("\nWelcome to Student Management System\n");
    }

    public int mainOptions() {
        System.out.println("Select a number for the option you require");
        System.out.println("[1] Register Student");
        System.out.println("[2] View Student Information");
        System.out.println("[3] Edit Student Information");
        System.out.println("[4] Delete Student Information");
        System.out.println("[5] View All Students Information");
        System.out.println("[6] Exit Program");
        return scanner.nextInt();
    }

    public Object[] registerStudent() {
        id++;
        int studentID = id;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        String studentName = scanner.next();
        System.out.print("Enter Student age: ");
        int studentAge = scanner.nextInt();
        return new Object[]{studentID, studentName, studentAge};
    }

    public static void viewStudent(Object[] data) {
        // implement the retrieved data into a view:
        System.out.println("\nStudent Name: " + data[0]);
        System.out.println("Student ID: " + data[1]);
        System.out.println("Student Age: " + data[2]);
    }

    public static String getName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        return scanner.next();
    }
}
