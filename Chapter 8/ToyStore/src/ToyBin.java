public class ToyBin
{

	// A class that simulates a bin of one type of toy.

	// fields for a toy bin
	// NOTE: YOU CANNOT ADD ADDITIONAL FIELDS FOR THIS CLASS
	private String toyName;
	private int toyQuantity;

	public ToyBin(String name)
	{
		// Creates an empty toy bin for the given toy name

		toyName = name;
		toyQuantity = 0;
	}

	public String getToyName()
	{
		return toyName;
	}

	public int getToyQuantity()
	{
		return toyQuantity;
	}

	public void addOneToy()
	{
		toyQuantity++;
	}

	public void removeOneToy()
	{
		if (toyQuantity > 0)
			toyQuantity--;
	}

	//Printing the Bin
	public String toString()
	{
		return toyName + " / " + "Quantity: " + toyQuantity;
	}
}
