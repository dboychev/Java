import java.lang.reflect.Method;

public class Coin implements Lockable
{
	private final int HEADS = 0; //Two sides of the coin that can be flipped
	private final int TAILS = 1;
	
	private int face, key; //'face' shows the upper side of the coin, 'key' is for locking an object
	private boolean locked; //'locked' stands for showing if an object is locked
	
	public void setKey(int newKey) //Setting a new key
	{
		key = newKey;
	}
	
	public void lock(int newKey) //Locking the object
	{
		if (key == newKey) //If the key is correct
		{
			locked = true;
			System.out.println("Object locked!");
		}
		
		else //If the key is wrong
		{
			System.out.println("Locking failed! Wrong key!");
		}
	}
	
	public void unlock(int newKey) //Unlocking the object
	{
		if (key == newKey) //If the key is correct
		{
			locked = false;
			System.out.println("Object unlocked!");
		}
		
		else //If the key is wrong
		{
			System.out.println("Unlocking failed! Wrong key!");
		}
	}

	public boolean locked() //Shows whether the object is locked
	{
		if (locked)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	public Coin() //'Coin' constructor
	{
		locked = true; //Each object is locked by default
		flip();
	}
	
	public void flip() //Flipping the coin on a random side
	{
		if (locked())
		{
			System.out.println("Object is locked! No access!");
		}
		
		else
		{
			face = (int) (Math.random() * 2);
		}
	}
	
	public boolean isHeads() //A check that shows if the upper side of the coin is 'Heads'
	{
		if (locked())
		{
			System.out.println("Object is locked! No access!");
			return false;
		}
		
		else
		{
			return (face == HEADS);
		}
	}
	
	public String toString() //Printing the object
	{
		String faceName;
		if (locked())
		{
			faceName = "Object is locked! No access!";
		}
		
		else
		{
			if (face == HEADS)
			{
				faceName = "Heads";
			}
			else
			{
				faceName = "Tails";
			}
		}
		return faceName;
	}
}