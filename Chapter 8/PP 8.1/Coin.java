public class Coin
{
	private final int HEADS = 0; //Two sides of the coin that can be flipped
	private final int TAILS = 1;
	
	private int face; //'face' shows the upper side of the coin
	
	public Coin() //'Coin' constructor
	{
		flip();
	}
	
	public void flip() //Flipping the coin on a random side
	{
		face = (int) (Math.random() * 2);
	}
	
	public boolean isHeads() //A check that shows if the upper side of the coin is 'Heads'
	{
		return (face == HEADS);
	}
	
	public String toString() //Printing the object
	{
		String result;

		if (face == HEADS)
		{
			result = "Heads";
		}
		else
		{
			result = "Tails";
		}

		return result;
	}
}