import java.util.*;

public class MinHeap 
{ 
	// array to hold data values for the minheap, level by level
	// do not use index 0 of the array
	// heap is stored in positions 1 to numElements in the array
	private int[] data;
	private int numElements;

	public MinHeap() 
	{ 
		data = new int[1001];	// Heap can hold up to 1000 ints
		numElements = 0;
	}
	
	/**
	 * Inserts the item into the minheap if there is room.
	 * Otherwise the heap does not change.
	 * @param item Element to be inserted into the minheap.
	 */
	public void insert(int item) 
	{ 
		if (numElements == 1000)
			return;
		// COMPLETE insert METHOD BELOW. YOU MAY USE 
		// ADDITIONAL HELPER METHOD(S) AS NECESSARY.
		
		//Create a variable to store the index of our new element - increase numElements
		int index = ++numElements;
		
		//Add the new element to the array
		data[index] = item;
		
		//While it is smaller than its parent and it is not the root, swap it with the parent
		while (index > 1 && data[index] < data[index / 2])
		{
			swap(index);
			index /= 2;
		}
	}
	
	//A helper function for swapping an element with its parent
	private void swap(int index)
	{
		int temp = data[index];
		data[index] = data[index / 2];
		data[index / 2] = temp;
	}
	
	public int remove() 
	{ 
		if (numElements == 0)
			throw new NoSuchElementException();
		// COMPLETE remove METHOD BELOW. YOU MAY USE 
		// ADDITIONAL HELPER METHOD(S) AS NECESSARY.
		
		//Save the root element at a variable
		int minimum = data[1];
		
		//Copy the last element at the root, delete it from last place and decrease the number of elements
		data[1] = data[numElements];
		data[numElements] = 0;
		numElements--;
		
		//Create two variables for comparing an element with its children
		int newIndex = 0, index = 1;
		
		//While the root's children are smaller than it, swap it with its smallest child
		while (index * 2 <= numElements && (data[index] > data[index * 2] || (data[index] > data[index * 2 + 1] && data[index * 2 + 1] != 0)))
		{
			//Find out which child is smaller
			if (data[index * 2] > data[index * 2 + 1] && data[index * 2 + 1] > 0)
			{
				newIndex = index * 2 + 1;
			}
			
			else
			{
				newIndex = index * 2;
			}
			
			//Swap them and assign the element its child's index
			swap(newIndex);
			index = newIndex;
		}

		//Return the root element
		return minimum;	// STUB: REMOVE THIS LINE WHEN YOU COMPLETE THIS METHOD
	} 

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= numElements; i++) 
			sb.append(data[i] + " ");
		sb.append(" (numElements = " + numElements + ")");
		return sb.toString();
	}		

}
