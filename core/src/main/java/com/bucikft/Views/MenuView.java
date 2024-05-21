package com.bucikft.Views;

import com.bucikft.Game;
import com.bucikft.Views.GameView;
import com.bucikft.Controllers.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The type Menu view.
 */
public class MenuView extends JFrame {
    private final Controller controller;
    private static GameView gameView;

    /**
     * Instantiates a new Menu view.
     */
    public MenuView() {
        setTitle("A Logarléc");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        controller = new Controller();

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(500, 500));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);

        JLabel titleLabel = new JLabel("A Logarléc");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(100)); // Space above the title
        panel.add(titleLabel);

        JPanel sizePanel = new JPanel();
        sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.X_AXIS));

        JLabel playerLabel = new JLabel("Játékosok száma:");
        JComboBox<Integer> playerField = new JComboBox<>(new Integer[]{1,2,3, 4, 5, 6, 7, 8, 9, 10});
        playerField.setSelectedIndex(2);

        JLabel sizeLabel = new JLabel("Méret:");
        JComboBox<Integer> sizeField = new JComboBox<>(new Integer[]{3, 4, 5, 6, 7, 8, 9, 10});
        sizeField.setSelectedIndex(3);


        sizePanel.add(playerLabel);
        sizePanel.add(Box.createRigidArea(new Dimension(10, 0)));
        sizePanel.add(playerField);
        sizePanel.add(Box.createRigidArea(new Dimension(10, 0)));
        sizePanel.add(sizeLabel);
        sizePanel.add(Box.createRigidArea(new Dimension(10, 0)));
        sizePanel.add(sizeField);
        sizePanel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton newGameButton = new JButton("New Game");
        JButton loadButton = new JButton("Load Game");
        JButton exitButton = new JButton("Exit");

        sizePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        sizeField.setMaximumSize(new Dimension(60, 30));
        playerField.setMaximumSize(new Dimension(60, 30));

        newGameButton.addActionListener(e -> {
            int selectedSize = (Integer) sizeField.getSelectedItem();
            int selectedPlayers = (Integer) playerField.getSelectedItem();
            controller.newGameStart(selectedPlayers,selectedSize);

            gameView = new GameView(controller);
            setVisible(false);
        });

        exitButton.addActionListener(e -> System.exit(0));

        loadButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(MenuView.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try { controller.loadGame(selectedFile);
                GameView gw = new GameView(controller);
                setVisible(false);
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(MenuView.this, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        panel.add(Box.createVerticalStrut(50)); // Üres hely az első gomb felett
        panel.add(sizePanel);
        panel.add(Box.createVerticalStrut(10)); // Üres hely az első és második gomb között
        panel.add(newGameButton);
        panel.add(Box.createVerticalStrut(10)); // Üres hely az első és második gomb között
        panel.add(loadButton);
        panel.add(Box.createVerticalStrut(10)); // Üres hely a harmadik és negyedik gomb között
        panel.add(exitButton);

        add(layeredPane);
        add(panel);

        setVisible(true);

    }

    /**
     * Gets game view.
     *
     * @return the game view
     */
    public static GameView getGameView() {
        return gameView;
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuView::new);
    }


}