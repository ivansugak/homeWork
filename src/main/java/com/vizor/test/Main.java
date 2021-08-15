package com.vizor.test;

import com.vizor.model.ButtonLoad;
import com.vizor.model.Gallery;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends Frame {
    private static final int WIDTH = 800; //1024
    private static final int HEIGHT = 600; //768
    public static JFrame frame;
//    public static JPanel jPanel = new JPanel();

    public void run() {
        frame = new JFrame("DT Developer Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(new Main()::run);

        Gallery gallery = new Gallery();
        Thread thread = new Thread(gallery);
        thread.start();


//        JFrame frame = new JFrame("DT Developer Test");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
////        frame.setVisible(true);
//        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

//        File dir = new File("..//dt-developer-test//assets");
//
//        File[] image = dir.listFiles();


        Gallery.jPanel.setLayout(new GridLayout(1,4));
        frame.add(Gallery.jPanel, BorderLayout.SOUTH);

//        JLabel label;
//        for (int i = 0; i < image.length; i++) {
//             label = new JLabel(new ImageIcon(String.valueOf(image[i])));
//            jPanel.add(label);
//        }
//        JLabel label = new JLabel(new ImageIcon());
//        jPanel.add(label);

//        ButtonLoad load = new ButtonLoad ();
////        PlayButtonListener PlayButton = new PlayButtonListener ();
////        StopButtonListener StopButton = new StopButtonListener ();
////        NextButtonListener NextButton = new NextButtonListener ();
//
//
//        JButton jButtonLoad = new JButton("loading image");
//        JButton jButtonSizeUp = new JButton("+ size image");
//        JButton jButtonSizeDown = new JButton("- size image");
//        JButton jButtonPrevious = new JButton ("Previous");
//        JButton jButtonNext = new JButton ("Next");
//        jPanel.add(jButtonLoad);
//        jPanel.add(jButtonSizeUp);
//        jPanel.add(jButtonSizeDown);
//        jPanel.add(jButtonPrevious);
//        jPanel.add(jButtonNext);
//
//        //add listeners to corresponding componenets
//        jButtonLoad.addActionListener(load);
////        jButtonSizeUp.addActionListener(PlayButton);
////        jButtonSizeDown.addActionListener(StopButton);
////        jButtonPrevious.addActionListener(NextButton);
////        jButtonNext.addActionListener(NextButton);

//        JList myList = new JList(image);
//        frame.add(myList);

        frame.setVisible(true);

//        jButtonLoad.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//
//        jButtonSizeUp.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//
//        jButtonSizeDown.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//
//        jButtonPrevious.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//
//        jButtonNext.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
    }
}

