@SuppressWarnings("unchecked")

public class OrderedArrayList<T extends Comparable<T>> {
	
	// An ordered array consists of a collection of objects 
	// of some type T that is comparable to itself
	// (i.e. has a compareTo method to compare objects of type T)

	private T[] dataArray;
	private int numData;

	/**
	 * Creates an empty ordered array list of comparable entries of the same type
	 */
	public OrderedArrayList() {
		dataArray =  (T[]) new Comparable[1];
		numData = 0;
	}

	/**
	 * Adds the new entry into this ordered array list. If the entry is not in the
	 * list, the entry is added so that the list remains ordered in increasing order
	 * and returns true. If the entry is already in the list, the list is not changed
	 * and false is returned.
	 * @param newEntry The new data item to be inserted into this ordered array list.
	 * @return true if the array list is changed, false if not
	 */
	public boolean add(T newEntry) 
	{
		int index = 0; //The index where our new element should be put
		
		boolean alreadyIn = false; //A variable that shows if the element is already in the list
		boolean foundPlace = false; //A variable that shows if we have found a place for the new element
		
		//This loop stops when the index gets too big or the element is found in the array, or it has found its place
		//This loop works only on a not-empty array
		while (index < numData && !alreadyIn && numData > 0 && !foundPlace)
		{
			//If the new date is sooner than the one in the array, the index increases
			if (newEntry.compareTo(dataArray[index]) > 0)
			{
				index++;
			}
			
			//If it is before that date, the index should not be changed
			else if (newEntry.compareTo(dataArray[index]) < 0)
			{
				foundPlace = true;
			}
					
			//If it equals a date in the array, is must not be put in, 'alreadyIn' variable changes its value
			else
			{
				alreadyIn = true;
			}
		}
		
		//If the array does not contain the new date
		if (!alreadyIn)
		{
			//If the array does not have any free cells
			if (numData == dataArray.length)
			{
				reallocate();
			}
			
			//Shift all the elements after the index with 1 position to the end
			for (int i = numData; i > index; i--)
			{
				dataArray[i] = dataArray[i - 1];
			}
		
			//Put the new date to its suitable place and increase the number of dates
			dataArray[index] = newEntry;
			numData++;
		}
		
		//Returns the opposite value of 'alreadyIn'. It means if the date was not already in and was just put, the
		//method returns true
		return !alreadyIn;
	}

	public String toString() {
		String result = "";
		result += "numData = " + numData + ", dataArray.length = " + dataArray.length + "\n";
		for (int i = 0; i < numData; i++)
			result += "dataArray[" + i + "] = " + dataArray[i] + "\n";
		return result;
	}
	
	private void reallocate() {
		T[] newArray = (T[]) new Comparable[dataArray.length*2];
		System.arraycopy(dataArray, 0, newArray, 0, dataArray.length);
		dataArray = newArray;
	}

	
}
