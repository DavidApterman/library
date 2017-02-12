/*==================================================
  interface List
  Declares methods that will be implemented by any 
  class wishing to adhere to this specification.
  This interface specifies behaviors of a list of Objects.
  ==================================================*/

public interface List {

    // Return number of meaningful elements in the list
    int size();

    // Append element to the end. Return true.
    boolean add( Object num ); 

    // Insert element at index
    void add( int index, Object obj ); 

    // Retrieve element at index
    Object get( int index );

    // Overwrite element at index
    Object set( int index, Object obj );

    // Remove element at index,
    // shifting any elements after it to the left.
    // Return removed value.
    Object remove( int index );

}//end interface List
