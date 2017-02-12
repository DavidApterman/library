/**************************************************
  class SuperArray version 5.0
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

public class SuperArray<T> implements List<T>
{
    private T[] _data;  //underlying container structure
    private int _lastPos; //marker for last meaningful element         
    private int _size;    //number of meaingful elements

    //default constructor
    //initializes 10-item array         
    public SuperArray()
    {
        _data = (T[])new Object[10]; //hack: typecast to get around compiler
        _lastPos = -1;
        _size = 0;
    }


    //output elements in [a,b,c] format
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
        T[] temp = (T[])new Object[_data.length * 2];
        for( int i = 0; i < _data.length; i++ )
            temp[i] = _data[i];
        _data = temp;
    }


    //accessor method -- return element at specified index
    public T get( int index )
    {
	if ( index < 0 || index >= size() ) {
	    throw new IndexOutOfBoundsException("U B ILLIN (get)");
	}
        return _data[index];
    }


    //mutator method -- set index to newVal, return old element at index
    public T set( int index, T newVal )
    {
	if ( index < 0 || index >= size() ) {
	    throw new IndexOutOfBoundsException("U B ILLIN (set)");	
	}
        T temp = _data[index];
        _data[index] = newVal;
        return temp;
    }


    //add an item after the last item
    //return true
    public boolean add( T newVal )
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
    public void add( int index, T newVal )
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
    //return removed element
    public T remove( int index )
    {
	if ( index < 0 || index >= size() ) {
	    throw new IndexOutOfBoundsException("U B ILLIN (rem)");	
	}
	T retVal = _data[index]; //store to return later
        for( int i=index; i < _size-1; i++ ) {
            _data[i] = _data[i+1];
        }
        _data[_size-1] = null; //unnecessary    
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

	
	//********************************************
	//again, this time with generic typing
	//********************************************
	SuperArray<String> lee = new SuperArray<String>();
	System.out.println("Printing empty SuperArray lee...");
	System.out.println(lee);

	lee.add("never");
	lee.add("been");
	lee.add("a");
	lee.add("dude");
	lee.add("like");

	System.out.println("Printing populated SuperArray lee...");
	System.out.println(lee);

	lee.remove(3);
	System.out.println("Printing SuperArray lee post-remove(3)...");
	System.out.println(lee);
	lee.remove(3);
	System.out.println("Printing SuperArray lee post-remove(3)...");
	System.out.println(lee);

	try { //this should fail bc no highest index is now 2...
	    lee.add(3,"this");
	}
	catch (IndexOutOfBoundsException ioobe) {
	    System.out.println("IOOBE caught");
	}
	catch (Exception e) {
	    System.out.println("E caught");	    
	}
	System.out.println("Printing SuperArray lee post-insert...");
	System.out.println(lee);
	lee.add(2,"this");
	System.out.println("Printing SuperArray lee post-insert...");
	System.out.println(lee);
	lee.add(1,"ever");
	System.out.println("Printing SuperArray lee post-insert...");
	System.out.println(lee);
	
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
