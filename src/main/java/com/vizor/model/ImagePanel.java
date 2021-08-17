package com.vizor.model;


import javax.swing.*;
import java.awt.*;
import java.util.List;
import static com.vizor.model.Gallery.PAGE_SIZE;

public class ImagePanel extends JPanel {

    public ImagePanel() {
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 3));

        for (int i = 0; i < PAGE_SIZE; i++) {
            final JLabel no_image = new JLabel("No image");
            add(no_image);
        }
    }

    public void loadImages(List<String> fileNames) {
        removeAll();
        for (int i = 0; i < PAGE_SIZE; i++) {
            if (i < fileNames.size()) {
                final JLabel jLabel = new JLabel(new ImageIcon(fileNames.get(i)));
                add(jLabel);

            } else {
                final JLabel no_image = new JLabel("No image");
                add(no_image);
            }
        }
    }
}
