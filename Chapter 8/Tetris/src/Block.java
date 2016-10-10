public class Block
{
  private Grid display;
  private Color color;
  private Location[] locs;
  
  public Block(Grid grid)
  {
	display = grid;
    int shapeNum = (int)(Math.random() * 3);
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
	  
	  
	  
	  /*for (int i = 0; i < locs.length; i++)
	  {
		  //Checking if the location is valid (is in the grid)
		  if ((locs[i].getRow() > display.getNumRows() - 1 || locs[i].getRow() < 0) 
				  || (locs[i].getCol() > display.getNumCols() - 1 || locs[i].getCol() < 0))
		  {
			  valid = false; //If there is one cell from the figure that is not valid, the figure is not valid
		  }
		  
		  //Checking if the location is empty (cells should be black)
		  if (valid)
		  {
			  if (!(display.getColor(locs[i]).equals(black)))
			  {
				  empty = false; //If there is one cell from the figure that is not empty, the figure cannot be shifted
			  }
		  }
	  }*/
	  
	  return (valid && empty);  // remove this instruction when you write this method
  }
  
  public boolean shift(int deltaRow, int deltaCol)
  {
	  boolean moved = false;
	  
	  Color black = new Color(0, 0, 0);
	  
	  for (int i = 0; i < locs.length; i++)
	  {
		  display.setColor(locs[i], black);
	  }
	  
	  Location[] newLocs = new Location[locs.length];
	  
	  for (int i = 0; i < locs.length; i++)
	  {
		  newLocs[i] = new Location (locs[i].getRow() + deltaRow, locs[i].getCol() + deltaCol);
	  }
	  
	  if (areValidAndEmpty(newLocs))
	  {
		  for (int i = 0; i < locs.length; i++)
		  {
			  locs[i] = newLocs[i];		
		  }
		  
		  moved = true;
	  }
	  
	  for (int i = 0; i < locs.length; i++)
	  {
		  display.setColor(locs[i], color);
	  }
	  
	  return moved;  // remove this instruction when you write this method
  }

  public void rotate()
  {
	  Color black = new Color(0, 0, 0);
	  
	  int row0 = locs[0].getRow();
	  int col0 = locs[0].getCol();
	  
	  for (int i = 0; i < locs.length; i++)
	  {
		  display.setColor(locs[i], black);
	  }
	  
	  Location[] newLocs = new Location[locs.length];
	  
	  for (int i = 0; i < locs.length; i++)
	  {
		  newLocs[i] = new Location (row0 + locs[i].getCol() - col0, col0 + row0 - locs[i].getRow());
	  }
	  
	  if (areValidAndEmpty(newLocs))
	  {
		  for (int i = 0; i < locs.length; i++)
		  {
			  locs[i] = newLocs[i];		
		  }  
	  }
	  
	  for (int i = 0; i < locs.length; i++)
	  {
		  display.setColor(locs[i], color);
	  }
  
  }
}