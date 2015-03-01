public class GCD{
        
            
        public static void main(String []args){
            int a=Integer.parseInt(args[0]);
            int b=Integer.parseInt(args[1]);
            int gcd=getGCD(a,b);
            System.out.println(gcd);
        }
        
        public static int getGCD(int a, int b){
            if (b==0 || a==0){
                if (b>a){
                    return b;
                }
                else{
                    return a;
                }
            }
            
            if (b>a){
                int temp=a;
                a=b;
                b=temp;
            }
            int c;
            while (true){
                c=a%b;
                if (c==0){
                    return b;
                }
                else{
                    a=b;
                    b=c;
                }
            }
            
        }
        
}