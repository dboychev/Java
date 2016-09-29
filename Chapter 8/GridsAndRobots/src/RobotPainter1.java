
public class RobotPainter1 
{

	public static void main(String[] args) 
	{
		Robot.load("floor.txt"); //Loading the map
		Robot.setDelay(50); //Setting a delay between execution of 'Robot' commands
		Robot.makeDark(); //Making dark the starting cell
		
		boolean finished = false; //'finished' variable - used to show if the whole map have been colored in dark
		
		int turns = 1; //Counting the turns on each row's last cell to get to the new uncolored row
	
		while (finished == false) //Checking if the whole map is already colored and whether the robot should stop
		{
			
			if (!Robot.frontIsClear()) //If the front cell is not clear (has a wall or is out of the map)
			{
				finished = true; //Always setting 'finished' = true at the beginning, then if there are more cells
				//to be colored its value changes to 'false'
				
				//'turns' is either 1, or 3. To turn left the robot needs 1 left turn; to turn right it needs 3 left
				//turns. When going to a new row it always has to turn to it, make a move and then turn the same
				//number of times again before making the new move. Going to two new rows are always made by 3 turns
				// + 1 turn on the next row or 1 turn + 3 turns on the next row, so when the robots gets to a new
				//row it always changes 'turns' value to the other one (if it was 3 to 1 and if it was 1 to 3)
				if (turns == 1)
				{
					Robot.turnLeft(); //Turning left to look to the first cell of the new row
 					if (Robot.frontIsClear()) //If it is not the last cell
					{
						Robot.move(); //Moving to the new row, coloring the first cell and turning to the new cell
						Robot.makeDark();
					
						Robot.turnLeft();
						turns = 3; //Next turn will be right
						finished = false; //Still not finished
					}
				}				
				
				else
				{
					while (turns != 0) //Turning 3 times left to execute a right turn
					{
						Robot.turnLeft();
						turns--;
					}
					
					if (Robot.frontIsClear()) //If it is not the last cell
					{
						Robot.move(); //Moving to the new row, coloring the first cell
						Robot.makeDark();
					
						turns = 3;
					
						while (turns != 0) //Turning to the next cell of the row (3 left turns = 1 right turn)
						{
							Robot.turnLeft();
							turns--;
						}
						
						Robot.move(); //Moving to the next cell and coloring it
						Robot.makeDark();
					
						turns = 1; //Next turn will be right
						finished = false; //Still not finished
					}
				}
				
			}
			
			if (!finished) //If the map is still not finished - moving ahead and coloring the cell
			{
				Robot.move();
				Robot.makeDark();
			}
		}	
		
	}

}
