package fr.vadc.java.Sandbox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TestPdf {

    public static void testPrintFirstPdfPage() {
        String pdfFilename = "F:\\CCP_library\\Doc\\epo\\Data Mining with Decision Trees.pdf";
        printPage(pdfFilename, 1);
    }

    public static void printPage(String pPdfFilename, int pPage) {
        try {
            PDDocument document = PDDocument.load(new File(pPdfFilename));
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            try {
                BufferedImage bim = pdfRenderer.renderImageWithDPI(pPage, 300, ImageType.RGB);
                // suffix in filename will be used as the file format
                ImageIOUtil.writeImage(bim, pPdfFilename + "-" + (pPage + 1) + ".png", 300);
            } catch (IOException ex) {
                //ignore
            }
            document.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
