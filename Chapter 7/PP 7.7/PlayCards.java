
public class PlayCards 
{

	public static void main(String[] args) 
	{
		DeckOfCards myDeck = new DeckOfCards(); //Creating a deck, testing and printing it
		System.out.println(myDeck);

		myDeck.shuffle();
		System.out.println(myDeck);
		
		myDeck.dealACard(15);
		myDeck.dealACard(5);
		myDeck.dealACard(5);

		System.out.println(myDeck);	
	}
}