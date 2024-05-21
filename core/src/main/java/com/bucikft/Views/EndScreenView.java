package com.bucikft.Views;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class EndScreenView extends JFrame {

    private Image image;
    public EndScreenView(){
        setTitle("EndScreen");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String imagePath = System.getProperty("user.dir") + File.separator +
                "core" + File.separator +
                "src" + File.separator +
                "main" + File.separator +
                "resources" + File.separator +
                "images" + File.separator +
                 "endscreen.png";
        // Kép beolvasása
        ImageIcon imageIcon = new ImageIcon(imagePath);
        image = imageIcon.getImage();

        // Kép és szöveg megjelenítése
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (image != null) {
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                }
                g.setFont(new Font("Arial", Font.BOLD, 50));
                g.setColor(Color.WHITE);
                String text = "You won!";
                FontMetrics fm = g.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(text)) / 2;
                int y = fm.getAscent(); // A szöveg magasságának megfelelő függőleges elhelyezés
                g.drawString(text, x, y);
            }
        };

        setContentPane(panel);
        setVisible(true);
    }
}
