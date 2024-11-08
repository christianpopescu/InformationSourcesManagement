package fr.vadc;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class PdfService {
    public static String GetPageImage(String fileName) {

        return fileName + " will be processed";
    }

    /**
     *  Print the pPage of the pPdfFilename as image
     * @param pPdfFilename  - String that express the Filename as path
     * @param pPage
     */

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

    public static void printPage(Path pPdfFilename, int pPage, Path pImageDestination) {
        try {
            PDDocument document = PDDocument.load(new File(pPdfFilename.toString()));
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            try {
                BufferedImage bim = pdfRenderer.renderImageWithDPI(pPage, 300, ImageType.RGB);
                // suffix in filename will be used as the file format
                String filename = new StringBuilder().append(pImageDestination.toString()).append("\\").append(pPdfFilename.getFileName().toString()).append("-").append(pPage + 1).append(".png").toString();
                ImageIOUtil.writeImage(bim,
                        filename, 300);
            } catch (IOException ex) {
                //ignore
            }
            document.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
