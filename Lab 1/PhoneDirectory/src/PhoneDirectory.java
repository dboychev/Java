import java.io.*;

public class PhoneDirectory {

	// Data fields
	
	/** The current number of entries in the array */
	private int numEntries;
	
	/** The array to contain the directory data */
	private DirectoryEntry[] directoryArray;
	
	/** The name of the data file that contains directory data */
	private String sourceName;
	
	/** Boolean flag to indicate whether the directory was
	    modified since it was either loaded or saved. */
	private boolean modified;
	
	/**
	 *  Constructs an empty directory as an array
	 *  with an initial capacity of 10.
	 */
	public PhoneDirectory() {
		numEntries = 0;
		directoryArray = new DirectoryEntry[10];
	}
	
	public void loadData(String sourceName) {
		this.sourceName = sourceName;
		try {
			// Create a BufferedReader for the file
			BufferedReader in = new BufferedReader(new FileReader(sourceName));
			String name;
			String number;
			
			// Read each name and number and add the entry to the array
			while ((name = in.readLine()) != null) {
				// Read name and number from successive lines
				if ((number = in.readLine()) == null) {
					break;	// no number for name, exit loop
				}
				// Add an entry for this name and number
				add(name, number);
			}
			
			// Close the file
			in.close();
		} catch (FileNotFoundException e) {
			// Do nothing - no data to load
			return;
		} catch (IOException e) {
			System.err.println("Load of directory failed.");
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	
	public String addOrChangeEntry(String name, String number) {
		String oldNumber = null;
		int index = find(name);
		if (index > -1) {
			oldNumber = directoryArray[index].getNumber();
			directoryArray[index].setNumber(number);
		} else {
			add(name, number);
		}
		modified = true;
		
		System.out.print(getDirectory(directoryArray));
		
		return oldNumber;
	}
	
	public String lookupEntry(String name) {
		int index = find(name);
		if (index > -1) {
			return directoryArray[index].getNumber();
		} else {
			return null;
		}
	}
	
	public String removeEntry(String name) {
		if (find(name) != - 1) //If the that name exists at the remove entries
		{	
			String number = directoryArray[find(name)].getNumber(); //Its number is saved here
		
			//All entries left after that one are moved one place forward
			for (int i = find(name); i < directoryArray.length - 1; i++)
			{
				directoryArray[i] = directoryArray[i + 1];
			}
			
			//The last one is deleted
			directoryArray[directoryArray.length - 1] = null;
			numEntries--;
		
			return number;
		}

		return null;	
	}
	
	public void save() {
		if (modified) {
			try {
				// Create PrintWriter for the file
				PrintWriter out = new PrintWriter(new FileWriter(sourceName));
				
				// Write each directory entry to the file
				for (int i = 0; i < numEntries; i++) {
					out.println(directoryArray[i].getName());
					out.println(directoryArray[i].getNumber());
				}
				
				// Close the file and reset modified
				out.close();
				modified = false;
			} catch (Exception e) {
				System.err.println("Save of directory failed");
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	// Private helper method to add the given name and number
	// to the phone directory in the next available position in
	// the array. If the array is full, the array is reallocated
	// to twice its size using the reallocate method.
	private void add(String name, String number) {
		if (numEntries >= directoryArray.length) {
			reallocate();
		}
		directoryArray[numEntries] = new DirectoryEntry(name, number);
		numEntries++;
	}

	private void reallocate() {
		DirectoryEntry[] newArray = new DirectoryEntry[directoryArray.length*2];
		System.arraycopy(directoryArray, 0, newArray, 0, directoryArray.length);
		directoryArray = newArray;
	}

	// Private helper method to find the index in the array of
	// the directory entry that contains the given name
	// or -1 if not found	
	private int find(String name) {
		for (int i = 0; i < numEntries; i++) {
			if (directoryArray[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;		// if loop does find a match, return -1 to mean 'not found'
	}
	
	private String getDirectory(DirectoryEntry[] directoryArray)
	{
		String result = "";
	
		//A helper function that prints all the names and numbers
		for (int i = 0; i < directoryArray.length; i++)
		{
			if (directoryArray[i] != null)
			{
				result += directoryArray[i].getName() + " / " + directoryArray[i].getNumber() + "\n";
			}
		}
		
		return result;
	}
	
	public void reverseOrder()
	{
		DirectoryEntry temp = new DirectoryEntry("", "");
		
		int size = 0;
		
		//Calculating the number of directory entries
		while (directoryArray[size] != null)
		{
			size++;
		}
		
		//Reversing them by swapping one from the beginning with one from the end
		for (int i = 0; i < size / 2; i++)
		{
			temp = directoryArray[i];
			directoryArray[i] = directoryArray[size - i - 1];
			directoryArray[size - i - 1] = temp;
		}
	}
}
