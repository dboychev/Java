
public class Transaction 
{

	public static void main(String[] args) 
	{
		Account acct1 = new Account ("Ted Murphy", 72354, 102.56); //Creating some 'Account' objects
		Account acct2 = new Account ("Jane Smith", 69713, 40.00);
		Account acct3 = new Account ("Edward Demsey", 93757, 759.32);
		
		acct1.deposit(25.85); //Deposit in 'Ted Murphy's account
		
		double smithBalance = acct2.deposit(500.00); //Deposit in 'Jane Smith's account
		//System.out.println("Smith balance after deposit: " + smithBalance);
		
		//System.out.println("Smith balance after withdrawal: " + acct2.withdraw(430.75, 1.50));
		
		acct1.addInterest();
		acct2.addInterest();
		acct3.addInterest();
		
		//Printing all three accounts
		System.out.println();
		System.out.println(acct1);
		System.out.println(acct2);
		System.out.println(acct3);
	}

}