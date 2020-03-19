package ch.supsi.kevin.tspfilereader;

import ch.supsi.kevin.datastructure.TspData;

import java.io.*;
import java.util.*;

/**
 * @author Kevin
 * This class converts .tsp files into data
 */
@Deprecated
public class TspFileToData {

    /**
     * Reads all .tsp files and returns a list of {@link TspData}
     * @param folder
     * @return list of {@link TspData}
     */
    public static List<TspData> folderToListOfTspData(File folder) {
        List<TspData> tspDataArrayList = new ArrayList<>();
        for (String s : folder.list()) {
            if (s.matches(".*\\.tsp$")) {//Find all files ending with .tsp
                tspDataArrayList.add(fileToTspData(new File(folder.toString() + "/" + s)));
            }
        }
        return tspDataArrayList;
    }

    public static Map<String, TspData> folderToMapOfTspData(File folder) {
        List<TspData> tspDataArrayList = new ArrayList<>();
        Map<String, TspData> map = new HashMap<>();
        for (String s : folder.list()) {
            if (s.matches(".*\\.tsp$")) {//Find all files ending with .tsp
                map.put(s, fileToTspData(new File(folder.toString() + "/" + s)));
            }
        }
        return map;
    }


    private static TspData fileToTspData(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            //Skip 8 lines because of the file format.
            for (int i = 0; i < 7; i++) {
                bufferedReader.readLine();
            }
            List<Float> list = new LinkedList<>();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null || line.equals("EOF")) {
                    return new TspData(list);
                }
                String[] tmp = line.split(" ");
                list.add(Float.parseFloat(tmp[1]));
                list.add(Float.parseFloat(tmp[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;//Something went wrong if you land here
    }
}