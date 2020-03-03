package ch.supsi.kevin.tspfilereader;

import java.io.*;

public class TspFileToData {

    public static void convert(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while (true){
            String line = bufferedReader.readLine();
            if(line == null) break;
            System.out.println(line);
        }

    }

}
