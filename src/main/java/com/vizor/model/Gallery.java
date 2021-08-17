package com.vizor.model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Gallery extends JPanel {

    public static final String IMG_DIR = "assets/";
    private final ImagePanel imagePanel = new ImagePanel();
    private final NavigationPanel navigationPanel = new NavigationPanel();
    private final List<String> images = new ArrayList<>();
    public static final int PAGE_SIZE = 1;
    private int currentPage = 0;

    public Gallery() {
        init();
        loadAssets();
        loadImages();
        initButtons();
        initButtonLoad();
        initButtonPrevious();
        initButtonSizeDown();
    }

    private void init() {
        setLayout(new BorderLayout());  //setLayout(new GridLayout(2, 1));
        add(imagePanel, BorderLayout.CENTER);
        add(navigationPanel, BorderLayout.SOUTH);
    }

    private void loadImages() {
        imagePanel.loadImages(images.subList(PAGE_SIZE * currentPage, (currentPage + 1) * PAGE_SIZE));
    }

    private void loadAssets() {
        File dir = new File(IMG_DIR);
        final String[] imageFiles = dir.list();
        if (imageFiles != null) {
            Arrays.asList(imageFiles).forEach(f -> images.add(IMG_DIR + f));
        }
    }


    private void initButtons() {
        navigationPanel.getNextButton().addActionListener(e -> {
            if ((currentPage + 1) * PAGE_SIZE < images.size()) {
                currentPage++; //if ??
                loadImages();
                validate();
                repaint();
            } else {
//                               navigationPanel.getNextButton().setEnabled(false);
            }
        });
    }

    private void initButtonLoad() {
        navigationPanel.getLoadButton().addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setMultiSelectionEnabled(true);
            jFileChooser.setDialogTitle("Save file");
            int a = jFileChooser.showSaveDialog(navigationPanel);
            File file = jFileChooser.getSelectedFile();
            String fileName = jFileChooser.getName();

            try {
                FileInputStream fis;
                FileOutputStream fos;
                fis=new FileInputStream(file);
                fos=new FileOutputStream("assets/fileName.png");
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer, 0, buffer.length);
                fos.write(buffer, 0, buffer.length);
                fis.close();
                fos.close();
            }
            catch(IOException m){
               m.getStackTrace();
            }

            validate();
            repaint();
        });
    }

    private void initButtonPrevious() {
        navigationPanel.getPreviousButton().addActionListener(e -> {
            if ((currentPage - 1) * PAGE_SIZE != 0) {
                currentPage--; //if ??
                loadImages();
                validate();
                repaint();
            } else {
                currentPage = 0;
                loadImages();
                validate();
                repaint();
            }
        });
    }

    private void initButtonSizeDown() {

        navigationPanel.getSizeDownButton().addActionListener(e -> {
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File("assets/"));
                Image dimg = img.getScaledInstance(50, 50,
                        Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(dimg);
            } catch (IOException a) {
                a.printStackTrace();
            }
        });
    }


}
