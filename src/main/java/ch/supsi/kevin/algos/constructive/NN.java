package ch.supsi.kevin.algos.constructive;

import ch.supsi.kevin.Main;
import ch.supsi.kevin.datastructure.ListType;
import ch.supsi.kevin.datastructure.Point;
import ch.supsi.kevin.datastructure.TspData;

import java.util.LinkedList;
import java.util.List;

public class NN {

    public static List<Point> solve(TspData tspData){
        List<Point> inputPoints = tspData.toListOfPoint(ListType.LINKED);
        List<Point> outputPoints = new LinkedList<>();

        Point current = inputPoints.remove(0);//This should be random or seed
        outputPoints.add(current);

        float sumOfDistances = 0;

        while (inputPoints.size() != 0){//TODO ERROR
            float tmpMinDistance = Float.MAX_VALUE;
            int tmpMinDistIndex = -1;

            for(int i = 0; i < inputPoints.size(); i++){
                float distance = Point.distance(current, inputPoints.get(i));

                if(distance < tmpMinDistance){
                    tmpMinDistIndex = i;
                    tmpMinDistance = distance;
                }
            }
            sumOfDistances += tmpMinDistance;
            current = inputPoints.remove(tmpMinDistIndex);
            outputPoints.add(current);
        }

        System.out.println(sumOfDistances);//TODO tmp
        return outputPoints;
    }


    public static void main(String[] args){
        System.out.println("Nearest neighbour");
        List<Point> path = solve(TspData.folderToMapOfTspData(Main.FOLDER_PATH).get("fake.tsp"));

        for(Point p : path){
            System.out.println(p);
        }
    }
}
