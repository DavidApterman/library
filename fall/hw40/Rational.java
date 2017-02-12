/*-----------------------------
  class Rational
  by Clyde "Thluffy" Sinclair
  * represents a rational number (p/q)
  * implements Java's Comparable interface
  -----------------------------*/


public class Rational implements Comparable
{
    //attributes
    private int _numerator;
    private int _denominator;


    //default constructor
    //inits to 0/1
    public Rational() 
    {
	_numerator = 0;
	_denominator = 1;
    }


    //overloaded constructor
    //inits to n/d
    //unless d==0, which will cause revert to 0/1
    public Rational( int n, int d ) 
    {
	this();
	if ( d == 0 ) {
	    System.out.println( "Invalid input. Value set to 0/1." );
	}
	else {
	    _numerator = n;
	    _denominator = d;
	}
    }


    //overridden toString()
    public String toString() 
    {
	return _numerator + " / " + _denominator;
    }


    //return floating-point approximation of this rational num
    public double floatValue() 
    {
	return (double)_numerator / _denominator;
    }


    /***
     * void multiply(Rational) -- multiplies 2 Rational objects
     * precondition:  input not null 
     * postcondition: this Rational instance is product
     ***/
    public void multiply( Rational r ) 
    {
	_numerator = this._numerator * r._numerator;
	_denominator = this._denominator + r._denominator;
    }


    /***
     * void divide(Rational) -- divides one Rational by another
     * precondition:  input not null 
     * postcondition: this Rational instance is quotient
     ***/
    public void divide( Rational r ) 
    {
	if ( r._numerator != 0 ) {
	    _numerator = _numerator * r._denominator;
	    _denominator = _denominator * r._numerator;
	}
	else {
	    System.out.println( "Div by 0 error. Values unchanged." );
	}
    }


    /***
     * void add(Rational) -- adds 2 Rationals
     * precondition:  input not null 
     * postcondition: this Rational instance is sum
     ***/
    public void add( Rational r ) 
    {
	_numerator = _numerator * r._denominator + r._numerator * _denominator;
	_denominator = _denominator * r._denominator;
    }


    /***
     * void subtract(Rational) -- computes difference of 2 Rationals
     * precondition:  input not null 
     * postcondition: this Rational instance is difference
     ***/
    public void subtract( Rational r ) 
    {
	_numerator = _numerator * r._denominator - r._numerator * _denominator;
	_denominator = _denominator * r._denominator;
    }


    /***
     * int gcd() -- computes greatest common divisor of numerator, denomninator
     * precondition:  input not null 
     * postcondition: returns GCD(numerator,denominator) of this Rational
     ***/
    public int gcd() 
    {
	int a, b, x;

	if ( _numerator > _denominator ) {
	    a = _numerator;
	    b = _denominator;
	}
	else {
	    a = _denominator;
	    b = _numerator;
	}

	while( a % b != 0 ) {
	    x = a;
	    a = b;
	    b = x % b;
	}

	return b;
    }


    /***
     * void reduce() -- simplifies fraction
     * precondition:  input not null 
     * postcondition: this Rational reduced to simplest terms
     ***/
    public void reduce() 
    {
	int g = gcd();
	_numerator = _numerator / g;
	_denominator = _denominator / g;
    }



    /***
     * int gcd(int,int) -- computes greatest common divisor of inputs
     * precondition:  inputs nonzero
     * postcondition: returns GCD(numerator,denominator) of this Rational
     ***/
    public static int gcd( int n, int d ) 
    {
	int a, b, x;

	if ( n > d ) {
	    a = n;
	    b = d;
	}
	else {
	    a = d;
	    b = n;
	}

	while( a % b != 0 ) {
	    x = a;
	    a = b;
	    b = x % b;
	}

	return b;
    }


