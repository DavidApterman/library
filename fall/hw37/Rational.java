public class Rational
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
     * int compareTo(Rational) -- tells which of two Rationals is greater
     * precondition:  input not null
     * postcondition: returns...
     *   0 if the two values are equal
     *   positive integer if this greater than input
     *   negative integer if this less than input
     ***/
    public int compareTo( Rational other ) 
    {
	int thisNumerator, otherNumerator;

	thisNumerator = _numerator * other._denominator;
	otherNumerator = _denominator * other._numerator;

	return thisNumerator - otherNumerator;

    }


    //main method for testing
    public static void main(String[] args) {
	
	Rational r = new Rational( 3, 7 );
	Rational s = new Rational();
	Rational t = new Rational( 8, 5 );

	Rational u = new Rational( 1, 2 );
	Rational v = new Rational( 2, 3 );
	Rational w = new Rational( 8, 12 );
	
	System.out.println("r: " + r );
	System.out.println("s: " +  s );
	System.out.println("t: " +  t );

	System.out.println( r + " represented as a floating pt num: " 
			    + r.floatValue() );

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
		
    }


}//end class Rational
