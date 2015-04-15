public class StackCalc {


    public static boolean isOperator( char c  ) {

	return c == '-' || c == '+' || c == '*' || c == '/';
    }

    public static int getPriority( char op ) {
	if ( op == '-' || op == '+')
	    return 1;
	else
	    return 2;	
    }

    
    
    public static String toPostfix( String infix ) {

	LStack<Character> temp = new LStack<Character>();
	String postFix = "";
	int x=0;
	while(x<infix.length()){
	    if(! isOperator(infix.charAt(x))){
		postfix=postfix+infix.charAt(x);
	    }
	    if(ifOperator(infix.charAt(x))){
		if(temp.isEmpty()){
		    temp.push(infix.charAt(x));
		}
		else{
		    while(!temp.isEmpty || getPriority(temp.peek())>getPriority(infix.charAt(x))){
			char p=temp.pop();
			postfix=postfix+String.valueOf(p);
		    }
		    if(temp.isEmpty() || getPriority(temp.peek())<getPriority(infix.charAr(x))){
			temp.push(infix.charAt(x));
		    }

		}
	    }
	   
	}
	while(!temp.isEmpty()){
		char part=temp.pop();
		postfix=postfix+String.valueOf(part);
	    }
	return postFix;
    }

    public static double evaluate( double b, double a, char operator ) {

	if ( operator == '+' )
	    return a + b;
	else if ( operator == '-' )
	    return a - b;
	else if ( operator == '*' )
	    return a * b;
	else
	    return a / b;
    }
	

    public static double calculate( String postfix ) {

	LStack<Double> values = new LStack<Double>();
	int x=0;
	while(x<postfix.length()){
	    String section=postfix.substring(x,x+1);
	    char part=postfix.charAt(x);
	    if(!isOperator(part)){
		values.push(Double.parseDouble(section));
	    }
	    else if(isOperator(part)){
		double p1=values.pop();
		double p2=values.pop();
		values.push(evaluate(p1,p2,part));
	    }
	}
	return values.pop();
    }

    public static void main(String[] args) {
	
	String s = "4+3*6/2";
	String p = toPostfix( s );

	System.out.println( p );
	
	System.out.println( calculate(p) );
    }

}
