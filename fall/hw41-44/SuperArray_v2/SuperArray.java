/*==================================================
  class SuperArray version 2.0
  Wrapper class for array. Facilitates resizing, 
  expansion on-demand, and read/write capability on elements.
  ==================================================*/

public class SuperArray 
{
    private int[] _data;  //underlying container structure
    private int _lastPos; //marker for last meaningful value
    private int _size;    //number of meaingful values

    //default constructor
    //initializes 10-item array
    public SuperArray() 
    { 
	_data = new int[10];
	_lastPos = -1;
	_size = 0;	
    }


    //output array in [a,b,c] format
    //eg, for int[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() 
    { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }


    //double capacity of this instance of SuperArray 
    private void expand() 
    { 
	int[] temp = new int[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }


    //accessor method -- return value at specified index
    public int get( int index ) 
    {
	return _data[index];
    }


    //mutator method -- set index to newVal, return old value at index
    public int set( int index, int newVal ) 
    {
 	int temp = _data[index];
	_data[index] = newVal;
	return temp;
    }



    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( int newVal ) 
    { 
	//first expand if necessary
	if ( _size >= _data.length )
	    expand(); 
	_data[_lastPos+1] = newVal;
	_lastPos++;
	_size++;
    }


    //inserts an item at index
    //shifts existing elements (starting at index) right 1 slot
    public void add( int index, int newVal )
    {
	//first expand if necessary
	if ( _size >= _data.length )
	    expand();
	//traverse R->L, shifting elements to right 1 slot
	for( int i = _size; i > index; i-- ) {
	    _data[i] = _data[i-1]; 
	} 
	_data[index] = newVal;
	_lastPos++;
	_size++;
    }


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) 
    { 
	for( int i=index; i < _size - 1; i++ ) {
	    _data[i] = _data[i+1];
	}
	_data[_size-1] = 0; //unnecessary
	_size--;
	_lastPos--;
    }


    //return number of meaningful items in _data
    public int size() 
    { 
	return _size;
    }


    //main method for testing
    public static void main( String[] args ) 
    {
	SuperArray curtis = new SuperArray();
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set(i,i*2);
	    curtis._size++; //necessary bc no add() method yet
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);

	System.out.println("testing get()...");
	for( int i = 0; i < curtis._size; i++ ) {
	    System.out.print( "item at index" + i + ":\t" );
	    System.out.println( curtis.get(i) );
	}

	System.out.println("Expanded SuperArray curtis:");
	curtis.expand();
	System.out.println(curtis);

	SuperArray mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.add(5);
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);

	mayfield.add(3,99);  //Q: Significance of this test call?
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class SuperArray
