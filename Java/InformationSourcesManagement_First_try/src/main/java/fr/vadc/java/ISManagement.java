package fr.vadc.java;

import fr.vadc.java.Sandbox.TestPdf;
import fr.vadc.java.Sandbox.TestSwing;

import javax.swing.filechooser.FileSystemView;
import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Information Sources management
 *
 */
public class ISManagement
{
    private static final Logger logger = LogManager.getLogger(ISManagement.class);
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        logger.info("Application started!");
        File homeDirectoryFile;
        try {
            homeDirectoryFile = new File("E:\\CCP_library");
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
