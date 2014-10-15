import java.util.*;
public class main{
    public static void main(String [] args){
        // int a=12;
        // System.out.println( Sec_4.josephusProblem(a));
        int [] arr={0,5,7,3,4,9,8,1,3,2};
        Sec_5.quickSort(arr,0,arr.length);
        printArr(arr);
        // for (int i=1;i<arr.length;i++){
            // int pivot=Sec_5.getKthLargest(arr,i);
            // System.out.println(pivot);
            // System.out.println(arr[pivot]);
            // printArr(arr);
        // }
    }
        
    public static void printArr(int [] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}