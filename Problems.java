import java.util.HashMap;
import java.util.Arrays;
import java.lang.StringBuilder;


public class Problems{
  public static void main( String [] args){
//    char [] str={'a','b','e','c','d','e','\0'};
//    boolean check=hasUniqueArray(str);
//    System.out.println(check);
//    char [] str1={'a','b',' ','c','d'};
//    check=hasUniqueArray(str1);
//    System.out.println(str1);
//    str1[0]='\0';
//    
    
    
//    System.out.println(str);
    String str="this string   has   empty   space....";
    str=removeDuplicatesHash(str);
//    
//    String str_new=replaceSpace(str);
    System.out.println(str);
//    System.out.println(str_new);
    
    
  }
  
  
  
  public static String replaceSpace(String str){
    boolean space=false;
    String str_new="";
    for (int i=0;i<str.length();i++){
      if (str.charAt(i)!=' '){
        if (space){
          str_new=str_new +"%20";
          space=false;
        }
        str_new=str_new+str.charAt(i);
      }else{
        if (!space){
          space=true;
        }
      }
    }
    if (space){
      str_new=str_new +"%20";
    }
    
    return str_new;
  }
  
  public static String removeDuplicates(String str_s){
    char [] str=str_s.toCharArray();
    Arrays.sort(str);
    System.out.println(str);
    int numel_null=0;
    for (int i=0;i<str.length-1;i++){
      if (str[i]==str[i+1]){
        int j=i+1;
        while(j<str.length && str[i]==str[j]){
          numel_null++;
          str[j]='\0';
          j++;
        }
        i=j-1;
      }
    }
    System.out.println(numel_null);
    Arrays.sort(str);
    String str_new=String.copyValueOf(str,numel_null,str.length-numel_null);
    return str_new;
  }
  
  
  public static String removeDuplicatesHash(String str){
    StringBuilder str_new=new StringBuilder(str);
    HashMap <Integer,Character> map=new HashMap<Integer,Character> ();
    int del_count=0;
    
    for (int i=0;i<str.length();i++){
      int key=(int)str.charAt(i);
      char val=str.charAt(i);
      if (map.containsKey(key)){
        str_new.deleteCharAt(i-del_count);
        del_count++;
      }
      else{
        map.put(key,val);
      }
    }
    return str_new.toString();
  }
  
  
  public static boolean hasUniqueArray(char [] str){
    Arrays.sort(str);
    for (int i=0;i<str.length-1;i++){
      if (str[i]==str[i+1]){
        return false;
      }
    }
    return true;
  }
  
  public static boolean hasUnique(char [] str){
    HashMap <Integer,Character> map=new HashMap <Integer,Character> ();
    for (char c:str) map.put((int)c,c);
    int coll_count=map.size();
    if (coll_count<str.length){
      return false; 
    }
    else{
      return true;
    }
    
  }
  
}