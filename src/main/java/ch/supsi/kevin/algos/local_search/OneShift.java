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
import java.util.function.Function;

public class OneShift {

    public static boolean swap(List<Point> list, int index) {

        Function<Integer, Integer> indexFunction = (i) -> {
            if (i == -1) return list.size() - 1;
            return i % list.size();
        };

        if (indexFunction.apply(index) >= list.size()) return false;
        int nextIndex = indexFunction.apply(index + 1);


        float delta = -Point.distance(list.get(indexFunction.apply(index)), list.get(indexFunction.apply(index - 1)));
        delta -= Point.distance(list.get(indexFunction.apply(index + 1)), list.get(indexFunction.apply(index + 2)));

        delta += Point.distance(list.get(indexFunction.apply(index + 1)), list.get(indexFunction.apply(index - 1)));
        delta += Point.distance(list.get(indexFunction.apply(index)), list.get(indexFunction.apply(index + 2)));
        System.out.println(delta);

        Point tmp = list.get(index);
        list.set(index, list.get(nextIndex));
        list.set(nextIndex, tmp);
        return true;
    }


    public static void main(String[] args) throws IOException {
        Map<String, TspData> data = TspData.getDataFromFolder(Main.FOLDER_PATH);
        TspData tspdata = data.get("fake.tsp");
        List<Point> path1 = NN.solve(tspdata);
        List<Point> path2 = MultiFragment.solve(tspdata);

        ImageGenerator.generatePNG(path1, "1.png");
        ImageGenerator.generatePNG(path2, "2.png");

        for (int i = 0; i < path1.size(); i++) {
            System.out.println(path1);
            swap(path1, i);
            System.out.println(path1);
            ImageGenerator.generatePNG(path1, i + "_.png");
            swap(path1, i);
            System.out.println("====");
        }

        System.out.println(path1);
        System.out.println(path2);


    }


}
