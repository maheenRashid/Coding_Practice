import java.util.*;

public class Sec_2{
    public static void dfs(int [][]graph){
        for (int i=0;i<graph.length;i++){
            dfs_stack(graph,i);
        }
    }

    public static void dfs_stack(int [][]graph, int node){
        if(graph[node][node]<0){
            return;
        }
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(node);
        while(!stack.isEmpty()){
            int node_curr=stack.pop();
            System.out.print("->");
            System.out.print(node_curr);
            graph[node_curr][node_curr]=-1;
            for (int neigh=0;neigh<graph[node_curr].length;neigh++){
                if(graph[node_curr][neigh]>0 && graph[neigh][neigh]>=0 && !stack.contains(neigh)){
                    stack.push(neigh);
                }
            }
        }
    }
}