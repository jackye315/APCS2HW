import java.io.*;
import java.util.*;

public class sudoku{

    char[][] board;
    int maxX;
    int maxY;
    static final String clear = "\033[2J";
    static final String hide = "\033[?25l";
    static final String show = "\033[?25h";
    
public String go(int x, int y) {
	return "\033[" + x + ";" + y + "H";
    }
    
    public void wait( int ms ) {
	try {
	    Thread.sleep( ms );
	}
	catch( Exception e ) {}
    }
    public sudoku() {
	maxX=4;
	maxY=4;
	board = new char[maxX][maxY];
	try {	    
 	    Scanner sc = new Scanner(new File("sudoku-small.dat"));
	    int j=0;

	    while (sc.hasNext()) {
		String line = sc.nextLine();
		for (int i=0; i < maxX; i++) {
		    board[i][j] = line.charAt(i);
		}
		j++;
	    }
	}
	catch (Exception e) {}	
    }
public String toString() {
	String s = "";
	for (int y=0;y<maxY;y++) {
	    for (int x=0;x<maxX;x++)
		s = s +board[x][y];
	    s=s+"\n";
	}
	
	return s;
    }

    public boolean contains(int x, int y, int num){
	int a=0;
	while(a<board[x].length){
	    if(board[x][a]==Character.forDigit(num,10)){
		return true;
	    }
	    a=a+1;
	}
	int b=0;
	while(b<board.length){
	    if(board[b][y]==Character.forDigit(num,10)){
		return true;
	    }
	    b=b+1;
	}
	return false;
    }	
    public boolean full(){
	int a=0;
	while(a<board.length){
	    int b=0;
	    while(b<board[a].length){
		if(board[a][b]=='-'){
		    return false;
		} b=b+1;
	    }
	    a=a+1;
	}
	return true;
    }
    public void solve(){
	solveHelper(0,0,3);
    }

    public boolean solveHelper(int x, int y, int num ){
	System.out.println( this );
	wait( 30 );
	if(y<4 && board[x][y]!='-'){
	    y=y+1;
	}
	if(y==4){
	    y=0;
	    x=x+1;
	}
	if( x==3 &&  y==3 && board[3][3]!='-' && full()){
	    return true;
	}


	if(contains(x,y,num)){
	    return false;
	}
	board[x][y]=Character.forDigit(num,10);
	
        
	


	if(solveHelper(x,y+1,1)){
		return true;
	    }
	else if(solveHelper(x,y+1,2)){
	    return true;
	}
	else if(solveHelper(x,y+1,3)){
	    return true;
	}
	else if(solveHelper(x,y+1,4)){
	    return true;
	}
	/*
	else if(solveHelper(x+1,y,1)){
	    return true;
	}
	else if(solveHelper(x+1,y,2)){
	    return true;
	}
	else if(solveHelper(x+1,y,3)){
	    return true;
	}
	else if(solveHelper(x+1,y,4)){
	    return true;
	}
	*/
	else{
	    return false;
	}
	

    }
 


    public static void main(String[] args){
	sudoku s = new sudoku();
	s.solve();
	System.out.println(s);
    }






}
//Not sure what is wrong with code
