package fr.vadc.java;

import fr.vadc.java.Sandbox.TestPdf;
import fr.vadc.java.Sandbox.TestSwing;

import java.io.File;

/**
 * Information Sources management
 *
 */
public class ISManagement
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        File selectedFile = TestSwing.chooseFile();
        //TestPdf.printPage("F:\\CCP_library\\Doc\\epo\\Data Mining with Decision Trees.pdf", 0);

        if (selectedFile != null)
            TestPdf.printPage(selectedFile,0);
        else
            System.out.println("File not selected");
    }
}
