import java.util.Scanner;
import java.util.Random;

public class DealCards 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in); //Creating an object for reading the input
		Random generator = new Random(); //Creating an object for generating random integer
		Card card; //Creating an object of type 'Card'
		card = new Card(0, 0); 
		String deal = "YES"; //Creating a string which defines whether to do a new deal of cards or stop
		
		while (deal.equalsIgnoreCase("YES")) 
		{
			System.out.println("Random Dealing Cards");
			for (int i = 1; i <= 5; i++)
			{
				System.out.println("Card " + i + ": " + card.getRandomCard()); //Printing the cards
			}
		
			System.out.println("Would you like 5 new cards? YES/NO"); //An option for the user to stop or continue
			deal = scan.nextLine();
			if (!deal.equalsIgnoreCase("YES") && !deal.equalsIgnoreCase("NO")) //If the user types invalid input
			{
				System.out.println("Invalid input! YES/NO");
				deal = scan.nextLine();
			}
		}
		scan.close(); //Closing the scanner
	}

}
