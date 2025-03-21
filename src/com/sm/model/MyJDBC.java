package com.sm.model;

import java.sql.*;

public class MyJDBC {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/student_management",
                    "root",
                    "Segun25!"
            );

            Statement statement = connection.createStatement();
            long start = System.nanoTime();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENTS WHERE name = 'kenny'");
            resultSet.next();
            System.out.println(resultSet.getString("name") + " " + resultSet.getInt("age"));
            long timeElapsed = System.nanoTime() - start;
            System.out.println("Time in Nanoseconds:" + timeElapsed);
            System.out.println("Time in milliseconds: " + (timeElapsed / 1000000));
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
