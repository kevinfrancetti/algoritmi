package ch.supsi.kevin.datastructure;

public class Edge {
    public City p1;
    public City p2;
    public float distance;

    public Edge(City p1, City p2){
        this.p1 = p1;
        this.p2 = p2;
        distance = distance();
    }

    public float distance(){
        return City.distance(p1,p2);
    }

    public String toString(){
        return "p1(" + p1 + ") --- p2(" + p2 + ")    distance: " + distance;
    }

}
