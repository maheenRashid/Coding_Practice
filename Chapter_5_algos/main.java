import java.util.*;
public class main{
    public static void main(String [] args){
        int [] arr={0,5,7,3,4,9,8,1,3,2};
        Sec_1.mergeSort(arr);
        printArr(arr);
    }
        
    public static void printArr(int [] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}