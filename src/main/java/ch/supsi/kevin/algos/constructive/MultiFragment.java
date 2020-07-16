package ch.supsi.kevin.algos.constructive;

import ch.supsi.kevin.Main;
import ch.supsi.kevin.datastructure.*;
import ch.supsi.kevin.graphics.ImageGenerator;

import java.io.IOException;
import java.util.*;
import java.util.List;

public class MultiFragment {

    public static List<City> solve(TspData tspData){
        List<Edge> edgeList = solveAndReturnListOfEdges(tspData);
        return createListFromOneEdge(edgeList.get(0));//Edge should be in a cyclic tour
    }

    private static List<Edge> solveAndReturnListOfEdges(TspData tspData) {
        List<City> points = tspData.getCities(ListType.ARRAY);
        List<Edge> edges = new ArrayList<>();
        List<Edge> outputEdges = new ArrayList<>();

        /*Getting all the possible edges*/
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                edges.add(new Edge(points.get(i), points.get(j)));
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
            City.connect(edge.p1, edge.p2);
            if (checkIfCyclic(edge) && outputEdges.size() + 1 != points.size()) {//Recursive check
                City.disconnect(edge.p1, edge.p2);
                continue;
            }
            outputEdges.add(edge);
            distance += edge.distance;
        }

        System.out.println(tspData.getName() + ".MF  Length: " + distance);

        return outputEdges;
    }

    public static List<City> createListFromOneEdge(Edge e){
        List<City> list = new LinkedList<>();
        recursiveCycleCheck(e.p1, null, new HashSet<>(), list);
        return list;
    }

    private static boolean checkIfCyclic(Edge e) {
        return recursiveCycleCheck(e.p1, null, new HashSet<>(), null);
    }

    /*If list is null then the cycle is not saved, but it will still give an answer*/
    private static boolean recursiveCycleCheck(City p, City previous, Set<City> visitedPoints, List<City> list){
        visitedPoints.add(p);
        if(list != null) list.add(p);
        for (City neighbour : p.neighbours) {
            if (neighbour.equals(previous)) continue;
            if (visitedPoints.contains(neighbour)) return true;
            return recursiveCycleCheck(neighbour, p, visitedPoints, list);
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        Map<String, TspData> map = TspData.getDataFromFolder(Main.FOLDER_PATH);
        TspData data = map.get("eil76.tsp");
        List<Edge> solutionEdge = solveAndReturnListOfEdges(data);
        List<City> solutionList = createListFromOneEdge(solutionEdge.get(0));
        //System.out.println(solutionList.size());
        ImageGenerator.generatePNG(solutionEdge, "ZZ.png");

        float distance = 0;
        for (Edge e : solutionEdge) {
            System.out.println(e);
            distance += e.distance;
        }
        System.out.println("Distance: " + distance);

    }
}
