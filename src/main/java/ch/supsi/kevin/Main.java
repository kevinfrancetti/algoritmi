package ch.supsi.kevin;

import ch.supsi.kevin.algos.metaheuristic.NN;
import ch.supsi.kevin.datastructure.TspData;


import java.io.File;
import java.util.*;

public class Main {
    private final static String folderPath = "src/main/resources/";

    public static void main(String[] args)  {
        Map<String, TspData> map;

        map = TspData.folderToMapOfTspData(new File(folderPath));
        for(String s : map.keySet()){
            System.out.println(s);
        }
        TspData fake = map.get("fake.tsp");
        float[] f = fake.data;
        f[1] = 666;
        System.out.println(fake.data[1]);



        //Drawer d = new Drawer();
        //d.test();

    }

}
