public class BikeThief{
    public static void main (String [] args){
        int a=Integer.parseInt(args[0]);
        int b=Integer.parseInt(args[1]);
        if (a%2==0 ||b%2==1){
            System.out.println(a+" "+b+" Yes");
        }else{
            System.out.println(a+" "+b+" No");
        }
    }
}