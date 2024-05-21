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

/**
 * The type Game view.
 */
public class GameView extends JFrame {

    private final Controller controller;
    private boolean useMode = false;
    private static GamePanel gamePanel;
    private StatusPanel statusPanel;

    /**
     * The Inv buttons.
     */
    List<InventoryButton> invButtons = new ArrayList<>();


    /**
     * Instantiates a new Game view.
     *
     * @param controller the controller
     */
    public GameView(Controller controller) {
        this.controller = controller;
        statusPanel = new StatusPanel(controller);
        gamePanel = new GamePanel(controller, statusPanel, this);
        setTitle("Game");
        setSize(800, 550);
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
            InventoryButton invButton = getInventoryButton(controller, i);
            invButtons.add(invButton);
        }


        JButton nextButton = new JButton("Next");
        JToggleButton godMode = new JToggleButton("GodMode");

        JToggleButton useDrop = new JToggleButton("Use");

        useDrop.addActionListener(e -> {
            useMode = !useMode;
            if (useMode) {
                useDrop.setText("Drop");
            } else {
                useDrop.setText("Use");
            }
        });

        nextButton.addActionListener(e -> {
            try {
                controller.nextButtonPressed();
                gamePanel.draw();
                redraw();
            } catch (Exception err) {
                JOptionPane.showMessageDialog(GameView.this, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        });

        godMode.addActionListener(e-> {
            {
                controller.setGodMode();
                statusPanel.redraw();
            }
        });




        taskbar.add(inventoryLabel);
        for (InventoryButton invButton: invButtons) {
            taskbar.add(invButton);
        }

        JButton pairButton = new JButton("Pair");
        pairButton.addActionListener(e-> {
            controller.pairTransistors();
            statusPanel.redraw();
            redraw();
        });

        taskbar.add(useDrop);
        taskbar.add(nextButton);
        taskbar.add(pairButton);
        taskbar.add(godMode);

        JButton saveButton = getSaveButton(controller);
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

    private InventoryButton getInventoryButton(Controller controller, int i) {
        InventoryButton invButton = new InventoryButton();
        int finalI = i;
        invButton.addActionListener(e -> {
            try {
                controller.inventoryButtonClicked(finalI, useMode);
                redraw();
                gamePanel.redraw();
            } catch (Exception err) {
                JOptionPane.showMessageDialog(GameView.this, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        return invButton;
    }

    private JButton getSaveButton(Controller controller) {
        JButton saveButton = new JButton("Save");

        saveButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(GameView.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    controller.saveGame(selectedFile);
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(GameView.this, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            // Show the file chooser dialog
    });
        return saveButton;
    }

    /**
     * Redraw.
     */
    public void redraw() {
        List<String> textures = controller.getInventoryTextures();
        for (int i=0;i<5;i++) {
            InventoryButton b = invButtons.get(i);
            b.changeTexture(textures.get(i));
        }
    }

    public static void showDialog(String msg, String title) {
        JOptionPane.showMessageDialog(gamePanel, msg,title,JOptionPane.PLAIN_MESSAGE);
    }
}
