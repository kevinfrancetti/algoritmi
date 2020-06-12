package ch.supsi.kevin.datastructure;

import java.util.List;

public class Solution {
    private List<City> tour;
    private float length;

    public Solution(){

    }

    public float computeLength(){
        City previous = null;
        length = 0;
        for(City city : tour){
            if(previous == null){
                previous = city;
                continue;
            }
            length += City.distance(previous, city);
        }
        length += City.distance(tour.get(0), tour.get(tour.size() - 1));
        return length;
    }



}
