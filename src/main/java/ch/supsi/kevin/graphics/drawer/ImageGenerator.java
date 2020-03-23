package ch.supsi.kevin.graphics.drawer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageGenerator {
    private static int WIDTH = 1000;
    private static int HEIGHT = 1000;
    private static int IMAGE_TYPE = BufferedImage.TYPE_INT_ARGB;

    public static void generatePNG(float[] tspArrayData) throws IOException {

        /*Preparing for scaling the data for fit the image size TODO trovare soluzione*/
        float xMax = -1;
        float yMax = -1;
        for (int i = 0; i < tspArrayData.length; i += 2) {
            if (tspArrayData[i] > xMax) xMax = tspArrayData[i];
            if (tspArrayData[i + 1] > yMax) yMax = tspArrayData[i + 1];
        }

        /*Image global setup*/
        final BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D graphics2D = image.createGraphics();
        graphics2D.setPaint(Color.WHITE);
        graphics2D.fillRect(0, 0, WIDTH, HEIGHT);
        graphics2D.setPaint(Color.BLACK);


        //TODO trovare soluzione
        xMax += 35;
        yMax += 35;
        for (int i = 0; i < tspArrayData.length - 3; i += 2) {
            graphics2D.draw(new Line2D.Double(tspArrayData[i] * WIDTH/xMax, tspArrayData[i + 1] * HEIGHT/yMax,
                    tspArrayData[i + 2] * WIDTH/xMax, tspArrayData[i + 3] * HEIGHT/yMax));
        }
        graphics2D.dispose();

        String outputDirectoryName = "images";
        new File(outputDirectoryName).mkdirs();
        ImageIO.write(image, "png", new File(outputDirectoryName + "/image.png"));
    }

    public static void main(String[] args) throws IOException {
        //Test();
        float[] f = {10, 0, 10 , 10, 20, 10, 20, 0};
        generatePNG(f);
    }
}
