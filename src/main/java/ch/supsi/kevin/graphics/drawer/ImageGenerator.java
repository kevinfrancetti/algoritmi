package ch.supsi.kevin.graphics.drawer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageGenerator {
    public static void main(String[] args) throws IOException {
        final BufferedImage image = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D graphics2D = image.createGraphics();
        graphics2D.setPaint(Color.WHITE);
        graphics2D.fillRect(0, 0, 1000, 1000);
        graphics2D.setPaint(Color.BLACK);
        graphics2D.drawOval(0, 0, 1000, 1000);
        graphics2D.drawLine(0,0,500,500);
        graphics2D.draw(new Line2D.Double(1, 1, 300.7, 250));
        graphics2D.dispose();

        String outputDirectoryName = "images";
        new File(outputDirectoryName).mkdirs();
        ImageIO.write(image, "png", new File(outputDirectoryName + "/image.png"));
    }
}
