class Queue<Type>{
  Node <Type> first;
  Node <Type> last;
  
  public Queue(){
    first=null;
    last=null;
  }
  
  public void enqueue(Type data){
    Node <Type> n=new Node <Type> (data);
    if (last==null){
      last=n;
      last.next=null;
      first=last;
    }
    else{
      n.next=null;
      last.next=n;
      last=n;
    }
    
    
    
  }
  
  public Node <Type> dequeue(){
    if (first==null){
      return null;
    }
    Node <Type> to_return=first;
    first=first.next;
    if (first==null){
      last=null;
    }
    return to_return;
    
  }
  
  public Node <Type> peek(){
      return first;
  }
  
  public static void main (String [] args){
    Queue <Integer> q= new Queue<Integer> ();
    for (int i=0;i<3;i++){
      q.enqueue(i);
    }
    
    Node <Integer> returned=q.dequeue();
    while(returned!=null){
      System.out.println(returned.data);
      returned=q.dequeue();
    }
    
    for (int i=0;i<5;i++){
      q.enqueue(i);
    }
    
    returned=q.dequeue();
    while(returned!=null){
      System.out.println(returned.data);
      returned=q.dequeue();
    }
    
  }
  
}