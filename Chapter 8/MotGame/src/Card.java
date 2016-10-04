import java.util.Random;

public class Card 
{

	// Complete this class given the instructions in your assignment.

	//Fields for card number and color
	private int number;
	private String color;
	
	public Card() //Constructor
	{
		Random generator = new Random(); //Creating an object for generating random values
		number = generator.nextInt(9) + 1; //Random number
		switch(generator.nextInt(4) + 1) //Random color
		{
		case 1:
			color = "red";
			break;
		case 2:
			color = "green";
			break;
		case 3:
			color = "blue";
			break;
		case 4:
			color = "yellow";
			break;
		}
	}

	//Setters and getters for 'number' and 'color'
	public void setNumber(int newNumber)
	{
		number = newNumber;
	}
	
	public void setColor(String newColor)
	{
		color = newColor;
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public String getColor()
	{
		return color;
	}
	
	//Printing method for each card
	public String toString()
	{
		return color + " " + number;
	}

	//Method for a check if two cards are equal
	public boolean equals(Card another)
	{
		if (number == another.number && color.equals(another.color))
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
}
