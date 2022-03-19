package com.vedansh.passwordgenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    private static JButton button;
    private static JTextField passwordField, keyField, encryptedPasswordField;
    private static JLabel passwordLabel, keyLabel, encryptedPasswordLabel;

    public static void main(String[] args) {
        JFrame passwordGenerator = new JFrame();
        passwordGenerator.setTitle("Password Generator");
        passwordGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        passwordGenerator.setSize(400,300);
        passwordLabel = new JLabel("Enter Password");
        passwordLabel.setBounds(15, 50, 110, 30);

        passwordField = new JTextField();
        passwordField.setBounds(150,50, 200,30);

        keyLabel = new JLabel("Enter Key");
        keyLabel.setBounds(15, 100, 110, 30);

        keyField = new JTextField();
        keyField.setBounds(150,100, 200,30);

        encryptedPasswordLabel = new JLabel("Encrypted Password");
        encryptedPasswordLabel.setBounds(15, 150, 135, 30);

        encryptedPasswordField = new JTextField();
        encryptedPasswordField.setBounds(150, 150, 200,30);
        encryptedPasswordField.setEditable(false);

        button = new JButton("Generate Password");
        button.setBounds(125,200,150,30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == button) {
                    PasswordGenerator obj = new PasswordGenerator(passwordField.getText(), keyField.getText());
                    encryptedPasswordField.setText(obj.encryptPassword());
                }
            }
        });

        passwordGenerator.add(passwordLabel);
        passwordGenerator.add(passwordField);
        passwordGenerator.add(keyLabel);
        passwordGenerator.add(keyField);
        passwordGenerator.add(encryptedPasswordLabel);
        passwordGenerator.add(encryptedPasswordField);
        passwordGenerator.add(button);

        passwordGenerator.setLayout(null);
        passwordGenerator.setVisible(true);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}
