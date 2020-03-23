package ch.supsi.kevin;

import ch.supsi.kevin.datastructure.TspData;

import java.util.*;

public class Main {
    private final static String FOLDER_PATH = "src/main/resources/";

    public static void main(String[] args)  {
        Map<String, TspData> map;

        map = TspData.folderToMapOfTspData(FOLDER_PATH);
        for(String s : map.keySet()){
            System.out.println(s);
        }
        TspData fake = map.get("fake.tsp");
        System.out.println(fake.size);

    }
}
