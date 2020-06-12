package ch.supsi.kevin.datastructure;

import ch.supsi.kevin.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * All the data is stored inside a float[], every point is composed by x and y,
 * hence the size of a single data is two floats
 */
public class TspData {
    private final String name;
    private final List<City> cities;

    private TspData(List<City> dataList, String name) {
        this.cities = dataList;
        this.name = name;
    }

    public List<City> getCities(ListType type) {
        if(type.equals(ListType.LINKED)) return new LinkedList<>(cities);
        return new ArrayList<>(cities);
    }

    public String getName(){
        return name;
    }

    public int getNumberOfCities(){
        return cities.size();
    }

    /*=============PUBLIC STATIC METHODS===============*/

    /**
     * Reads all .tsp files inside a folder and returns a map {@link Map}
     * where the key is the filename with the extension included
     *
     * @param folderPath {@link String} a folder containing .tsp files.
     * @return Map of {@link TspData}
     */
    public static Map<String, TspData> getDataFromFolder(String folderPath) {
        File folder = new File(folderPath);
        Map<String, TspData> map = new HashMap<>();
        for (String fileName : folder.list()) {
            if (fileName.matches(".*\\.tsp$")) {//Find all files ending with .tsp
                map.put(fileName, fileToTspData(folder.toString() + "/" + fileName));
            }
        }
        return map;
    }

    /*=============PRIVATE STATIC METHODS===============*/

    /*Read a single file and returns a TspData Object*/
    private static TspData fileToTspData(String filePath) {
        try {
            File file = new File(filePath);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            //Skip 8 lines because of the file format.
            for (int i = 0; i < 7; i++) {
                bufferedReader.readLine();
            }
            List<City> cities = new ArrayList<>();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null || line.equals("EOF")) {
                    return new TspData(cities, file.getName());
                }
                String[] tmp = line.split(" ");
                cities.add(new City(Float.parseFloat(tmp[1]), Float.parseFloat(tmp[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;//Something went wrong if you land here
    }


    public static void main(String[] args) {
        Map<String, TspData> map = TspData.getDataFromFolder(Main.FOLDER_PATH);

    }

}
