import java.util.Scanner;

public class PalindromeTester 
{
	public static boolean palindrome(String text)
	{
		//If the string contains only 1 symbol or all the others before reaching that state are equal
		if (text.length() <= 1)
		{
			return true;
		}
		
		else //Before reaching 'length' = 1
		{
			if (text.charAt(0) != text.charAt(text.length() - 1)) //If the first and the last symbols are different
			{
				return false;
			}
		}
		
		//Recall the string without its first and last symbols
		return palindrome(text.substring(1, text.length() - 1));
	}
	

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner (System.in); //Creating an object for reading input
		String another = "y"; //Creating a string for another try
		
		while (another.equals("y")) //While the user wants to try another string
		{
			System.out.print("Enter string: ");
			String text = scan.nextLine();
			
			if (palindrome(text))
			{
				System.out.println(text + " IS a palindrome!");
			}
			
			else
			{
				System.out.println(text + " IS NOT a palindrome!");
			}
		
			System.out.print("\nTest another palindrome? (y/n): "); //Asking the user
			another = scan.nextLine();
		}
		
		scan.close();
	}

}
