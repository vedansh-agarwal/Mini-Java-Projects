package com.vedansh.binaryoperations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private static BinaryOperations obj = new BinaryOperations();
    private static JButton button;
    private static JTextField num1Field, num2Field, result1Field, result2Field;
    private static JLabel num1Label, num2Label, result1Label, result2Label, operatorLabel;
    private static JComboBox operator;
    private static int op;

    public static void main(String[] args) {
        JFrame binaryOperations = new JFrame();
        binaryOperations.setTitle("Binary Operations");
        binaryOperations.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        binaryOperations.setSize(350,400);
        binaryOperations.setResizable(false);

        num1Label = new JLabel("Binary Number 1");
        num1Label.setBounds(10, 30, 105, 30);

        num1Field = new JTextField();
        num1Field.setBounds(125,30, 200,30);

        num2Label = new JLabel("Binary Number 2");
        num2Label.setBounds(10, 80, 105, 30);

        num2Field = new JTextField();
        num2Field.setBounds(125,80, 200,30);

        operatorLabel = new JLabel("Operation");
        operatorLabel.setBounds(10,130,150,30);

        String operators[] = {"Addition", "Subtraction", "Multiplication", "Division (fraction)", "Division (remainder)", "Binary to Decimal", "Decimal to Binary", "2's Complement"};
        operator = new JComboBox(operators);
        operator.setBounds(125,130,200,30);
        operator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = operator.getSelectedIndex();
                if(op > 4) {
                    num2Label.setVisible(false);
                    num2Field.setVisible(false);
                    num1Label.setText((op == 6)?"Decimal Number":"Binary Number");
                }
                else {
                    num2Label.setVisible(true);
                    num2Field.setVisible(true);
                    num1Label.setText("Binary Number 1");
                }
            }
        });

        button = new JButton("Output");
        button.setBounds(135,180,80,30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s[];
                switch(op) {
                    case 0: result1Field.setText(obj.add(num1Field.getText(), num2Field.getText()));
                            result1Label.setText("Sum");
                            changeVisibility();
                            break;
                    case 1: s = obj.subtract(num1Field.getText(), num2Field.getText());
                            result1Field.setText(s[0]);
                            result1Label.setText("Difference");
                            changeVisibility();
                            if(s[1].length() != 0)
                                changeVisibility1(s[1], "2's Complement");
                            break;
                    case 2: result1Field.setText(obj.multiply(num1Field.getText(), num2Field.getText()));
                            result1Label.setText("Product");
                            changeVisibility();
                            break;
                    case 3: result1Field.setText(obj.divideFraction(num1Field.getText(), num2Field.getText()));
                            result1Label.setText("Quotient");
                            changeVisibility();
                            break;
                    case 4: s = obj.divide(num1Field.getText(), num2Field.getText());
                            result1Field.setText(s[0]);
                            result1Label.setText("Quotient");
                            changeVisibility();
                            if(!s[1].equals("0"))
                                changeVisibility1(s[1], "Remainder");
                            break;
                    case 5: String str = Double.toString(obj.binaryToDecimal(num1Field.getText()));
                            if(str.indexOf(".0") == str.length()-2)
                                str = str.substring(0,str.indexOf(".0"));
                            result1Field.setText(str);
                            result1Label.setText("Decimal Number");
                            changeVisibility();
                            break;
                    case 6: result1Field.setText(obj.decimalToBinary(Double.parseDouble(num1Field.getText())));
                            result1Label.setText("Binary Number");
                            changeVisibility();
                            break;
                    case 7: result1Field.setText(obj.twosComplement(num1Field.getText()));
                            result1Label.setText("2's Complement");
                            changeVisibility();
                }
            }
            public void changeVisibility() {
                result1Field.setVisible(true);
                result1Label.setVisible(true);
                result2Field.setVisible(false);
                result2Label.setVisible(false);
            }
            public void changeVisibility1(String result, String label) {
                result2Field.setText(result);
                result2Label.setText(label);
                result2Field.setVisible(true);
                result2Label.setVisible(true);
            }
        });

        result1Label = new JLabel();
        result1Label.setBounds(10, 230, 105, 30);
        result1Label.setVisible(false);

        result1Field = new JTextField();
        result1Field.setBounds(125, 230, 200,30);
        result1Field.setEditable(false);
        result1Field.setVisible(false);

        result2Label = new JLabel();
        result2Label.setBounds(10, 280, 105, 30);
        result2Label.setVisible(false);

        result2Field = new JTextField();
        result2Field.setBounds(125, 280, 200,30);
        result2Field.setEditable(false);
        result2Field.setVisible(false);

        binaryOperations.add(num1Label);
        binaryOperations.add(num1Field);
        binaryOperations.add(operatorLabel);
        binaryOperations.add(operator);
        binaryOperations.add(num2Label);
        binaryOperations.add(num2Field);
        binaryOperations.add(result1Label);
        binaryOperations.add(result1Field);
        binaryOperations.add(result2Label);
        binaryOperations.add(result2Field);
        binaryOperations.add(button);

        binaryOperations.setLayout(null);
        binaryOperations.setVisible(true);
    }
}