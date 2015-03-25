public class nodestack<E>{

    public LNode top;
    
    public nodestack(){
	top=new LNode();
    }

    public void push(E item){
	while(top.getNext()!=null){
	    top=top.getNext();
	}
	    top.setNext(item);
    }


    

    public E pop(){
	while(top.getNext()!=null){
	    top=top.getNext();
	}
	E curr=top.getData();
	top.setData(null);
	return curr;
    }

    public LNode<E> peek(){
	while(top.getNext()!=null){
	    top=top.getNext();
	}
	E curr=top.getData();
	return curr;
    }

    public boolean isEmpty(){
	return top.getData==null;
    }




}
