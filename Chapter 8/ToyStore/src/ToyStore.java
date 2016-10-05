public class ToyStore
{

	// fields for the toy store
	// NOTE: YOU CANNOT ADD ADDITIONAL FIELDS FOR THIS CLASS
	private ToyBin[] binArray;
	private int numBins;
	private int maxBins;

	public ToyStore()
	{
		maxBins = 7;
		binArray = new ToyBin[maxBins];
		numBins = 0;
	}

	public void createBin(String toyName, int toyQuantity)
	{
		// This method creates a new bin for the store
		// (if possible) and fills the bin with the 
		// given number of toys based on the parameters
		// Assumption: The specified toy is not already
		// in another bin. (How would you check for this?)
	
		if (numBins < maxBins)
		{
			// Create a bin for this toy
			binArray[numBins] = new ToyBin(toyName);

			// Add one toy at a time to the bin
			for (int i = 1; i <= toyQuantity; i++)
			{
				binArray[numBins].addOneToy();
			}

			System.out.println("Created a bin: " 
				+ binArray[numBins].toString());

			// The store now has one more bin
			numBins++;
		}
		else
		{
			System.out.println("NO BINS AVAILABLE");
		}
	}
		

	public int countToys() 
	{
		// returns the total number of toys in the
		// toy store

		int count = 0; //Storing the number of all toys in a variable 'count'
		
		for (int i = 0; i < numBins; i++)
		{
			count += binArray[i].getToyQuantity(); //Getting the sum of all bins' toys
		}
		
		return count;
	}

	public void returnToy(String name)
	{
		// Customer returns one toy to the toy store
		// with the name given in the parameter
		
		//Using private helper method for localising the index of the bin that the returned  toy should be put in
		if (localise(name) != -1)
		{
			binArray[localise(name)].addOneToy();
		}
		
		else //If there is not any bin with the same toys as the one that is returned, we should one
		{
			if (numBins < maxBins) //If there is an empty slot for a new bin
			{
				binArray[numBins] = new ToyBin(name); //Creating the new bin
				binArray[numBins].addOneToy(); //Adding a toy to the bin
				numBins++; //Increasing the number of all bins with 1
			}
			
			else //If there are too many bins and there is no any space for a new one
			{
				System.out.println("NO BINS AVAILABLE");
			}
		}
	}

	public void buyToy(String name)
	{
		// Customer buys one toy with the name given in the
		// parameter from the toy store

		//Using private helper method again to find the index of the suitable bin
		int index = localise(name);
		if (index != -1) //If there is a bin with the same toy the one, we want to buy
		{
			binArray[index].removeOneToy(); //Removing one toy from the bin and decreasing the quantity with 1
			
			if (binArray[index].getToyQuantity() == 0) //If the bin becomes empty
			{
				for (int i = index; i < numBins; i++)
				{
					binArray[i] = binArray[i + 1]; //Moving all the bins back with 1 place to fill the empty slot
				}
				
				numBins--; //Decreasing the number of bins with 1
			}
		}
		
		else //If there is no bin containing the same toy, we want to buy
		{
			System.out.println("NOT IN STOCK");
		}
	}
	
	private int localise(String name) //Helping method for 'returnToy' and 'buyToy' methods
	{
		int index = -1; //Setting 'index' to -1 initially
		for (int i = 0; i < numBins && index == -1; i++)
		{
			if (binArray[i].getToyName().equals(name)) //If there is a bin with the name we are searching for
			{
				index = i; //'index' is no more -1
			}
		}
		
		return index;
	}
	
	public String toString()
	{
		String result = "numBins = " + numBins + "\n";
		for (int i = 0; i < numBins; i++) //Printing all the slots 1 by 1
		{
			result += "binArray[" + i + "] = " + binArray[i].toString() + "\n";
		}
		
		return result;
	}

}
