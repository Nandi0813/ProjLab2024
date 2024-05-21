package com.bucikft.Views;
import javax.swing.*;
import java.awt.*;
import java.io.File;

import com.bucikft.Controllers.Controller;

/**
 * The type Inventory button.
 */
public class InventoryButton extends JButton {
    private Image texture;
    private Controller controller;
    private String imagePath = System.getProperty("user.dir") + File.separator +
            "core" + File.separator +
            "src" + File.separator +
            "main" + File.separator +
            "resources" + File.separator +
            "images" + File.separator;

    /**
     * Instantiates a new Inventory button.
     */
    public InventoryButton() {
        texture = new ImageIcon(imagePath+"Floor.png").getImage();
        setPreferredSize(new Dimension(20,20));
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
    }

    /**
     * Change texture.
     *
     * @param tex the tex
     */
    public void changeTexture(String tex){
        texture = new ImageIcon(imagePath+tex).getImage();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(texture, 0, 0, getWidth(), getHeight(), this);
        super.paintComponent(g);
    }
}
