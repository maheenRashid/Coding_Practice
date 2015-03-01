public class LostInLocalization{
    public static void main (String [] args){
        int [] number={10,100,1000,3,0,7,17};
        for (int i=0;i<number.length;i++){
            System.out.println(getTranslation(number[i])+" "+number[i]);
        }
        
    }
    
    public static String getTranslation(int n){
        String toReturn=new String();
        if (n<=0){
            toReturn="";
        }
        else if(n<=4){
            toReturn="few";
        }
        else if(n<=9){
            toReturn="several";
        }
        else if(n<=19){
            toReturn="pack";
        }
        else if(n<=49){
            toReturn="lots";
        }
        else if(n<=99){
            toReturn="horde";
        }
        else if(n<=249){
            toReturn="throng";
        }
        else if(n<=499){
            toReturn="swarm";
        }
        else if(n<=999){
            toReturn="zounds";
        }
        else{
            toReturn="legion";
        }
        return toReturn;
        
    }
}