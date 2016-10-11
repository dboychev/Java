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
	
		/*if (saveScore(points))
		{
			System.out.print("New high score!");
		}*/
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