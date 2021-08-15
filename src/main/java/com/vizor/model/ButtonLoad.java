package com.vizor.model;

import com.vizor.test.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ButtonLoad implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
//        URL website = new URL("http://www.website.com/information.asp");
//        try (InputStream in = website.openStream()) {
//            Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
//        }
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setMultiSelectionEnabled(true);
//        jFileChooser.showSaveDialog(Gallery.jPanel);
        int i = jFileChooser.showDialog(Gallery.jPanel, "save as");
        File file = jFileChooser.getSelectedFile();
        if (i == 0){
            //добавить "file" в массив
        }

    }
}
