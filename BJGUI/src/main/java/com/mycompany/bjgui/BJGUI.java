package com.mycompany.bjgui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BJGUI extends JFrame implements ActionListener, Runnable {
    Game game;
    private static JTextField userText;
    private static JPasswordField passText;
    private static JLabel success;
    private static JFrame frame;
    private static JButton button;

    public static void main(String[] args) {

        ImageIcon login = new ImageIcon("login.png");
        ImageIcon logo = new ImageIcon("logo.jpg");
        Border border = BorderFactory.createLineBorder(new Color(51,153,255),3);

        JLabel label = new JLabel();
        label.setIcon(logo);
        label.setBackground(Color.BLACK);
        label.setOpaque(true);
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(125,70,250,250);

        JLabel user = new JLabel("User");
        user.setFont(new Font("Apple Casual",Font.BOLD,15));
        user.setForeground(new Color(51,153,255));
        user.setBounds(125,360,80,25);

        userText = new JTextField();
        userText.setBounds(245,360,131,25);

        JLabel password = new JLabel("Password");
        password.setFont(new Font("Apple Casual",Font.BOLD,15));
        password.setForeground(new Color(51,153,255));
        password.setBounds(125,400,90,25);

        passText = new JPasswordField();
        passText.setBounds(245,400,131,25);

        button = new JButton("Login");
        button.setFont(new Font("Apple Casual",Font.BOLD,13));
        button.setBounds(215,450,80,25);
        button.addActionListener(new BJGUI());

        success = new JLabel("");
        success.setBounds(168,475,300,25);

        frame = new JFrame("Please Log In before entering BLACKJACK game window!");
        frame.setVisible(true);
        frame.setSize(500,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setIconImage(login.getImage());
        frame.setLayout(null);

        frame.add(label);
        frame.add(user);
        frame.add(password);
        frame.add(userText);
        frame.add(passText);
        frame.add(button);
        frame.add(success);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String user = userText.getText();
        String password = String.valueOf(passText.getPassword());

        if (user.equals("a") && password.equals("a")) {
            JOptionPane.showMessageDialog(frame, "Login Successfully!");
            JOptionPane.showMessageDialog(frame, "Welcome to Blackjack!\nScore as close to 21 without going over to win");
            JOptionPane.showMessageDialog(frame, "Let's ROCK!!!");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Game game = new Game(BJGUI.this);
        }
        else {
            JOptionPane.showMessageDialog(frame, "Invalid username or password!");
        }
    }

    public void run() {
        while (true) {
            game.refresher();
            game.repaint();
        }
    }
}

