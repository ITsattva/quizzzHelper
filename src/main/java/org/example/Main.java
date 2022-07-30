package org.example;

import org.example.view.UI;

import java.sql.*;

public class Main {
//    private static Connection connection = null;
//
//    static {
//        try {
//            Class.forName("org.sqlite.JDBC");
//            connection = DriverManager.getConnection("jdbc:sqlite:c:\\SQLite\\questions.db");
//            System.out.println("Connected to DB");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static void main(String[] args) throws SQLException {
        UI gui = new UI();
        gui.setVisible(true);
    }
}
