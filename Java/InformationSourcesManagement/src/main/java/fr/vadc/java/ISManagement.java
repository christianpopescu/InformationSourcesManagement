package fr.vadc.java;

import fr.vadc.java.Sandbox.TestPdf;
import fr.vadc.java.Sandbox.TestSwing;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;

/**
 * Information Sources management
 *
 */
public class ISManagement
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        File homeDirectoryFile;
        try {
            homeDirectoryFile = new File("F:\\CCP_library");
        } catch (NullPointerException ex) {
            homeDirectoryFile =FileSystemView.getFileSystemView().getHomeDirectory();
        }
        File selectedFile = TestSwing.chooseFile(homeDirectoryFile);

        if (selectedFile != null) {
            TestPdf.printPage(selectedFile, 0);
        }
        else
            System.out.println("File not selected");

        selectedFile = TestSwing.chooseFile(homeDirectoryFile);
        if (selectedFile != null) {
            TestSwing.saveResizedFile(selectedFile, 0.25);
        }
        else
            System.out.println("File not selected");


    }
}
