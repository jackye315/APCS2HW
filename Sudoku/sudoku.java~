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


    public static void main(String[] args){
	sudoku s = new sudoku();
	
	System.out.println(s);
    }

    public void solve(){
	solveHelper(1,1);
    }

    public boolean solveHelper(




}
