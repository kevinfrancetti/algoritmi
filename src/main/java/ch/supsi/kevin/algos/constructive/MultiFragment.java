package ch.supsi.kevin.algos.constructive;

import ch.supsi.kevin.Main;
import ch.supsi.kevin.datastructure.*;

import java.util.*;
import java.util.List;

public class MultiFragment {


    public static void solve(TspData tspData) {
        List<Point> inputPoints = tspData.toListOfPoint(ListType.LINKED);
        List<Point> outputPoints = new LinkedList<>();
        List<Edge> edges = new LinkedList<>();
        List<Edge> outputEdgeList = new LinkedList<>();

        /*Getting all the possible edges*/
        for (int i = 0; i < inputPoints.size(); i++) {
            for (int j = i + 1; j < inputPoints.size(); j++) {
                edges.add(new Edge(inputPoints.get(i), inputPoints.get(j)));
                System.out.println("i: " + i + " j: " + j);
            }
        }

        for (Edge a : edges) {
            System.out.println(a.distance);
        }
        System.out.println("==========");

        /*Sorting in ascending order*/
        edges.sort((Edge a1, Edge a2) -> {
            float delta = a1.distance - a2.distance;
            if (delta > 0) return 1;
            if (delta < 0) return -1;
            return 0;
        });

        for (Edge a : edges) {
            System.out.println(a.distance);
        }
        System.out.println(edges.size());

        for (Edge edge : edges) {

            /*Check conditions*/
            if(edge.p1.neighbours.size() >= 2 || edge.p2.neighbours.size() >=2) continue;
            Point.connect(edge.p1, edge.p2);
            if(checkIfCyclic(edge)){
                Point.disconnect(edge.p1, edge.p2);
                continue;
            }
            outputEdgeList.add(edge);

        }

        float distance = 0;
        for (Edge edge : outputEdgeList) {
            System.out.println(edge);
            distance += edge.distance;
        }
        System.out.println("Number of edges: " + outputEdgeList.size());
        System.out.println("Length: " + distance);
    }

    static boolean recursiveCheck(Point p, Point previous, Set<Point> memory) {
        memory.add(p);
        for (Point neighbour : p.neighbours) {
            if (neighbour.equals(previous)) continue;
            if (memory.contains(neighbour)) return true;
            if (recursiveCheck(neighbour, p, memory)) return true;
        }
        return false;
    }

    static boolean checkIfCyclic(Edge e) {
        Set<Point> memory = new HashSet<>();
        return recursiveCheck(e.p1, e.p1, new HashSet<>()) && recursiveCheck(e.p2, e.p2, new HashSet<>());
    }

    public static void main(String[] args) {

        Map<String, TspData> map = TspData.folderToMapOfTspData(Main.FOLDER_PATH);
        TspData data = map.get("fake.tsp");
        solve(data);

        System.out.println("Yolo");

    }

}
