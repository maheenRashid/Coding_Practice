public class Sec_1{
    public static void insertionSort(int [] arr){
        if (arr.length<2)
            return;
        for (int i=1;i<arr.length;i++){
            int val=arr[i];
            int j=i-1;
            while (j>=0 && val<arr[j]){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=val;
        }
    }
}