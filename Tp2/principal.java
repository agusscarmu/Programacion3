package Tp2;

import java.util.Arrays;

public class principal {
    
    public static void main(String[]args){
        MergeSort ms=new MergeSort();
        int[]arr={1,4,3,2,6,5,7,9,8};

        ms.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
