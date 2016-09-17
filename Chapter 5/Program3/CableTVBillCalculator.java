import java.util.Scanner;
import java.text.DecimalFormat;

public class CableTVBillCalculator 
{
	public static int computeBasic(boolean hasDVRBox)
	{
		if (!hasDVRBox) //If there is no DVRBox
		{
			return 3500;
		}
		
		else
		{
			return (int) (3500 * 1.1);
		}
	}
	
	public static int computeFamily(int premiumChannels, boolean hasDVRBox)
	{
		if (!hasDVRBox)  //If there is no DVRBox
		{
			return 5000 + premiumChannels * 799; 
		}
		
		else
		{
			return (int) (1.1 * (5000 + premiumChannels * 799));
		}
	}
	
	public static int computePlatinum(int premiumChannels, int numMovies, boolean hasDVRBox)
	{
		if (!hasDVRBox)  //If there is no DVRBox
		{
			if (numMovies > 4) //If pay-per-view movies are more than 4
			{
				return 7250 + premiumChannels * 549 + 4 * 499 + (numMovies - 4) * 249; 
			}
			
			else
			{
				return 7250 + premiumChannels * 549 + numMovies * 499;
			}
		}
		
		else
		{
			if (numMovies > 4) //If pay-per-view movies are more than 4
			{
				return (int) (1.1 * (7250 + premiumChannels * 549 + 4 * 499 + (numMovies - 4) * 249)); 
			}
		
			else
			{
				return (int) (1.1 * (7250 + premiumChannels * 549 + numMovies * 499));
			}
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in); //Creating an object for reading input
		System.out.println("--Cable Service Menu--");
		System.out.println("BAS [Basic Cable]");
		System.out.println("FAM [Family Cable]");
		System.out.println("PLA [Platinum Cable]");
		System.out.print("Enter your menu choice: ");
		DecimalFormat fmt = new DecimalFormat("#.00"); //Creating an object for formatting the price number
		
		boolean DVRB = false; //A boolean that says if the user has a DVRBox
		String DVRBox = ""; //A string that says if the user has a DVRBox
		
		String choice = scan.nextLine();
		if (!choice.equals("BAS") && !choice.equals("FAM") && !choice.equals("PLA")) //If the input is invalid
		{
			System.out.println("Cannot compute cable bill - unknown service type.");
		}
		
		else
		{
			System.out.print("Do you have a DVR Box? (YES/NO): "); //Asking the user if he has a DVR Box
			DVRBox = scan.nextLine();
			if (!DVRBox.equals("YES") && !DVRBox.equals("NO")) //If answer is neither 'YES', nor 'NO'
			{
				System.out.println("Warning: Using an answer of NO.");
			}
		}
		
		if (DVRBox.equals("YES"))
		{
			DVRB = true; //Changing the value of DVRB boolean if the answer is 'YES'
		}
		
		if (choice.equals("BAS")) //Computing the bill of the user depending on the service
		{	
			System.out.println("Your cable bill is $" + fmt.format((float)computeBasic(DVRB) / 100));
		}
		
		if (choice.equals("FAM"))
		{
			System.out.print("Enter the number of premium channels received: ");
			int premium = scan.nextInt();
			System.out.println("Your cable bill is $" + fmt.format((float)computeFamily(premium, DVRB) / 100));
		}
		
		if (choice.equals("PLA"))
		{
			System.out.print("Enter the number of premium channels received: ");
			int premium = scan.nextInt();
			System.out.print("Enter the number of pay-per-view movies purchased: ");
			int ppviews = scan.nextInt();
			System.out.println("Your cable bill is $" + fmt.format((float)computePlatinum(premium, ppviews, DVRB) / 100));
		}
		
		scan.close(); //Closing the scanner
	}

}
