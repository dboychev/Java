import java.util.Scanner;

public class PrintString 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner (System.in); //Creating Scanner object for reading the input
		System.out.print("Enter string: "); //Printing an "Enter string: " message
		String str = scan.nextLine(); //Creating a string 'str', assigning the input to it
		
		for (int i = 0; i < str.length(); i++) //A loop from 0 to the number of the length of 'str'
		{
			System.out.println(str.charAt(i)); //Printing each character of 'str'
		}
		scan.close(); //Closing the scanner
	}

}
