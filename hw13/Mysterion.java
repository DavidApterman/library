/*****************************************************
 * class Mysterion
 *
 *
 *
 *
 *****************************************************/

public class Mysterion 
{
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

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------



    public static int mysterion( int arr[], int a, int b, int c)
    {
	int v = arr[c];

	swap( c, b, arr);
	int s = a;

	for( int i = a; i < b; i++ ) {
	    if ( arr[i] <= v) {
		swap( i, s, arr );
		s++;}
	}
	swap(s,b,arr);

	return s;
    }//end mysterion


    //main method for testing
    public static void main( String[] args )
    {
	//init test arrays of magic numbers
	int[] p1 = {8,21,17,69,343};
	int[] p3 = {1,28,33,4982,37};
	int[] p4 = {5,4,17,9000,6};
	int[] p5 = {3,0,16,599,1024};

	// run mysterion on each array,
	// holding a & b fixed, varying c...
	for( int testC = 0; testC < 5; testC++ ) {
	    System.out.println("p1's magic nums:");
	    printArr(p1);
	    mysterion(p1,0,4,testC);
	    System.out.println("after mysterion w/ a=0,b=4,c=" 
			       + testC +"...");
	    printArr(p1);
	    System.out.println("-----------------------");

	    System.out.println("p3's magic nums:");
	    printArr(p3);
	    mysterion(p3,0,4,testC);
	    System.out.println("after mysterion w/ a=0,b=4,c=" 
			       + testC +"...");
	    printArr(p3);
	    System.out.println("-----------------------");

	    System.out.println("p4's magic nums:");
	    printArr(p4);
	    mysterion(p4,0,4,testC);
	    System.out.println("after mysterion w/ a=0,b=4,c=" 
			       + testC +"...");
	    printArr(p4);
	    System.out.println("-----------------------");

	    System.out.println("p5's magic nums:");
	    printArr(p5);
	    mysterion(p5,0,4,testC);
	    System.out.println("after mysterion w/ a=0,b=4,c=" 
			       + testC +"...");
	    printArr(p5);
	    System.out.println("-----------------------");
	}
    }//end main

}//end class Mysterion
