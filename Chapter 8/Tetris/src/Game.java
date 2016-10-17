import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Game
{
	private Grid display;
	private Block block;
	private boolean gameOver;
	
	private int points;
	private int pause;

	public Game()
	{
		gameOver = false;
		display = new Grid(20, 10);
		display.setTitle("Tetris");
		display.setLineColor(new Color(0, 0, 0));
		block = new Block(display);
		block.revealSelf();
		
		points = 0; //A variable for the points at the current game
		pause = 50; //A variable for the pause controlling the speed of figures moving
	}

	public void play() throws IOException
	{
		int rounds = 1; //Counting rounds to control the speed
		
		System.out.println("Total score: 0\n");
		while (!gameOver)
		{
			rounds++;
			
			for (int i = 0; i < 10; i++)
			{
				Grid.pause(pause);
				int key = display.checkLastKeyPressed();
				if (key == 37)
				{
					block.shift(0, -1);
				}
				else if (key == 38)
				{
					block.rotate();					
				}
				else if (key == 39)
				{
					block.shift(0, 1);
				}
				
				else if (key == 40)
				{
					block.shift(1, 0);	
				}
			}
			
			if (block.shift(1, 0) == false)
			{
				removeCompletedRows(); //If the figure can not go down
				block = new Block(display); //Creating a new figure
				if (block.revealSelf() == false) //If we can not create a new figure, the game is over
				{
					gameOver = true;
				}
			}
			
			if (pause > 10 && rounds % 10 == 0) //Decreasing the pause time, increasing the speed of game
			{
				pause--;
			}
					
		}
		
		System.out.println("GAME OVER");
		System.out.println("Final score: " + points);
		
		saveScore(points); //Printing all the players and points saved
	}

	public boolean isCompletedRow(int row)
	{
		boolean noBlack = true; //A boolean that shows if there is a black block on that row
		int size = display.getNumCols(); //Getting the number of columns of the playing field
		Color black = new Color (0, 0, 0); //An object for black color
		Location[] locs = new Location[size]; //Creating a new array that helps to move all the blocks

		for (int i = 0; i < size; i++)
		{
			locs[i] = new Location(row, i); //'locs' now represents the row, we have to check if is completed
		}
		
		for (int i = 0; i < size; i++)
		{
			if (display.getColor(locs[i]).equals(black))
			{
				noBlack = false; //Comparing the color of blocks to black, if one of them is the same,
			}					//the row is not completed
		}
		
		return noBlack;	
	}

	public void removeSquare(Location loc)
	{
		int i = 0;
		
		Color black = new Color(0, 0, 0);
		//Starting from the highest block in that column
		while (display.getColor(new Location(i, loc.getCol())).equals(black))
		{
			i++; //Reaching the first non-black block in the column
		}
		
		int j; //'j' is decreasing until it reaches 'i'
		
		//Moving all the non-black block down with 1 place
		for (j = loc.getRow() - 0; j > i; j--)
		{
			Location locUp = new Location(j, loc.getCol());
			display.setColor(new Location(j, loc.getCol()), display.getColor(new Location(j - 1, loc.getCol())));
		} 
		
		//Making the highest non-black block black
		display.setColor(new Location(j, loc.getCol()), black);
	}

	public void removeRow(int row)
	{
		//Removing a row by removing each of its blocks one by one
		for (int i = 0; i < display.getNumCols(); i++)
		{
			removeSquare(new Location(row, i));
		}
	}

	//Checking for all the completed rows and removing all of them at once
	public void removeCompletedRows()
	{
		int count = 0; //Counting the number of the rows
		for (int i = 0; i < display.getNumRows(); i++)
		{
			if (isCompletedRow(i))
			{
				removeRow(i);
				count ++;
			}
		}
		
		if (count != 0)
		{
			System.out.println(printPoints(count)); //Printing the points won for cempleting the rows
		}
	}
	
	public void saveScore(int points) throws IOException
	{
		boolean newHighScore = false;
		
		File fileName = new File("scores.txt"); //Creating an object to open the file
		Scanner fileScan = new Scanner(fileName); //Creating an object for scanning through the file
		Scanner scan = new Scanner(System.in); //Creating an object for reading input
		
		String text = ""; //Saving the text of the file to a string
		int size = 0; //Counting the number of players saved in high scores
		
		while (fileScan.hasNextLine()) //Until reaching the end of the file
		{
			text += fileScan.nextLine(); //Saving to the string one by one
			size++;
		}
		text += '\0';
		
		String[] name = new String[size + 1]; //Creating two arrays - one for the names of the players
		int[] score = new int[size + 1]; //the other - for their scores
		
		//The arrays 'name' and 'score' are getting their values by substrings from the 'text' string
		//'j' is used for finding the start and end index of each substring
		int j = 0, start = 0, end = j;
		for (int i = 0; i < size && text.charAt(j) != '\0'; i++)
		{
			while (text.charAt(j) < '0' || text.charAt(j) > '9') //Get to the first digit
			{
				j++;
			}
			
			start = j;
			while (text.charAt(j) >= '0' && text.charAt(j) <= '9') //Now get to the last digit
			{
				j++;
			}
			end = j;
			
			score[i] = Integer.parseInt(text.substring(start, end));
		
			while (text.charAt(j) == '\t') //Skipping the tab and reaching the name's first letter
			{
				j++;
			}
			start = j;
	
			//Now getting to the end of the name
			while ((text.charAt(j) >= 'a' && text.charAt(j) <= 'z') || (text.charAt(j) >= 'A' && text.charAt(j) <= 'Z'))
			{
				j++;
			}
			end = j;
			
			name[i] = text.substring(start, end);
		}
			
		if (points > 0) //If the user has scored any points
		{
			System.out.print("Enter your name: ");
			String player = scan.nextLine();
			score[size] = points; //The user's information is going to the end of the array - last place
			name[size] = player;
		}
		
		else
		{
			size--;
		}
		
		int i = 0;
		while (i < size && score[i] > score[size]) //Reaching the first player with smaller score than the new one
		{
			i++;
		}
		
		if (i == 0) //If 'i' = 0 that means there is no one with greater score than ours, so it is a new high score
		{
			newHighScore = true;
		}
		
		if (score[size] >= score[i])
		{
			String saveName = name[size];
			int saveScore = score[size];
						
			//Sorting the scores and names
			for (int l = size; l > i; l--)
			{
				name[l] = name[l - 1];
				score[l] = score[l - 1];
			}
			
			name[i] = saveName;
			score[i] = saveScore;
		}
		
		//Opening the file and writing the information in it
		BufferedWriter outputWriter = null;
		outputWriter = new BufferedWriter(new FileWriter(fileName));
		
		for (int r = 0; r < size + 1; r++) 
		{
			    // Maybe:
		outputWriter.write(score[r] + name[r] + "\r\n");
			    // Or:
		//outputWriter.newLine();
		}
		
		outputWriter.flush();  
		outputWriter.close();
		
		if (newHighScore)
		{
			System.out.println("\nNew high score!");
		}
		System.out.println("SCORES");
		for (int p = 0; p < size + 1; p++)
		{
			System.out.println(score[p] + "\t" + name[p]);
		}
		
		scan.close();
		fileScan.close();
	}
	
	/*public boolean saveScore(int points) throws IOException
	{
		File fileName = new File("scores.txt");
		Scanner fileScan = new Scanner(fileName);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String player = scan.nextLine();
		
		int highScore = 1;
		
		if (fileScan.hasNextLine())
		{
			FileWriter out = new FileWriter("scores.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(out);

			String line = "";
			String text = "";
			
			boolean saved = false;
			
			int place = 0;
			while (fileScan.hasNextLine())
			{
				line = fileScan.nextLine();
				
				int otherScore = 0, i = 0;
				while (line.charAt(i) >= '0' && line.charAt(i) <= '9')
				{
					i++;
				}
				
				otherScore = Integer.parseInt(line.substring(0, i));
				
				if (highScore < otherScore)
				{
					highScore = otherScore;
				}
				
				if (points > otherScore && !saved)
				{
					text += points + "\t" + player + "\n";
					saved = true;
				}
				
				text += line + "\n";
				
			}
			
			if (!saved)
			{
				text += points + "\t" + player + "\n";
			}
			
			System.out.println(text);
			
			bufferedWriter.write(text);
			bufferedWriter.close();
			
			scan.close();
			fileScan.close();

			
			if (highScore < points)
			{
				return true;
			}
			
			else
			{
				return false;
			}
			
			
		}
		
		else
		{		
			PrintWriter out = new PrintWriter("scores.txt");
			out.println(points + "\t" + player + "\t");
			scan.close();
			fileScan.close();
			out.close();
			
			return true;
		}		
	}*/
	
	public String printPoints(int rows)
	{
		int newPoints = (int) (10 * Math.pow(2, rows)); //Calculating the points by having the number of rows completed
		points += newPoints; //Calculating the total score
		
		String result = "You just completed " + rows + " rows!\n";
		result += newPoints + " POINTS!\n";
		result += "Total score: " + points + "\n";
		
		return result;
	}

	public static void main(String[] args) throws IOException
	{
		Game game = new Game();		// Create an instance of this class
		game.play();				// Start playing the game we created
	}
}