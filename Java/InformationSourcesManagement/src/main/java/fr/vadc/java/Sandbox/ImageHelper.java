package fr.vadc.java.Sandbox;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Helper class that use behind BufferedImage
 *  - Resize image
 *  - Load Image from disk
 *  - Save Image
 */

public class ImageHelper {

    protected BufferedImage bufferedImage;
    protected String imageFile;
    // Protected constructor ImageHelper could be constructed only by factory method
    protected ImageHelper() {

    }

    public static ImageHelper getImageHelper(File pImageFile) throws IOException {
        ImageHelper result = new ImageHelper();
        result.bufferedImage = ImageIO.read(pImageFile);
        result.imageFile = pImageFile.getAbsolutePath();
        return result;
    }

    public ImageHelper getResizedImage(double pRatio) {
        ImageHelper result = new ImageHelper();
        int scaledWidth = (int) (bufferedImage.getWidth() * pRatio);
        int scaledHeight = (int)(bufferedImage.getHeight()*pRatio);
        result.bufferedImage  = new BufferedImage(scaledWidth, scaledHeight,bufferedImage.getType());
        Graphics2D g2d = result.bufferedImage.createGraphics();
        g2d.drawImage(bufferedImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
        return result;
    }

    public void SaveImage(String pOutputImage) throws IOException {
        ImageIO.write(bufferedImage,"png", new File(pOutputImage));
    }

}
