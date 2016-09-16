import java.util.Scanner;
import java.util.Random;

public class TicketGenerator 
{
	public static void displayFirstNum() //Generating first four digits of Ticket Number
	{
		Random generator = new Random(); //Creating an object for generating a random number
		System.out.print(generator.nextInt(9) + 1); //Printing a random integer between 1 and 9
		for (int i = 1; i <= 3; i++)
		{
			System.out.print(generator.nextInt(10)); //Printing a random integer between 0 and 9 three times
		}
	}
	
	public static void displaySecondNum() //Generating the next three digits of Ticket Number
	{
		Random generator = new Random(); //An object for a random number
		for (int i = 1; i <= 3; i++)
		{
			System.out.print(generator.nextInt(10) / 2 * 2); //Generating a random even number between 0 and 8
		}
	}
	
	public static void displayValidationCode() //Generating the validation code
	{
		Random generator = new Random();
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 1; i <= 3; i++)
		{
			System.out.print(letters.charAt(generator.nextInt(26))); //Printing 3 random characters from the string
		}
	}
	
	public static void displayExpirationDate() //Generating an expiration date
	{
		Random generator = new Random();
		String months = "JANFEBMARAPRMAYJUNJULAUGSEPOCTNOVDEC";
		int num = generator.nextInt(12) + 1; //A random number between 1 and 12
		System.out.print(months.substring(num * 3 - 3, num * 3) + " 2010"); //Printing the 3 letters of the month
	}
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in); //Creating an object for reading input
		
		System.out.println("Please enter your first name:");
		String firstName = new String(scan.nextLine()); //Reading the first name
		
		System.out.println("Please enter your last name:");
		String lastName = new String(scan.nextLine()); //Reading the last name
		
		System.out.print("****************************************\n"
				+ "---- PITTSBURGH MUSEUM ENTRY TICKET ----\n"
				+ firstName.toUpperCase() + " " + lastName.toUpperCase()); //Printing the names in upper case
		System.out.println(); //Going to the next line
		System.out.print("Ticket Number: ");
		displayFirstNum();
		System.out.print("-" + firstName.toUpperCase().charAt(0) + "-"); //Printing the first letter of 'firstName'
		displaySecondNum();
		System.out.print("-" + lastName.toUpperCase().charAt(lastName.length() - 1)); //Printing the last letter 
		System.out.println(); //Going to the next line								    of 'lastName'
		System.out.print("Validation Code: ");
		displayValidationCode();
		System.out.println(); //New line
		System.out.print("Expires: ");
		displayExpirationDate();
		System.out.println(); //New line
		System.out.print("****************************************\n");
		
		scan.close();
	}

}
