//Adeebur Rahman
//APCS2 pd1
//HW14 -- So So Fast
//2017-03-07

/***
 * class FastSelect
 * includes method to obtain yth smallest integer in an array
 * ALGORITHM
 * 1. Starting with the last index as the pvtPos, call partition method on input array.
 * 2. If index returned is equal to k-1, return value at the index.
 * 3. If index is larger than k-1, return fastSelect but now with bounds [oldLeft,pivot).
 * 4. If index is smaller, return fastSelect but now with bounds [pivot+1,oldRight].
 */

public class FastSelect {
   
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
        int tmp = o[x];
        o[x] = o[y];
        o[y] = tmp;
    }

    //print input array
    public static void printArr( int[] a ) {
        for ( int o : a )
            System.out.print( o + " " );
        System.out.println();
    }
    //--------------^  HELPER METHODS  ^--------------
    
    /******************************************************
     * int partition(int[] arr,int left,int right,int pvtPos)
     * Precond:  Input array isn't empty,
     * integer inputs within bounds of input array
     * Postcond: Input array modified such that
     * values smaller then number at pvtPos are to the left of pvtPos,
     * and values larger are to the right of pvtPos,
     * index at pvtPos is now at its final resting place.
     * new index of pvtPos returned
     ******************************************************/
    public static int partition (int[] arr, int left, int right, int pvtPos) {
	int pvtVal = arr[pvtPos];
	swap(pvtPos, right, arr);
	int storVal = left;
		
	for (int i = left; i < right; i++) {
	    if (arr[i] <= pvtVal) {
		swap(i, storVal, arr);
		storVal++;
	    }
	}
	swap(storVal, right, arr);
		
	return storVal;
    }//end partition()

    /******************************************************
     * int fastSelect(int[] arr,int y)
     * main fastSelect function
     * Precond:  Input array isn't empty,
     * integer input is within bounds of input array.
     * Postcond: Input array modified from partition,
     * yth smallest int returned.
     ******************************************************/
    public static int fastSelect(int[] arr, int y) {
	return fastSelect(arr, 0, arr.length - 1, y);
    }//end fastSelect()

    /******************************************************
     * int fastSelect(int[] arr,int left,int right,int y)
     * helper method for fastSelect(int[], int)
     * Precond: Input array isn't empty,
     * integer inputs within bounds of input array,
     * and left isn't greater than right.
     * Postcond: Input array modified from partiton
     * yth smallest int in [left, right] returned.
     ******************************************************/    
    public static int fastSelect(int[] arr, int left, int right, int y) {
	int pivot = partition(arr,left,right,left+((right-left)/2));
	//pivot = final resting place of yth lowest num. Return value at index pivot
	if (pivot == y - 1) { return arr[pivot]; }
	//pivot > final resting place. Restrict next call from left to pivot-1
	else if (pivot > y - 1) { return fastSelect(arr,left,pivot-1,y); }
	//pivot < final resting place. Restrict next call from pivot+1 to right 
	else { return fastSelect(arr,pivot+1,right,y); }
    }//end fastSelect() (helper)

    //main method for testing    
    public static void main(String args[]) {

	//init test arrays
	int[] p1 = {8,21,17,69,343};
	int[] p3 = {1,28,33,4982,37};
	int[] p4 = {5,4,17,9000,6};
	int[] p5 = {3,0,16,599,1024};
	int[][] arrs = {p1,p3,p4,p5};
	
	// run fastSelect on each array, varying y
	for (int i = 0; i < arrs.length; i++) {
	    System.out.print("Input Array: ");
	    printArr(arrs[i]);
	    for (int j = 1; j <= arrs[i].length; j++) {
		System.out.print("y: ");
		System.out.print(j);
		System.out.print(" yth term: ");
		System.out.println(fastSelect(arrs[i],j));
	    }
	    System.out.println("\n================================\n");
	}
	
    }//end main()
    
}//end class FastSelect
