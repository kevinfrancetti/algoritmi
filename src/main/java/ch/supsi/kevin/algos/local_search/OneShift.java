package ch.supsi.kevin.algos.local_search;

import ch.supsi.kevin.Main;
import ch.supsi.kevin.algos.constructive.MultiFragment;
import ch.supsi.kevin.algos.constructive.NN;
import ch.supsi.kevin.datastructure.City;
import ch.supsi.kevin.datastructure.TspData;
import ch.supsi.kevin.graphics.ImageGenerator;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class OneShift {

    public static boolean swap(List<City> list, int index) {

        if (index >= list.size()) return false;
        int nextIndex = (index + 1) % list.size();


        City tmp = list.get(index);
        list.set(index, list.get(nextIndex));
        list.set(nextIndex, tmp);
        return true;
    }



    private static float delta(List<City> list, int index){

        Function<Integer, Integer> indexFunction = (i) -> {
            if (i == -1) return list.size() - 1;
            return i % list.size();
        };

        float delta = -City.distance(list.get(indexFunction.apply(index)), list.get(indexFunction.apply(index - 1)));
        delta -= City.distance(list.get(indexFunction.apply(index + 1)), list.get(indexFunction.apply(index + 2)));

        delta += City.distance(list.get(indexFunction.apply(index + 1)), list.get(indexFunction.apply(index - 1)));
        delta += City.distance(list.get(indexFunction.apply(index)), list.get(indexFunction.apply(index + 2)));
        return delta;
    }

    public static float computeLength(List<City> tour){
        City previous = null;
        float length = 0;
        for(City city : tour){
            if(previous == null){
                previous = city;
                continue;
            }
            float tmp = City.distance(previous, city);
            length += tmp;
            previous = city;
        }
        float tmp = City.distance(tour.get(0), tour.get(tour.size() - 1));
        length += tmp;
        return length;
    }



    public static void main(String[] args) throws IOException {
        Map<String, TspData> data = TspData.getDataFromFolder(Main.FOLDER_PATH);
        TspData tspdata = data.get("fake.tsp");
        List<City> path1 = NN.solve(tspdata);
        List<City> path2 = MultiFragment.solve(tspdata);
        System.out.println(computeLength(path1));
        System.out.println(computeLength(path2));


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
