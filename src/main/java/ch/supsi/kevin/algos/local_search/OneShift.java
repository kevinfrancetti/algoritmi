package ch.supsi.kevin.algos.local_search;

import ch.supsi.kevin.datastructure.Point;

import java.util.List;

public class OneShift {


    public boolean shiftRight(List<Point> list, int index){
        if(index == list.size() - 1) return false;//Something wrong if return false
        Point tmp = list.get(index);
        list.set(index, list.get(index + 1));
        list.set(index + 1, tmp);
        return true;
    }


}
