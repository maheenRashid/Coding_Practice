public class main{
    public static void main(String args[]){
        HashTable_Probing<Integer,Integer> hashtable = new HashTable_Probing<Integer,Integer>();
        for (int i=0;i<14;i++){
            hashtable.add(i,i);
        }
        for (int i=0;i<14;i++){
            System.out.println(hashtable.getValue(i));
        }
                
    }
    
}