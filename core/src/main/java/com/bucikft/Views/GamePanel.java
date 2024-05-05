package com.bucikft.Views;

import com.bucikft.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel {
    public GamePanel() {
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


}
