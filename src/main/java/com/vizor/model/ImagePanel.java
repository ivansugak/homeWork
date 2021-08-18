package com.vizor.model;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {

    public ImagePanel() {
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 3));
        final JLabel no_image = new JLabel("No image");
        add(no_image);

    }

    public void loadImage(Image image) {
        removeAll();

        final JLabel jLabel = new JLabel(new ImageIcon(image));
        add(jLabel);
    }
}
