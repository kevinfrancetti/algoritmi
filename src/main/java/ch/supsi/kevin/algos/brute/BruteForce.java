package ch.supsi.kevin.algos.brute;

//Bad solution, could be improved. But it's meaningless!
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

    public static void permute(int n, int[] a){
        if(n == 1){
            //print(a, "");//here the calculations should be performed
            return;
        }

        for(int i = 0; i < n; i++){
            swap(n-1, n-1-i, a);
            permute(n-1, a);
            swap(n-1, n-1-i, a);
        }

    }

    public static void main(String[] args){
        System.out.println("==Args==");
        for(String s : args) {
            System.out.println(s);
        }
        System.out.println("=======");
        int[] a = new int[Integer.parseInt(args[0])];
        for(int i = 0; i < a.length; i++){
            a[i] = i;
        }
        permute(a.length,a);
    }


}
