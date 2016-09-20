import java.text.NumberFormat;

public class Account implements Lockable
{
	private final double RATE = 0.035; //The interest rate
	
	private long acctNumber; //Account number
	private double balance; //Balance of the account
	private String name; //Name of the owner
	private int key; //Key for lock/unlock
	private boolean locked; //Lock/unlock status
	
	public Account(String newName, long newAcctNumber, double newBalance) //Account constructor
	{
		name = newName;
		acctNumber = newAcctNumber;
		balance = newBalance;
		locked = true; //The account is locked by default
		key = 654321;
	}
	
	public double deposit(double amount) //Deposit into the account
	{
		if (locked()) //If the account is locked
		{
			System.out.println("Account locked! No access!");
			return 0;
		}
		
		else 
		{
			balance += amount;			
			return balance;
		}
	}
	
	public double withdraw(double amount, double fee) //Withdraw money from the account
	{
		if (locked())
		{
			System.out.println("Account locked! No access!");
			return 0;
		}
		
		else
		{
			balance -= (amount + fee);
			return balance;
		}
	}
	
	public double addInterest() //Adding an interest to the account
	{
		if (locked())
		{
			System.out.println("Account locked! No access!");
			return 0;
		}
		
		else
		{
			balance += (balance * RATE);
			return balance;
		}
	}
	
	public double getBalance() //Checking the balance
	{
		if (locked())
		{
			System.out.println("Account locked! No access!");
			return 0;
		}
		
		else
		{
			return balance;
		}
	}
	
	public String toString() //Printing information about the account - balance
	{
		if (locked())
		{
			return "Account locked! No access!";
		}
		
		else
		{
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		return acctNumber + "\t" + name + "\t" + fmt.format(balance);
		}
	}
	
	public void setKey(int newKey) //Setting a key to the lockable account
	{
		key = newKey;
	}
	
	public void lock(int newKey) //Locking the account
	{
		if (newKey == key)
		{
			locked = true;
		}
		else
		{
			System.out.println("Locking failed! Wrong key!");
		}
	}
	public void unlock(int newKey) //Unlocking the account
	{
		if (newKey == key)
		{
			locked = false;
		}
		else
		{
			System.out.println("Unlocking failed! Wrong key!");
		}
	}
	
	public boolean locked() //Checking lock/unlock status
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
	
}
