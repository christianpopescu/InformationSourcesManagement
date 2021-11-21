package fr.vadc.java.Sandbox;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class TestSwing {
    public static File chooseFile() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            return selectedFile;
        }

        return null;

    }
}
