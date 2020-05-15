package ch.supsi.kevin.tmp;

import java.util.*;

class LinkedPoint {
    int x, y;
    int name;
    List<LinkedPoint> neighbours = new LinkedList<>();
    public LinkedPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public LinkedPoint(int name){
        this(0,0);
        this.name = name;
    }

    boolean add(LinkedPoint point){
        //if(neighbours.size() >= 2) return false;
        //if(point.neighbours.size() >=2) return false;
        neighbours.add(point);
        point.neighbours.add(this);
        return true;
    }

    public String toString(){
        return ""+name;
    }
}



public class CycleTest {

    static boolean isCycle(LinkedPoint p, LinkedPoint previous, Set<LinkedPoint> memory){
        memory.add(p);
        for(LinkedPoint neighbour : p.neighbours){
            if(neighbour.equals(previous)) continue;
            if(memory.contains(neighbour)) return true;
            if(isCycle(neighbour, p, memory)) return true;
        }
        return false;
    }

    static void starter(LinkedPoint p){
        Set<LinkedPoint> memory = new HashSet<>();
        System.out.println(isCycle(p, p, memory));
    }

    public static void main(String[] args){
        System.out.println("Yolo");

        LinkedPoint p1 = new LinkedPoint(1);
        LinkedPoint p2 = new LinkedPoint(2);
        LinkedPoint p3 = new LinkedPoint(3);
        LinkedPoint p4 = new LinkedPoint(4);
        LinkedPoint p5 = new LinkedPoint(5);

        p1.add(p2);
        p2.add(p3);
        p3.add(p4);
        //p4.add(p2);
        p3.add(p5);
        p5.add(p1);
        //p3.add(p4);


        starter(p1);


    }

}
