
public class Sec_1{
  
  public static int[] bubbleSort(int [] arr){
    for (int n=arr.length-1;n>0;n--){
        for (int i=0;i<n;i++){
            if (arr[i]>arr[i+1])
                swap(arr,i,i+1);
        }
    }
    return arr;
  }
  
  public static int[] selectionSort(int [] arr){
    for (int i=0;i<arr.length;i++){
        int idx_min=i;
        for (int j=idx_min+1;j<arr.length;j++){
            if (arr[j]<arr[idx_min]){
                idx_min=j;
            }
        }
        swap(arr,idx_min,i);
    }
    return arr;
  }
  
  public static void swap(int [] arr,int i,int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
  }
  
}