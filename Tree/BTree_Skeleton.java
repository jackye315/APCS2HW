/*========== BTree.java ==========
  
  Basic binary tree.
  Uses TreeNode
  
  jdyrlandweaver
  =========================*/

import java.io.*;
import java.util.*;

public class BTree<E> {

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;
    
    random rand=new random();
    private TreeNode<E> root;

    public BTree() {
	root = null;
    }

    /*======== public void add() ==========
      Inputs:   E d
      Returns: 
      
      Wrapper method for the recursive add()
      ====================*/     
    public void add( E d ) {
	
	TreeNode<E> bn = new TreeNode<E>( d );

	if ( root == null )
	    root = bn;
	else
	    add( root, bn );
    }

    /*======== public void add() ==========
      Inputs:   TreeNode<E> curr, TreeNode<E> bn  
      Returns: 
      
      Adds bn to the tree rooted at curr. If curr has 
      an available child space, then attach bn there.

      Otherwise, try to add at the subtree rooted at
      one of curr's children. Choose the child to be
      added to randomly.
      ====================*/
    public void add( TreeNode<E> curr, TreeNode<E> bn ) {
	if(curr.getLeft()==null){
	    curr.setLeft(bn);
	}
	else if(curr.getRight()==null){
	    curr.setRight(bn);
	}
	int r=rand.nextInt(4);
	else if(r==0){
	    curr.getLeft().setLeft(bn);
	}
	else if(r==1){
	    curr.getLeft().setRight(bn);
	}
	else if(r==2){
	    curr.getRight().setLeft(bn);
	}
	else if(r==3){
	    curr.getRight().setRight(bn);
	}

    }
    
    public void traverse( int mode) {
	if ( mode == PRE_ORDER )
	    preOrder( root );
	else if ( mode == IN_ORDER )
	    inOrder( root );
	else
	    postOrder( root );
	System.out.println();
    }
    /*======== public void preOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Pritns out the elements in the tree by doing an
      pre-order Traversal
      ====================*/
    public void preOrder( TreeNode<E> curr ) {
	if(curr.getData()==null){
	    return;
	}
	E ans;
	ans=ans+curr.getData();
	preOrder(curr.getLeft());
	preOrder(curr.getRight());
	System.out.println(ans);
    }


    /*======== public void inOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Pritns out the elements in the tree by doing an
      in-order Traversal
      ====================*/
    public void inOrder( TreeNode<E> curr ) {
	if(curr.getData()==null){
	    return;
	}
	E ans;
	inOrder(curr.getLeft());
        ans=ans+curr.getData();
	inOrder(curr.getRight());
	System.out.println(ans);
    }

    /*======== public void postOrder() ==========
      Inputs:   TreeNode<E> curr  
      Returns: 
      
      Prints out the elements in the tree by doing a
      post-order Traversal

      04/05/12 08:56:34
      jdyrlandweaver
      ====================*/
    public void postOrder( TreeNode<E> curr ) {
	if(curr.getData()==null){
	    return;
	}
	E ans;
	postOrder(curr.getLeft());
	postOrder(curr.getRight());
        ans=ans+curr.getData();
	System.out.println(ans);
    }
    
	
    public static void main( String[] args ) {

	BTree<Integer> t = new BTree<Integer>();

	for ( int i=0; i < 8; i++ ) 
	    t.add( i );
	System.out.println( "Pre-order: ");
	t.traverse( PRE_ORDER );
	System.out.println( "In-order: ");
	t.traverse( IN_ORDER );
	System.out.println( "Post-order: ");
	t.traverse( POST_ORDER );

    }
}
