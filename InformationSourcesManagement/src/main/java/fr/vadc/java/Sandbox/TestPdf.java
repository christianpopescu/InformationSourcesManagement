package fr.vadc.java.Sandbox;

import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import java.io.*;
import java.awt.image.BufferedImage;

public class TestPdf {

    public static void testPrintFirstPdfPage() {
        String pdfFilename = "F:\\CCP_library\\Doc\\epo\\Data Mining with Decision Trees.pdf";
        try {                               // /f/CCP_library/Doc/epo/Data Mining with Decision Trees.pdf
            PDDocument document = PDDocument.load(new File(pdfFilename));
            // }
        PDFRenderer pdfRenderer = new PDFRenderer(document);
        for (int page = 0; page < 1 /*document.getNumberOfPages()*/; ++page) {
            try {
                BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
                // suffix in filename will be used as the file format
                ImageIOUtil.writeImage(bim, pdfFilename + "-" + (page + 1) + ".png", 300);
            } catch(IOException ex) {
                //ignore
            }


        }
            document.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
