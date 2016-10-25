import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WP6 
{
	public static int Sum(String fileName)
	{
		File name = new File (fileName); //An object for opening a file
		Scanner fileScan; //A scanner for reading a file
		
		try
		{
			fileScan = new Scanner(name); //The program reads the exact file which name was typed by the user
		}
		
		catch (FileNotFoundException e)
		{
			return 0; //If the file does not exist
		}
		
		
		int sum = 0;
		while (fileScan.hasNextLine()) //Until the end of the file
		{
			sum += (fileScan.nextInt()); //The file has one integer on every new line
		}
		
		fileScan.close();
		return sum;
	}
	
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter file name: "); //The user has to type the name of the file
		String fileName = scan.nextLine();
		
		System.out.println(Sum(fileName));

		scan.close();
	}

}
