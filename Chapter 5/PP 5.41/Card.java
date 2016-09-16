
public class Card 
{
	private int value;
	private int suit;

	public Card(int newValue, int newSuit)
	{
		value = newValue; //A variable for the value of the card
		suit = newSuit; //A variable for the suit of the card
	}
	
	//setters and getters of class Card
	public void setValue(int newValue)
	{
		value = newValue;
	}
	
	public void setSuit(int newSuit)
	{
		suit = newSuit;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public int getSuit()
	{
		return suit;
	}
}
