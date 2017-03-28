/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *
      1. Begin at right end of input expression
      2. Start pushing close parens, numbers, ops onto stack
         ...until you reach an open paren
      3. Perform operation on stacked numbers, popping off 1 at at time
         ...until encounter a close paren
      4. Push result of calculations onto stack without parens
      5. Repeat steps 2-5 until entire input expression has been traversed
 * 
 * STACK OF CHOICE: LLStack by Clyde "Thluffy" Sinclair 
 * b/c that Thluffy likes nodes
 ******************************************************/

public class Scheme 
{

    /****************************************************** 
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and 
     *           integer operands.
     * postcond: Returns simplified value of expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     ******************************************************/
    public static String evaluate( String expr ) 
    {
	String retVal = "";
	String[] exprArr = expr.split("\\s+"); //split on whitespace 

	Stack<String> flapjacks = new LLStack<String>();

	//traverse input expression from R to L
	for( int i = exprArr.length - 1; i > -1; i-- ) {
	    if ( exprArr[i].equals("(") ) {
      		String op = flapjacks.pop();
		if ( op.equals("+") ) {
		    flapjacks.push( unload(1,flapjacks) );
		}
		else if ( op.equals("-") ) {
		    flapjacks.push( unload(2,flapjacks) );
		}
		else if ( op.equals("*") ) {
		    flapjacks.push( unload(3,flapjacks) );
		}
	    }
	    //push numbers, ops, )'s onto stack
	    else {
		flapjacks.push( exprArr[i] );
	    }
	}
	retVal = flapjacks.pop();
	return retVal;
    }


    /****************************************************** 
     * precond:  Assumes top of input stack is a number.
     * postcond: Performs op on nums until closing paren
     *           is seen thru peek().
     *           Returns result of applying operator to
     *           sequence of operands.
     *           Ops: + is 1, - is 2, * is 3
     ******************************************************/
    public static String unload( int op, Stack<String> numbers ) 
    {
	int retVal = Integer.parseInt( numbers.pop() );

	while( !( numbers.peek().equals(")") ) ) {
	    int nextVal = Integer.parseInt( numbers.pop() );
	    if ( op == 1 ) {
		retVal = retVal + nextVal;
	    }
	    else if ( op == 2 ) {
		retVal = retVal - nextVal;
	    }
	    else if ( op == 3 ) {
		retVal = retVal * nextVal;
	    }
	}
	if( numbers.peek().equals(")") ) { 
	    numbers.pop();
	}
	return retVal + "";
    }//end unload()


    /*
    //optional check-to-see-if-its-a-number helper fxn:
    public static boolean isNumber( String s ) {
        try {
	    Integer.parseInt(s);
	    return true;
	}
        catch( NumberFormatException e ) {
	    return false;
	}
    }
    */


    //main method for testing
    public static void main( String[] args ) 
    {
	String zoo1 = "( + 4 3 )";
	System.out.println(zoo1);
	System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
	//...7

	String zoo2 = "( + 4 ( * 2 5 ) 3 )";
	System.out.println(zoo2);
	System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
	//...17

	String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
	System.out.println(zoo3);
	System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
	//...29

	String zoo4 = "( - 1 2 3 )";
	System.out.println(zoo4);
	System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
	//...-4
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//main

}//end class Scheme
