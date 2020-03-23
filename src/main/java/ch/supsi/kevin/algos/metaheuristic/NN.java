package ch.supsi.kevin.algos.metaheuristic;

import ch.supsi.kevin.datastructure.ListType;
import ch.supsi.kevin.datastructure.Point;
import ch.supsi.kevin.datastructure.TspData;

import java.util.LinkedList;
import java.util.List;

public class NN {

    public static List<Point> solve(TspData tspData){
        List<Point> inputPoints = TspData.floatToListOfPoint(tspData, ListType.LINKED);
        List<Point> outputPoints = new LinkedList<>();

        Point current = inputPoints.remove(8);//This should be random or seed
        outputPoints.add(current);

        float sumOfDistances = 0;

        while (inputPoints.size() != 1){
            float tmpMinDistance = Float.MAX_VALUE;
            int tmpMinDistIndex = -1;

            for(int i = 0; i < inputPoints.size(); i++){
                float distance = distance(current, inputPoints.get(i));

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

    public static float distance(Point p1, Point p2){
        return (float) Math.sqrt( Math.pow((p2.x - p1.x), 2)  + Math.pow((p2.y - p1.y), 2) );
    }


    public static void main(String[] args){
        System.out.println("Nearest neighbour");
        List<Point> path = solve(TspData.folderToMapOfTspData("src/main/resources/").get("fl1577.tsp"));

        for(Point p : path){
            System.out.println(p);
        }

    }

}
