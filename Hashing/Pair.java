public class Pair<K extends Object,V extends Object>{
    private K key;
    private V value;
    
    public Pair(K key, V value){
        this.key=key;
        this.value=value;
    }
    
    public K getKey(){
        return this.key;
    }
    
    public V getValue(){
        return this.value;      
    }
}