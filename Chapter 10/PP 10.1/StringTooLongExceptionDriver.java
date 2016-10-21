import java.util.Scanner;

public class StringTooLongExceptionDriver 
{

	public static void main(String[] args) throws StringTooLongException
	{
		final int MAX = 20; //A constant value for maximum string length
		Scanner scan = new Scanner(System.in); //An object for reading input
		String words = ""; //A string where the text will be kept

		//An object for the exception
		StringTooLongException problem = new StringTooLongException("String entered is too long!");
		
		//A loop for entering strings until the string is 'DONE'
		while (!words.equals("DONE"))
		{
			System.out.print("Enter string: ");
			words = scan.nextLine();
			if (words.length() > 20) //If the string length is bigger than 20, the exception is thrown
			{
				throw problem;
			}
		}
		
		System.out.println("End of main method.");
		
		scan.close();
	}

}
