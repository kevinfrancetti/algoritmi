package ch.supsi.kevin.tmp;

public class Tmp {

    public static void main(String[] args){
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
