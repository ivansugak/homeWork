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
    private int currentImageIndex = 0;

    public Gallery() {
        init();
        loadAssets();
        loadImage();
        initButtons();
    }

    private void init() {
        setLayout(new BorderLayout());
        add(imagePanel, BorderLayout.CENTER);
        add(navigationPanel, BorderLayout.SOUTH);
    }

    private void loadImage() {
        imagePanel.loadImage(images.get(currentImageIndex));
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
            if (currentImageIndex < images.size() - 1) {
                currentImageIndex++;
                loadImage();
                validate();
                repaint();

            }
        });

        navigationPanel.getLoadButton().addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setMultiSelectionEnabled(true);
            jFileChooser.setDialogTitle("Save file");
            int a = jFileChooser.showSaveDialog(navigationPanel);
            if (a == 0) {
                File file = jFileChooser.getSelectedFile();


                try (FileInputStream fis = new FileInputStream(file);
                     FileOutputStream fos = new FileOutputStream("assets/" + file.getName())) {
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer, 0, buffer.length);
                    fos.write(buffer, 0, buffer.length);

                } catch (IOException m) {
                    m.getStackTrace();
                }
            }

            validate();
            repaint();
        });

        navigationPanel.getPreviousButton().addActionListener(e -> {
            if (currentImageIndex > 0) {
                currentImageIndex--;
                loadImage();
                validate();
                repaint();
            }
        });

        navigationPanel.getSizeDownButton().addActionListener(e -> {
            try {
                BufferedImage img = ImageIO.read(new File(IMG_DIR + images.get(currentImageIndex)));
                Image dimg = img.getScaledInstance(10, 10,
                        Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(dimg);
            } catch (IOException a) {
                a.printStackTrace();
            }
        });

    }

}
