import java.util.Random;
import java.util.ArrayList;
public class Sec_4{
    public static int [][] getFullyConnectedGraph(int lim, int arr_size){
        int [][] arr=new int [arr_size][arr_size];
        Random rand=new Random();
        for (int i=0;i<arr_size;i++){
            for (int j=i+1;j<arr_size;j++){
                if (i==j)
                    continue;
                arr[i][j]=rand.nextInt(lim)+1;
                
                arr[j][i]=arr[i][j];
            }
        }
        return arr;
    }
    
    public static void printGraph(int [][] graph){
        for (int i=0;i<graph.length;i++){
            for (int j=0;j<graph[i].length;j++){
                System.out.print(graph[i][j]);
                System.out.print("\t");
            }
            System.out.println("");
        }
    }
    
    
    public static void printPaths(ArrayList<ArrayList <Integer>> paths){
        for (int i=0;i<paths.size();i++){
            printPath(paths.get(i));
        }
    }
    
    public static void printPath(ArrayList<Integer> path){
        for (int j=0;j<path.size();j++){
            System.out.print(path.get(j));
            if (j!=path.size()-1)
                System.out.print("->");
        }
        System.out.println("");
    }
    
    public static ArrayList <ArrayList <Integer> > getAllPaths(int [][]graph,ArrayList<Integer> path){
        
        ArrayList<ArrayList<Integer>> paths=new ArrayList<ArrayList<Integer>>();
        // printPath(path);
        // printGraph(graph);
        // System.out.println("***");
        int n=graph.length;
        int start=path.get(1);
        int sum=path.get(0);
        int curr=path.get(path.size()-1);
        if (path.size()==n+1){
            sum=sum+graph[curr][start];
            path.set(0,sum);
            path.add(start);
            paths.add(path);
        }
        else{
            for (int n_no=curr+1;n_no<n;n_no++){
                if ((n_no!=start) && (graph[curr][n_no]!=0)){
                    int [][] copy=new int[n][n];
                    for (int i=0;i<n;i++){
                        for (int j=0;j<n;j++){
                            copy[i][j]=graph[i][j];
                        }
                    }
                    for (int i=0;i<n;i++){
                        if (i!=start)
                            copy[i][n_no]=0;
                    }
                    ArrayList<Integer> path_cpy=new ArrayList<Integer> (path);
                    path_cpy.add(n_no);
                    int sum_curr=sum+graph[curr][n_no];
                    path_cpy.set(0,sum_curr);
                    ArrayList<ArrayList <Integer>> paths_curr=getAllPaths(copy,path_cpy);
                    paths.addAll(paths_curr);
                }
            }
        }
        
        return paths;
    }
    
    public static ArrayList<Integer> getBestPath(ArrayList<ArrayList<Integer>> paths){
        int min=Integer.MAX_VALUE;
        int idx=-1;
        for (int i=0;i<paths.size();i++){
            int sum=paths.get(i).get(0);
            if (sum<min){
                min=sum;
                idx=i;
            }
        }
        return paths.get(idx);
    }
    
}