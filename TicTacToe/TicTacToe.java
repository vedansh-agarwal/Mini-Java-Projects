package com.vedansh.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe implements ActionListener {

    JFrame tictactoeFrame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel titleText = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton reset = new JButton();
    JButton undo = new JButton();
    boolean turnX = false;


    TicTacToe() {
        tictactoeFrame.setTitle("TicTacToe");
        tictactoeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tictactoeFrame.setSize(400,450);
        tictactoeFrame.setResizable(false);
        tictactoeFrame.setVisible(true);

        titlePanel.setBounds(0,0,400,50);

        titleText.setFont(new Font(Font.SANS_SERIF, Font.BOLD,40));
        titleText.setText("O turn");
        titleText.setOpaque(true);

        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150,150,150));

        for(int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font(Font.SANS_SERIF,Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        titlePanel.add(titleText);
        tictactoeFrame.add(titlePanel,BorderLayout.NORTH);
        tictactoeFrame.add(buttonPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 9; i++)
            if(e.getSource() == buttons[i])
                if(turnX)
                    turnButtonValue(255, 0, "X", false, "O Turn", i);
                else
                    turnButtonValue(0, 255, "O", true, "X Turn", i);
    }
    public void turnButtonValue(int x, int y, String text, boolean val, String turn, int i) {
        buttons[i].setForeground(new Color(x,0,y));
        buttons[i].setText(text);
        turnX = val;
        titleText.setText(turn);
        check();
    }

    public void check() {
        if(buttons[0].getText() == "X" && buttons[1].getText() == "X" && buttons[2].getText() == "X")
            callOnWin(0,1,2, 'X');
        if(buttons[3].getText() == "X" && buttons[4].getText() == "X" && buttons[5].getText() == "X")
            callOnWin(3,4,5, 'X');
        if(buttons[6].getText() == "X" && buttons[7].getText() == "X" && buttons[8].getText() == "X")
            callOnWin(6,7,8, 'X');
        if(buttons[0].getText() == "X" && buttons[3].getText() == "X" && buttons[6].getText() == "X")
            callOnWin(0,3,6, 'X');
        if(buttons[1].getText() == "X" && buttons[4].getText() == "X" && buttons[7].getText() == "X")
            callOnWin(1,4,7, 'X');
        if(buttons[2].getText() == "X" && buttons[5].getText() == "X" && buttons[8].getText() == "X")
            callOnWin(2,5,8, 'X');
        if(buttons[0].getText() == "X" && buttons[4].getText() == "X" && buttons[8].getText() == "X")
            callOnWin(0,4,8, 'X');
        if(buttons[2].getText() == "X" && buttons[4].getText() == "X" && buttons[6].getText() == "X")
            callOnWin(2,4,6, 'X');

        if(buttons[0].getText() == "O" && buttons[1].getText() == "O" && buttons[2].getText() == "O")
            callOnWin(0,1,2, 'O');
        if(buttons[3].getText() == "O" && buttons[4].getText() == "O" && buttons[5].getText() == "O")
            callOnWin(3,4,5, 'O');
        if(buttons[6].getText() == "O" && buttons[7].getText() == "O" && buttons[8].getText() == "O")
            callOnWin(6,7,8, 'O');
        if(buttons[0].getText() == "O" && buttons[3].getText() == "O" && buttons[6].getText() == "O")
            callOnWin(0,3,6, 'O');
        if(buttons[1].getText() == "O" && buttons[4].getText() == "O" && buttons[7].getText() == "O")
            callOnWin(1,4,7, 'O');
        if(buttons[2].getText() == "O" && buttons[5].getText() == "O" && buttons[8].getText() == "O")
            callOnWin(2,5,8, 'O');
        if(buttons[0].getText() == "O" && buttons[4].getText() == "O" && buttons[8].getText() == "O")
            callOnWin(0,4,8, 'O');
        if(buttons[2].getText() == "O" && buttons[4].getText() == "O" && buttons[6].getText() == "O")
            callOnWin(2,4,6, 'O');
    }
    
    public void callOnWin(int a, int b, int c, char ch) {
        buttons[a].setOpaque(true);
        buttons[b].setOpaque(true);
        buttons[c].setOpaque(true);
        buttons[a].setBackground(new Color(0, 255, 0));
        buttons[b].setBackground(new Color(0, 255, 0));
        buttons[c].setBackground(new Color(0, 255, 0));

        for(int i = 0; i < 9; i++)
            buttons[i].setEnabled(false);
        titleText.setText(ch+" wins");
    }
}
