
public interface HashTable<K extends Object,V extends Object>{
    
    V getValue(K key);
    
    void add(K key, V val);
    
}