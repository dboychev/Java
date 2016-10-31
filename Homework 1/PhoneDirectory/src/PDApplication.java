import java.util.*;

/**
 * 	Program to display and modify a simple phone directory
 */

public class PDApplication {

	public static void main(String[] args) 
	{

		Scanner scan = new Scanner(System.in);
		
		PhoneDirectory pd = new PhoneDirectory();
		pd.loadData("phonedata.txt");
		
		PDUserInterface pdInterface;
		System.out.println("Would you like the GUI interface? (y/n)?");
		String response = scan.nextLine().toLowerCase();
		if (response.length() > 0 && response.charAt(0) == 'y')
				pdInterface = new PDGUI();
		else
				pdInterface = new PDConsoleUI();

		pdInterface.processCommands(pd);
		
		scan.close();
		
		
	}

}
