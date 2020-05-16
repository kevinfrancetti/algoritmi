package ch.supsi.kevin.algos.constructive;

import ch.supsi.kevin.Main;
import ch.supsi.kevin.datastructure.*;
import ch.supsi.kevin.graphics.ImageGenerator;

import java.io.IOException;
import java.util.*;
import java.util.List;

public class MultiFragment {

    public static List<Edge> solve(TspData tspData) {
        List<Point> inputPoints = tspData.toListOfPoint(ListType.LINKED);
        List<Edge> edges = new LinkedList<>();
        List<Edge> outputEdgeList = new LinkedList<>();

        /*Getting all the possible edges*/
        for (int i = 0; i < inputPoints.size(); i++) {
            for (int j = i + 1; j < inputPoints.size(); j++) {
                edges.add(new Edge(inputPoints.get(i), inputPoints.get(j)));
                //System.out.println("i: " + i + " j: " + j);
            }
        }

        /*Sorting in ascending order*/
        edges.sort((Edge a1, Edge a2) -> {
            float delta = a1.distance - a2.distance;
            if (delta > 0) return 1;
            if (delta < 0) return -1;
            return 0;
        });

        float distance = 0;//TODO tmp
        for (Edge edge : edges) {

            /*Check conditions*/
            if (edge.p1.neighbours.size() >= 2 || edge.p2.neighbours.size() >= 2) continue;
            Point.connect(edge.p1, edge.p2);
            if (checkIfCyclic(edge) && outputEdgeList.size() + 1 != inputPoints.size()) {//Recursive check
                Point.disconnect(edge.p1, edge.p2);
                continue;
            }
            outputEdgeList.add(edge);
            distance += edge.distance;
        }

        System.out.println(tspData.name + ".MF  Length: " + distance);
        return outputEdgeList;
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
        //Set<Point> memory = new HashSet<>();//TODO check this, seems strange
        return recursiveCheck(e.p1, e.p1, new HashSet<>()) && recursiveCheck(e.p2, e.p2, new HashSet<>());
    }

    public static void main(String[] args) throws IOException {

        Map<String, TspData> map = TspData.folderToMapOfTspData(Main.FOLDER_PATH);
        TspData data = map.get("fake.tsp");
        List<Edge> solution = solve(data);
        ImageGenerator.generatePNGfromEdges(solution, "ZZ.png");

        float distance = 0;
        for (Edge e : solution) {
            System.out.println(e);
            distance += e.distance;
        }
        System.out.println("Distance: " + distance);

    }
}
