import java.util.Random;
import java.util.ArrayList;

public class Sec_3{
    public static Point[] generatePoints(int n,int min,int max){
        Point[] point_arr=new Point [n];
        Random rand=new Random();
        for (int i=0;i<n;i++){
            point_arr[i]=generatePoint(min,max,rand);
        }
        return point_arr;
    }
    
    public static Point generatePoint(int min,int max,Random rand){
        int range=max-min;
        int x=rand.nextInt(range);
        int y=rand.nextInt(range);
        x=x-min;
        y=y-min;
        Point p= new Point(x,y);
        return p;
    }
    
    public static double closestPair(Point [] point_arr){
        double dist=Double.MAX_VALUE;
        for (int a=0;a<point_arr.length-1;a++){
            for (int b=a+1;b<point_arr.length;b++){
                double x_diff=(double)point_arr[a].x-point_arr[b].x;
                double y_diff=(double)point_arr[a].y-point_arr[b].y;
                double d_curr=Math.pow(x_diff,2.0)+Math.pow(y_diff,2.0);
                
                if (d_curr<dist)
                    dist=d_curr;
            }
        }
        
        return Math.sqrt(dist);
    }
    
    public static boolean isOnHull(double [] line, Point [] arr){
        boolean onHull=true;
        boolean left=false;
        boolean right=false;
        
        for (int i=0;i<arr.length;i++){
            double x=(double) arr[i].x;
            double y=(double) arr[i].y;
            
            double check=line[0]*x+line[1]*y+line[2];
            
            if (check<0){
                left=true;
            }
            if (check>0){
                right=true;
            }
            if (left && right){
                onHull=false;
                break;
            }
        }
        return onHull;
    }
    
    public static double [] getLine(Point a,Point b){
        double x1=(double)a.x;
        double y1=(double)a.y;
        double x2=(double)b.x;
        double y2=(double)b.y;
        
        double [] line={0,0,0};
        
        if ((y2-y1)==0){
            line[1]=1;line[2]=-y1;            
        }
        else if ((x2-x1)==0){
            line[0]=1;line[2]=-x1;
        }
        else{
            double m=(y2-y1)/(x2-x1);
            double c=-m*x1+y1;
            line[0]=-m;
            line[1]=1;
            line[2]=-c;
        }
        return line;
    }
    
    public static ArrayList<Point> convexHull(Point [] p_arr){
        ArrayList <Point> p_arr_list=new ArrayList<Point>();
        for (int i=0;i<p_arr.length-1;i++){
            for (int j=i+1;j<p_arr.length;j++){
                double [] line =getLine(p_arr[i],p_arr[j]);
                boolean onConv=isOnHull(line,p_arr);
                if (onConv){
                    p_arr_list.add(p_arr[i]);
                    p_arr_list.add(p_arr[j]);
                }
            }
        }
        System.out.println(p_arr_list.size());
        return p_arr_list;
    }
    
}