package com.vizor.model;

import com.vizor.test.Main;

import javax.swing.*;
import java.awt.*;

public class NavigationPanel extends JPanel {

    private final JButton nextButton = new JButton ("Next");
    private final JButton loadButton = new JButton ("Load");
    private final JButton sizeUpButton = new JButton ("SizeUp");
    private final JButton sizeDownButton = new JButton ("SizeDown");
    private final JButton previousButton = new JButton ("Previous");


    public NavigationPanel() {
        init();
    }

    private void init() {

        setLayout(new GridLayout(1,4));

        add(loadButton);

        add(sizeUpButton);

        add(sizeDownButton);

        add(previousButton);

        add(nextButton);
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JButton getLoadButton() {
        return loadButton;
    }

    public JButton getSizeUpButton() {
        return sizeUpButton;
    }

    public JButton getSizeDownButton() {
        return sizeDownButton;
    }

    public JButton getPreviousButton() {
        return previousButton;
    }
}
