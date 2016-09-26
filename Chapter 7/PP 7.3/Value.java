
public class Value 
{
	private int lowerBound, higherBound, count;
	
	public Value(int newLowerBound, int newHigherBound) //Constructor
	{
		lowerBound = newLowerBound;
		higherBound = newHigherBound;
		count = 0; //Counter always starts from '0'
	}
	
	public void setLowerBound(int newLowerBound)
	{
		lowerBound = newLowerBound;
	}
	
	public void setHigherBound(int newHigherBound)
	{
		higherBound = newHigherBound;
	}
	
	public void increaseCount() //A function for increasing the counter
	{
		count++;
	}
	
	public int getLowerBound()
	{
		return lowerBound;
	}
	
	public int getHigherBound()
	{
		return higherBound;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public String toString()
	{
		String result;
		if (lowerBound == 1) //If it is the first object of the array -> 3 digits
		{
			result = "|   " + lowerBound + " - " + higherBound + "  |  ";
		}
		else if (higherBound == 100) //If it is the last object of the array -> 5 digits
		{
			result = "|  " + lowerBound + " - " + higherBound + " |  ";
		}
		else //Standard -> 4 digits
		{
			result = "|  " + lowerBound + " - " + higherBound + "  |  ";
		}
		
		for (int i = 0; i < count; i++) //Adding a '*' for each number in the range
		{
			result += "*";
		}
		
		return result;
	}
}