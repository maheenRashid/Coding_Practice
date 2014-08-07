import java.util.Arrays;

public class Sorter{
      public static void main(String []args){
        char [] test={'a','b','\0'};
        
        System.out.println(test);
        reverseString(test);
        
        System.out.println(test);
        
        int [] arr={3,9,10,11,3,8};
        int [] find={3,11,1};
        for (int i=0;i<find.length;i++){
          System.out.println(binary_search(arr,find[i]));
        }
        
        
        }
      
      public static void reverseString(char [] string){
        int begin=0;
        int end=string.length-2;
        if (end<=begin){
          return;
        }
        while (true){
          if (end<=begin){
            return;
          }
          swapVals(string,begin,end);
          begin++;
          end--;
        }
      }
      
      private static void swapVals(char [] string, int idx1, int idx2){
        char temp=string [idx1];
        string[idx1]=string[idx2];
        string[idx2]=temp;
      }
      
      
public static void print_array(int [] arr, String str){
    System.out.print(str+": ");
    for (int i=0;i<arr.length;i++){
      System.out.print(arr[i]+" ");
    }
    System.out.println("");
    
  }      
      
public static int binary_search( int []  arr, int v){
  return split_binary(arr,v,0,arr.length);
}

private static int split_binary(int [] arr, int v, int begin, int end){
  if (end-begin<2){
    if (arr[begin]==v){
      return begin;
    }
    else{
      return -1;
    }
  }
  else {
    int half=(end-begin)/2;
    half=begin+half;
    if (arr[half]==v){
      return half;
    }else if(v<arr[half]){
      return split_binary(arr,v,begin,half);
    }else{
      return split_binary(arr,v,half,end);
    }
  }
}

public static int[] merge(int [] a, int [] b){
        int [] merged= new int[a.length+b.length];
        int ptr_a=0;
        int ptr_b=0;
        for (int ptr=0;ptr<merged.length;ptr++){
          if (ptr_a==a.length){
            merged[ptr]=b[ptr_b];
            ptr_b++;
           
          }
          else if (ptr_b==b.length){
            merged[ptr]=a[ptr_a];
            ptr_a++;
           
          }
          else if (a[ptr_a]>=b[ptr_b]){
            merged[ptr]=b[ptr_b];
            ptr_b++;
           
          }
          else{
            merged[ptr]=a[ptr_a];
            ptr_a++;
           
          }
          
        }
        return merged;
      }
      
      public static int [] merge_sort(int [] arr){
        if (arr.length>1){
          int half= arr.length/2;
          int [] a=Arrays.copyOfRange(arr,0,half);
          int [] b=Arrays.copyOfRange(arr,half,arr.length);
          a=merge_sort(a);
          b=merge_sort(b);
          arr=merge(a,b);
        }
        return arr;
      }
      
      
      public static void change_val(int [] arr){
        arr[0]=20;
//        int [] arr_n=new int [12];
//        arr=arr_n;
      }
      
      public static int [] insert_sort(int [] arr){
        int n=arr.length;
        for (int i=1;i<n;i++){
          int temp=arr[i];
          for (int j=0;j<i;j++){
            if (temp<=arr[j]){
              for (int k=i-1;k>j-1;k--){
                arr[k+1]=arr[k];
              }
              arr[j]=temp;
              break;
            }
          }
        }
        return arr;
      }
}