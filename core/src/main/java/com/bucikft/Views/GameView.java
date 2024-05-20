package com.bucikft.Views;

import com.bucikft.Controllers.Controller;
import com.bucikft.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GameView extends JFrame {

    private Controller controller;
    private boolean useMode = false;
    private GamePanel gamePanel;
    private StatusPanel statusPanel;

    List<JButton> invButtons = new ArrayList<>();



    public GameView(Controller controller) {
        this.controller = controller;
        statusPanel = new StatusPanel(controller);
        gamePanel = new GamePanel(controller, statusPanel);
        redraw();
        setTitle("Game");
        setSize(700, 520);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel taskbar = new JPanel();
        taskbar.setLayout(new BoxLayout(taskbar, BoxLayout.X_AXIS));

        JLabel inventoryLabel = new JLabel("Inventory:");
        Font font = new Font("Arial", Font.PLAIN, 15);
        inventoryLabel.setFont(font);

        taskbar.setBackground(Color.LIGHT_GRAY);

        for (int i=0;i<5;i++) {
            JButton invButton = new JButton(Integer.toString(i));
            int finalI = i;
            invButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.inventoryButtonClicked(finalI,useMode);
                    gamePanel.redraw();
                }
            });
            invButtons.add(invButton);
        }


        JButton nextButton = new JButton("Next");
        JToggleButton godMode = new JToggleButton("GodMode");

        JToggleButton useDrop = new JToggleButton("Use");

        useDrop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                useMode = !useMode;
                if (useMode) {
                    useDrop.setText("Drop");
                } else {
                    useDrop.setText("Use");
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.nextButtonPressed();
                gamePanel.draw();
            }
        });

        godMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setGodMode();

            }
        });




        taskbar.add(inventoryLabel);
        for (JButton invButton: invButtons) {
            taskbar.add(invButton);
        }
        taskbar.add(useDrop);
        taskbar.add(nextButton);
        taskbar.add(godMode);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(GameView.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    controller.saveGame(selectedFile);
                }
                // Show the file chooser dialog
        }});
        taskbar.add(saveButton);

        JPanel middle = new JPanel();
        middle.setLayout(new BoxLayout(middle, BoxLayout.X_AXIS));
        middle.add(gamePanel);
        middle.add(statusPanel);
        middle.setBackground(Color.BLACK);
        add(middle, BorderLayout.CENTER);
        this.setResizable(false);
        this.setVisible(true);
        add(taskbar, BorderLayout.SOUTH);



    }

    public void redraw() {
        // somehow make inventory buttons display items inside

    }
}
