public class Commafier 
{

    /*=====================================
      String commafyR(int) -- inserts commas in a number, every 3rd digit,
      recursively.
      precondition:  n is non-negative integer
      postcondition: returns String version of n with commas inserted
      =====================================*/
    public static String commafyR( int n ) 
    {
	//store String version of n
	String nAsStr = n + "";

	if (n < 1000) 
	    return nAsStr; 
	else 
	    return commafyR( n/1000 ) + "," 
		+ nAsStr.substring( nAsStr.length() - 3 );
	//Q: why is (n%1000) insufficient after the comma?
    }


    /*=====================================
      String commafyF(int) -- inserts commas in a number, every 3rd digit,
      using a FOR Loop.
      precondition:  n is non-negative integer
      postcondition: returns String version of n with commas inserted
      =====================================*/
    public static String commafyF( int n ) 
    {
	//store String version of n
	String nAsStr = n + "";

	//traverse String version of n fr R to L, inserting a comma 
	// at every 3rd position
	for( int pos = nAsStr.length()-3; pos > 0; pos-=3 ) { 
	    nAsStr = nAsStr.substring( 0 , pos ) + ","
		+ nAsStr.substring( pos ); 
	} 
        return nAsStr; 
    }


    public static void main( String[] args ) { 
	  //test calls for development:
	System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" ); 
	System.out.println( "commafyR(1): " + commafyR(1) ); 
	System.out.println( "commafyR(10): " + commafyR(10) ); 
	System.out.println( "commafyR(101): " + commafyR(101) ); 
	System.out.println( "commafyR(1000): " + commafyR(1000) ); 
	System.out.println( "commafyR(12345): " + commafyR(12345) ); 
	System.out.println( "commafyR(1234567890): " + commafyR(1234567890) ); 

	System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" ); 
	System.out.println( "commafyF(1): " + commafyF(1) ); 
	System.out.println( "commafyF(10): " + commafyF(10) ); 
	System.out.println( "commafyF(101): " + commafyF(101) ); 
	System.out.println( "commafyF(1000): " + commafyF(1000) ); 
	System.out.println( "commafyF(12345): " + commafyF(12345) ); 
	System.out.println( "commafyF(1234567890): " + commafyF(1234567890) ); 

	System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" ); 
	System.out.println( "cmd line args process below:" );
	System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" ); 

	//code to handle command line input: 
	// (note, need only work for int CLI...)
	for( String intAsStr : args ) {
	    int x = Integer.parseInt( intAsStr );
	    System.out.println( commafyF( x ) );
	}

	//or

	System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" ); 

	for( String intAsStr : args ) {
	    int x = Integer.parseInt( intAsStr );
	    System.out.println( commafyR( x ) );
	}
	/*-------------------------------------------------------
	  =======================================================*/
    }//end main

}//end class 
