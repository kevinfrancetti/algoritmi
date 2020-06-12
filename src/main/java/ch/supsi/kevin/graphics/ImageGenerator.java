package ch.supsi.kevin.graphics;

import ch.supsi.kevin.Main;
import ch.supsi.kevin.algos.constructive.MultiFragment;
import ch.supsi.kevin.algos.constructive.NN;
import ch.supsi.kevin.datastructure.Edge;
import ch.supsi.kevin.datastructure.TspData;
import ch.supsi.kevin.datastructure.City;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ImageGenerator {
    private static int WIDTH = 1500;
    private static int HEIGHT = 1500;

    @Deprecated
    public static void generatePNGfromList(float[] tspArrayData) throws IOException {
        /*Image global setup*/
        final BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D graphics2D = image.createGraphics();
        graphics2D.setPaint(Color.WHITE);
        graphics2D.fillRect(0, 0, WIDTH, HEIGHT);
        graphics2D.setPaint(Color.BLACK);

        /*Preparing for scaling the data for fit the image size*/
        float xMax = -1;
        float yMax = -1;
        for (int i = 0; i < tspArrayData.length; i += 2) {
            if (tspArrayData[i] > xMax) xMax = tspArrayData[i];
            if (tspArrayData[i + 1] > yMax) yMax = tspArrayData[i + 1];
        }

        /*Apply scaled coordinates to image*/
        for (int i = 0; i < tspArrayData.length - 3; i += 2) {
            graphics2D.draw(new Line2D.Double(tspArrayData[i] * WIDTH / xMax, tspArrayData[i + 1] * HEIGHT / yMax,
                    tspArrayData[i + 2] * WIDTH / xMax, tspArrayData[i + 3] * HEIGHT / yMax));
        }
        graphics2D.dispose();

        /*Saving the image*/
        String outputDirectoryName = "images";
        new File(outputDirectoryName).mkdirs();
        ImageIO.write(image, "png", new File(outputDirectoryName + "/image.png"));
    }


    public static <T> void generatePNG(List<T> list, String title) throws IOException {
        List<City> points;
        if (list.get(0) instanceof Edge) {
            points = MultiFragment.createListFromOneEdge((Edge) list.get(0));
        } else {
            points = (List<City>) list;
        }
        generatePNGfromList(points, title);
    }

    private static void generatePNGfromEdges(List<Edge> edgeList, String title) throws IOException {
        /*Image global setup*/
        final BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D graphics2D = image.createGraphics();
        graphics2D.setPaint(Color.WHITE);
        graphics2D.fillRect(0, 0, WIDTH, HEIGHT);
        graphics2D.setPaint(Color.BLACK);

        /*Preparing for scaling the data for fit the image size*/
        float xMax = -1;
        float yMax = -1;
        for (Edge e : edgeList) {
            if (e.p1.x > xMax) xMax = e.p1.x;
            if (e.p1.y > yMax) yMax = e.p1.y;
            if (e.p2.x > xMax) xMax = e.p2.x;
            if (e.p2.y > yMax) yMax = e.p2.y;
        }

        /*Apply scaled coordinates to image*/
        for (int i = 0; i < edgeList.size(); i++) {
            if (i % 2 == 0) graphics2D.setColor(Color.blue);
            else graphics2D.setColor(Color.red);
            if (i == 0) graphics2D.setColor(Color.green);
            if (i == edgeList.size() - 1) graphics2D.setColor(Color.black);
            graphics2D.draw(new Line2D.Double(edgeList.get(i).p1.x * WIDTH / xMax, edgeList.get(i).p1.y * HEIGHT / yMax,
                    edgeList.get(i).p2.x * WIDTH / xMax, edgeList.get(i).p2.y * HEIGHT / yMax));
            Shape s;
            if (i == 0) {
                graphics2D.setColor(Color.green);
                s = new Ellipse2D.Double((edgeList.get(i).p1.x * WIDTH / xMax) - 7.5, (edgeList.get(i).p1.y * HEIGHT / yMax) - 7.5, 15, 15);
            } else {
                s = new Ellipse2D.Double((edgeList.get(i).p1.x * WIDTH / xMax) - 2.5, (edgeList.get(i).p1.y * HEIGHT / yMax) - 2.5, 5, 5);
            }
            graphics2D.fill(s);
            graphics2D.draw(s);
        }
        graphics2D.dispose();

        /*Saving the image*/
        String outputDirectoryName = "images";
        new File(outputDirectoryName).mkdirs();//TODO manage this
        ImageIO.write(image, "png", new File(outputDirectoryName + "/" + title));
    }

    private static void generatePNGfromList(List<City> pointList, String title) throws IOException {
        /*Image global setup*/
        final BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D graphics2D = image.createGraphics();
        graphics2D.setPaint(Color.WHITE);
        graphics2D.fillRect(0, 0, WIDTH, HEIGHT);
        graphics2D.setPaint(Color.BLACK);

        /*Preparing for scaling the data for fit the image size*/
        float xMax = -1;
        float yMax = -1;
        for (City p : pointList) {
            if (p.x > xMax) xMax = p.x;
            if (p.y > yMax) yMax = p.y;
        }

        /*Apply scaled coordinates to image*/
        for (int i = 0; i < pointList.size() - 1; i++) {
            if (i % 2 == 0) graphics2D.setColor(Color.blue);
            else graphics2D.setColor(Color.red);
            graphics2D.draw(new Line2D.Double(pointList.get(i).x * WIDTH / xMax, pointList.get(i).y * HEIGHT / yMax,
                    pointList.get(i + 1).x * WIDTH / xMax, pointList.get(i + 1).y * HEIGHT / yMax));
            Shape s;
            if (i == 0) {
                graphics2D.setColor(Color.green);
                s = new Ellipse2D.Double((pointList.get(i).x * WIDTH / xMax) - 7.5, (pointList.get(i).y * HEIGHT / yMax) - 7.5, 15, 15);
            } else {
                s = new Ellipse2D.Double((pointList.get(i).x * WIDTH / xMax) - 2.5, (pointList.get(i).y * HEIGHT / yMax) - 2.5, 5, 5);
            }
            graphics2D.fill(s);
            graphics2D.draw(s);
        }
        graphics2D.setColor(Color.green);
        graphics2D.draw(new Line2D.Double(pointList.get(0).x * WIDTH / xMax, pointList.get(0).y * HEIGHT / yMax,
                pointList.get(pointList.size() - 1).x * WIDTH / xMax, pointList.get(pointList.size() - 1).y * HEIGHT / yMax));
        graphics2D.dispose();

        /*Saving the image*/
        String outputDirectoryName = "images";
        new File(outputDirectoryName).mkdirs();//TODO manage this
        ImageIO.write(image, "png", new File(outputDirectoryName + "/" + title));
    }

    public static void main(String[] args) throws IOException {
        Map<String, TspData> map = TspData.getDataFromFolder(Main.FOLDER_PATH);


        for (String title : map.keySet()) {
            generatePNG(NN.solve(map.get(title)), title + ".NN.png");
            generatePNG(MultiFragment.solveAndReturnListOfEdges(map.get(title)), title + ".MF.png");
        }


        //generatePNGfromEdges(MultiFragment.solve(map.get("fake.tsp")), "fake2.MF.png");
        //generatePNG(NN.solve(map.get("fake.tsp")), "fake2.png");

        /*
        List<Point> list = NN.solve(tspData);
        generatePNG(list, "image3.png");
        */
    }
}
