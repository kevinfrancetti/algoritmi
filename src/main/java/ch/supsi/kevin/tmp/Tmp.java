package ch.supsi.kevin.tmp;

public class Tmp {

    public static void main(String[] args){

        /*
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
        */
        int[] a = new int[2];
        a[0] = 1;
        a[1] = 2;
        mmm(a);
        System.out.println(a[0]);

    }

    public static void mmm(int[] arr){
        arr[0] = 3243;
    }

    public static void f1(int[] array){
        System.out.println(array);
        array[2] = 726;
    }

    public static void f2(int a){

    }

}
