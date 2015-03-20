public class LinkedList {

    private LNode front;

    public LinkedList() {
	front = null;
    }

    public String toString() {
	String s = "";
	LNode curr = front;

	while ( curr != null ) {
	    s+= curr.getData() + " ";
	    curr = curr.getNext();
	}
	return s;	
    }

    public void add( char c ) {

	LNode n = new LNode( c );
	LNode curr = front;

	if ( curr == null )
	    front = n;

	else {
	    while ( curr.getNext() != null )
		curr = curr.getNext();
	    curr.setNext( n );
	}
    }

    public void add( char c, int i ) throws IndexOutOfBoundsException {

	if(i<0 || i>= size()){
	    throw new IndexOutOfBoundsException();
	}
	LNode n = new LNode( c );
	LNode curr = front;

	if ( curr == null ) {
	    front = n;
	    return;
	}

	if ( i == 0 ) {	    
	    n.setNext( front );
	    front = n;
	    return;
	}

	while ( curr.getNext() != null && i > 1 ) {
	    curr = curr.getNext();
	    i--;
	}
	
	n.setNext( curr.getNext() );
	curr.setNext( n );
    }
    

    public char set( char c, int i ) throws IndexOutOfBoundsException {
	if(i<0 || i>= size()){
	    throw new IndexOutOfBoundsException();
	}
	LNode curr = front;
	char old = 0;

	while ( curr != null &&  i > 0 ) {	    
	    curr = curr.getNext();
	    i--;
	}

	if ( curr != null ) {
	    old = curr.getData();
	    curr.setData( c );
	}	    
	return old;
    }

    public char get( int i ) throws IndexOutOfBoundsException {
	if(i<0 || i>= size()){
	    throw new IndexOutOfBoundsException(); //Each exception is object
	}
	LNode curr = front;
	
	while ( curr != null &&  i > 0 ) {	    
	    curr = curr.getNext();
	    i--;
	}
	if ( curr != null ) {
	    return curr.getData();
	}	    
	return 0;
    }

    public char remove( int i ) throws IndexOutOfBoundsException {
	if(i<0 || i>= size()){
	    throw new IndexOutOfBoundsException();
	}
	LNode curr = front;
	char old = 0;
	
	if ( curr == null )
	    return 0;

	if ( i == 0 ) {
	    front = front.getNext();
	    return curr.getData();
	}
	    
	while ( curr.getNext() != null && i > 1 ) {
	    curr = curr.getNext();
	    i--;	    
	}
	
	old = curr.getNext().getData();
	curr.setNext( curr.getNext().getNext()  );

	return old;
    }
    
    public int size() {

	LNode curr = front;
	int s = 0;
	while ( curr != null ) {
	    curr = curr.getNext();
	    s++;
	}
	return s;
    }

    public void transferNodesFromEnd(LinkedList other, int num){

	if(num>other.size()){
	    while(other.size()-num > 0){
		other.front=other.front.getNext();
	    }
	    while(num>0){
		add(other.remove(other.size()-num));
		num=num-1;
	    }
	}
    }
       

    public static void main(String[] args) {

	LinkedList l = new LinkedList();
	LinkedList s = new LinkedList();
	for (char c = 'A'; c < 'F'; c++){
	    l.add(c);
	    s.add(c);
	}
	System.out.println( l );	
	
	l.add( '0', 0 );
	l.add( '1', 1 );
	l.add( '2', 3 );
	l.add( '3', 4 );

	System.out.println( l );	
	/*
	l.set( '!', 0 );
	//l.set( '@', 8 );

	System.out.println( l );	
	
	System.out.println( l.get(0) );
	System.out.println( l.get(5) );
	//System.out.println( l.get(3) );
	

	System.out.println( l.remove(0) );
	//System.out.println( l.remove(5) );

	System.out.println( l );
	System.out.println( l.size() );
	*/
	l.transferNodesFromEnd(s,3);
	System.out.println(l);
	System.out.println(s);
    }
    
}
