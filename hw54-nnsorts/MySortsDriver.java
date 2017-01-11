import java.util.ArrayList;

public class MySortsDriver
{
    public static void main( String [] args )
    {
	  ArrayList crookshanks = MySorts.populate( 10, 1, 1000 );

	  System.out.print("\n\nTesting ");
	  System.out.print("BubbleSort");
	  System.out.print(" ...\n");
	  System.out.println( "before sorting:\n" + crookshanks );
	  MySorts.bubbleSort(crookshanks);
	  System.out.println( "after sorting:\n" + crookshanks );

	  System.out.print("\n\nTesting ");
	  System.out.print("BubbleSort");
	  System.out.print(" ...\n");
	  System.out.println( "before sorting:\n" + crookshanks );
	  MySorts.selectionSort(crookshanks);
	  System.out.println( "after sorting:\n" + crookshanks );

	  System.out.print("\n\nTesting ");
	  System.out.print("BubbleSort");
	  System.out.print(" ...\n");
	  System.out.println( "before sorting:\n" + crookshanks );
	  MySorts.insertionSort(crookshanks);
	  System.out.println( "after sorting:\n" + crookshanks );
	/*===============for VOID methods=============
	  ============================================*/
    }//end main

}//end class
