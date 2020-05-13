package ch.supsi.kevin.datastructure;

public class Point {
    public float x, y;

    public Point(float x, float y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "x: " + x + "  y: " + y;
    }

    public static float distance(Point p1, Point p2){
        return (float) Math.sqrt( Math.pow((p2.x - p1.x), 2)  + Math.pow((p2.y - p1.y), 2) );
    }

}
