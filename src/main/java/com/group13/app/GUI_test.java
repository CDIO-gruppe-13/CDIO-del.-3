package com.group13.app;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI_test implements ActionListener {

    // The window and the panel.
    JFrame frame;
    JPanel panel;

    // All the visual content of the product
    JLabel labelTextBox;

    JLabel PlayerOne;
    JLabel PlayerTwo;
    JLabel PlayerThree;
    JLabel PlayerFour;

    JLabel PlayerOneAccount;
    JLabel PlayerTwoAccount;
    JLabel PlayerThreeAccount;
    JLabel PlayerFourAccount;

    JButton RollButton;

    public void GUI() {
        // Creates the frame of the program.
        frame = new JFrame();

        // Creates the panel for all the content.
        panel = new JPanel();

        labelTextBox = new JLabel();

        PlayerOne = new JLabel();
        PlayerTwo = new JLabel();
        PlayerThree = new JLabel();
        PlayerFour = new JLabel();

        RollButton = new JButton("Roll dice");

        RollButton.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Monoply JR");
        frame.pack();
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

    }

}