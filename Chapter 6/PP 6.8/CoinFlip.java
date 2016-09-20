
public class CoinFlip
{

	public static void main(String[] args) 
	{
		Coin myCoin = new Coin(); //Creating a 'Coin' object - locking, unlocking, flipping
		myCoin.setKey(123456);
		myCoin.lock(123456);
		myCoin.unlock(1123456);
		myCoin.unlock(123456);		
		myCoin.flip();
		
		System.out.println(myCoin);
		
		if (myCoin.locked())
		{
			System.out.println("Object is locked! No access!");
		}
		
		else
		{
			if (myCoin.isHeads())
			{
				System.out.println("You win.");
			}
			else
			{
				System.out.println("Better luck next time.");
			}
			
		}
	}

}
