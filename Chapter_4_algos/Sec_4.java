import java.lang.Math;

public class Sec_4{
    public static int binarySearch(int[] arr,int start,int end,int x){
        int idx=-1;
        if (start==end-1){
            if (arr[start]==x)
                idx=start;
        }
        else{
            int mid=(int)Math.floor((start+end)/2);
            
            if (arr[mid]==x){
                idx=mid;
            }
            else if (arr[mid]<x){
                idx=binarySearch(arr,mid,end,x);
            }
            else{
                idx=binarySearch(arr,start,mid,x);
            }
        }
        return idx;
    }
    
    private static int sum(int [] arr, int start, int end){
        int sum=0;
        for (int i=start;i<end;i++){
            sum=sum+arr[i];
        }
        return sum;
    }
    
    public static int getFakeCoinThreeStack(int [] arr, int start, int end){
        int idx=-1;
        int rem=(end-start)%3;
        int siz=(int)Math.floor((end-start)/3);
        if (rem==0){
            start=getLighterStackIdx(arr,start,end);
            idx=getFakeCoinThreeStack(arr, start, start+siz);
        }
        else if(rem==2){
            int first=end-1;
            int second=end-2;
            if (arr[first]<arr[second]){
                idx=first;
            }
            else if(arr[second]<arr[first]){
                idx=second;
            }
            else{
                start=getLighterStackIdx(arr,start,second);
                idx=getFakeCoinThreeStack(arr,start,start+siz);
            }
        }
        else{
            if (start==end-1){
                idx=start;
            }
            else{
                int start_check=getLighterStackIdx(arr,start,end-1);
                if (start_check==-1){
                    idx=end-1;
                }
                else{
                    idx=getFakeCoinThreeStack(arr,start_check,start_check+siz);
                }
            }
        }
        return idx;
    }
    
    private static int getLighterStackIdx(int [] arr, int start, int end){
        int start_idx=-1;
        int siz=(end-start)/3;
        int m1=start+siz;
        int m2=m1+siz;
        if (sum(arr,m2,end)<sum(arr,start,m1)){
            start_idx=m2;
        }
        else if (sum(arr,start,m1)<sum(arr,m1,m2)){
            start_idx=start;
        }
        else if(sum(arr,m1,m2)<sum(arr,start,m1)){
            start_idx=m1;
        }
        return start_idx;
    }
    
    
    public static int getFakeCoin(int [] arr, int start, int end){
        int idx=-1;
        if (start==end-1){
            idx =start;
        }
        else if((end-start)%2==1){
            int left_out=end-1;
            int mid=(start+left_out)/2;
            if (sum(arr,start,mid)==sum(arr,mid,left_out)){
                idx=left_out;
            }
            else{
                idx=getFakeCoin(arr,start,left_out);
            }
        }
        else{
            int mid=(start+end)/2;
            if (sum(arr,start,mid)<sum(arr,mid,end)){
                idx=getFakeCoin(arr,start,mid);
            }
            else{
                idx=getFakeCoin(arr,mid,end);
            }
        }
        return idx;
    }
    
    public static int russianPeasant(int n,int m){
        int ans=0;
        if (n<1 || m<1){
            ans=-1;
        }
        else if (n==1){
            ans=n*m;
        }
        else if(n%2==1){
            int add=m;
            ans=russianPeasant((n-1)/2,2*m);
            ans=ans+add;
        }
        else{
            ans=russianPeasant(n/2,2*m);
        }
        return ans;
    }
    
    public static int josephusProblem(int a){
        int b=a & a<<1;
        int sr_no=Integer.SIZE-Integer.numberOfLeadingZeros(a);
        int c=a>>sr_no-1;
        return b|c;        
    }
    
}