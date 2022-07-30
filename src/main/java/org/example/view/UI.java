package org.example.view;

import org.example.db.DBHelper;
import org.example.model.Question;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.EventListener;
import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;

public class UI extends JFrame{
    private DBHelper dbHelper = new DBHelper();
    private JButton button = new JButton("Send question to DataBase");
    private JLabel labelQuestion = new JLabel("Enter question's description:");
    private JTextField question = new JTextField("", 5);
    private JLabel labelAnswer = new JLabel("Enter right answer:");
    private JTextField rightAnswer = new JTextField("", 5);
    private JLabel labelFaultedAnswers = new JLabel("Enter additional faulted answers:");
    private JLabel first = new JLabel("first faulted:");
    private JLabel second = new JLabel("second faulted:");
    private JLabel third = new JLabel("third faulted:");
    private JTextField answer1 = new JTextField("", 5);
    private JTextField answer2 = new JTextField("", 1);
    private JTextField answer3 = new JTextField("", 5);

    public UI() {
        super("Main frame");
        this.setBounds(450, 200, 400, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(6, 3, 2, 2));
        container.add(labelQuestion);
        container.add(question);
        container.add(labelAnswer);
        container.add(rightAnswer);
        container.add(first);
        container.add(answer1);
        container.add(second);
        container.add(answer2);
        container.add(third);
        container.add(answer3);
        container.add(button);

        button.addActionListener(new Listener());
    }

    class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String desc = question.getText();
            String answ1 = rightAnswer.getText();
            String answ2 = answer1.getText();
            String answ3 = answer2.getText();
            String answ4 = answer3.getText();

            Question dbquestion = new Question(desc, answ1, answ2, answ3, answ4);
            try {
                dbHelper.insertIntoDB(dbquestion);
                JOptionPane.showMessageDialog(null, "Question has been added to database", "OUTPUT", JOptionPane.PLAIN_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "An error has been occurred", "OUTPUT", JOptionPane.PLAIN_MESSAGE);

                throw new RuntimeException(ex);
            }

        }
    }
}