    /***
     * int compareTo(Object) -- tells which of two Rationals is greater
     * (Comparable interface method)
     * precondition: 
     * postcondition: 
     * Throws exception if input not an instance of class Rational.
     * returns...
     *   0 if the two values are equal
     *   positive integer if this greater than input
     *   negative integer if this less than input
     ***/
    public int compareTo( Object other ) 
    {
	// If other is not a Rational, throw an exception
	// This will exit the function, generating a runtime error
	if ( ! (other instanceof Rational) )
	    // ClassCastException specified by Java API.
	    // Input String is optional; gives diagnostics info.
	    throw new ClassCastException("\nMy first error message! "
					 + " compareTo() input not a Rational");

	int thisNumerator, otherNumerator;

	thisNumerator = _numerator * ((Rational)other)._denominator;
	otherNumerator = _denominator * ((Rational)other)._numerator;

	return thisNumerator - otherNumerator;
    }

    
    /***
     * boolean equals(Object) -- tells whether 2 Objs are equivalent
     * pre:  other is an instance of class Rational
     * post: Returns true if this and other are aliases,
     * or if this and other have equal values. 
     ***/
    public boolean equals( Object other )
    { 
	//First, reduce ...thus allowing for direct comparison of attributes
	reduce();

	if ( other instanceof Rational ) 
	    ((Rational)other).reduce();
	/* Typecasting necessary because var type of other is Object, 
	   and an Object does not have a reduce() method.
	*/

	//Q: Why is boolean short-circuiting essential below?
	//   ie, What would happen if Java did not do it?
	return this == other //check for aliases
	    || 
	    ( other instanceof Rational
	      && this._numerator == ((Rational)other)._numerator 
	      && this._denominator == ((Rational)other)._denominator );

    }//end equals()


    //main method for testing
    public static void main(String[] args)
    {
	Rational r = new Rational( 3, 7 );
	Rational s = new Rational();
	Rational t = new Rational( 8, 5 );

	Rational u = new Rational( 1, 2 );
	Rational v = new Rational( 2, 3 );
	Rational w = new Rational( 8, 12 );
	Rational x = new Rational( 8, 12 );
	String y = "yoo";
	
	System.out.println("r: " + r );
	System.out.println("s: " +  s );
	System.out.println("t: " +  t );

	System.out.println( r + " as a floating pt approximation: " 
			    + r.floatValue() );
	System.out.println( s + " as a floating pt approximation: " 
			    + s.floatValue() );
	System.out.println( t + " as a floating pt approximation: " 
			    + t.floatValue() );

	System.out.println( "r > t: " +  r.compareTo(t) );
	System.out.println( "r > s: " +  r.compareTo(s) );
	System.out.println( "s > t: " +  s.compareTo(t) );

	//uncommenting the line below should trigger a runtime error
	//	System.out.println( "s > y: " +  s.compareTo(y) );

	try {
	    System.out.println( "s > y: " +  s.compareTo(y) );
	} catch ( ClassCastException cce) {
	    System.out.println("ClassCastExcp caught.");
	} catch (Exception e) {
	    System.out.println("Excp caught.");
	}
	
	System.out.println( "v.equals(v): " + v.equals(v) );
	System.out.println( "v.equals(w): " + v.equals(w) );
	System.out.println( "w.equals(x): " + w.equals(x) );

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  System.out.print( r + " * " + t + " = ");
	  r.multiply(t);
	  System.out.println(r);

	  System.out.print( r + " / " + t + " = ");
	  r.divide(t);
	  System.out.println(r);

	  System.out.print( u + " + " + v + " = ");
	  u.add(v);
	  System.out.println(u);
	
	  System.out.print( u + " - " + v + " = ");
	  u.subtract(v);
	  System.out.println(u);

	  System.out.println("GCD of " + r + " = " + r.gcd() );
	  System.out.println("GCD of " + t + " = " + t.gcd() );

	  System.out.print( r + " in reduced form = ");
	  r.reduce();
	  System.out.println(r);

	  System.out.println( "\nNow testing static gcd...");
	  System.out.println( Rational.gcd(100,9) );
	  System.out.println( Rational.gcd(245,25) );
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/		
    }//end main()


}//end class Rational
