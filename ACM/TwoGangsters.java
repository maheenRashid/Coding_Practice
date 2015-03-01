public class TwoGangsters{
    public static void main (String [] args){
        int a=Integer.parseInt(args[0]);
        int b=Integer.parseInt(args[1]);
        int sum=a+b-1;
        int n_a=sum-a;
        int n_b=sum-b;
        System.out.println(n_a+" "+n_b);
    }
}