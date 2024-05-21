package com.bucikft.Views;

import com.bucikft.Controllers.ActionType;
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

/**
 * The type Game panel.
 */
public class GamePanel extends JPanel {

    private final StatusPanel statpanel;
    private Tile[][] tiles;
    private final Controller controller;
    private final int tileSize = 75;
    private int dimension;
    private final GameView gameView;


    /**
     * Instantiates a new Game panel.
     *
     * @param controller the controller
     * @param statpanel  the statpanel
     * @param gw         the gw
     */
    public GamePanel(Controller controller, StatusPanel statpanel, GameView gw) {
        this.controller = controller;
        this.statpanel = statpanel;
        gameView = gw;
        setMinimumSize(new Dimension(tileSize*6,tileSize*6));
        setMaximumSize(new Dimension(tileSize*6, tileSize*6));
        draw();
        setBackground(Color.BLACK);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                //System.out.println("Clicked in room at pixel coords: ("+ x + "," + y +")!");
                int tileX = (int)Math.floor(e.getX()/tileSize);
                int tileY = (int)Math.floor(e.getY()/tileSize);
                //System.out.println("Clicked on tile (" +tileX+"," +tileY + ")!");
                try {
                    ActionType ac = controller.tileClicked(tiles[tileX][tileY]);
                    if ( ac == ActionType.Move) draw();
                    else {
                        if (ac==ActionType.PickUp) {
                            gameView.redraw();
                        }
                        redraw();
                    }
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(GamePanel.this, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    /**
     * Draw.
     */
    public void draw() {
        tiles = controller.initializeTileList();
        dimension=tiles.length;
        this.repaint();
        statpanel.redraw();
    }

    /**
     * Redraw.
     */
    public void redraw() {
        tiles = controller.getTileList(tiles);
        dimension = tiles.length;
        this.repaint();
        statpanel.redraw();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x<dimension; x++) {
            for (int y = 0; y<dimension; y++) {
                Tile tile = tiles[x][y];
                BufferedImage image = null;
                try {
                    String imagePath = System.getProperty("user.dir") + File.separator +
                            "src" + File.separator +
                            "main" + File.separator +
                            "resources" + File.separator +
                            "images" + File.separator +
                            tile.getType().name() + ".png";
                    image = ImageIO.read(new File(imagePath));
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

                g.drawImage(image, x*tileSize, y*tileSize, (x+1)*tileSize, (y+1)*tileSize,0,0, image.getWidth(), image.getHeight(), this);
            }
        }
    }
}
