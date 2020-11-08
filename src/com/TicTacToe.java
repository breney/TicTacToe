package com;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;


    TicTacToe() {

        //Creating Panel to the game
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(102, 102, 102));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        //Creating Label for Tittle
        textField.setBackground(new Color(51, 51, 51));
        textField.setForeground(new Color(255, 255, 255));
        textField.setFont(new Font("SansSerif", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        //Creating title panel
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(255, 102, 0));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            button_panel.add(buttons[i]);
        }

        //Add textfield and tittle_panel to the frame(MainPanel)
        title_panel.add(textField);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        for (int i = 0; i < 9; i++) {
            if (event.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(50, 50, 50));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textField.setText("O Player Turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(50, 50, 50));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textField.setText("X Player Turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textField.setText("X Player Turn");
        } else {
            player1_turn = false;
            textField.setText("O Player Turn");
        }

    }

    public void check() {
        //Check x wins
        for (int i = 0; i < 9; i++) {
            if(buttons[i].getText() == "X" && buttons[i+1].getText() == "X" && buttons[i+2].getText() == "X"){
                xWins(i,i+1,i+2);
            }
            if(buttons[i].getText() == "X" && buttons[i+3].getText() == "X" && buttons[i+6].getText() == "X"){
                xWins(i,i+3,i+6);
            }

            if(i == 0 && buttons[i].getText() == "X" && buttons[i+4].getText() == "X" && buttons[i+8].getText() == "X"){
                xWins(i,i+4,i+8);
            }
            if(i == 2 && buttons[i].getText() == "X" && buttons[i+2].getText() == "X" && buttons[i+4].getText() == "X"){
                xWins(i,i+2,i+4);
            }
        }
        //Check O wins
        for (int j = 0; j < 9; j++) {
            if(buttons[j].getText() == "O" && buttons[j +1].getText() == "O" && buttons[j +2].getText() == "O"){
                oWins(j, j +1, j +2);
            }
            if(buttons[j].getText() == "O" && buttons[j +3].getText() == "O" && buttons[j +6].getText() == "O"){
                oWins(j, j +3, j +6);
            }

            if(j == 0 && buttons[j].getText() == "O" && buttons[j +4].getText() == "O" && buttons[j +8].getText() == "O"){
                oWins(j, j +4, j +8);
            }
            if(j == 2 && buttons[j].getText() == "O" && buttons[j +2].getText() == "O" && buttons[j +4].getText() == "O"){
                oWins(j, j +2, j +4);
            }
        }
    }

    public void xWins(int a, int b, int c) {
        textField.setText("X WINS !");
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
    }

    public void oWins(int a, int b, int c) {
        textField.setText("O WINS !");
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
    }
}
