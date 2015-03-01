class ExThread extends Thread{
    public native String getTime();
 
}
public class ThMulti implements Runnable {
    boolean Stop;
    public static void main(String argv[]){
        ThMulti m = new ThMulti();
        m.go();
    }
    public void go(){
        ExThread ts = new ExThread(this);
        ts.start();
        Stop=true;
       
    }
    public void run(){
        if(Stop==true){
            return;
        }
        System.out.println("Thread is running");
    } 
}
