import java.util.ArrayList;
import java.util.*;
public class main{
    public static void main(String [] args){
        // int [][] graph=Sec_5.getGraph(5);
        // Sec_4.printGraph(graph);
        // Sec_5.dfs(graph);
        int [][] graph1=Sec_5.getGraph(5);
        Sec_4.printGraph(graph1);
        Sec_5.bfs(graph1);
    }
    

    
    public static void printArr(int [] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}