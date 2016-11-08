import java.util.*;

public class GameController {

	// DO NOT CHANGE OR ADD FIELDS BELOW.
	// YOU MUST USE THESE FIELDS TO IMPLEMENT YOUR GAME.

	private ArrayList<PlayingCard> deck;
	private ArrayList<PlayingCard>[] list;
	private ArrayList<PlayingCard> discardPile;
	private int playerScore;
	
	// WRITE YOUR CODE AND JAVADOC HERE:
	
	/**
	 * A helper function for the constructor. Creates the deck.
	 */
	private void createDeck()
	{
		deck = new ArrayList<PlayingCard>();
		
		char suit = 0;
		//With two loops the deck is filled with 52 different cards - from Ace to King in 4 different suits
		for (int i = 1; i < 5; i++)
		{
			switch(i)
			{
			case 1:
				suit = 'C';
				break;
			case 2:
				suit = 'S';
				break;
			case 3:
				suit = 'H';
				break;
			case 4:
				suit = 'D';
				break;
			}
			
			for (int j = 1; j < 14; j++)
			{
				//Adding the card at the deck one by one
				PlayingCard card = new PlayingCard(j, suit);
				deck.add(card);
			}
		}
	}

	/**
	 * Creates a controller to play the Aces Up game. The controller creates a deck of cards as an arraylist,
	 * four empty arraylists for the four card lists of the game,
	 * and an arraylist for the discard pile.
	 */
	public GameController()
	{
		createDeck(); //The helper function is invoked
		
		//An array of four ArrayList elements is created
		list = new ArrayList [4];
		//Each element of the array is a new empty object of type ArrayList
		for (int i = 0; i < 4; i++)
		{
			list[i] = new ArrayList<PlayingCard> ();
		}
		
		//A discard pile is created - empty ArrayList object
		discardPile = new ArrayList<PlayingCard> ();
		
		//The points of the player are set to 0
		playerScore = 0;
	}

	/**
	 * Gets the card in the specified list number at the given index. If the given list is empty,
	 * this method returns null. If the given index is invalid for the given list,
	 * this method returns null.
	 * 
	 * @param listNum - a number from 0 to 3 - one of the elements of list
	 * @param index - a number from 0 to 12 - an index of a card from one of the list
	 * @return - the card at the list and index typed, if there are no such card - null
	 */
	public PlayingCard getCard(int listNum, int index)
	{
		//Check if the list has any elements
		if (!list[listNum].isEmpty())
		{
			//Check if the index is too big for that list
			if (index < list[listNum].size())
			{
				//If all conditions are done, the card at the index is returned
				return list[listNum].get(index);
			}
		}
		
		return null;
	}
	
	/**
	 * Gets the current score.
	 * 
	 * @return - the score of the player
	 */
	public int getScore()
	{
		return playerScore;
	}
	
	/**
	 * Adds a card from the deck to the end of each of the card lists if the deck is not empty.
	 * Otherwise, do nothing.
	 */
	public void deal()
	{		
		//A check if there are still any cards left at the deck
		if (!deck.isEmpty())
		{
			//If yes - a card is dealt for each of the lists
			for (int i = 0; i < 4; i++)
			{
				list[i].add(list[i].size(), deck.remove(deck.size() - 1));
			}
		}
	}
	
	/**
	 * Moves the last card from the given list to the discard pile if the list is not empty and 
	 * the last card has a rank that is greater than the last card on another list with the same suit. 
	 * Otherwise, do nothing.
	 * 
	 * @param listNum - the number of the list which we want to discard a card from
	 */
	public void discard(int listNum)
	{
		//A helper boolean variable that shows if the card was discarded
		boolean done = false;
		
		//A check if the list has any cards in it
		if (!list[listNum].isEmpty())
		{
			//If yes - it performs a check if the operation can be done or not
			for (int i = 0; i < 4 && !done; i++)
			{
				if (i != listNum)
				{
					//If any of the other lists has such last card that has the same suit but lower rank than
					//the card we want to discard, the operation can be done
					if (list[i].get(list[i].size() - 1).getSuit() == list[listNum].get(list[listNum].size() - 1).getSuit()
							&& list[i].get(list[i].size() - 1).getRank() < list[listNum].get(list[listNum].size() - 1).getRank())
					{
						//Boolean is changed to stop the for loop that is not needed any more
						done = true;
						//Points are actualized
						playerScore += list[listNum].get(list[listNum].size() - 1).getRank();
						//Discard pile gets the discarded card
						discardPile.add(list[listNum].remove(list[listNum].size() - 1));
					}
				}
			}
		}
	}
	
	/**
	 * Move the last card from the given list (if the list is not empty) to an empty list if one exists. 
	 * Otherwise, do nothing.
	 * 
	 * @param listNum - the number of the list which we want to move the last card from
	 */
	public void move(int listNum)
	{
		//A check if the list is empty or not
		if (!list[listNum].isEmpty())
		{
			//A helper boolean variable that shows if we have found an empty list
			boolean foundEmpty = false;
			
			for (int i = 0; i < 4 && !foundEmpty; i++)
			{
				//If there is an empty list, different from the one we want to move the card from 
				if (i != listNum && list[i].isEmpty())
				{
					//The boolean is changed to true
					foundEmpty = true;
					//The card is moved to that list
					list[i].add(list[listNum].remove(list[listNum].size() - 1));
				}
			}
		}
	}
	
	/**
	 * Moves all cards from the lists and discard pile back into the deck of cards, 
	 * shuffles the deck and starts a new game.
	 */
	public void startNewGame()
	{
		//Moves all the cards from the discard pile to the deck, if there are any
		while (!discardPile.isEmpty())
		{
			deck.add(discardPile.remove(0));
		}
		
		//Moves all the cards from the lists to the deck, if there are any
		for (int i = 0; i < 4; i++)
		{
			while (!list[i].isEmpty())
			{
				deck.add(list[i].remove(0));
			}
		}
		
		//Shuffle the deck
		Collections.shuffle(deck);
		
		//After the deck is shuffled, add the last four cards to each of four lists starting from the first one
		for (int i = 0; i < 4; i++)
		{
			list[i].add(deck.remove(deck.size() - 1));
		}
		
		//Set the points to 0
		playerScore = 0;
	}
}
