package ch.supsi.kevin.algos.constructive;

import ch.supsi.kevin.Main;
import ch.supsi.kevin.datastructure.ListType;
import ch.supsi.kevin.datastructure.City;
import ch.supsi.kevin.datastructure.TspData;
import ch.supsi.kevin.graphics.ImageGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NN {

    public static List<City> solve(TspData tspData) {
        List<City> cities = tspData.getCities(ListType.LINKED);
        List<City> tour = new ArrayList<>(tspData.getNumberOfCities());

        City currentCity = cities.remove(0);//This should be random or seed
        tour.add(currentCity);

        float totalDistance = 0;

        while (cities.size() != 0) {
            float minDistance = Float.MAX_VALUE;
            City nearest = null;

            for (City city : cities) {
                float distance = City.distance(currentCity, city);

                if (distance < minDistance) {
                    nearest = city;
                    minDistance = distance;
                }
            }

            totalDistance += minDistance;
            cities.remove(nearest);
            tour.add(nearest);
        }
        totalDistance += City.distance(tour.get(0), tour.get(tour.size() - 1));

        System.out.println(tspData.getName() + ".NN  Lenght: " + totalDistance);//TODO tmp
        return tour;
    }


    public static void main(String[] args) throws IOException {
        System.out.println("Nearest neighbour");
        List<City> path = solve(TspData.getDataFromFolder(Main.FOLDER_PATH).get("fake.tsp"));
        ImageGenerator.generatePNG(path, "testfake.NN.tsp.png");
        for (City p : path) {
            System.out.println(p);
        }
    }
}
