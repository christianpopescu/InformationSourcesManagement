package fr.vadc.java.Sandbox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.apache.pdfbox.pdmodel.PDDocument.*;

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

    public static void printPage(File pPdfFile, int pPage) {
        try {
            PDDocument document = PDDocument.load(pPdfFile);
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            try {
                BufferedImage bim = pdfRenderer.renderImageWithDPI(pPage, 300, ImageType.RGB);
                // suffix in filename will be used as the file format
                String filename = pPdfFile.getAbsolutePath() + "-" + (pPage + 1) + ".png";
                System.out.println(filename);
                ImageIOUtil.writeImage(bim, filename, 300);
                TestSwing.showFile(new File(filename));
            } catch (IOException ex) {
                //ignore
            }
            document.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
