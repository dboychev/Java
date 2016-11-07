import javax.swing.*;

/**
 *  This class is an implementation of PDUserInterface
 *  that uses JOptionPane to display the menu of command choices. 
 */

public class PDGUI implements PDUserInterface {
	 
	 private PhoneDirectory directory;
	 
	 public PDGUI()
	 {
		 directory = null;
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
		 JFrame frame = null;
		 
		 do {
			 if (frame == null)
				 {
				 frame = new JFrame();
				 }
			 frame.setVisible(true);
			 frame.setLocation(800, 500);
			 frame.setAlwaysOnTop(true);
			 
			 choice = JOptionPane.showOptionDialog(frame,
					 "Select a command", 
					 "Phone Directory", 
					 JOptionPane.YES_NO_CANCEL_OPTION, 
					 JOptionPane.QUESTION_MESSAGE, 
					 null, 
					 commands,
					 commands[commands.length - 1]);
			 
			 switch (choice) {
			 	case 0: doAddChangeEntry(); break;
			 	case 1: doLookupEntry(); break;
			 	case 2: doRemoveEntry(); break;
			 	case 3:	doReverseEntries(); break;
			 	case 4: doSave(); break;
			 	default:  // do nothing
			 }
			 
		 } while (choice != commands.length-1);
		 System.exit(0);
	 }

	private void doReverseEntries() 
	{
		directory.reverseOrder();
		
		String message = "Order of directory entries reversed!";

		// Display confirmation message
		JOptionPane.showMessageDialog(null, message);
	}
	 
	private void doAddChangeEntry() {

		// Request the name
		String newName = JOptionPane.showInputDialog("Enter name");
		if (newName == null) {
			return;		// dialog was cancelled
		}
		
		// Request the number
		String newNumber = JOptionPane.showInputDialog("Enter number for " + newName);
		if (newNumber == null){
			return;		// dialog was cancelled
		}
		
		// Insert or change the number
		String oldNumber = directory.addOrChangeEntry(newName, newNumber);
		
		// Prepare confirmation message for dialog box
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
		JOptionPane.showMessageDialog(null, message);
		
	}
	
	private void doLookupEntry() {

		// Request the name
		String name = JOptionPane.showInputDialog("Enter name");
		if (name == null) {
			return;		// dialog was cancelled
		}
		
		// Look up the name
		String number = directory.lookupEntry(name);
		
		// Prepare confirmation message for dialog box
		String message = null;
		if (number != null) {
			message = "The number for " + name + " is " + number;
		} else {
			message = name + " is not listed in the directory";
		}
		// Display confirmation message
		JOptionPane.showMessageDialog(null, message);
			
	}
	
	private void doRemoveEntry() {

		// Request the name
		String name = JOptionPane.showInputDialog("Enter name");
		if (name == null) {
			return;		// dialog was cancelled
		}
		
		// Remove the entry if it is there
		String number = directory.removeEntry(name);
		
		// Prepare confirmation message for dialog box
		String message = null;
		if (number != null) {
			message = "The entry for " + name + " is removed";
		} else {
			message = name + " is not listed in the directory";
		}
		// Display confirmation message
		JOptionPane.showMessageDialog(null, message);
		
	}
	
	private void doSave() {
		
		directory.save();
		
	}
		
}
