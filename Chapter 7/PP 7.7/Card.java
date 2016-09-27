import java.util.Random;

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
	
	private String readCard(int value, int suit) //Reading a card by its value and suit indexes
	{
		String result = "";

		switch(value)
		{
		case 1:
			result = "A ";
			break;
		case 2:
			result = "2 ";
			break;
		case 3:
			result = "3 ";
			break;
		case 4:
			result = "4 ";
			break;
		case 5:
			result = "5 ";
			break;
		case 6:
			result = "6 ";
			break;
		case 7:
			result = "7 ";
			break;
		case 8:
			result = "8 ";
			break;
		case 9:
			result = "9 ";
			break;
		case 10:
			result = "10";
			break;
		case 11:
			result = "J ";
			break;
		case 12:
			result = "Q ";
			break;
		case 13:
			result = "K ";
			break;
		}
		
		switch(suit)
		{
		case 1:
			result += " Heart";
			break;
		case 2:
			result += " Diamond";
			break;
		case 3:
			result += " Club";
			break;
		case 4:
			result += " Spade";
			break;
		}
		
		return result;
	}
	
	public String toString() //Printing a card
	{
		return (readCard(value, suit) + "\n");
	}
	
	public String getRandomCard() //Dealing a random card
	{
		Random generator = new Random();

		return readCard(generator.nextInt(13) + 1, generator.nextInt(4) + 1);
	}
}