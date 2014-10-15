import java.util.*;
import java.lang.Math;

public class Sec_3{
    public static ArrayList<BitSet> BRGC(int n_curr,int n_total){
        ArrayList<BitSet> L = new ArrayList<BitSet>();
        if (n_curr==1){
            BitSet b_0=new BitSet(n_total);
            BitSet b_1=new BitSet(n_total);
            b_1.set(n_curr-1);
            L.add(b_0);L.add(b_1);
        }
        else{
            ArrayList <BitSet> L1= BRGC(n_curr-1,n_total);
            for (int i=L1.size()-1;i>-1;i--){
                BitSet b_curr=(BitSet) L1.get(i).clone();
                b_curr.set(n_curr-1);
                L.add(b_curr);
            }
            L.addAll(L1);
        }
        return L;
    }
    
    public static ArrayList<int[]> johnsonTrotter(int [] arr){
        Arrays.sort(arr);
        boolean [] mobile = new boolean [arr.length];
        Arrays.fill(mobile,true);
        ArrayList<int []> perms=new ArrayList<int []>();
        perms.add(Arrays.copyOf(arr,arr.length));
        while (getLargestMobileIndex(arr,mobile)!=-1){
            int k=getLargestMobileIndex(arr,mobile);
            int k_sw=k+1;
            if (mobile[k]) k_sw=k-1;
            swap(arr,k,k_sw);
            swap(mobile,k,k_sw);
            perms.add(Arrays.copyOf(arr,arr.length));
            for (int i=0;i<arr.length;i++){
                if (arr[i]>arr[k_sw])
                    mobile[i]=!mobile[i];
            }
        }
        
        return perms;
    }
    
    private static void printArr(int [] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
    
    
    private static void printArr(boolean [] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
    private static boolean isMobile(int [] arr, boolean [] mobile, int idx){
        int idx_comp=Math.min(idx+1,arr.length-1);
        if (mobile[idx])
            idx_comp=Math.max(idx-1,0);
        if (arr[idx_comp]<arr[idx])
            return true;
        else
            return false;
    }
    
    private static int getLargestMobileIndex(int [] arr, boolean [] mobile){
        int max_idx=-1;
        int max_val=-Integer.MAX_VALUE;
        for (int i=0;i<arr.length;i++){
            if (isMobile(arr,mobile,i)){
                if (arr[i]>max_val){
                    max_idx=i;
                }
            }
        }
        return max_idx;
    }
    
    public static void swap(int [] arr, int idx, int idx_sw){
        int temp=arr[idx];
        arr[idx]=arr[idx_sw];
        arr[idx_sw]=temp;
    }
    
    private static void swap(boolean [] arr, int idx, int idx_sw){
        boolean temp=arr[idx];
        arr[idx]=arr[idx_sw];
        arr[idx_sw]=temp;
    }
    
    
    public static ArrayList<int []> lexicographicPermute(int [] arr){
        ArrayList<int []> perms = new ArrayList<int []>();
        Arrays.sort(arr);
        perms.add(Arrays.copyOf(arr,arr.length));
        while (getIndexLatestSmallest(arr)!=-1){
            int i=getIndexLatestSmallest(arr);
            int j=getLargestIndexGreaterThanVal(arr,i+1,arr.length,arr[i]);
            
            swap(arr,i,j);
            reverse(arr,i+1,arr.length);
            
            int [] perm_curr=Arrays.copyOf(arr,arr.length);
            perms.add(perm_curr);
        }
        return perms;
    }
    
    private static int getLargestIndexGreaterThanVal(int [] arr, int start, int end, int val){
        int min_idx=-1;
        // int min_val=Integer.MAX_VALUE;
        for (int i=start;i<end;i++){
            if (arr[i]>val){
                min_idx=i;
            }
        }
        return min_idx;
    }
    
    private static int getIndexLatestSmallest(int [] arr){
        int min_max_idx=-1;
        int idx=arr.length-1;
        while (idx!=0 && arr[idx]<arr[idx-1]){
            idx=idx-1;
        }
        if (idx!=0){
            min_max_idx=idx-1;
        }
        return min_max_idx;
    }
    
    private static void reverse(int [] arr, int start, int end){
        end=end-1;
        while(start<end){
            swap(arr,start,end);
            start=start+1;
            end=end-1;
        }
    }
    
}