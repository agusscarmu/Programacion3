package Tp1.Ejercicio13;

import java.util.Arrays;

public class Fibonacci {
    

    public static void main(String[]args){
        System.out.println(Arrays.toString(fibonacci(19)));
    }
    
    public static int[] fibonacci(int limit){
        int[]fibonacci=new int[limit];
        fibonacci(fibonacci,limit-1,0,1);
        return fibonacci;
    }

    public static void fibonacci(int[]fibonacci, int limit, int anterior, int actual){
        if(limit>=0){
            int suma=anterior+actual;
            actual=anterior;
            anterior=suma;
            fibonacci(fibonacci,limit-1,anterior,actual);
            fibonacci[limit]=suma;
        }
    }
}
