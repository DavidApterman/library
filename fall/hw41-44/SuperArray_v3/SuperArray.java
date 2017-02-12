/**************************************************
  class SuperArray version 3.0
  Wrapper class for array. Facilitates 
  *  resizing 
  *  expansion 
  *  read/write capability on elements
  *  adding an element to end of array
  *  adding an element at specified index
  *  removing an element at specified index
  ...and now SuperArray complies with the specifications of the 
  ListInt interface. (ListInt.java must be in same dir as this file)
**************************************************/

public class SuperArray implements ListInt 
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
    //returns true
    public boolean add( int newVal )
    {
        //first expand if necessary                                             
        if ( _size >= _data.length )
            expand();
        _data[_lastPos+1] = newVal;
        _lastPos++;
        _size++;
	return true;
    }


    //inserts an item at index
    //shifts existing elements (starting at index) right 1 slot
    public void add( int index, int newVal )
    {
        //first expand if necessary
        if ( _size >= _data.length )
            expand();
	for( int i = _size; i > index; i-- ) {
	    _data[i] = _data[i-1];
	}
	_data[index] = newVal;
	_lastPos++;
	_size++;
    }


    //removes the item at index
    //shifts elements left to fill in newly-empted slot         
    //returns removed value
    public int remove( int index )
    {
	int retInt = _data[index]; //store to return later
        for( int i=index; i < _size-1; i++ ) {
            _data[i] = _data[i+1];
        }
        _data[_size-1] = 0; //unnecessary                                       
        _size--;
        _lastPos--;
	return retInt;
    }


    //return number of meaningful items in _data
    public int size()
    {
        return _size;
    }


    public static void main( String[] args ) 
    {

	/*===========================================
	SuperArray curtis = new SuperArray();
	System.out.println( "Printing empty SuperArray curtis..." );
	System.out.println( curtis );

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set( i, i * 2 );
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < 3; i++ ) {
	    curtis.expand();
	    System.out.println("Printing expanded SuperArray curtis...");
	    System.out.println(curtis);
	    System.out.println("new length of underlying array: " 
			       + curtis._data.length );
	}

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

	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	===========================================*/


	
	ListInt mayfield = new SuperArray();
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

	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);

    }//end main()

}//end class SuperArray

/***
             ,,########################################,, 
          .*##############################################* 
        ,*####*:::*########***::::::::**######:::*###########, 
      .*####:    *#####*.                 :*###,.#######*,####*. 
     *####:    *#####*                      .###########*  ,####* 
  .*####:    ,#######,                        ##########*    :####* 
  *####.    :#########*,                       ,,,,,,,,.      ,####: 
    ####*  ,##############****************:,,               .####* 
     :####*#####################################**,        *####. 
       *############################################*,   :####: 
        .#############################################*,####*   
          :#####:*****#####################################.  
            *####:                  .,,,:*****###########, 
             .*####,                            *######* 
               .####* :*#######*               ,#####* 
                 *###############*,,,,,,,,::**######, 
                   *##############################: 
                     *####*****##########**#####* 
                      .####*.            :####* 
                        :####*         .#####, 
                          *####:      *####: 
                           .*####,  *####* 
                             :####*####* 
                               *###### 
                                 *## 

				 -Miranda Chaiken '16

				 ***/
