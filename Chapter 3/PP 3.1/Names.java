import java.util.Scanner;
import java.util.Random;

public class Names 
{

	public static void main(String[] args) 
	{
		Random generator = new Random();
		Scanner scan = new Scanner(System.in);
		String firstName, lastName;
		
		System.out.print("First name: ");
		firstName = scan.next();
		
		System.out.print("Last name: ");
		lastName = scan.next();
		while (lastName.length() < 5)
		{
			System.out.println("Last name too short! Try again!");
			System.out.print("Last name: ");
			lastName = scan.next();
		}
		
		String newString = firstName.charAt(0) + lastName.substring(0, 5) + (generator.nextInt(90) + 10);
	
		System.out.println(newString);
	
		scan.close();
	}

}
