package com.bucikft.Views;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * The type End screen view.
 */
public class EndScreenView extends JFrame {

    private final Image image;
    private boolean lost;

    /**
     * Instantiates a new End screen view.
     */
    public EndScreenView(boolean lost){
        setTitle("EndScreen");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.lost = lost;

        String imagePath = System.getProperty("user.dir") + File.separator +
                "core" + File.separator +
                "src" + File.separator +
                "main" + File.separator +
                "resources" + File.separator +
                "images" + File.separator +
                "endscreen.png";

        ImageIcon imageIcon = new ImageIcon(imagePath);
        image = imageIcon.getImage();


        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (image != null) {
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                }
                g.setFont(new Font("Arial", Font.BOLD, 50));
                g.setColor(Color.WHITE);
                String text = !lost?"You won!":"You lost!";
                FontMetrics fm = g.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(text)) / 2;
                int y = fm.getAscent();
                g.drawString(text, x, y);

                String creators = "Készítők: Dukát Nándor, Benedek Olivér, Kurtos András, Gaszner Ádám, Zalaváry Dániel";
                g.setFont(new Font("Arial", Font.PLAIN, 20));
                fm = g.getFontMetrics();
                x = (getWidth() - fm.stringWidth(creators)) / 2;
                y = getHeight() - fm.getHeight();
                g.drawString(creators, x, y);
            }
        };

        setContentPane(panel);
        setVisible(true);
    }
}
