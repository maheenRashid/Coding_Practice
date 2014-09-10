import java.util.Random;
import java.util.*;
public class Sec_5{
    public static int[][] getGraph(int arr_size){
        int [][] arr=new int [arr_size][arr_size];
        Random rand=new Random();
        for (int i=0;i<arr_size;i++){
            for (int j=i+1;j<arr_size;j++){
                if (i==j)
                    continue;
                int edge=rand.nextInt(2);
                if (edge>0){
                    arr[i][j]=1;
                    arr[j][i]=arr[i][j];
                }
            }
        }
        return arr;
    }
    
    public static void dfs(int [][] graph){
        for (int i=0;i<graph.length;i++){
            if (graph[i][i]>=0){
                dfs(graph,i);
                System.out.println();
            }
        }
    }
    
    public static void bfs(int [][] graph){
        for (int i=0;i<graph.length;i++){
            if (graph[i][i]>=0){
                bfs(graph,i);
                System.out.println();
            }
        }
    }
    
    public static void bfs(int [][] graph, int v){
        if (graph[v][v]<0){
            return;
        }
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(v);
        while(!q.isEmpty()){
            v=q.remove();
            System.out.print("->");
            System.out.print(v);
            graph[v][v]=-1;
            for (int i=0;i<graph[v].length;i++){
                if (graph[v][i]>0 && graph[i][i]>=0){
                    if (!q.contains(i)){
                        q.add(i);
                    }
                }
            }
        }
    }
    
    public static void dfs(int [][] graph,int v){
        if (graph[v][v]<0){
            return;
        }
        else{
            System.out.print("->");
            System.out.print(v);
            graph[v][v]=-1;
            for (int i=0;i<graph[v].length;i++){
                if (graph[v][i]>0){
                    dfs(graph,i);
                }
            }
        }
    }
}