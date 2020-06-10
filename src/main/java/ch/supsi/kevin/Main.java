package ch.supsi.kevin;

import ch.supsi.kevin.algos.constructive.MultiFragment;
import ch.supsi.kevin.algos.constructive.NN;
import ch.supsi.kevin.datastructure.TspData;

import java.util.Map;

public class Main {
    public final static String FOLDER_PATH = "src/main/resources/";

    public static void main(String[] args)  {

        /*
        BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(lineReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
         */

        Map<String, TspData> map = TspData.getDataFromFolder(Main.FOLDER_PATH);
        for(String title : map.keySet()){
            NN.solve(map.get(title));
            MultiFragment.solve(map.get(title));
        }

        /*
        if(args[0].matches("[aA][lL]{2}")){
            System.out.print("YES");
        }
        */

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
