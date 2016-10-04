import java.util.*;
public class MotGame 
{

	public static void drawCards(Grid game, Card[] cardArray) 
	{
		game.setLineColor(new Color(255,255,255));
		System.out.println("Your cards:");
		for (int i = 0; i < 9; i++) {
			if (cardArray[i] != null) {
				game.setImage(new Location(0,i), 
					cardArray[i].getColor() + 
					cardArray[i].getNumber() + ".gif");
				System.out.println(i + ": " + cardArray[i]);
			}
			else {
				game.setImage(new Location(0,i),"black.gif"); 
			}
		}
	}

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		Card[] cardArray = new Card[9];
		Grid game = new Grid(1,9);
		game.setTitle("MOT!");
		
		// Complete the main method here according to the instructions
		// given in the assignment:
		
		//Creating 5 'Card' objects at the first 5 places in cardArray
		for (int i = 0; i < 5; i++) 
		{
			cardArray[i] = new Card();
		}
		
		int cards = 5; //Counting the cards in the array
		drawCards(game, cardArray); //Displaying the cards
	
		while (cards > 1 && cards < 10) //While the game is being played
		{
			System.out.println("Pick a card to move to position 0 or enter 0 to get a new card: ");
			int index = scan.nextInt(); //Reading the input
			
			//If the user's number is not in the range, represents an empty element of the array, or an element that
			//just does not have neither the same number, nor the same color with the first card
			while ((index < 0 || index > 8) 
					|| index >= cards 
					|| (cardArray[0].getNumber() != cardArray[index].getNumber() 
					&& !(cardArray[0].getColor().equals(cardArray[index].getColor()))))
			{
				System.out.println("INVALID POSITION");
				System.out.print("Pick a card to move to position 0 or enter 0 to get a new card: ");
				index = scan.nextInt(); //Until we get a valid index
			}	
			
			if (index > 0 && index < cards) //If the index is in the range
			{
				//If the index represents an element that can be moved at first position of the array
				if (cardArray[0].getNumber() == cardArray[index].getNumber() 
						|| cardArray[0].getColor().equals(cardArray[index].getColor()))
				{
					cardArray[0].setNumber(cardArray[index].getNumber()); //Moving user's element on first position
					cardArray[0].setColor(cardArray[index].getColor());
					
					cardArray[index].setNumber(cardArray[cards - 1].getNumber()); //Moving the last element on the
					cardArray[index].setColor(cardArray[cards - 1].getColor()); //user element's position
					
					cardArray[cards - 1] = null; //Removing the last element
					cards--; //Decreasing the number of cards
				}
			}
			
			if (index == 0)
			{
				if (cards < 9) //If there is still an empty space for a new card
				{
					cardArray[cards] = new Card(); //Creating a new 'Card' object on the first empty place
				}
				cards++; //Increasing the number of the cards
			}
			
			drawCards(game, cardArray); //Displaying the cards again
		}
		
		//When the game finishes - checking whether the player has won or lose
		if (cards == 1) 
		{
			System.out.println("WINNER\n");
		}
		else
		{
			System.out.println("LOSER\n");
		}
		
		scan.close();
	}
}
