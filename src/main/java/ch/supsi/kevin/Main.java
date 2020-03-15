package ch.supsi.kevin;

import ch.supsi.kevin.datastructure.TspData;
import ch.supsi.kevin.graphics.drawer.Drawer;
import ch.supsi.kevin.tspfilereader.TspFileToData;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args)  {

        System.out.println("hello, world banana");
        StringBuilder sb = new StringBuilder("src/main/resources/");

        List<TspData> tspDataList;

        tspDataList = TspFileToData.convertFromFolder(new File(sb.toString()));
        for(TspData data : tspDataList){
            data.printData();
            System.out.println();
        }

        System.out.println("YOLO");

        //Drawer d = new Drawer();
        //d.test();

    }

}
