package ch.supsi.kevin.tspfilereader;

import ch.supsi.kevin.datastructure.TspData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin
 * This class converts .tsp files into data
 */
public class TspFileToData {

    public static List<TspData> convertFromFolder(File folder) {
        List<TspData> data = new ArrayList<>();
        for (String s : folder.list()) {
            if (s.matches(".*\\.tsp$")) {//Find all files ending with .tsp
                data.add(convertFromFile(new File(folder.toString() + "/" + s)));
            }
        }
        return data;
    }

    public static TspData convertFromFile(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            //Skip 8 lines because of the file format.
            for (int i = 0; i < 7; i++) {
                bufferedReader.readLine();
            }
            List<Float> list = new ArrayList<>();
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
        return null;//Something went wrong if here
    }

}
