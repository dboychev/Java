import java.util.Scanner;
import java.util.Random;

public class DealCards 
{
	public static String checkCard(Card card)
	{
		String name = new String(""); //Creating a string that will display the exact value and suit of the card
	
		//The value gets a random number, depending on which the string gets the symbol for the exact value
		switch(card.getValue()) 
		{
		case 1:
			name = name.concat("A");
			break;
		case 2:
			name = name.concat("2");
			break;
		case 3:
			name = name.concat("3");
			break;
		case 4:
			name = name.concat("4");
			break;
		case 5:
			name = name.concat("5");
			break;
		case 6:
			name = name.concat("6");
			break;
		case 7:
			name = name.concat("7");
			break;
		case 8:
			name = name.concat("8");
			break;
		case 9:
			name = name.concat("9");
			break;
		case 10:
			name = name.concat("10");
			break;
		case 11:
			name = name.concat("J");
			break;
		case 12:
			name = name.concat("Q");
			break;
		case 13:
			name = name.concat("K");
			break;
		}

		//The suit gets a random number, depending on which then the exact suit is concatenated with 'name'
		switch(card.getSuit())
		{
		case 1:
			name = name.concat(" Heart");
			break;
		case 2:
			name = name.concat(" Diamond");
			break;
		case 3:
			name = name.concat(" Club");
			break;
		case 4:
			name = name.concat(" Spade");
			break;
		}
		
		return name;
	}
		
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in); //Creating an object for reading the input
		Random generator = new Random(); //Creating an object for generating random integer
		Card card1, card2, card3, card4, card5; //Creating 5 objects of type 'Card'
		card1 = new Card(0, 0);
		card2 = new Card(0, 0);
		card3 = new Card(0, 0);
		card4 = new Card(0, 0);
		card5 = new Card(0, 0); 
		String deal = "YES"; //Creating a string which defines whether to do a new deal of cards or stop
		
		while (deal.equalsIgnoreCase("YES")) 
		{
			card1.setValue(generator.nextInt(13) + 1); //Generating random integers for each card's value and suit
			card1.setSuit(generator.nextInt(4) + 1);
			card2.setValue(generator.nextInt(13) + 1);
			card2.setSuit(generator.nextInt(4) + 1);
			card3.setValue(generator.nextInt(13) + 1);
			card3.setSuit(generator.nextInt(4) + 1);
			card4.setValue(generator.nextInt(13) + 1);
			card4.setSuit(generator.nextInt(4) + 1);
			card5.setValue(generator.nextInt(13) + 1);
			card5.setSuit(generator.nextInt(4) + 1);
			
			/*card1 = new Card(generator.nextInt(13) + 1, generator.nextInt(4) + 1);
			card2 = new Card(generator.nextInt(13) + 1, generator.nextInt(4) + 1);
			card3 = new Card(generator.nextInt(13) + 1, generator.nextInt(4) + 1);
			card4 = new Card(generator.nextInt(13) + 1, generator.nextInt(4) + 1);
			card5 = new Card(generator.nextInt(13) + 1, generator.nextInt(4) + 1);*/
			
			System.out.println("Random Dealing Cards");
			System.out.println("Card 1: " + checkCard(card1)); //Printing the cards
			System.out.println("Card 2: " + checkCard(card2));
			System.out.println("Card 3: " + checkCard(card3));
			System.out.println("Card 4: " + checkCard(card4));
			System.out.println("Card 5: " + checkCard(card5));
			
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
