
public class Card 
{
	private int value; //A variable for the value of the card
	private int suit; //A variable for the suit of the card

	public Card(int newValue, int newSuit)
	{
		value = newValue;
		suit = newSuit;
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
