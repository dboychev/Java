import java.util.Scanner;
import java.text.DecimalFormat;

public class CableTVBillCalculator 
{
	public static int computeBasic(boolean hasDVRBox)
	{
		if (!hasDVRBox)
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
		if (!hasDVRBox)
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
		if (!hasDVRBox)
		{
			if (numMovies > 4)
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
			if (numMovies > 4)
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
		Scanner scan = new Scanner(System.in);
		System.out.println("--Cable Service Menu--");
		System.out.println("BAS [Basic Cable]");
		System.out.println("FAM [Family Cable]");
		System.out.println("PLA [Platinum Cable]");
		System.out.print("Enter your menu choice: ");
		DecimalFormat fmt = new DecimalFormat("#.00");
		
		boolean DVRB = false;
		String DVRBox = "";
		
		String choice = scan.nextLine();
		if (!choice.equals("BAS") && !choice.equals("FAM") && !choice.equals("PLA"))
		{
			System.out.println("Cannot compute cable bill - unknown service type.");
		}
		
		else
		{
			System.out.print("Do you have a DVR Box? (YES/NO): ");
			DVRBox = scan.nextLine();
			if (!DVRBox.equals("YES") && !DVRBox.equals("NO"))
			{
				System.out.println("Warning: Using an answer of NO.");
			}
		}
		
		if (DVRBox.equals("YES"))
		{
			DVRB = true;
		}
		
		if (choice.equals("BAS"))
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
		
		scan.close();
	}

}
