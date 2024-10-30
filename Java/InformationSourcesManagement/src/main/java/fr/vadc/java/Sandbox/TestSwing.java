package fr.vadc.java.Sandbox;

import javax.swing.*;
import java.io.File;
import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import javax.imageio.*;

/**
 * Use Swing JFileChooser to choose a file
 *
 */
public class TestSwing {
    public static File chooseFile(File pHomeDirectory) {

        //FileSystemView.getFileSystemView().getHomeDirectory();
        JFileChooser jfc = new JFileChooser(pHomeDirectory);

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            return selectedFile;
        }
        return null;
    }

    public static void showFile(final File pFile) {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame editorFrame = new JFrame("Image Demo");
                editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                BufferedImage image = null;
                try
                {
                    image = ImageIO.read(pFile);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    System.exit(1);
                }
                int h = image.getHeight();
                int w = image.getWidth();
                int ratio = w / 800;

                int wScaled = w / ratio;
                int hScaled = h / ratio;
                Image img = image.getScaledInstance(wScaled,
                        hScaled,Image.SCALE_DEFAULT);
                ImageIcon imageIcon = new ImageIcon(img);
                JLabel jLabel = new JLabel();
                jLabel.setIcon(imageIcon);
                editorFrame.setSize(400,300);
                editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);

                editorFrame.pack();
                editorFrame.setLocationRelativeTo(null);
                editorFrame.setVisible(true);

            }
        });
    }

    public static void saveResizedFile(final File pFile, double pRatio) {
        try {
            ImageHelper imageHelper = ImageHelper.getImageHelper(pFile);
            ImageHelper outputHelper = imageHelper.getResizedImage(pRatio);
            int lastDotPosition = pFile.getAbsolutePath().lastIndexOf(".");
            String prefix = pFile.getAbsolutePath().substring(0,lastDotPosition);
            String extension =  pFile.getAbsolutePath().substring(lastDotPosition + 1 );
            outputHelper.SaveImage(prefix + "resized." + extension);
        } catch ( IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
