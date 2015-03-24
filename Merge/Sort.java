/*========== Sort.java ==========

  Class used to test various sorting algorithms.
  The constructor will create an array of ints and then
  populate them with random values.
  
  The class also contains variables to keep track
  of the number of swaps and comparisons performed
  for a given sort.

  Complete bubble(), selection() and insertion()
jdyrlandweaver
=========================*/

import java.io.*;
import java.util.*;

public class Sort {

    public static int DEFAULT_SIZE = 1000;

    /*======== public void populate()) ==========
      Inputs: int[] list   
      Returns: 
      
      populates the list with random ints in the 
      range [0, list.length)
      ====================*/
    public static void populate( int[] list ) {

	Random r = new Random();
	for (int i=0; i<list.length; i++)
	    list[i] = r.nextInt() % list.length;
    }

    /*======== public void duplicate () ==========
      Inputs:  int[] a
      Returns: A new array of ints that is an exact
               duplicate of a      
      ====================*/
    public static int[] duplicate ( int[]  a ) {

	int[] n = new int[ a.length ];
    
	for (int i=0; i<a.length; i++)
	    n[i] = a[i];

	return n;
    }

    public static String show(int[] list) {
	String s = "";
	for (int i=0; i<list.length - 1; i++)
	    s = s + list[i] + ", ";
	return s + list[list.length-1];
    }


    /*======== public boolean isSorted()) ==========
      Inputs:   
      Returns: true if the list is sorted
               false if the list is unsorted

      ====================*/
    public static boolean isSorted(int[] list) {
	for (int i=0; i<list.length - 1; i++)
	    if (list[i] > list[i+1])
		return false;
	return true;
    }

    /*======== public void swap() ==========
      Inputs:  int a
               int b  
      Returns: 
      
      Swaps the values at postitons a and b in list
      ====================*/    
    public static void swap(int a, int b, int[] list) {
	int c = list[a];
	list[a] = list[b];
	list[b] = c;
    }

    public static void insertionSort(int[] a) {
	int t, pos;
	for (int i=1; i < a.length; i++) {
	    pos = i;
	    t = a[pos];
	    while ( pos > 0 && a[pos - 1] > t ) {
		a[pos] = a[pos - 1];
		pos --;
	    }
	    a[pos] = t;
	}
    }
    

    /*======== public static int[] merge() ==========
      Inputs:  int[] a
               int[] b  
      Returns: A new sorted array containing the 
               combined elements of a and b
              
      This method must run in linear time.      
      ====================*/
    public static int[] merge( int[] a, int[] b )  {
    	int[] sorted = new int[a.length + b.length];
	int x=0;
	int y=0;
	int z=0;
	while(x<sorted.length){
	    if(y<a.length && z<b.length){
	    if(a[y]>b[z]){
		sorted[x]=b[z];
		z=z+1;
	    }
	    else if(a[y]<b[z]){
		sorted[x]=a[y];
		y=y+1;
	    }
	    else{
		sorted[x]=b[z];
		z=z+1;
	    }
	    }
	    else{
	    if(a.length-1<y){
		sorted[x]=b[z];
		z=z+1;
	    }
	    else if(b.length-1<z){
		sorted[x]=a[y];
		y=y+1;
	    }
	    }
	    x=x+1;
	}
     	return sorted;
     }
    /*
    public static int[] merge(int[] a, int[] b){
	int[] c = new int[a.length+b.length];
	return merge(a,b,c,0,0,0);
    
    }

    
    public static int[] merge(int[] a, int[] b, int[] c, int acount, int bcount, int ccount){
	if(ccount == c.length){
	    return c;
	}
	if(acount == a.length){
	    for(int i = 0; i < b.length - bcount; i++){
		c[ccount+i] = b[bcount+i];
	    }
	    return c;
	}
	if(bcount == b.length){
	    for(int i = 0; i < a.length - acount; i++){
		c[ccount+i] = a[acount+i];
	    }
	    return c;
	}
	if(a[acount] > b[bcount]){
	    c[ccount] = b[bcount];
	    return merge(a,b,c,acount,bcount+1,ccount+1);
	}else{
	    c[ccount] = a[acount];
	    return merge(a,b,c,acount+1,bcount,ccount+1);

	}
	
    }
    */
 public static int[] merges(int[]array){
	if(array.length == 0 || array.length == 1){
	    return array;
	}
	int[] a = new int[array.length/2];
	int[] b = new int[array.length - array.length/2];
	System.arraycopy(array,0,a,0,array.length/2);
	System.arraycopy(array,array.length/2,b,0,array.length - array.length/2);
	return merge(merges(a),merges(b));

    }

public static void mergeSort(int[] array){
	int[] copy = new int[array.length];
	copy = merges(array);
	for(int i = 0; i < copy.length; i++){
	    array[i] = copy[i];
	}
    }   

    public static void main(String[] args) {
	
	int[] a1 = new int[10];
	int[] a2 = new int[10];

	populate(a1);
	populate(a2);
	insertionSort(a1);
	insertionSort(a2);
	System.out.println( show(a1) );
	System.out.println( show(a2) );

	int[] merged = merge( a1, a2 );
	System.out.println( show( merged ) );
	
	int[]a3=new int [10];
	populate(a3);
	System.out.println(show(a3));
	mergeSort(a3);
	System.out.println(show(a3));
	
    }
}

//Also fixed the first merge
