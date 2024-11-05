package fr.vadc;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class PdfService {
    public static String GetPageImage(String fileName) {

        return fileName + " will be processed";
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
