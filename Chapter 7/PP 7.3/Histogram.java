import java.util.Scanner;

public class Histogram {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in); //Creating an object for reading input
		Value[] values = //Creating an array of 'Value' objects
			{
					new Value(1, 10), new Value(11, 20),
					new Value(21, 30), new Value(31, 40),
					new Value(41, 50), new Value(51, 60),
					new Value(61, 70), new Value(71, 80),
					new Value(81, 90), new Value(91, 100)
			};
		
		int number = 0; //Our number
		while (number != -1)
		{
			int i = 0; //An index for the array of 'Value' objects
			if (number >= 1 && number <= 100)
			{
				while (number < values[i].getLowerBound() || number > values[i].getHigherBound())
				{
					i++;
				}
				
				values[i].increaseCount(); //Increasing the counter
			}
			number = scan.nextInt(); //Reading next integer
		}
		
		for (int i = 0; i < values.length; i++) //Printing the array
		{
			System.out.println(values[i]);
		}
		
		scan.close(); //Closing the scanner
	}	

}
