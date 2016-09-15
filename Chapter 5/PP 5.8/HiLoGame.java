import java.util.Scanner;
import java.util.Random;

public class HiLoGame 
{

	public static void main(String[] args) 
	{
		Random generator = new Random(); //Creating an object for generating random numbers
		Scanner scan = new Scanner(System.in); //Creating an object for reading the input
		int number = 0; //A variable for the random number
		int guess = 0; //A variable for the guesses of the user
		String play = "YES"; //A string for the state of the game
		
		
		while (play.equalsIgnoreCase("YES")) //If the user wants to continue playing
		{
			number = generator.nextInt(100) + 1; //Generating a random number between 1 and 100
			System.out.print("Hello! This is Hi-Lo Guessing Game!\n"
					+ "Feel free to quit the game anytime by typing -1 and pressing Enter!\n"
					+ "Enter your guess: "); //A message for each new game started
			guess = scan.nextInt(); //Reading the guess of the user
			int rounds = 1; //Counting the guesses
			while (number != guess && guess != - 1) //A check if the number is guessed or the user wants to quit
			{
				if (guess < 1 || guess > 100) //A check if the guess is out of the range
				{
					System.out.println("Your guess is out of the range! Please enter a number between 1 and 100!\n"
							+ "Enter your guess: ");
				}
				
				else
				{
					if (guess > number) //If the guess is higher than the number
					{
						System.out.print("Your guess is higher!\nEnter your guess: ");
					}
					if (guess < number) //If the guess is lower than the number
					{
						System.out.print("Your guess is lower!\nEnter your guess: ");
					}
				}
				guess = scan.nextInt(); //Reading the guess of the user
				rounds ++; //Increasing the number of guesses
			}
			
			if (guess == number || guess == -1) //When the current game finishes
			{
				if (guess == number) //If the number was correctly guessed
				{
					System.out.println("Congratulations! You guessed the number correctly!");
					System.out.println("You needed " + rounds + " guesses to find the number " + number + ".");
				}
				
				else //If the user decided to quit the game
				{
					System.out.println("You decided to quit the game!");
					System.out.println("The number was " + number + ".");
				}
					
				System.out.println("Do you want to play again? YES/NO?");
				scan.nextLine(); //A line to consume the '\n' character from the input
				play = scan.nextLine(); //Asking the user whether he wants to play another game
				while (!play.equalsIgnoreCase("YES") && !play.equalsIgnoreCase("NO")) //If the input is invalid
				{
					System.out.println("Invalid input! YES/NO?");
					play = scan.nextLine(); //Reading the answer of the user

				}
			}
		}
		scan.close(); //Closing the scanner
	}
}
