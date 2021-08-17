package com.vizor.test;

import com.vizor.model.Gallery;

import javax.swing.*;
import java.awt.*;

public class Main extends Frame {
    private static final int WIDTH = 800; //1024
    private static final int HEIGHT = 600; //768
    public static JFrame frame;


    public void run() {
        frame = new JFrame("DT Developer Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.add(new Gallery(), BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Main()::run);

    }
}

