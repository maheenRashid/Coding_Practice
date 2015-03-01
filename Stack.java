class Stack<Type>{
  Node <Type> top;
  public Stack(){
    top=null;
  }
  
  public void push(Type data){
    Node <Type> n=new Node <Type> (data);
    n.next=top;
    top=n;
  }
  
  public Node <Type> pop(){
    if (top==null){
      return top;
    }
    Node <Type> to_return=top;
    top=top.next;
    return to_return;
  }
  
  public Node <Type> peek(){
    return top;
  }
  
  public static void main (String [] args){
    Stack <Integer> stack=new Stack <Integer>();
    for (int i=0;i<5;i++){
      stack.push(i);
    }
    Node <Integer> returned=stack.pop();
    while (returned!=null){
      System.out.println(returned.data);
      returned=stack.pop();
    }
  }
  
  
}