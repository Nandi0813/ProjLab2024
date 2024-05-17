package com.bucikft.Views;

import com.bucikft.Controllers.Controller;
import com.bucikft.Game;

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {

    private Controller controller;

    public GameView(Controller controller) {
        this.controller = controller;
        setTitle("Game");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel taskbar = new JPanel();
        taskbar.setLayout(new BoxLayout(taskbar, BoxLayout.X_AXIS));

        JLabel playerName = new JLabel("*Player Name*");
        JLabel inventoryLabel = new JLabel("Inventory:");
        Font font = new Font("Arial", Font.PLAIN, 15);
        inventoryLabel.setFont(font);
        playerName.setFont(font);

        taskbar.setBackground(Color.LIGHT_GRAY);

        JButton inv1 = new JButton("1");
        JButton inv2 = new JButton("2");
        JButton inv3 = new JButton("3");
        JButton inv4 = new JButton("4");
        JButton inv5 = new JButton("5");
        JButton nextButton = new JButton("Next");

        JToggleButton useDrop = new JToggleButton("Use");
        taskbar.add(playerName);
        taskbar.add(inventoryLabel);
        taskbar.add(inv1);
        taskbar.add(inv2);
        taskbar.add(inv3);
        taskbar.add(inv4);
        taskbar.add(inv5);
        taskbar.add(useDrop);
        taskbar.add(nextButton);


        add(taskbar, BorderLayout.SOUTH);


        GamePanel gamePanel = new GamePanel(controller);
        add(gamePanel, BorderLayout.CENTER);
        this.setResizable(false);
        this.setVisible(true);
    }
}
