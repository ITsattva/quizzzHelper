package org.example.db;

import org.example.model.Question;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper {

    private static Connection connection = null;
    private static String table = "";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\SQLite\\questions.db");
            table = "sport";
            System.out.println("Connected to DB");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertIntoDB(Question question) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO " + table + " (description, answer1, answer2, answer3, answer4) VALUES (?, ?, ?, ?, ?)");
        System.out.println(statement.toString());
        statement.setString(1, question.getDescription());
        statement.setString(2, question.getAnswer1());
        statement.setString(3, question.getAnswer2());
        statement.setString(4, question.getAnswer3());
        statement.setString(5, question.getAnswer4());

        statement.executeUpdate();
        statement.close();
    }

    public void setTable(String table){
        this.table = table;
    }

}
