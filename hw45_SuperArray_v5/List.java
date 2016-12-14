/*==================================================
  interface List
  Specifies capabilities of a List.
  Allows for generic typing.
  ==================================================*/

public interface List<T>
{

    // Return number of meaningful elements in the list
    int size();

    // Append element to the end. Return true.
    boolean add( T obj ); 

    // Insert element at index
    void add( int index, T obj ); 

    // Retrieve element at index
    T get( int index );

    // Overwrite element at index
    T set( int index, T obj );

    // Remove element at index,
    // shifting any elements after it to the left.
    // Return removed value.
    T remove( int index );

}//end interface List
