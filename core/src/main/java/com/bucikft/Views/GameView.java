package com.bucikft.Views;

import javax.swing.*;

public class GameView extends JFrame {
    public GameView() {

        setTitle("Game");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("JÁTÉK GEC");
        panel.add(titleLabel);
        this.setVisible(true);
    }
}
