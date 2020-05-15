package ch.supsi.kevin.tmp;

import java.util.*;

class LP {
    int x, y;
    int name;
    List<LP> neighbours = new LinkedList<>();
    public LP(int x, int y){
        this.x = x;
        this.y = y;
    }

    public LP(int name){
        this(0,0);
        this.name = name;
    }

    boolean add(LP point){
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

    static boolean isCycle(LP p, LP previous, Set<LP> memory){
        memory.add(p);
        for(LP neighbour : p.neighbours){
            if(neighbour.equals(previous)) continue;
            if(memory.contains(neighbour)) return true;
            if(isCycle(neighbour, p, memory)) return true;
        }
        return false;
    }

    static void starter(LP p){
        Set<LP> memory = new HashSet<>();
        System.out.println(isCycle(p, p, memory));
    }

    public static void main(String[] args){
        System.out.println("Yolo");

        LP p1 = new LP(1);
        LP p2 = new LP(2);
        LP p3 = new LP(3);
        LP p4 = new LP(4);
        LP p5 = new LP(5);

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
