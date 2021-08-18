package com.vizor.model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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
    private Image currentImage;

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
        try {
            Image image = ImageIO.read(new File(images.get(currentImageIndex)));
            currentImage = image;
            imagePanel.loadImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadAssets() {
        File dir = new File(IMG_DIR);
        final String[] imageFiles = dir.list();
        if (imageFiles != null) {
            Arrays.asList(imageFiles).forEach(f -> images.add(IMG_DIR + f));

        }
    }

    private void initButtons() {

        navigationPanel.getLoadButton().addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setMultiSelectionEnabled(true);
            jFileChooser.setDialogTitle("Save file");
            int a = jFileChooser.showSaveDialog(navigationPanel);
            if (a == 0) {
                File file = jFileChooser.getSelectedFile();

                String fileName = IMG_DIR + file.getName();
                try (FileInputStream fis = new FileInputStream(file);
                     FileOutputStream fos = new FileOutputStream(fileName)) {
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer, 0, buffer.length);
                    fos.write(buffer, 0, buffer.length);
                    images.add(fileName);
                } catch (IOException m) {
                    m.getStackTrace();
                }
            }
            imagePanel.validate();
            imagePanel.repaint();
        });

        navigationPanel.getPreviousButton().addActionListener(e -> {
            if (currentImageIndex > 0) {
                currentImageIndex--;
                loadImage();
                imagePanel.validate();
                imagePanel.repaint();
            }
        });

        navigationPanel.getSizeDownButton().addActionListener(e -> {
            if (currentImage != null) {
                final int newWidth = Math.max(currentImage.getWidth(null) * 9 / 10, 1);
                final int newHeight = Math.max(currentImage.getHeight(null) * 9 / 10, 1);
                Image scaledImage = currentImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                imagePanel.loadImage(scaledImage);
                imagePanel.validate();
                imagePanel.repaint();
                currentImage = scaledImage;
            }
        });

        navigationPanel.getSizeUpButton().addActionListener(e -> {
            if (currentImage != null) {
                final int newWidth = Math.max(currentImage.getWidth(null) * 11 / 10, 1);
                final int newHeight = Math.max(currentImage.getHeight(null) * 11 / 10, 1);
                Image scaledImage = currentImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                imagePanel.loadImage(scaledImage);
                imagePanel.validate();
                imagePanel.repaint();
                currentImage = scaledImage;
            }
        });

        navigationPanel.getNextButton().addActionListener(e -> {
            if (currentImageIndex < images.size() - 1) {
                currentImageIndex++;
                loadImage();
                imagePanel.validate();
                imagePanel.repaint();
            }
        });
    }
}
