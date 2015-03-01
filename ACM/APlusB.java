public class APlusB{
    public static void main (String [] args){
        int a=10;
        int b=20;
        int c=getSum(a,b);
        System.out.println(""+a+"+"+b+"="+c);
    }
    
    public static int getSum(int a, int b){
        return a+b;
    }
}