import java.util.*;

/**
 *  This class is an implementation of PDUserInterface
 *  that uses the console to display the menu of command choices
 */


public class PDConsoleUI implements PDUserInterface {
	
	private PhoneDirectory directory;
	private Scanner scan;
	
	public PDConsoleUI() {
		directory = null;
		scan = new Scanner(System.in);
	}
	
	public void processCommands(PhoneDirectory dir)
	{
		 String[] commands = {"Add/Change Entry",
	 			  "Look Up Entry",
	 			  "Remove Entry",
	 			  "Reverse Entries",
	 			  "Save Directory",
	 			  "Exit"};

		 directory = dir;
		 int choice;
		 
		 do {
			 for (int i = 0; i < commands.length; i++) {
				 System.out.println("Select " + i + ": " + commands[i]);
			 }
			 try {
				 choice = scan.nextInt();
				 scan.nextLine();
				 switch (choice) {
				 	case 0: doAddChangeEntry(); break;
				 	case 1: doLookupEntry(); break;
				 	case 2: doRemoveEntry(); break;
				 	case 3:	doReverseEntries(); break; 
				 	case 4: doSave(); break;
				 	default:  System.out.println("INVALID CHOICE - TRY AGAIN");
				 }
			 } catch (InputMismatchException e) {
				 System.out.println("INVALID CHOICE - TRY AGAIN");
				 scan.nextLine();
				 choice = -1;
			 }	 
		 } while (choice != commands.length-1);
//		 System.exit(0);
	}
	
	private void doReverseEntries() 
	{
		directory.reverseOrder();
		
		System.out.println("Order of directory entries reversed!");
	}

	private void doAddChangeEntry() {
		// Request the name.
		System.out.println("Enter name:");
		String newName = scan.nextLine();
		if (newName.equals("")) {
			return;
		}
		
		// Request the number.
		boolean validNumber = false;
		String newNumber = "";
		while (!validNumber)
		{
			System.out.println("Enter number:");
			newNumber = scan.nextLine();
			
			validNumber = true;
			if (newNumber.length() != 10)
			{
				validNumber = false;
			}
			
			else
			{
				for (int i = 0; i < newNumber.length(); i++)
				{
					if (newNumber.charAt(i) < '0' || newNumber.charAt(i) > '9')
					{
						validNumber = false;
					}
				}
			}
		}
		
		if (newNumber.equals("")) {
			return;
		}
		
		// Insert/change name-number.
		String oldNumber = directory.addOrChangeEntry(newName, newNumber);

		// Prepare confirmation message for console
		String message = null;
		if (oldNumber == null) {
			message = newName + " was added to the directory"
						+ "\nNew number: " + newNumber;
		} else {
			message = "Number for " + newName + " was changed "
						+ "\nOld number: " + oldNumber 
						+ "\nNew number: " + newNumber;
		}

		// Display confirmation message
		System.out.println(message);
		
	}
	
	private void doLookupEntry() {
		
		// Request the name
		System.out.println("Enter name:");
		String name = scan.nextLine();
		if (name.equals("")) {
			return;		// dialog was cancelled
		}
		
		// Look up the name
		String number = directory.lookupEntry(name);
		
		// Prepare confirmation message for console
		String message = null;
		if (number != null) {
			message = "The number for " + name + " is " + number;
		} else {
			message = name + " is not listed in the directory";
		}
		// Display confirmation message
		System.out.println(message);
		
	}
	
	private void doRemoveEntry() {

		// Request the name
		System.out.println("Enter name:");
		String name = scan.nextLine();
		if (name.equals("")) {
			return;		// dialog was cancelled
		}
		
		// Remove the entry if it is there
		String number = directory.removeEntry(name);
		
		// Prepare confirmation message for console
		String message = null;
		if (number != null) {
			message = "The number for " + name + " is removed";
		} else {
			message = name + " is not listed in the directory";
		}
		// Display confirmation message
		System.out.println(message);
	}
	
	private void doSave() {
		directory.save();
	}	
	
}
