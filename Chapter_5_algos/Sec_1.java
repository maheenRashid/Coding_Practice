import java.util.*;

public class Sec_1{
    public static void mergeSort(int [] arr){
        if (arr.length<=1)
            return;
        int mid= (int) Math.floor(arr.length/2);
        int [] a = Arrays.copyOfRange(arr,0,mid);
        int [] b= Arrays.copyOfRange(arr,mid,arr.length);
        mergeSort(a);
        mergeSort(b);
        merge(arr,a,b);
    }
    
    private static void merge(int [] arr, int [] a , int [] b){
        int arr_idx=0;
        int a_idx=0;
        int b_idx=0;
        while(arr_idx<arr.length){
            if (b_idx==b.length || (!(a_idx==a.length) && a[a_idx]<=b[b_idx])){
                arr[arr_idx]=a[a_idx];
                a_idx++;
            }
            else if(a_idx==a.length || (!(b_idx==b.length) && b[b_idx]<=a[a_idx])){
                arr[arr_idx]=b[b_idx];
                b_idx++;
            }
            arr_idx++;
        }
        main.printArr(arr);
    }

}