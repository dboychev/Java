@SuppressWarnings("unchecked")

public class QuickSortTester {

	public static <T extends Comparable<T>> void sort(T[] table)
	{
		// Sort the table of data using Quick Sort from index 0 to index table.length-1
		// (i.e. sort the entire table)

		quicksort(table, 0, table.length - 1);
	}

	private static <T extends Comparable<T>> void quicksort(T[] table, int first, int last) 
	{

		// Sort the table using quicksort from index first to index last
		// Precondition: first <= last

		// Base case: If the given section of the table has 1 element, 
		// then it is sorted already, so just return

		if (first < last) 
		{
			// Partition the table so that the table contains all elements less than the pivot,
			// followed by the pivot, followed by all elements greater than the pivot.
			// Return the final position of the pivot after partioning.
			int pivotIndex = partition(table, first, last);

			// Sort the elements less than the pivot
			quicksort(table, first, pivotIndex - 1);

			// Sort the elements greater than the pivot
			quicksort(table, pivotIndex + 1, last);
		}
	}

	private static <T extends Comparable<T>> int partition(T[] table, int first, int last) 
	{
		// COMPLETE THIS METHOD BASED ON THE COMMENTS MARKED WITH ***

		// Select the first element in the table as the pivot
		T pivot = table[first];

		int i = first + 1;	// index of next element to consider from the left side of table
		int j = last;		// index of next element to consider from the right side of table

		do 
		{
			// Search for next element from left that is greater than the pivot ***
			while (i < table.length && pivot.compareTo(table[i]) >= 0)
			{
				i++;
			}

			// Search for next element from the right that is less than or equal to the pivot ***
			while (j >= 0 && pivot.compareTo(table[j]) < 0)
			{
				j--;
			}

			// Swap these values as long as our two searches don't pass each other ***
			if (i < j)
			{
				T temp = table[i];
				table[i] = table[j];
				table[j] = temp;
			}
		} while (i < j);  // Repeat until our two searches pass each other

		// Now the table consists of:
		// the pivot
		// followed by the first partition containing elements <= pivot (not necessarily sorted)
		// followed by the second partition containing elements > pivot (not necessarily sorted)
		// Swap the pivot with the final value in the first partition ***
		
		T temp = table[first];
		table[first] = table[j];
		table[j] = temp;

		// Return the final position of the pivot  ***
		return j;
	}

	private static <T extends Comparable<T>> void swap(T[] table, int i, int j) 
	{
		// Swaps table[i] with table[j]
		T temp = table[i];
		table[i] = table[j];
		table[j] = temp;
	}

	public static void main(String[] args) 
	{

		// Create a random table of 20 integers with values between 10 and 99
		Integer[] table = new Integer[20];
		for (int i = 0; i < 20; i++)
			table[i] = (int)(Math.random() * 90) + 10;

		// Output original table
		System.out.println("ORIGINAL TABLE:");
		for (Integer i : table)
			System.out.print(i + " ");
		System.out.println();

		// Sort the table
		sort(table);

		// Output sorted table
		System.out.println("SORTED TABLE:");
		for (Integer i : table)
			System.out.print(i + " ");
		System.out.println();

	}
}
