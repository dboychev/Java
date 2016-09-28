
public class MonetaryCoin extends Coin
{
	private double value; //Value of the coin
	
	public MonetaryCoin(double newValue) //Constructor
	{
		value = newValue;
	}
	
	public double getValue()
	{
		return value;
	}
	
	public String toString() //Printing the coin face and value
	{
		String result;

		if (this.isHeads())
		{
			result = "Heads";
		}
		else
		{
			result = "Tails";
		}
		
		result += " - " + value;

		return result;
	}
}
