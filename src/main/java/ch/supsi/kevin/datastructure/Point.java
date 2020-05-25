package ch.supsi.kevin.datastructure;

import java.util.LinkedList;
import java.util.List;

public class Point {
    public float x, y;
    public List<Point> neighbours = new LinkedList<>();//SIZE == 2

    public Point(float x, float y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return " -- (x:" + x + ",y:" + y+")";
    }

    public static float distance(Point p1, Point p2){
        return (float) Math.sqrt( Math.pow((p2.x - p1.x), 2)  + Math.pow((p2.y - p1.y), 2) );
    }

    public static boolean connect(Point p1, Point p2){
        if(p1.neighbours.size() >= 2 || p2.neighbours.size() >= 2) return false;
        p1.neighbours.add(p2);
        p2.neighbours.add(p1);
        return true;
    }

    public static boolean disconnect(Point p1, Point p2){
        if(!p1.neighbours.contains(p2) || !p2.neighbours.contains(p1)) return false;
        p1.neighbours.remove(p2);
        p2.neighbours.remove(p1);
        return true;
    }

}
