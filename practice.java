public class practice{


    public static String scrambleWord(String word){
	int x=0;
	String ans="";
	while(x<word.length()-1){
	    if(word.substring(x,x+1).equals("A")&& !word.substring(x+1,x+2).equals("A")){
		    ans=ans+word.substring(x+1,x+2);
		    ans=ans+"A";
		    x=x+2;
	    }
	    else{
		ans=ans+word.substring(x,x+1);
		x=x+1;
	    }
	}
	return ans;
    }

    public static void scrambleOrRemove(List<String> wordList){
	int x=0;
	while(x<wordList.size()){
	    String scramble=scrambleWord(wordList.get(x));
	    if(scramble.equals(wordList.get(x))){
		wordList.remove(x);
	    }
	    else{
		wordList.set(x,scramble);
		x=x+1;
	    }
	}
    }


    public class Trio implements MenuItem{
	private Sandwich sandwich;
	private Salad salad;
	private Drink drink;

	public Trio(Sandwich a, Salad b, Drink c){
	    sandwich =a;
	    salad=b;
	    drink=c;
	}
	public String getName(){
	    return sandwich.getName()+"/"+salad.getName()+"/"+drink.getName()+" Trio";
	}

	public double getPrice(){
	    double a=sandwich.getPrice();
	    double b=salad.getPrice();
	    double b=drink.getPrice();
	    double ans;
	    if(a<=b && a<=c){
		ans=b+c;
	    }
	    if(b<=a && b<=c){
		ans=a+c;
	    }
	    if(c<=a && c<=b){
		ans=a+b;
	    }
	    return ans;
	    
	}

    }



}
