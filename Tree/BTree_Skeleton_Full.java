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
    


    /*======== public int getHeight()) ==========
      Inputs:   
      Returns: The height of the tree

      Wrapper for the recursive getHeight method
      ====================*/
    public int getHeight() {
	return getHeight( root );
    }
    /*======== public int getHeight() ==========
      Inputs:   TreeNode<E> curr  
      Returns:  The height of the tree rooted at node curr
      
      ====================*/
    public int getHeight( TreeNode<E> curr ) {
        if (curr.getRight==null && curr.getLeft==null){
	    return 1;
	}
	else{
	    int lheight=getHeight(curr.getLeft());
	    int rheight=getHeight(curr.getRight());
	    if(lheight>rheight){
		return lheight;
	    }
	    else{
		return rheight;
	    }
	}
	return -1;
    }

    /*======== public String getLevel() ==========
      Inputs:   TreeNode<E> curr
                int level
                int currLevel  
      Returns: A string containing all the elements on the
               given level, ordered left -> right
      
      ====================*/
    public String getLevel( TreeNode<E> curr, int level, int currLevel ) {
        if(curr.getData=null){
	    return "";
	}
	else if(level==0){
	    return ""+curr.getData;
	}
	else{
	    getLevel(curr.getLeft(),level-1,currLevel);
	    getLevel(curr.getRight(),level-1,currLevel);
	}

	return "";
    }
    
    /*======== public String toString()) ==========
      Inputs:   
      Returns: A string representation of the tree
     
      This string should display each level as a separate line.
      A simple version might look something like this:

      0
      1 2
      3 4 5

      Note that you cannot tell exactly where 3, 4 and 5 lie.
      That is ok, but if you want a challenge, you can try to
      get the output to look nicer, something like this:

           0
        1     2
         3   4 5

      04/05/12 09:13:06
      jdyrlandweaver
      ====================*/
    public String toString() {
	int h=getHeight(root);
	int level=0;
	String ans;
	while(level<h){
	    ans=ans+getLevel((root),level,0)+"\n";
	    level=level+1;

	}
	return ans;
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
	System.out.println( "Height: " + t.getHeight() );

	System.out.println( t );
    }
}
