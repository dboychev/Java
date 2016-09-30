import java.util.*;

public class DiceGame 
{

	public static void displayDice(Grid game, int[] die) {
		for (int i = 0; i < die.length; i++) {
			if (die[i] >= 1 && die[i] <= 6) {
				game.setImage(new Location(0,i), "die" + die[i] + ".png");
			}
			System.out.print(die[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) 
	{
		
		int[] die = new int[5];
		boolean[] reroll = new boolean[5];
		Grid game = new Grid(1,5);
		game.setTitle("ANITROC!");
		
		final int MAX_ROLLS_PER_ROUND = 4;
		final int MAX_STRIKES_PER_GAME = 3;
		
		// Complete the main method here according to the instructions
		// given in the assignment:
		
		Scanner scan = new Scanner(System.in); //Creating an object for reading input
		Random generator = new Random(); //Creating an object for generating a random integer
		
		int strikes = 0, rolls = 0, total = 0; //Number of strikes, rolls per round and total points
		boolean play = true, stop = false; //'play' - indicates if the round has finished by any reason and the
		//numbers must be changed; 'stop' - indicates if the player presses ENTER for continuing
				
		System.out.println("Welcome to ANITROC!"); //Message for starting the game
			
		while (strikes < MAX_STRIKES_PER_GAME && !stop) //The game is played until the player gets the maximum
			//allowed number of strikes or does not press ENTER when asked
		{
			for (int i = 0; i < 5; i++) //For each of the dice generate a number - used in the beginning and
				//when the player needs new numbers because the previous round has finished
			{
				die[i] = generator.nextInt(6) + 1; //Generating random number for each die
			}
			
			rolls = 0; //Number of rolls just before the beginning of a new round
			
			while (getScore(die) == 0 && rolls < 4 && play == true) //If the dice has no score
			{
				displayDice(game, die); //Displaying the dice
				play = false; //Round is initially finished, it will be changed only if the player decides to
				//roll at least one of the dice
				for (int j = 0; j < 5; j++)
				{
					System.out.print("Do you want to roll die " + j + " again (y for yes)? "); //Asking the player
					//for rolling the dice one by one
					if (scan.nextLine().equals("y")) //'y' for YES, everything else counts as NO
					{
						reroll[j] = true; //If - yes, reroll the die
						die[j] = generator.nextInt(6) + 1;
					}
					else
					{
						reroll[j] = false;
					}
					
					if (reroll[j]) //If there is one die rerolled - game continues
					{
						play = true;
					}
				}
				System.out.println(); //An empty line
				if (play)
				{
					rolls++; //There was a roll, so counter should be incremented 
				}
			}
			
			if (getScore(die) != 0 || (rolls >= 4 && getScore(die) == 0) || !play) //If a round has finished
			{
				String result = null;
				switch(getScore(die)) //Checking the score
				{
				case 200:
					result = "ANITROC! ";
					break;
				case 100:
					result = "FOUR OF A KIND ";
					break;
				case 50:
					result = "LARGE STRAIGHT ";
					break;
				case 40:
					result = "FULL HOUSE ";
					break;
				case 30:
					result = "THREE OF A KIND ";
					break; 
				case 20:
					result = "SMALL STRAIGHT ";
					break;
				case 10:
					result = "TWO PAIRS ";
					break;
				case 0:
					result = "STRIKE! ";
					strikes++;
					break;
				}
				
				displayDice(game, die); //Displaying the dice
				total += getScore(die); //Total incrementing
				result += "You scored " + getScore(die) + "\nStrikes = " + strikes + "\tYour total = " + total;
				
				System.out.println(result); //Printing formatted result
				
				System.out.println("Hit ENTER to continue");
				if (scan.nextLine().equals("\n"))
				{
					stop = true; //If ENTER pressed, game is not stopped and it continues
				}
				
				play = true; //'play' is made ready for a new round
				//rolls = 0; //'rolls' are 0 again for the new round
			}
			
			if (strikes == 3) //If the game is over
			{
				System.out.println("GAME OVER");
			}		
			
			scan.close();
		}
	}

	

	public static int getScore(int[] die) 
	{
		
		// Method to compute and return the score for the 5 dice values
		// stored in the die array.

		Arrays.sort(die); //Sorting the array
		//If an element of the array is equal to another element it means all the elements between them
		//are also equal to them
		
		
		int score = 0; //Starting the game with 0 points
		
		//If die0 = die4 it means all dice between 0 and 4 are also equal to them, because array is just sorted
		if (die[0] == die[4]) 
		{
			score = 200;
		}
		
		//The same logic here
		else if (die[0] == die[3] || die[1] == die[4]) 
		{
			score = 100;
		}
		
		//Large straight
		else if ((die[0] == 1 && die[1] == 2 && die[2] == 3 && die[3] == 4 && die[4] == 5) ||
				(die[0] == 2 && die[1] == 3 && die[2] == 4 && die[3] == 5 && die[4] == 6))
		{
			score = 50;
		}
		
		//If there are 3 equal and another 2 equal numbers on the dice
		else if ((die[0] == die[2] && die[3] == die[4]) || (die[0] == die[1] && die[2] == die[4]))
		{
			score = 40;
		}
		
		//If there are three equal numbers
		else if (die[0] == die[2] || die[1] == die[3] || die[2] == die[4])
		{
			score = 30;
		}
		
		//Small straight
		else if(((die[0] == die[1] - 1) && (die[1] == die[2] - 1) && (die[2] == die[3] - 1)) ||
				((die[1] == die[2] - 1) && (die[2] == die[3] - 1) && (die[3] == die[4] - 1)))
		{
			score = 20;
		}
		
		//If there are two pairs of the same number
		else if ((die[0] == die[1] && (die[2] == die[3] || die[3] == die[4])) || (die[1] == die[2] && die[3] == die[4]))
		{
			score = 10;
		}
				
		return score; 
		}
}
