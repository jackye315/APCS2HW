public class queue<E>{

    public LNode<E> front;
    public LNode<E> back;

    public queue(){
    }

    public void enqueue(E item){
	LNode<E> curr=front;
	LNode<E> n=new LNode<E>(item);
	if(curr==null){
	    front=n;
	}
	else{
	    while(curr.getNext()!=null){
		curr=curr.getNext();
	    }
	    curr.setNext(n);
	}
    }
    
    public E dequeue(){
	E curr=front.getData();
	front=front.getNext();
	return curr;
    }

    public E peek(){
	return front.getData();
    }

    public boolean isEmpty(){
	return front.getData()==null;
    }

    public static void main(String[]args){
	queue<Integer> a=new queue<Integer>();
	a.enqueue(5);
	System.out.println(a.dequeue());
	a.enqueue(10);
	System.out.println(a.peek());
    }

}
