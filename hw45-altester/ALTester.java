// Clyde "Thluffy" Sinclair
// APCS1 pd00
// HW45 --  Al<B> Sorted!
// 2016-12-14

//DIRECTIVE:
//Write class ALTester, which will populate an ArrayList with 23 Integers and determine whether the list is sorted or not.

import java.util.ArrayList;

public class ALTester 
{

    public static void main( String[] args ) 
    {
	ArrayList<Comparable> foo = new ArrayList<Comparable>();


	System.out.println(foo);

	//populate
	for( int i=0; i<23; i++ ){
	    foo.add(i*2);
	}

	System.out.println(foo);

	foo.set(5,100);
	
	//check for sorted
	//if msg does not appear, list was sorted
	for( int i=0; i<foo.size()-1; i++ ) {
	    System.out.println("at i: " + foo.get(i) );
	    if ( foo.get(i).compareTo(foo.get(i+1)) > 0 ) {
		System.out.println( " *** NOT sorted *** " );
		break;
	    }
	}
	    
    }//end main

}//end class
