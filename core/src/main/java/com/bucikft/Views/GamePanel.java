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
import jdk.jshell.Snippet;

public class GamePanel extends JPanel {

    private StatusPanel statpanel;
    private Tile[][] tiles;
    private Controller controller;
    private int tileSize = 75;
    private int gridSize;
    private int dimension;


    public GamePanel(Controller controller, StatusPanel statpanel) {
        this.controller = controller;
        this.statpanel = statpanel;
        setMinimumSize(new Dimension(tileSize*6,tileSize*6));
        setMaximumSize(new Dimension(tileSize*6, tileSize*6));
        redraw();
        setBackground(Color.BLACK);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.println("Clicked in room at pixel coords: ("+ x + "," + y +")!");
                int tileX = (int)Math.floor(e.getX()/tileSize);
                int tileY = (int)Math.floor(e.getY()/tileSize);
                System.out.println("Clicked on tile (" +tileX+"," +tileY + ")!");
                controller.tileClicked(tiles[tileX][tileY]);
                redraw();


            }
        });
    }

    public void redraw() {
        tiles = controller.getTileList();
        dimension = tiles.length;
        System.out.println(dimension);
        gridSize = dimension*tileSize;
        this.repaint();
        statpanel.redraw();

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
                    image = ImageIO.read(new File(imagePath));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                g.drawImage(image, x*tileSize, y*tileSize, (x+1)*tileSize, (y+1)*tileSize,0,0, image.getWidth(), image.getHeight(), this);
            }
        }
    }


}
