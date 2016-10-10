public class Game
{
	private Grid display;
	private Block block;
	private boolean gameOver;

	public Game()
	{
		gameOver = false;
		display = new Grid(20, 10);
		display.setTitle("Tetris");
		display.setLineColor(new Color(0, 0, 0));
		block = new Block(display);
		block.revealSelf();
	}

	public void play()
	{
		while (!gameOver)
		{
			for (int i = 0; i < 10; i++)
			{
				Grid.pause(50);
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
				removeCompletedRows();
				block = new Block(display);
				if (block.revealSelf() == false)
				{
					gameOver = true;
				}
			}
				
		}
		System.out.println("GAME OVER");
	}

	public boolean isCompletedRow(int row)
	{
		boolean noBlack = true;
		int size = display.getNumCols();
		Color black = new Color (0, 0, 0);
		Location[] locs = new Location[size];

		for (int i = 0; i < size; i++)
		{
			locs[i] = new Location(row, i);
		}
		
		for (int i = 0; i < size; i++)
		{
			if (display.getColor(locs[i]).equals(black))
			{
				noBlack = false;
			}
		}
		
		return noBlack;	// Remove this line when you write this method  
	}

	public void removeSquare(Location loc)
	{
		int i = 0;
		
		Color black = new Color(0, 0, 0);
		while (display.getColor(new Location(i, loc.getCol())).equals(black))
		{
			i++;
		}
		
		int j;
		
		for (j = loc.getRow() - 0; j > i; j--)
		{
			Location locUp = new Location(j, loc.getCol());
			display.setColor(new Location(j, loc.getCol()), display.getColor(new Location(j - 1, loc.getCol())));
		}
		
		display.setColor(new Location(j, loc.getCol()), black);
	
	}

	public void removeRow(int row)
	{
		for (int i = 0; i < display.getNumCols(); i++)
		{
			removeSquare(new Location(row, i));
		}
	
	}

	public void removeCompletedRows()
	{
		for (int i = 0; i < display.getNumRows(); i++)
		{
			if (isCompletedRow(i))
			{
				removeRow(i);
			}
		}
	
	}

	public static void main(String[] args)
	{
		Game game = new Game();		// Create an instance of this class
		game.play();				// Start playing the game we created
	}

}