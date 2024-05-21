package com.bucikft.Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.bucikft.Controllers.Controller;

import java.awt.*;
import java.util.List;


/**
 * The type Status panel.
 */
public class StatusPanel extends JPanel {
    private Controller controller;

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
    }

    /**
     * Redraw.
     */
    public void redraw() {
        List<String> lines = controller.getStatusStrings();
        int i = 0;
        for (Component comp : this.getComponents()) {
            if (comp instanceof JLabel txt) {
                txt.setText(lines.get(i++));
            }
        }
        repaint();
    }

}
