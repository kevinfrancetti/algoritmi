package ch.supsi.kevin.datastructure;

public class Edge {
    public Point p1;
    public Point p2;
    public float distance;

    public Edge(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
        distance = distance();
    }

    public float distance(){
        return Point.distance(p1,p2);
    }

    public String toString(){
        return "p1(" + p1 + ") --- p2(" + p2 + ")    distance: " + distance;
    }

}
