public class Eniya{
    public static void main(String [] args){
        int n=10;
        int a=4;
        int b=6;
        int amnt=getAmountNeeded(n,a,b);
        System.out.println("N "+n+" A "+a+" B "+b+" Amount "+amnt);
    }
    public static int getAmountNeeded(int n, int a, int b){
        return (n*a*b*2);
    }
}