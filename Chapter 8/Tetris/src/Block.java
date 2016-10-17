public class Block
{
  private Grid display;
  private Color color;
  private Location[] locs;
  
  public Block(Grid grid)
  {
	display = grid;
    int shapeNum = (int)(Math.random() * 5);
    if (shapeNum == 0)
    {
    	// Magenta "stick"
    	locs = new Location[3];
    	locs[0] = new Location(0,4);
    	locs[1] = new Location(0,3);
    	locs[2] = new Location(0,5);
    	color = new Color(255, 0, 255);
    }
    else if (shapeNum == 1)
    {
    	// Yellow "corner"
    	locs = new Location[3];
    	locs[0] = new Location(0,4);
    	locs[1] = new Location(0,5);
    	locs[2] = new Location(1,4);
    	color = new Color(255, 255, 0);
    }
    
    else if (shapeNum == 2)
    {
    	//New figure - a square - white color
    	locs = new Location[4];
    	locs[0] = new Location(0,4);
    	locs[1] = new Location(0,5);
    	locs[2] = new Location(1,4);
    	locs[3] = new Location(1,5);
    	color = new Color(255, 255, 255);
    }
    
    else if (shapeNum == 3)
    {
    	//New figure - 4 blocks - grey color
    	locs = new Location[4];
    	locs[0] = new Location(0,4);
    	locs[1] = new Location(0,3);
    	locs[2] = new Location(0,5);
    	locs[3] = new Location(1,5);
    	color = new Color(127, 127, 127);    	
    }
    
    else
    {
    	// Cyan "T"
    	locs = new Location[4];
    	locs[0] = new Location(0,4);
    	locs[1] = new Location(0,3);
    	locs[2] = new Location(0,5);
    	locs[3] = new Location(1,4);
    	color = new Color(0, 255, 255);
    }
  }
  
  public boolean revealSelf() {
	  if (areValidAndEmpty(locs)) {
		  drawSelf(color);
		  return true;
	  }
	  return false;
  }
  
  public void drawSelf(Color color)
  {
	  //Setting the color the whole array containing the locations of a figure 
	  for (int i = 0; i < locs.length; i++)
	  {
		  display.setColor(locs[i], color);
	  }  
  }
  
  public boolean areValidAndEmpty(Location[] locs)
  {
	  boolean valid = true, empty = true; //Two boolean variables to show if the location is valid and empty
	  
	  Color black = new Color(0, 0, 0); //That is the grid default color

	  int i = 0;
	  while (valid && empty && i < locs.length)
	  {
		  if ((locs[i].getRow() < 0 || locs[i].getRow() >= display.getNumRows())
			  || (locs[i].getCol() < 0 || locs[i].getCol() >= display.getNumCols()))
		  {
			  valid = false;
		  }
		  
		  if (valid)
		  {
			  if (!(display.getColor(locs[i]).equals(black)))
			  {
				  empty = false;
			  }
		  }
		
		  i++;
	  }
		  
	  return (valid && empty);  // remove this instruction when you write this method
  }
  
  public boolean shift(int deltaRow, int deltaCol)
  {
	  boolean moved = false; //A boolean that shows if the block has moved
	  
	  Color black = new Color(0, 0, 0); //A color object for the black
	  
	  for (int i = 0; i < locs.length; i++)
	  {
		  display.setColor(locs[i], black); //Setting all the block's color to black
	  }
	  
	  Location[] newLocs = new Location[locs.length]; //Creating a new array for the blocks with their new positions
	  
	  for (int i = 0; i < locs.length; i++)
	  {
		  //The new array gets the old positions but with some changes
		  newLocs[i] = new Location (locs[i].getRow() + deltaRow, locs[i].getCol() + deltaCol);
	  }
	  
	  if (areValidAndEmpty(newLocs)) //Checking whether the block can be moved
	  {
		  for (int i = 0; i < locs.length; i++)
		  {
			  locs[i] = newLocs[i];		
		  }
		  
		  moved = true; //The block was successfully moved
	  }
	  
	  for (int i = 0; i < locs.length; i++)
	  {
		  display.setColor(locs[i], color); //Giving the figure its color again
	  }
	  
	  return moved;
  }

  public void rotate()
  {
	  Color black = new Color(0, 0, 0); //Object for the black color
	  
	  int row0 = locs[0].getRow();
	  int col0 = locs[0].getCol();
	  
	  for (int i = 0; i < locs.length; i++)
	  {
		  display.setColor(locs[i], black); //Setting the blocks of the figure to black 
	  }
	  
	  Location[] newLocs = new Location[locs.length]; //Creating a new object for the new positions
	  
	  for (int i = 0; i < locs.length; i++)
	  {
		  //Calculating the new locations by a formula
		  newLocs[i] = new Location (row0 + locs[i].getCol() - col0, col0 + row0 - locs[i].getRow());
	  }
	  
	  if (areValidAndEmpty(newLocs))
	  {
		  //If the figure can be rotated - the old array gets the new locations
		  for (int i = 0; i < locs.length; i++)
		  {
			  locs[i] = newLocs[i];		
		  }  
	  }
	  
	  for (int i = 0; i < locs.length; i++)
	  {
		  //Giving back the old color of the figure
		  display.setColor(locs[i], color);
	  }
  
  }
}