public class Recursion{

    public String name(){
	return "Ye,Jack";
    }

    public int fact(int n){
	if(n>1){
	    return n*fact(n-1);
	}else{
	    return n;
	}

    }
    public int fib(int n){
	if(n>2){
	    return fib(n-1)+fib(n-2);
	}
	if(n==2 || n==1){
	    return 1;
	}else{
	    return n;
	}
    }
    public double sqrt(double n){
	if(n>0){

	}
    }

    public double helper(double n, double guess){
	if(guess
    }

public static void main (String [] args){
    Recursion a;
    a=new Recursion();
    System.out.println(a.fact(4));
    System.out.println(a.fib(8));
}




}
