public ListNode getKthNode( int i )  {

    LNode curr = front;
    while ( curr != null && i > 0 ) {
	curr = curr.getNext();
	i--;
    }
    return curr;
}


public void transferNodesFromEnd(WaitingList other, int num){

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
