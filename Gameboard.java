import java.util.*;
public class GameBoard(){

    private TreeNode root;
    Random rand=new Random();
    public int getMaxHelper(TreeNode current){
	if(current==null){
	    return 0;
	}
	else{
	    int l=getMaxHelper(current.getLeft());
	    int r=getMaxHelper(current.getRight());
	    if(l>r){
		return l+curr.getData();
	    }
	    else{
		return r+curr.getData();
	    }
	}
    }

    public GameBoard(int numLevels){
	r=rand.nextInt(10);
	if(numLevels==0){
	    return null;
	}
	else{
	    TreeNode t=new TreeNode(r);
	    t.setLeft(GameBoard(numLevels-1));
	    t.setRight(GameBoard(numLevels-1))l
	}
	return t;
    }


}
