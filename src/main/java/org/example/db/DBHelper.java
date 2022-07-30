package org.example.db;

import org.example.model.Question;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper {

    private static Connection connection = null;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\SQLite\\questions.db");
            System.out.println("Connected to DB");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertIntoDB(Question question) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO sport(description, answer1, answer2, answer3, answer4) VALUES (?, ?, ?, ?, ?)");
        statement.setString(1, question.getDescription());
        statement.setString(2, question.getAnswer1());
        statement.setString(3, question.getAnswer2());
        statement.setString(4, question.getAnswer3());
        statement.setString(5, question.getAnswer4());

        statement.executeUpdate();
        statement.close();
    }

}
