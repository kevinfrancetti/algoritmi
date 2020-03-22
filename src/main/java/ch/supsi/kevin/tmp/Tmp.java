package ch.supsi.kevin.tmp;

import java.util.LinkedList;
import java.util.List;

public class Tmp {

    public static void main(String[] args){
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for(int i = 0; i < list.size(); i++){
            list.remove(i);
        }





        int[] array = {1,2,3};
        System.out.println(array);
        System.out.println(array.getClass().getName() + "@" + Integer.toHexString(array.hashCode()));

        f1(array);

    }

    public static void f1(int[] array){
        System.out.println(array);
        array[2] = 726;
    }

    public static void f2(int a){

    }

}
