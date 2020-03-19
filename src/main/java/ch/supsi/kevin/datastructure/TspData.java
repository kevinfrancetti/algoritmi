package ch.supsi.kevin.datastructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TspData {
    public final float[] data;//Length will always be even
    public final int size;

    public TspData(float[] data){
        this.data = data;
        this.size = data.length / 2;
    }

    public TspData(List<Float> data){
        this.data = new float[data.size()];
        this.size = this.data.length / 2;
        for(int i = 0; i < this.data.length; i++){
            this.data[i] = data.get(i);
        }
    }

    /*DEBUG PROPOSE*/
    public void printData(){
        for(int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }
    }

    /**
     * Reads all .tsp files inside a folder and returns a list of {@link TspData}
     * @param folder {@link File} that is  folder.
     * @return list of {@link TspData}
     */
    @Deprecated
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
