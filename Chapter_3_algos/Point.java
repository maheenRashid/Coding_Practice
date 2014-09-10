public class Point{
    public int x;
    public int y;
    
    public Point(){        
    }
    
    public Point(int x_,int y_){
        x=x_;
        y=y_;
    }
    
    public void print(){
        System.out.println("x "+x+" y "+y);
    }
}