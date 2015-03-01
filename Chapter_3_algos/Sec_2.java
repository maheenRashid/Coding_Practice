public class Sec_2{
        
    public static int sequentialSearch(int [] arr, int key){
        int index=-1;
        for (int i=0;i<arr.length;i++){
            if (arr[i]==key){
                index=i;
                break;
            }
        }
        return index;
    }
    
    public static int stringMatch(String str, String key){
        int upperlim=str.length()-key.length()+1;
        int index=-1;
        for (int i=0;i<upperlim;i++){
            int j=0;
            for (;j<key.length();j++){
                if (str.charAt(i+j)!=key.charAt(j))
                    break;
            }
            if (j==key.length()){
                index=i;
                break;
            }
        }
        return index;
    }
}