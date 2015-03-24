public class LinkedList {

    private LNode front;
    public LinkedList(LNode node){
	front=node;
    }

    public String toString(){
	String s="";
	while(node!=null){
	    s=s+node.toString();
	    node=node.getNext();
	}
	return s;
    }

    public void add(char c){
	Lnode yay=front;
	Lnode next=new LNode(c);
	if(yay==null){
	    front=next;
	    return;
	}
	while(yay.getNext()!=null){
	    yay=yay.getNext();
	    yay.setNext(next);
	}
	
    }

    public void add(char c, int i){
	LNode insert=new LNode(c);
	LNode nodeNow=front;
	if(i>=this.size()){
	    add(c);
	    return;
	}
	for(int counter=0;nodeNow.getNext()!=null;counter++){
	    if(counter==1){
		insert.setNext(nodeNow.getNext());
		nodeNow.setNext(insert);
		return;
	    }
	    nodeNow=nodeNow.getNext();
	}
    }


    //or

    public void add1(char c, int i){
	LNode n=new LNode (c);
	LNode curr=new LNode(c);
	//code here;

	while(curr.getNext()!= null && i>1){
	    curr=curr.getNext();
	    i--;
	}
	n.setNext(curr.getNext());
	curr.setNext(n);
    }
    public char get(int i){
	while(i>0){
	    front.getNext=front;
	    i=i-1;
	}
	return front.getData();
    }

    public void set(char c, int i){
	while(i>0){
	    front.getNext=front;
	    i=i-1;
	}
	front.getNext.setData(c);
    }

    public char remove(int i){
	while(i>0){
	    front.Next=front;
	    i=i-1;
	}
	char removed=front.next.getData;
	front.getNext.getNext=front;
	return removed;
    }

    public int size(){
	int ans=0;
	while(front.next != null){
	    ans=ans+1;
	}
	return ans;
    }

public static void main(String[] args) {
     LinkedList List=new LinkedList(front);
    System.out.println(List.size());

}
}
//I'm confused about how to access the Next node.
