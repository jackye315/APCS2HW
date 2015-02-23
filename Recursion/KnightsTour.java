import java.io.*;
import java.util.*;

public class KnightsTour{
    // int size;
    static final String clear = "\033[2J";
    static final String hide = "\033[?25l";
    static final String show = "\033[?25h";

    private int[][]board;
    
    private String go(int x,int y){
	return "\033[" + x + ";" + y + "H";
    }
 
 

    
    public String toString(){
	String s = "\n";
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		int value = board[i][j];
		if(value < 10 ){
		    s=s+" ";
		}
		if(value <100){
		    s=s+" ";
		}
	     
		s=s+board[i][j];
	    }
	    s=s+"\n";	
	}
	return hide + clear + go(0,0) + s +"\n" + show;
    }
    
    public KnightsTour(int size){
	board = new int[size][size];
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
		board[i][j]=0;
	    }
	}	
    }
    
    public void wait( int ms ) {
	try {
	    Thread.sleep( ms );
	}
	catch( Exception e ) {}
    }    

    public boolean solve(){
	return solveHelper(0,0,1);
    }

		
    public boolean solveHelper(int x,int y,int MoveNumber){
	//System.out.println(this);
	//wait(50);
	if(x < 0 || x >= board.length || y < 0 || y >= board.length || board.length<6){
	    return false;
	}
	if(board[x][y]==0){
	    if(MoveNumber == board.length*board.length){
		board[x][y] = MoveNumber;
		return true;
	    }
	    board[x][y] = MoveNumber;
	    if(solveHelper(x+1,y+2,MoveNumber+1) || 
	       solveHelper(x-1,y+2,MoveNumber+1) || 
	       solveHelper(x+1,y-2,MoveNumber+1) ||
	       solveHelper(x-1,y-2,MoveNumber+1) ||
	       solveHelper(x+2,y+1,MoveNumber+1) ||
	       solveHelper(x-2,y+1,MoveNumber+1) ||
	       solveHelper(x+2,y-1,MoveNumber+1) ||
	       solveHelper(x-2,y-1,MoveNumber+1)){
		return true;
	    }
	    board[x][y]=0;
	}
	return false;
    }
    
    public static void main(String[]args){
	KnightsTour a = new KnightsTour(6);
	
	
	if(a.solve()){
	    System.out.println(a);
	}else{
	    System.out.println("No Solution");

	}
    }

}
//Takes really long time to complete anything above 7x7 board
