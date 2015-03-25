public class arraystack{

    public int[] array;
    public int top;

    public arraystack(){
	array=new int[10];
	top=0;
    }

    public void push(int item){
	for(int i=0;i<array.length;i++){
	    if(array[i]==0){
		array[i]=item;
		top=i;
		i=i+array.length;
	    }
	}
    }

    public int pop(){
	for(int i=0;i<array.length-1;i++){
	    if(array[i+1]==0){
		top=i;
		array[i]=0;
		i=i+array.length;
	    }
	}
	return array[top];
    }
    public int peek(){
	for(int i=0;i<array.length-1;i++){
	    if(array[i+1]==0){
		top=i;
		i=i+array.length;
	    }
	}
	return array[top];
    }

    public boolean isEmpty(){
	return array[0]==0;
    }

    public String toString(){
	int x=0;
        String ans="[";
	while (x<array.length){
	    ans=ans+array[x]+" ";
	    x=x+1;
	}
	ans=ans+"]";
	return ans;
    }


public static void main (String[]args){
    arraystack a=new arraystack();
    a.push(5);
    a.push(10);
    a.push(11);
    System.out.println(a.toString());
    a.pop();
    System.out.println(a.peek());
    a.pop();
    a.pop();
    System.out.println(a.isEmpty());




}
}
