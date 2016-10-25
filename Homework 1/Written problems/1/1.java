import java.util.Scanner;

public class WP 
{
	public static String unique(String str1, String str2)
	{
		String result = ""; //The string that will be returned at the end of the function
		
		//Counters for each of the strings' symbols
		for (int i = 0; i < str1.length(); i++) 
		{
			for (int j = 0; j < str2.length(); j++)
			{
				//A check whether the combination of the symbols of 'str1' and 'str2' is already written
				if (! (result.contains("" + str1.charAt(i) + str2.charAt(j))))
				{
					//If not - save it to the string
					result += "" + str1.charAt(i) + str2.charAt(j) + " ";
				}
			}
		}
		
		return result;
	}
	
	

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter string 1: ");
		String str1 = scan.nextLine();
		
		System.out.print("Enter string 2: ");		
		String str2 = scan.nextLine();
		
		System.out.println(unique(str1, str2));		
		
		scan.close();
	}

}
