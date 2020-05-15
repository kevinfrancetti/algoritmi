package ch.supsi.kevin.algos.constructive;

import ch.supsi.kevin.Main;
import ch.supsi.kevin.datastructure.Edge;
import ch.supsi.kevin.datastructure.ListType;
import ch.supsi.kevin.datastructure.Point;
import ch.supsi.kevin.datastructure.TspData;

import java.util.*;
import java.util.List;

public class MultiFragment {


    public static void solve(TspData tspData){
        List<Point> inputPoints = tspData.toListOfPoint(ListType.LINKED);
        List<Point> outputPoints = new LinkedList<>();
        List<Edge> edges = new LinkedList<>();
        List<Edge> outputArchList = new LinkedList<>();

        /*Getting all the possible edges*/
        for(int i = 0; i < inputPoints.size(); i++){
            for(int j = i+1; j < inputPoints.size(); j++){
                edges.add(new Edge(inputPoints.get(i), inputPoints.get(j)));
                System.out.println("i: " + i + " j: " + j);
            }
        }

        for(Edge a : edges){
            System.out.println(a.distance);
        }
        System.out.println("==========");

        /*Sorting in ascending order*/
        edges.sort((Edge a1, Edge a2)->{
            float delta = a1.distance - a2.distance;
            if(delta > 0) return 1;
            if(delta < 0) return -1;
            return 0;
        } );

        for(Edge a : edges){
            System.out.println(a.distance);
        }
        System.out.println(edges.size());

        /*Describe how many connection has a point*/
        Map<Point, Integer> usedPoints = new HashMap<>();

        for(Edge edge : edges){

            if(!usedPoints.containsKey(edge.p1)){
                usedPoints.put(edge.p1, 0);
            }
            if(!usedPoints.containsKey(edge.p2)){
                usedPoints.put(edge.p2, 0);
            }

            if(usedPoints.get(edge.p1) >= 1 && usedPoints.get(edge.p2) >= 1) continue;
            if(usedPoints.get(edge.p1) >= 2 || usedPoints.get(edge.p2) >= 2) continue;

            usedPoints.put(edge.p1, usedPoints.get(edge.p1) + 1);
            usedPoints.put(edge.p2, usedPoints.get(edge.p2) + 1);
            outputArchList.add(edge);

        }


        for(Edge arch : outputArchList){
            System.out.println(arch);
        }
        System.out.println(outputArchList.size());
    }

    private static boolean checkAndUpdate(Map<Point, Integer> memory, Point point){
        if(memory.containsKey(point)){
            int tmpPointValue = memory.get(point);
            if(tmpPointValue >= 2) return false;
            else memory.put(point, tmpPointValue+1);
        }else {
            memory.put(point, 1);
            return true;
        }
        return true;
    }

    private static boolean checkAndUpdate2(Map<Point, Integer> memory, Point point1, Point point2){
        if(memory.containsKey(point1) && memory.containsKey(point2)) return false;
        if(memory.containsKey(point1)){
            int tmpPointValue = memory.get(point1);
            if(tmpPointValue >= 2) return false;
            else memory.put(point1, tmpPointValue+1);
        }else {
            memory.put(point1, 1);
            return true;
        }
        return true;
    }

    public static void main(String[] args){

        Map<String, TspData> map = TspData.folderToMapOfTspData(Main.FOLDER_PATH);
        TspData data = map.get("fake.tsp");
        solve(data);

        System.out.println("Yolo");

    }

}
