public class MergeSorter{
  public static void main(String []args){
        String s="check";
        char [] sc=s.toCharArray();
        System.out.println(sc[0]);
        int []arr1={3,9,10,1};
        
        int [] sorted_arr=merge_sort(arr1);

        for (int i=0;i<sorted_arr.length;i++){
            System.out.println(sorted_arr[i]);
        }
  }
  
  private static void print_array(int [] arr, String str){
    System.out.print(str+": ");
    for (int i=0;i<arr.length;i++){
      System.out.print(arr[i]+" ");
    }
    System.out.println("");
    
  }
  
  public static int[] merge_sort(int[] a){
    int [] result=new int[a.length];
    split_merge(result,0,a.length,a);
    return result;
  }
  
  private static void split_merge(int [] result,int begin, int end, int [] orig){
    if (end-begin>1){
      int half=(end-begin)/2;
      split_merge(result,begin,begin+half,orig);
//      print_array(result,"split_merge1");
      split_merge(result,begin+half,end,orig);
//      print_array(result,"split_merge2");
      merge(result,begin,begin+half,end,orig);
    }
    else{
      result[begin]=orig[begin];
    }
  }
  
  private static void merge(int[] result, int begin, int half, int end, int[] orig){
    int a_ptr=begin;
    int b_ptr=half;
    for (int ptr=begin;ptr<end;ptr++){
      if (a_ptr==half){
        result[ptr]=orig[b_ptr];
        b_ptr++;
      }
      else if (b_ptr==end){
      result[ptr]=orig[a_ptr];
        a_ptr++;
      }
      else if (orig[a_ptr]<orig[b_ptr]){
        result[ptr]=orig[a_ptr];
        a_ptr++;
      }
      else{
        result[ptr]=orig[b_ptr];
        b_ptr++;
      }
    }
  print_array(result,"split_merge1");
  }
 
}