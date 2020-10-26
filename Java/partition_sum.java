import java.io.*; 
import java.util.*; 

public class partition_sum { 

	// Declare Lists to store both 
	// the sets. 
	static List<Integer> set1 = new ArrayList<Integer>(); 
	static List<Integer> set2 = new ArrayList<Integer>(); 
	/// Function to print the equal sum sets 
	// of the array. 
	static void printSets() 
	{ 
		int i; 

		/// Print set 1. 
		for (i = 0; i < set1.size(); i++) { 
			System.out.print(set1.get(i) + " "); 
		} 

		System.out.println(); 

		/// Print set 2. 
		for (i = 0; i < set2.size(); i++) { 
			System.out.println(set2.get(i) + " "); 
		} 
	} 

	// Utility function to find the sets 
	// of the array which have equal sum. 
	static boolean findSets(Integer[] arr, int n, 
							int sum1, int sum2, 
							int pos) 
	{ 

		// If entire array is traversed, 
		// compare both the sums. 
		if (pos == n) { 

			// If sums are equal print 
			// both sets and return true 
			// to show sets are found. 
			if (sum1 == sum2) { 
				printSets(); 
				return true; 
			} 

			// If sums are not equal 
			// then return sets are not 
			// found. 
			else
				return false; 
		} 

		// Add current element to set 1. 
		set1.add(arr[pos]); 

		// Recursive call after adding 
		// current element to set 1. 
		boolean res = findSets(arr, n, sum1 + arr[pos], 
							sum2, pos + 1); 

		// If this inclusion results in 
		// equal sum sets partition then 
		// return true to show desired 
		// sets are found. 
		if (res == true) 
			return res; 

		// If not then backtrack by removing 
		// current element from set1 and 
		// include it in set 2. 
		set1.remove(set1.size() - 1); 
		set2.add(arr[pos]); 

		// Recursive call after including 
		// current element to set 2. 
		res = findSets(arr, n, sum1, sum2 
										+ arr[pos], 
					pos + 1); 

		if (res == false) 
			if (set2.size() > 0) 
				set2.remove(set2.size() - 1); 

		return res; 
	} 

	// Return true if array arr can be 
	// partitioned into two equal sum 
	// sets or not. 
	static boolean isPartitionPoss(Integer[] arr, int n) 
	{ 
		// Calculate sum of elements in 
		// array. 
		int sum = 0; 

		for (int i = 0; i < n; i++) 
			sum += arr[i]; 

		// If sum is odd then array cannot 
		// be partitioned. 
		if (sum % 2 != 0) 
			return false; 

		/// Find both the sets. 
		return findSets(arr, n, 0, 0, 0); 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
		Integer[] arr = { 545, 655, 451, 671, 454, 765, 869, 4410 }; 
		int n = arr.length; 
		if (isPartitionPoss(arr, n) == false) { 
			System.out.print("-1"); 
		} 
	} 
} 
