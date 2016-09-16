import java.util.Random;

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
	
	public String getRandomCard()
	{
		Random generator = new Random();
		String name = new String(""); //Creating a string that will display the exact value and suit of the card
		
		//The value gets a random number, depending on which the string gets the symbol for the exact value
		switch(generator.nextInt(13) + 1) 
		{
		case 1:
			name = name.concat("A");
			break;
		case 2:
			name = name.concat("2");
			break;
		case 3:
			name = name.concat("3");
			break;
		case 4:
			name = name.concat("4");
			break;
		case 5:
			name = name.concat("5");
			break;
		case 6:
			name = name.concat("6");
			break;
		case 7:
			name = name.concat("7");
			break;
		case 8:
			name = name.concat("8");
			break;
		case 9:
			name = name.concat("9");
			break;
		case 10:
			name = name.concat("10");
			break;
		case 11:
			name = name.concat("J");
			break;
		case 12:
			name = name.concat("Q");
			break;
		case 13:
			name = name.concat("K");
			break;
		}

		//The suit gets a random number, depending on which then the exact suit is concatenated with 'name'
		switch(generator.nextInt(4) + 1)
		{
		case 1:
			name = name.concat(" Heart");
			break;
		case 2:
			name = name.concat(" Diamond");
			break;
		case 3:
			name = name.concat(" Club");
			break;
		case 4:
			name = name.concat(" Spade");
			break;
		}
		
		return name;	
	}
}
