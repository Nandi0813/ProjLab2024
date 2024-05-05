package com.bucikft.Views;

import com.bucikft.Views.GameView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuView extends JFrame {

    BufferedImage background;

    public MenuView() {
        setTitle("A Logarléc");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        try {
            background = ImageIO.read(new File("/Users/gaszneradam/Documents/BME/3. félév/Szoftvertechnológia/ProjLab2024/core/src/main/java/com/bucikft/background.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        // Háttérkép beolvasása
        ImageIcon backgroundImage = new ImageIcon(background.getScaledInstance(500, 500, Image.SCALE_DEFAULT));
        JLabel backgroundLabel = new JLabel(backgroundImage);


        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(500, 500));

        // Háttérkép réteg hozzáadása
        backgroundLabel.setBounds(0, 0, 500, 500);
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false); // Áttetszővé tétele, hogy a háttérkép látszódjon

        JLabel titleLabel = new JLabel("A Logarléc");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(100)); // Üres hely a cím felett
        panel.add(titleLabel);

        JButton newGameButton = new JButton("New Game");
        JButton loadButton = new JButton("Load Game");
        JButton creditsButton = new JButton("Credits");
        JButton exitButton = new JButton("Exit");

        newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        creditsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Írd ide az új játék indításával kapcsolatos kódot
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Írd ide a játék betöltésével kapcsolatos kódot
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        creditsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Írd ide a kreditek megjelenítésével kapcsolatos kódot
            }
        });

        panel.add(Box.createVerticalStrut(50)); // Üres hely az első gomb felett
        panel.add(newGameButton);
        panel.add(Box.createVerticalStrut(10)); // Üres hely az első és második gomb között
        panel.add(loadButton);
        panel.add(Box.createVerticalStrut(10)); // Üres hely a második és harmadik gomb között
        panel.add(creditsButton);
        panel.add(Box.createVerticalStrut(10)); // Üres hely a harmadik és negyedik gomb között
        panel.add(exitButton);

        add(layeredPane);
        add(panel);

        setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuView();
            }
        });
    }
}
