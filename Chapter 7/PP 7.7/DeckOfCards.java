import java.util.Random;

public class DeckOfCards 
{
	Random generator = new Random(); //An object for reading input
	
	private int cardsNum = 52; //The number of cards every new deck has
	private Card[] deck; //Our deck of cards
	
	public DeckOfCards() //Constructor
	{
		deck = new Card[cardsNum];
		for (int i = 0; i < 13; i++) //Creating the cards suit by suit
		{
			for (int j = 0; j < 4; j++)
			{
				deck[i + j * 13] = new Card(i + 1, j + 1);
			}
		}
	}
	
	public int getCardsNum() //Getting the number of cards left in the deck
	{
		return cardsNum;
	}
	
	public void shuffle() //Shuffling a new deck with 52 cards
	{
		deck = new Card[52]; 
		for (int i = 0; i < 13; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				deck[i + j * 13] = new Card(i + 1, j + 1);
			}
		}
		
		for (int i = 0; i < 52; i++)
		{
			int index1 = generator.nextInt(52); //Choosing two random indexes to swap
			int index2 = generator.nextInt(52);
			
			Card temp = deck[index1]; //Swapping two cards
			deck[index1] = deck[index2];
			deck[index2] = temp;
		}
		System.out.println("Deck shuffeled!");
	}
	
	public Card dealACard(int index)
	{
		Card result = deck[index]; //Saving our card
		
		cardsNum--; //Decreasing cards number
		Card[] newDeck = new Card[cardsNum]; //Creating a new array with smaller size
		int i;
		for (i = 0; i < index; i++) //Assigning the values before and after our card to the new array
		{
			newDeck[i] = deck[i];
		}
		
		for (i = index + 1; i < cardsNum + 1; i++)
		{
			newDeck[i - 1] = deck[i];
		}
		
		deck = newDeck; //The old array is now the same without our card and with size smaller with 1
	
		return result;
	}
	
	public String toString() //Printing the deck
	{
		String result = "Deck Of Cards\n" + "Number of cards: " + getCardsNum() + "\n";
		for (int i = 0; i < cardsNum; i++)
		{
			if (i < 9)
			{
				result += "# ";
			}
			
			else
			{
				result += "#";
			}
			
			result += (i + 1) + ": " + deck[i].toString();
		}
		
		return result;
	}	
}