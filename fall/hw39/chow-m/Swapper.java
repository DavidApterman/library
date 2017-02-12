/*
Melanie Chow
APCS pd4
HW39 -- Put it together
2016-12-03
*/

/*
SUMMARY: User inputs the dimensions of the array. Unique codes are generated using random letters, numbers, and special characters.
User then inputs the row # and column # of the first point they want to switch. Then asked again for the second.
If any of the #'s are out of range, a random valid # is inputted and the user is notified of the change. Finally, the points swap. 

MORE DETAILED SUMMARY:
When run...
1. You are prompty asked how many rows and how many columns you want your array to be. This was done using Keyboard.readInt().
2. After dimensions are specified, array is printed out with unique 4 character strings. 

Unique codes randomly generated with this order:  1. number 2.uppercase letter 3. special symbol 4. lowercase letter
(this was done by using Math.random() and creating arrays with letter and special characters)

3. Then you are asked the first point you want to switch. Inputting row and column one at a time. 
4. Then you are asked to input the second point. (Parallel to first point input)

If any of your row or column #'s are outside the range, a random valid # is substituted and printed for the user to see

5. Finally, your arraY is switched using the swap method, which stores the Strings at the two points in temporary variables, then sets the new values 
*/

import cs1.Keyboard;

public class Swapper{

    //-------GENERATE UNIQUE 4 CHAR STRING------------------------

    public static final String[] ALPHABET={
	"A","B","C","D","E","F","G","H","I","J","K","L","M",
	"N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
    };
    
    public static final String[] SPECIAL={
	"@","!","#","$","%","^","&","*","+","-","~"
    };

    public static String unique(){
	String a=""+(int)(Math.random()*10);
	String b=ALPHABET[(int)(Math.random()*26)];
	String c=SPECIAL[(int)(Math.random()*SPECIAL.length)];
	return a+b+c;
    }

    //----------------------------------------------------------

    public static String printarray( String[][] a ){
	String retStr = "";
        for(String[] i : a){
	    retStr +="{";
	    for(String x : i){
		retStr += x + ",";
	    }
	    retStr = retStr.substring(0,retStr.length()-1);
	    retStr +="}\n";
	}
	return retStr;
    }

    public static void populate(String[][] a){
	for (int i=0; i<a.length; i++){
	    for (int j=0; j<a[i].length; j++){
		a[i][j]=unique()+j;
	    }
	}
    }
    
    public static void swap(String[][] a, int x1, int y1, int x2, int y2){
	String swap1=a[x1][y1];
	String swap2=a[x2][y2];
	a[x1][y1]=swap2;
	a[x2][y2]=swap1;
    }

    public static void main(String[] args){
	//ARRAY SETUP
	String x="Hello! Let's make your array. \n";
	x+="# of rows:";
	System.out.print(x);
	int rows=Keyboard.readInt();
	System.out.print("# of columns:");
	int columns=Keyboard.readInt();
	String [][]a=new String[rows][columns];
	System.out.println("\nThis is your randomly generated array!:");
	populate(a); //test populate
	System.out.println(printarray(a));

	//WHAT ARE WE SWAPPING?

	//---point 1----
	String y="\nNow it's time to switch! Pick a point to swap. \n";
	y+="Point at row #...";
	System.out.print(y);
	int x1=Keyboard.readInt();	
	if (x1>rows-1){
	    x1=(int)(Math.random()*rows);
	    System.out.println("Invalid row #: Random row #"+x1+" inputed ");
	}

	System.out.print("Point at column #...");
	int y1=Keyboard.readInt();	
	if (y1>columns-1){
	    y1=(int)(Math.random()*columns);
	    System.out.println("Invalid column #: Random column #"+y1+" inputed ");
	}

	//--point 2----
	String z="\nSwap ("+x1+","+y1+") with... \n";
	z+="Point at row #...";
	System.out.print(z);	
	int x2=Keyboard.readInt();
	if (x2>rows-1){
	    x2=(int)(Math.random()*rows);
	    System.out.println("Invalid row #: Random row #"+x2+" inputed ");
	}

	System.out.print("Point at column #...");
	int y2=Keyboard.readInt();
	if (y2>columns-1){
	    y2=(int)(Math.random()*columns);
	    System.out.println("Invalid column #: Random column #"+y2+" inputed ");
	}

	//SWAP IT OUT

	System.out.println("\nSWAPPING ("+x1+","+y1+") WITH ("+x2+","+y2+")...");

	swap(a,x1,y1,x2,y2); 
	System.out.println(printarray(a));

	/* ------testing------------
	String [][]a=new String[3][3];
	System.out.println(printarray(a));
	populate(a); //test populate
	System.out.println(printarray(a));
	swap(a,0,0,0,2); //test swap
	System.out.println(printarray(a));

	---test unique String generator---
	System.out.println(unique());
	System.out.println(unique());
	System.out.println(unique());
	*/
    }
}	
	
