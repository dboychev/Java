import java.util.Random;
import java.util.Scanner; 

public class SlotMachine 
{
	public static void check(int num1, int num2, int num3) //A function that how many of the numbers are the same
	{
		if ((num1 == num2 && num1 != num3) || (num1 == num3 && num1 != num2) || (num2 == num3 && num2 != num1))
		{
			System.out.println("***************************\n"
					+ "You have two equal numbers!\n"
					+ "***************************"); //For two equal numbers
		}
		
		if (num1 == num2 && num2 == num3)
		{
			System.out.println("****************************\n"
					+ "	*********JACKPOT!!!*********\n"
					+ "You have three equal numbers!\n"
					+ "****************************"); //For three equal numbers
		}
		
		if (num1 != num2 && num2 != num3 && num3 != num1)
		{
			System.out.println("**************************\n"
					+ "You have no equal numbers!\n"
					+ "**************************");
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in); //An object for reading input
		Random generator = new Random(); //An object for generating random integers
		int num1, num2, num3; //The numbers
		String play = "YES"; //The state of the game
		
		while (play.equalsIgnoreCase("YES"))
		{
				num1 = generator.nextInt(10);
				num2 = generator.nextInt(10);
				num3 = generator.nextInt(10); //Giving the numbers new random values
				System.out.println("**********" + num1 + "-" + num2 + "-" + num3 + "***********"); //Printing the numbers
				check(num1, num2, num3); //Checking for equal numbers
				System.out.println("Play again? YES/NO"); //Asking the user whether he wants to play new game
				play = scan.nextLine();
				if (!play.equalsIgnoreCase("YES") && !play.equalsIgnoreCase("NO")) //It he types neither "YES", nor "NO"
				{
					System.out.println("Invalid input! Play again? YES/NO");
					play = scan.nextLine();
				}
		}
		
		scan.close();
	}

}
