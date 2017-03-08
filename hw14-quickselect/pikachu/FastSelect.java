// Jake Zaia
// APCS2 pd1
// HW #14: So So Fast
// 2017-03-06


public class FastSelect{

    // Prints the array
    public static void printArray(int [] arr){
	String toPrint = " {";
	for (int i: arr)
	    toPrint += i + ", ";
	System.out.print(toPrint.substring(0, toPrint.length()-2) + "}");
    }

    // Swaps 2 items within arr
    public static void swap(int [] arr, int x, int y){
	int z = arr[x];
	arr[x] = arr[y];
	arr[y] = z;
    }

    //Formerly mysterion:
    public static int partition(int [] arr, int lb, int ub, int pivot){
	// lb = lower bound, ub = upper bound
	int v = arr[pivot];
	swap(arr, ub, pivot);
	int s = lb;
	for (int i = lb; i < ub; i++){
	    if (arr[i] < v) {
		swap(arr, s, i);
		s++;
	    }
	}
	swap(arr, ub, s);
	//printArray(arr);
	//System.out.println(" Returns: "+ s +"\n"); //prints final value of s
	return s;
    }

    // Shuffles elements within the array randomly
    public static void shuffle(int [] arr){
	int p, q;
	int al = arr.length;
	for (int i = 0; i < al; i++){
	    p = (int) Math.random() * al;
	    q = (int) Math.random() * al;
	    swap(arr, p, q);
	}
    }

    // Finds yth element of an array by using the partition is search
    public static int findElement(int [] arr, int y){
	int lb = 0;
	int ub = arr.length -1;
	int pivot = arr.length/2;
	int comp = -1; // Compared value
	while (comp != y){
	    comp = partition(arr, lb, ub, pivot);
	    if (comp > y){
		ub = comp;
		pivot = comp - 1;
	    }
	    else{
		lb = comp;
		pivot = comp + 1;
	    }
	}
	return arr[comp];
    }

    public static void main(String [] args){
	
	/*int [] test = {5, 4, 3, 2, 1};
	
	for (int i = 0; i < test.length; i++){
	    System.out.println(findElement(test, i));
	}*/
	
	int [] test2 = new int[100];
	for (int i = 0; i < test2.length; i++){
	    test2[i] = i;
	}
	shuffle(test2);
	
	for (int i = 0; i < test2.length; i++){
	    //Prints 0-99 as expected
	    //System.out.println(findElement(test2, i));
	}
    }
}
