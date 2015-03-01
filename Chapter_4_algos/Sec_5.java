public class Sec_5{
    public static int lomutoPartition(int [] arr, int l, int r){
        
        int p=arr[l];
        int s=l;
        r=r-1;
        while(s<=r){
            if (arr[s]<=p){
                s++;
            }
            else{
                Sec_3.swap(arr,s,r);
                r--;
            }
        }
        Sec_3.swap(arr,l,r);
        return r;
    }
    
    public static void quickSort(int [] arr,int start, int end){
        if (start>=end-1){
            return;
        }
        int pivot=lomutoPartition(arr,start,end);
        quickSort(arr,start,pivot);
        quickSort(arr,pivot+1,end);
    
    }    
    
    public static int getKthLargest(int [] arr, int k){
        if (k>arr.length || k<1)
            return -1;
        if (k==arr.length)
            return getMinIdx(arr);
        else if (k==1)
            return getMaxIdx(arr);
        
        int idx=-1;
        int r_size=arr.length;
        int r=arr.length;
        int l=0;
        while(r_size!=(k-1)){
            if (r_size>(k-1)){
                l=idx+1;
                idx=lomutoPartition(arr, l,r);
            }
            else{
                r=idx;
                idx=lomutoPartition(arr,l,r);
            }
            r_size=arr.length-(idx+1);
        }
        return idx;
    }
    
    public static int getMinIdx(int [] arr){
        int min_val =Integer.MAX_VALUE;
        int min_idx=-1;
        for (int i=0;i<arr.length;i++){
            if (arr[i]<min_val){
                min_idx=i;
                min_val=arr[i];
            }
        }
        return min_idx;
    }
    
    public static int getMaxIdx(int [] arr){
        int max_val =-Integer.MAX_VALUE;
        int max_idx=-1;
        for (int i=0;i<arr.length;i++){
            if (arr[i]>max_val){
                max_idx=i;
                max_val=arr[i];
            }
        }
        return max_idx;
    }
    
}