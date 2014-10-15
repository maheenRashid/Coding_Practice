import java.util.*;
public class HashTable_Probing <K,V> {
    
    private ArrayList<Pair<K,V>> table;
    private int init_size=13;
    
    @SuppressWarnings("unchecked")
    public HashTable_Probing(){
        table = new ArrayList<Pair<K,V>>(init_size);
        for (int i=0;i<init_size;i++){
            table.add(null);
        }
        table.trimToSize();
    }
    
    public  void add(K key, V val){
        int idx=hash(key);
        if (table.get(idx)==null){
            table.set(idx,new Pair<K,V>(key,val));
        }
        else{
            probeAndAdd(idx+1,key,val);
        }
    }
    
    private void probeAndAdd(int idx, K key, V val){
        boolean foundPlace=false;
        for (int i=idx;i<table.size();i++){
            if (table.get(i)==null){
                foundPlace=true;
                table.set(i,new Pair<K,V>(key,val));
                break;
            }
        }
        if (!foundPlace){
            // table.add(new Pair<K,V>(key,val));
            System.out.println("Sorry. Full Capacity");
        }
    }
    
    public V getValue(K key){
        V ret=null;
        int idx=hash(key);
        for (int i=idx;i<table.size();i++){
            if (table.get(i)!=null && key.equals(table.get(i).getKey())){
                ret=table.get(i).getValue();
                break;
            }
        }
        return ret;
    }
    
    private int hash(K key){
        int hash=(key.hashCode() & 0x7fffffff)%table.size();
        return hash;
    }


}