package ch.supsi.kevin;

import ch.supsi.kevin.datastructure.TspData;

import java.util.*;

public class Main {
    public final static String FOLDER_PATH = "src/main/resources/";

    public static void main(String[] args)  {

        /*Debug info
        System.out.println("args: ");
        for(String arg : args){
            System.out.print(arg + " ");
        }
        System.out.println();
         */

        if(args[0].matches("[aA][lL]{2}")){
            System.out.print("YES");

        }

        /*
        Map<String, TspData> map;

        map = TspData.folderToMapOfTspData(FOLDER_PATH);
        for(String s : map.keySet()){
            System.out.println(s);
        }
        TspData fake = map.get("fake.tsp");
        System.out.println(fake.size);
         */

    }
}
