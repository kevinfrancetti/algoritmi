package ch.supsi.kevin.algos.local_search;

import ch.supsi.kevin.Main;
import ch.supsi.kevin.algos.constructive.MultiFragment;
import ch.supsi.kevin.algos.constructive.NN;
import ch.supsi.kevin.datastructure.Point;
import ch.supsi.kevin.datastructure.TspData;
import ch.supsi.kevin.graphics.ImageGenerator;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class OneShift {

    public static boolean swap(List<Point> list, int index) {
        if (index >= list.size()) return false;
        int nextIndex = (index + 1) % list.size();


        float distanceToSubrtact = 0;


        Point tmp = list.get(index);
        list.set(index, list.get(nextIndex));
        list.set(nextIndex, tmp);
        return true;
    }


    public static void main(String[] args) throws IOException {
        Map<String, TspData> data = TspData.folderToMapOfTspData(Main.FOLDER_PATH);
        TspData tspdata = data.get("fake.tsp");
        List<Point> path1 = NN.solve(tspdata);
        List<Point> path2 = MultiFragment.solveAndReturnListOfPoints(tspdata);

        ImageGenerator.generatePNG(path1, "1.png");
        ImageGenerator.generatePNG(path2, "2.png");

        System.out.println(path1);
        System.out.println(path2);



    }


}
