package ch.supsi.kevin.algos.brute;

public class BruteForce {

    public static void swap(int n, int index, int[] a){
        if(n == 0) return;
        int tmp = a[n];
        a[n] = a[index];
        a[index] = tmp;
    }

    public static void print(int[] a, String msg){
        System.out.println(msg);
        for(int val : a){
            System.out.print(val + " ");
        }
        //System.out.println();
    }

    public static void f(int n, int[] a){
        if(n == 1){
            print(a, "");
            return;
        }

        for(int i = 0; i < n; i++){
            swap(n-1, n-1-i, a);
            f(n-1, a);
            swap(n-1, n-1-i, a);
        }

    }

    public static void main(String[] args){
        int[] a = {1,2,3};

        f(a.length,a);



    }


}
