package com.bucikft.Views;

import com.bucikft.Controllers.Controller;
import javax.imageio.ImageIO;
import java.io.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.List;

import com.bucikft.Controllers.Tile;

public class GamePanel extends JPanel {

    private Tile[][] tiles;
    private Controller controller;
    private int tileSize = 75;
    private int gridSize;
    private int dimension;

    public GamePanel(Controller controller) {
        this.controller = controller;
        redraw();
        setBackground(Color.BLACK);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.println("Clicked in room at pixel coords: ("+ x + "," + y +")!");

            }
        });
    }

    public void redraw() {
        tiles = controller.getTileList();
        dimension = tiles.length;
        System.out.println(dimension);
        gridSize = dimension*tileSize;
        this.repaint();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x<dimension; x++) {
            for (int y = 0; y<dimension; y++) {
                Tile tile = tiles[x][y];
                BufferedImage image;
                try {
                    String imagePath = System.getProperty("user.dir") + File.separator +
                            "core" + File.separator +
                            "src" + File.separator +
                            "main" + File.separator +
                            "resources" + File.separator +
                            "images" + File.separator +
                            tile.getType().name() + ".png";
                    System.out.println(imagePath);
                    image = ImageIO.read(new File(imagePath));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                g.drawImage(image, x*tileSize, y*tileSize, (x+1)*tileSize, (y+1)*tileSize,0,0, image.getWidth(), image.getHeight(), this);
            }
        }
    }


}
