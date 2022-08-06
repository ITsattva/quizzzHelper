package org.example.view;

import org.example.db.DBHelper;
import org.example.model.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UI extends JFrame{
    private DBHelper dbHelper = new DBHelper();

    private JLabel tableLabel = new JLabel("Choose correct table:");
    private String[] tables = {"sport", "muscles"};
    private JComboBox optionPane = new JComboBox(tables);

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
        super("Quizzz Helper");
        this.setBounds(450, 200, 400, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(7, 0, 2, 2));

        container.add(tableLabel);
        container.add(optionPane);

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

        button.addActionListener(new ButtonListener());
    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String desc = question.getText();
            String answ1 = rightAnswer.getText();
            String answ2 = answer1.getText();
            String answ3 = answer2.getText();
            String answ4 = answer3.getText();
            String table = optionPane.getSelectedItem().toString();
            System.out.println(table);
            dbHelper.setTable(table);

            Question dbquestion = new Question(desc, answ1, answ2, answ3, answ4);
            try {
                dbHelper.insertIntoDB(dbquestion);
                JOptionPane.showMessageDialog(null, "Question has been added to database", "OUTPUT", JOptionPane.PLAIN_MESSAGE);
                clearFields();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "An error has been occurred", "OUTPUT", JOptionPane.PLAIN_MESSAGE);

                throw new RuntimeException(ex);
            }

        }

        public void clearFields(){
            question.setText("");
            rightAnswer.setText("");
            answer1.setText("");
            answer2.setText("");
            answer3.setText("");
        }
    }
}
