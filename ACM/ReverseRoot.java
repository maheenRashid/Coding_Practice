import java.io.*;

public class ReverseRoot{
    public static void main(String []args){
        // int a=36;
        // int b=(int)Math.pow(a,0.5);
        // System.out.println(b);
        try{
            InputStream stream=new FileInputStream("number_stream.txt");
            printSqrt(stream);
        }catch (FileNotFoundException err){
            System.out.println("Error!");
        }
    }
    
    public static void printSqrt(InputStream stream){
        String str=stream2String(stream);
        for (String number: str.split("[\\s+]")){
            if (number.matches("\\d+")){
                int num=Integer.parseInt(number);
                System.out.printf("%.4f\n",Math.pow(num,0.5));
            }
        }
    }
    
    private static String stream2String(InputStream stream){
        BufferedReader reader=new BufferedReader(new InputStreamReader(stream));
        StringBuilder str=new StringBuilder();
        String line;
        try{
            while((line=reader.readLine())!=null){
                str.append(line);
            }
            reader.close();
        }catch(IOException err){
            System.out.println("Error!");
        }
        return str.toString();
    }
    
}