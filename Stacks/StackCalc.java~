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

	return values.pop();
    }

    public static void main(String[] args) {
	
	String s = "4+3*6/2";
	String p = toPostfix( s );

	System.out.println( p );
	
	System.out.println( calculate(p) );
    }

}
