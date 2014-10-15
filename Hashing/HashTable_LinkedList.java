import java.util.*;
public class HashTable_LinkedList<K,V> implements HashTable<K,V>{
    private ArrayList<ArrayList<Pair<K,V>>> table;
    private int init_size=13;
    
    public HashTable_LinkedList(){
        table= new ArrayList<ArrayList<Pair<K,V>>>(init_size);
        for (int i=0;i<init_size;i++){
            ArrayList<Pair<K,V>> arr= new ArrayList<Pair<K,V>>(0);
            table.add(arr);
        }
    }
    
    
    public V getValue(K key){
        int idx=hash(key);
        ArrayList<Pair<K,V>> arr=table.get(idx);
        V val=null;
        for (int i=0;i<arr.size();i++){
            if (arr.get(i).getKey().equals(key)){
                val=arr.get(i).getValue();
                break;
            }
        }
        return val;
    }
    
    
    public void add(K key, V val){
        int idx=hash(key);
        table.get(idx).add(new Pair<K,V>(key,val));
    }
    
    
    private int hash(K key){
        int hash=(key.hashCode() & 0x7fffffff)%table.size();
        return hash;
    }
    
    
}