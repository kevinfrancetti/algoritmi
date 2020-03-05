package ch.supsi.kevin;

import ch.supsi.kevin.graphics.drawer.Drawer;
import ch.supsi.kevin.tspfilereader.TspFileToData;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args)  {
        System.out.println("hello, world banana");
        File f = new File("src/main/resources/ch130.tsp");
        try {
            TspFileToData.convert(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Drawer d = new Drawer();
        //d.test();

    }

}
