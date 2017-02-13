/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 
  1. If dataset size == 1, return (1-element list is sorted)
  2. Else split dataset in half and recurse on each half
     When each of those halves is returned sorted, merge them. 
     (Continually append min val from front of each.)
  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) {

	int[] retArr = new int[ a.length + b.length ];

	//init position markers for each input array
	int aPos = 0;
	int bPos = 0;

	int pos = 0; //position marker for return array

	while( aPos < a.length && bPos < b.length ) {
	    if ( a[aPos] < b[bPos] ) {
		retArr[pos] = a[aPos];
		aPos++;
	    }
	    else {
		retArr[pos] = b[bPos];
		bPos++;
	    }
	    pos++;
	}
	//at least one input array has been exhausted
	if ( bPos >= b.length )
	    for( ; pos < retArr.length; pos++ ) {
		retArr[pos] = a[aPos]; 
		aPos++;
	    }
	else
	    for( ; pos < retArr.length; pos++ ) {
		retArr[pos] = b[bPos]; 
		bPos++;
	    }

	return retArr;
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) {

	//if dataset is 1 element, then dataset is sorted
	if ( arr.length <= 1 ) 
	    return arr;

	//else, halve dataset and recurse on each half
	int leftLen = arr.length / 2;
	int[] leftHalf = new int[ leftLen ];
	int[] rightHalf = new int[ arr.length - leftLen ];

	for( int i=0; i<arr.length; i++ ) {
	    if ( i < leftLen )
		leftHalf[i] = arr[i];
	    else
		rightHalf[ i-leftLen ] = arr[i];
	}

	return merge( sort(leftHalf), sort(rightHalf) );
    }



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {


	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
    }

}//end class MergeSort