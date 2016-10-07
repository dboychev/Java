import java.util.*;
public class LightsOutGame {
	
	// Static "helper" methods provided for you. Do not change code in these methods.

	public static void displayGrid(Grid grid, boolean[][] lightArray) {
		// updates grid display based on data in game array
		grid.setLineColor(new Color(255,255,255));
		for (int i = 0; i < grid.getNumRows(); i++) {
			for (int j = 0; j < grid.getNumCols(); j++) {
				grid.setColor(new Location(i,j), getColor(lightArray[i][j]));
			}
		}	
	}
	
	public static Color getColor(boolean isOn) {
		if (isOn)
			return new Color(255,255,0);
		else
			return new Color(0,0,0);
	}
	
	public static void main(String[] args) 
	{
		// Complete your program here. Write additional static helper methods
		// below according to the instructions given in the assignment.
		
		Scanner scan = new Scanner(System.in); //Creating an object for reading input
		boolean gameOver = false; //A boolean variable to show when the game should stop
		
		System.out.println("ENTER THE SIZE OF THE GAME");
		int rows = 0, cols = 0;
		
		//Rows and columns numbers should be at least 5
		while (rows < 5)
		{
			System.out.print("Rows: ");
			rows = scan.nextInt();
		}
		while (cols < 5)
		{
			System.out.print("Cols: ");
			cols = scan.nextInt();
		}
		
		Grid grid = new Grid(rows, cols); //Creating the grid for the game
		boolean[][] game = new boolean[rows][cols]; //Creating the array with the lights and user's size
		
		//Setting all the elements of the array to false, the lights are off initially
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				game[i][j] = false;
			}
		}
		
		displayGrid(grid, game); //Displaying the grid
		
		generateNewGame(game); //Turning some lights on randomly
		
		/* EASY WIN TEST
		game[0][0] = true;
		game[1][0] = true;
		game[0][1] = true;
		*/
		
		displayGrid(grid, game); //Displaying the new grid with turned lights on
		
		//A loop for the game
		while (!gameOver)
		{
			Location loc = grid.checkLastLocationClicked(); //Getting the location of the last mouse click
			if (loc != null)								//but only if there was such a click
			{
				toggleLights(game, loc.getRow(), loc.getCol());
			}
			
			displayGrid(grid, game); //Displaying the new grid with changed cells values	
			
			if (checkForGameWin(game)) //If all the lights are off
			{
				gameOver = true; //Game ends
			}
		}
		
		System.out.println("YOU WIN!");

		int flashTimes = (rows + cols) / 2; //Calculating the time of toggling the lights for the win of the player
		while (flashTimes > 0)
		{
			Grid.pause(450); //A pause between the toggling
			toggleAllLights(game);
			displayGrid(grid, game);
			flashTimes--;
		}
	
		scan.close();
	}
	
	public static void generateNewGame(boolean[][] lightArray)
	{
		//Randomly generated values of the array elements, some lights are on, others off
		Random generator = new Random();
		for (int i = 0; i < lightArray.length; i++)
		{
			for (int j = 0; j < lightArray[i].length; j++)
			{
				lightArray[i][j] = generator.nextBoolean();
			}
		}
	}
	
	public static void toggleLights(boolean[][] lightArray, int row, int col)
	{		
		//Changing the value of the cell, the user clicked on and all its neighbor cells
		lightArray[row][col] = !lightArray[row][col];
	
		//Checking if the cell has a neighbor at each side
		if (row > 0)
		{
			lightArray[row - 1][col] = !lightArray[row - 1][col];
		}
		
		if (col > 0)
		{
			lightArray[row][col - 1] = !lightArray[row][col - 1];
		}
		
		if (row < lightArray.length - 1)
		{
			lightArray[row + 1][col] = !lightArray[row + 1][col];
		}
		
		if (col < lightArray[0].length - 1)
		{
			lightArray[row][col + 1] = !lightArray[row][col + 1];
		}
	}
	
	public static boolean checkForGameWin(boolean[][] lightArray)
	{
		boolean win = true; //A variable that is initially true
		
		//If only one of the lights is turned on, 'win' changes to false
		for (int i = 0; i < lightArray.length; i++)
		{
			for (int j = 0; j < lightArray[0].length; j++)
			{
				if (lightArray[i][j] == true)
				{
					win = false;
				}
			}
		}
		
		return win;
	}
	
	public static void toggleAllLights(boolean[][] lightArray)
	{
		//Changing the value of all the lights
		for (int i = 0; i < lightArray.length; i++)
		{
			for (int j = 0; j < lightArray[0].length; j++)
			{
				lightArray[i][j] = !lightArray[i][j];
			}
		}
	}
	
}
