package ch.supsi.kevin.datastructure;

import java.util.List;

public class Solution {
    public List<Edge> edgeList;
    public List<Edge> orderedListOfEdges;
    public List<Point> orderedListOfPoints;

    public Solution(List<Edge> edgeList, List<Edge> orderedListOfEdges, List<Point> orderedListOfPoints){
        this.edgeList = edgeList;
        this.orderedListOfEdges = orderedListOfEdges;
        this.orderedListOfPoints = orderedListOfPoints;
    }

    public Solution(){
        this(null, null, null);
    }

}
