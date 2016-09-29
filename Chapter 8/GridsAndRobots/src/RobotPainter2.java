
public class RobotPainter2 
{

	public static void main(String[] args)
	{
		Robot.load("floor.txt"); //Loading the map
		Robot.setDelay(50); //Setting a delay between execution of 'Robot' commands
		Robot.makeDark(); //Making dark the starting cell
		
		int rowCounter = 0, colCounter = 0; //Counting the rows and columns
		
		while (Robot.frontIsClear()) //By moving the robot ahead we get the number of the columns
		{
			Robot.move();
			Robot.makeDark();
			colCounter++;
		}
		
		Robot.turnLeft(); //Turning the robot left
		
		while (Robot.frontIsClear()) //By moving ahead here we get the number of the rows
		{
			Robot.move();
			Robot.makeDark();
			rowCounter++;
		}
		
		while (rowCounter > 0 && colCounter > 0) //Until the moment one of these variable gets 0
		{
			Robot.turnLeft(); //Moving the robot ahead, then turning it left and decrementing the 'colCounter'
			for (int i = 0; i < colCounter; i++)
			{
				Robot.move();
				Robot.makeDark();
			}
			colCounter--;

			Robot.turnLeft(); //Moving the robot ahead, then turning it left and decrementing the 'rowCounter'
			for (int j = 0; j < rowCounter - 1; j++)
			{
				Robot.move();
				Robot.makeDark();
			}
			rowCounter--;
		}
	}
}
