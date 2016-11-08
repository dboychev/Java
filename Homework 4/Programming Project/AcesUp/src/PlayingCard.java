public class PlayingCard extends Object implements Comparable<PlayingCard> 
{
	private int rank;
	private char suit;

	/**
	 * Constructs a single playing card given the card rank and suit in the parameters.
	 * 
	 * @param newRank - the rank of the created card
	 * @param newSuit - the suit of the created card
	 */
	public PlayingCard(int newRank, char newSuit)
	{
		rank = newRank;
		suit = newSuit;
	}
	
	/**
	 * Returns a positive integer if this card has a lower rank than the other card,
	 * a negative integer if this card has a higher rank than the other card,
	 * or 0 if this card's rank is the same as the other card's rank.
	 */
	public int compareTo(PlayingCard otherCard)
	{
		return - (rank - otherCard.rank);
	}
	
	/**
	 * Gets the image file name for this card.
	 * The image file name for a card consists of its rank followed by its suit
	 * followed by the suffix ".png". 
	 * For example: the Ace of Spades would have a file name of "1S.png",
	 * the 7 of Diamonds would have a file name of "7D.png" and 
	 * the Jack of Hearts would have a file name of "11H.png".
	 * 
	 * @return - the created name that should suit the needed image file
	 */
	public String getImageFileName()
	{
		String fileName = rank + "" + suit + ".png";
		
		return fileName;
	}
	
	/**
	 * Gets the rank of this card.
	 * 
	 * @return - the value of rank field of the card
	 */
	public int getRank()
	{
		return rank;
	}
	
	/**
	 * Gets the suit of this card.
	 * 
	 * @return - the value of the suit field of the card
	 */
	public char getSuit()
	{
		return suit;
	}
	
	/**
	 * Returns the string representation of this card including its rank and suit.
	 */
	public String toString()
	{
		String card = rank + suit + "";
		
		return card;
	}
}