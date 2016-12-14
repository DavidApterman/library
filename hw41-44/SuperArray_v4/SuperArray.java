/**************************************************
  class SuperArray version 4.0
  Wrapper class for array. Facilitates 
  *  resizing 
  *  expansion 
  *  read/write capability on elements
  *  adding an element to end of array
  *  adding an element at specified index
  *  removing an element at specified index
  ...and now SuperArray complies with the specifications of the 
  List interface. (List.java must be in same dir as this file)
**************************************************/

public class SuperArray implements List 
{
    private Object[] _data;  //underlying container structure
    private int _lastPos; //marker for last meaningful value         
    private int _size;    //number of meaingful values

    //default constructor
    //initializes 10-item array         
    public SuperArray()
    {
        _data = new Object[10];
        _lastPos = -1;
        _size = 0;
    }


    //output array in [a,b,c] format
    //eg, for Object[] a = {1,2,3} ...
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
        Object[] temp = new Object[ _data.length * 2 ];
        for( int i = 0; i < _data.length; i++ )
            temp[i] = _data[i];
        _data = temp;
    }


    //accessor method -- return value at specified index
    public Object get( int index )
    {
	if ( index < 0 || index >= size() ) {
	    throw new IndexOutOfBoundsException("U B ILLIN (get)");
	}
        return _data[index];
    }


    //mutator method -- set index to newVal, return old value at index
    public Object set( int index, Object newVal )
    {
	if ( index < 0 || index >= size() ) {
	    throw new IndexOutOfBoundsException("U B ILLIN (set)");	
	}
        Object temp = _data[index];
        _data[index] = newVal;
        return temp;
    }


    //add an item after the last item
    //return true
    public boolean add( Object newVal )
    {
        //first expand if necessary                                             
        if ( _size >= _data.length )
            expand();
        _data[_lastPos+1] = newVal;
        _lastPos++;
        _size++;
	return true;
    }


    //insert an item at index
    //shift existing elements (starting at index) right 1 slot
    public void add( int index, Object newVal )
    {
	if ( index < 0 || index >= size() ) {
	    throw new IndexOutOfBoundsException("U B ILLIN (add)");	
	}

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


    //remove the item at index
    //shift elements left to fill in newly-empted slot         
    //return removed value
    public Object remove( int index )
    {
	if ( index < 0 || index >= size() ) {
	    throw new IndexOutOfBoundsException("U B ILLIN (rem)");	
	}
	Object retVal = _data[index]; //store to return later
        for( int i=index; i < _size-1; i++ ) {
            _data[i] = _data[i+1];
        }
        _data[_size-1] = 0; //unnecessary                                       
        _size--;
        _lastPos--;
	return retVal;
    }


    //return number of meaningful items in _data
    public int size()
    {
        return _size;
    }


    public static void main( String[] args ) 
    {
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
	System.out.println("Printing SuperArray mayfield post-remove(3)...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove(3)...");
	System.out.println(mayfield);

	try { //this should fail bc no highest index is now 2...
	    mayfield.add(3,99);
	}
	catch (IndexOutOfBoundsException ioobe) {
	    System.out.println("IOOBE caught");
	}
	catch (Exception e) {
	    System.out.println("E caught");	    
	}
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
