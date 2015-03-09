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
	while(i>0){
	    front.getNext()=front;
	    i=i-1;
	}
	front.getNext=new LNode(c);
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
