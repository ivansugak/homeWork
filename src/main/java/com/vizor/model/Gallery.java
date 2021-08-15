package com.vizor.model;

import com.vizor.test.Main;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;

public class Gallery extends JFrame implements Runnable{

    public static JPanel jPanel = new JPanel();
    public static int curImageIndex=0;
    private BufferedImage image;


    public Gallery() throws IOException {
        BufferedImage myPicture = ImageIO.read(new File("..//dt-developer-test//assets"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        add(picLabel);
//        File fi = new File("..//dt-developer-test//assets");
//        byte[] fileContent = Files.readAllBytes(fi.toPath());
//
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


    }

    @Override
    public void run() {
        File fi = new File("..//dt-developer-test//assets");
        try {
            byte[] fileContent = Files.readAllBytes(fi.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ButtonLoad load = new ButtonLoad ();
//        PlayButtonListener PlayButton = new PlayButtonListener ();
//        StopButtonListener StopButton = new StopButtonListener ();
//        NextButtonListener NextButton = new NextButtonListener ();

        JButton jButtonLoad = new JButton("loading image");
        JButton jButtonSizeUp = new JButton("+ size image");
        JButton jButtonSizeDown = new JButton("- size image");
        JButton jButtonPrevious = new JButton ("Previous");
        JButton jButtonNext = new JButton ("Next");
        jPanel.add(jButtonLoad);
        jPanel.add(jButtonSizeUp);
        jPanel.add(jButtonSizeDown);
        jPanel.add(jButtonPrevious);
        jPanel.add(jButtonNext);

        //add listeners to corresponding componenets
        jButtonLoad.addActionListener(load);
//        jButtonSizeUp.addActionListener(PlayButton);
//        jButtonSizeDown.addActionListener(StopButton);
//        jButtonPrevious.addActionListener(NextButton);
//        jButtonNext.addActionListener(NextButton);
    }

//    FileInputStream dir = new FileInputStream ("..//dt-developer-test//assets");
//
//    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dir));
//
//    ImageIO[] image = ImageIO.

//    File file = new File("..//dt-developer-test//assets");
//    BufferedImage input = ImageIO.read(file);

//    JList myList = new JList(fileContent); //как реализовать добавление массива в JList?
//    Main.frame.add(myList);
}