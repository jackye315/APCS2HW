import java.util.*;

public class Recursion{



    public static int fact(int n) throws IllegalArgumentException {
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	if(n>1){
	    return n*fact(n-1);
	}else{
	    return n;
	}

    }
    public static int fib(int n, ArrayList <Integer> L) throws IllegalArgumentException {
	if (n < 0){
	    throw new IllegalArgumentException(); 
	}
	if(L.size()> n){
	    return L.get(n);
	}
	else{
	    L.add(fibhelp(n-1)+fibhelp(n-2));
	    return fibhelp(n-1)+fibhelp(n-2);
	 
	}
	
    }

    public static int fibhelp(int n){
	if(n>2){
	    return fibhelp(n-1)+fibhelp(n-2);
	}
	if(n==2 || n==1){
	    return 1;
	}else{
	    return n;
	}
    }

    public static double sqrt(double n) throws IllegalArgumentException{
	if (n < 0){
	    throw new IllegalArgumentException();

	}else if (n == 0){
	    return 0;
	}else{
	    return sq(n, 1);
	}
    }

    public static double sq(double n, double guess){
	double nguess = (n/guess + guess) / 2;
	double nsq = nguess * nguess;
	double dif = nsq - n;
	if (nsq != n){
	    if (dif < .0001){
		return nguess;
	    }
	    return sq(n, nguess);
	}else{
	    return nguess;
	}
    }
    //Couldn't figure out scramble
     public static ArrayList scramble(String s){
	 ArrayList <String> List= new ArrayList<String>();
	 if(s.length()<=0){
	     throw new IllegalArgumentException();
	 }
	 if(s.length()==1){
	     List.add(s);
	     return List;
	 }
	 if(s.length()==2){
	     List.add(s);
	     s=s.substring(1)+s.substring(0,1);
	     List.add(s);
	     return List;
	 }
	 else{
	     int x=0;
	     while(x<s.length()){
	    
		 s="" + s.charAt(x)+s.substring(0,x)+s.substring(x+1);
		 String y=""+s.charAt(0)+scramble(s.substring(1));


		 List.add(y);
		 x=x+1;
	     }
	     return List;
	 }
     }
    /*
    public String scramblehelp(String s){
	if(s.length()==2){
	    String a=s.substring(1)+s.substring(0,1);
	    return a;
	}
	else{
	return s;
    }
    }

    */
    


public static void main (String [] args){
    Recursion a;
    ArrayList <Integer> b= new ArrayList<Integer>();
    a=new Recursion();
    System.out.println(a.fact(4));
    System.out.println(a.fib(6, b));
    System.out.println(a.sqrt(50));
    System.out.println(a.scramble("bat"));

}




}
