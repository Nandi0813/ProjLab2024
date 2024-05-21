package com.bucikft.Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.bucikft.Controllers.Controller;
import com.bucikft.Controllers.OutputHandler;

import java.awt.*;
import java.util.List;


/**
 * The type Status panel.
 */
public class StatusPanel extends JPanel {
    private final Controller controller;

    /**
     * Instantiates a new Status panel.
     *
     * @param controller the controller
     */
    public StatusPanel(Controller controller) {
        this.controller = controller;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        List<String> lines = controller.getStatusStrings();
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        for (String line : lines) {
            JLabel txt = new JLabel(line);
            txt.setFont(new Font("Arial", Font.PLAIN, 15));
            txt.setForeground(Color.WHITE);
            add(txt);
        }
        for (int i=0;i<6;i++) {
            JLabel txt = new JLabel(" ");
            txt.setFont(new Font("Arial", Font.PLAIN, 15));
            txt.setForeground(Color.RED);
            add(txt);
        }
    }

    /**
     * Redraw.
     */
    public void redraw() {
        List<String> lines = controller.getStatusStrings();
        List<String> output = OutputHandler.getOutputMessages();
        int i = 0;
        for (String line: lines) {
            if (this.getComponents()[i++] instanceof JLabel txt) {
                txt.setText(line);
            }
        }
        for (int j=0;j<6-output.size();j++) {
            if (this.getComponents()[i++] instanceof JLabel txt) {
                txt.setText(" ");
            }
        }
        for (String line : output) {
            if (this.getComponents()[i++] instanceof JLabel txt) {
                txt.setText(line);
            }
        }
        repaint();
    }

}
