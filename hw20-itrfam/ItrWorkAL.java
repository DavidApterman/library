/*****************************************************
 * class ItrWorkAL -- skeleton
 * Allows for familiarization with iterators
 *****************************************************/

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWorkAL 
{
    //using FOREACH loop
    //returns a boolean to indicate whether key is present in L
    public static boolean foundA( Integer key, List<Integer> L ) 
    { 
	//Traverse list until key encountered.
	for( Integer n : L ) 
	    if( n.equals(key) ) 
		return true;
	return false;
    }


    //explicitly using an iterator
    //returns a boolean to indicate whether key is present in L
    public static boolean foundB( Integer key, List<Integer> L ) 
    { 
	Iterator<Integer> itr = L.iterator(); 

	while( itr.hasNext() ) 
	    if ( itr.next().equals(key) )
		return true;

	return false;
    }


    //using FOREACH loop
    //returns a list containing the odd numbers in L
    public static List<Integer> oddsA( List<Integer> L ) 
    { 
	List<Integer> retL = new ArrayList<Integer>();

	for( Integer n : L ) 
	    if ( n % 2 == 1 )
		retL.add(n);

	return retL;
    }


    /* Q: WHAT IS WRONG WITH THE VERSION BELOW?
       public static List<Integer> oddsB( List<Integer> L ) { 
       List<Integer> retL = new ArrayList<Integer>();
       Iterator itr = L.iterator();
       while( itr.hasNext() ) {
       Integer tmp = itr.next(); 
       if ( tmp % 2 == 1 )
       retL.add( tmp );
       }
       return retL;
       }
       A: itr.next() returns an Object
       FIX: typecast ret val into Integer, or make itr an Iterator<Integer>
    */


    //explicitly using an iterator
    //returns a list containing the odd numbers in L
    public static List<Integer> oddsB( List<Integer> L ) 
    { 
	List<Integer> retL = new ArrayList<Integer>();

	Iterator<Integer> itr = L.iterator();

	while( itr.hasNext() ) {
	    Integer tmp = itr.next(); //Q: Why this line necessary?
	    if ( tmp % 2 == 1 )
		retL.add( tmp );
	}
	return retL;
    }


    //explicitly using an iterator
    //modifies L s.t. it contains no evens
    public static void removeEvens( List<Integer> L ) 
    { 
	Iterator<Integer> itr = L.iterator();

	while( itr.hasNext() )
	    if ( itr.next() % 2 == 0 )
		itr.remove();
    }


    public static void main( String [] args ) 
    {

	//var type: List   obj type: ArrayList	
	List<Integer> L = new ArrayList<Integer>();

	for( int i = 0; i < 10; i++ )
	    L.add(i);


	// TASK: write code to print the contents of ArrayList L...

	// a) using a FOREACH loop


	// b) explicitly using an iterator


	System.out.println("\nTesting foundA...");
	System.out.println("9 in L? -> " + foundA(9,L) );
	System.out.println("13 in L? -> " + foundA(13,L) );

	System.out.println("\nTesting foundB...");
	System.out.println("9 in L? -> " + foundB(9,L) );
	System.out.println("13 in L? -> " + foundB(13,L) );

	System.out.println("\nTesting oddsA...");
	List<Integer> A = oddsA(L);
	for( int n : A ) System.out.println(n);

	System.out.println("\nTesting oddsB...");
	List<Integer> B = oddsB(L);
	for( int n : B ) System.out.println(n);

	System.out.println("\nTesting removeEvens...");
	removeEvens(L);
	for( int n : L ) System.out.println(n);
	/*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main

}//end class ItrWork

