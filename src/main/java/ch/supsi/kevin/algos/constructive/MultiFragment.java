package ch.supsi.kevin.algos.constructive;

import ch.supsi.kevin.Main;
import ch.supsi.kevin.datastructure.Arch;
import ch.supsi.kevin.datastructure.ListType;
import ch.supsi.kevin.datastructure.Point;
import ch.supsi.kevin.datastructure.TspData;

import java.util.*;
import java.util.List;

public class MultiFragment {


    public static void solve(TspData tspData){
        List<Point> inputPoints = tspData.toListOfPoint(ListType.LINKED);
        List<Point> outputPoints = new LinkedList<>();
        List<Arch> archList = new LinkedList<>();
        List<Arch> outputArchList = new LinkedList<>();

        for(int i = 0; i < inputPoints.size(); i++){
            for(int j = i+1; j < inputPoints.size(); j++){
                archList.add(new Arch(inputPoints.get(i), inputPoints.get(j)));
                System.out.println("i: " + i + " j: " + j);
            }
        }

        for(Arch a : archList){
            System.out.println(a.distance);
        }
        System.out.println("==========");

        archList.sort((Arch a1, Arch a2)->{
            float delta = a1.distance - a2.distance;
            if(delta > 0) return 1;
            if(delta < 0) return -1;
            return 0;
        } );

        for(Arch a : archList){
            System.out.println(a.distance);
        }
        System.out.println(archList.size());

        /*Describe how many connection has a point*/
        Map<Point, Integer> pointsCardinality = new HashMap<>();
        for(Arch arch : archList){

            if(checkAndUpdate(pointsCardinality, arch.p1) && checkAndUpdate(pointsCardinality, arch.p2)){
                outputArchList.add(arch);
            }

        }

        for(Arch arch : outputArchList){
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
            memory.put(point, 0);
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

    static void test(){
        Map<Integer, String> list = new HashMap<>();

        System.out.println(list.computeIfAbsent(3, key -> "Ciaone"));
        System.out.println(list.computeIfPresent(4, (key, val) -> "Cazzo"));
        System.out.println("ffeef");
    }

}
