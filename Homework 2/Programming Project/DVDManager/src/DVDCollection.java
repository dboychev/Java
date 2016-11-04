import java.io.*;
import java.util.Scanner;

public class DVDCollection {

	// Data fields
	
	/** The current number of DVDs in the array */
	private int numdvds;
	
	/** The array to contain the DVDs */
	private DVD[] dvdArray;
	
	/** The name of the data file that contains dvd data */
	private String sourceName;
	
	/** Boolean flag to indicate whether the DVD collection was
	    modified since it was last saved. */
	private boolean modified;
	
	/**
	 *  Constructs an empty directory as an array
	 *  with an initial capacity of 7. When we try to
	 *  insert into a full array, we will double the size of
	 *  the array first.
	 */
	public DVDCollection() {
		numdvds = 0;
		dvdArray = new DVD[7];
	}
	
	/**
	 *Saves the information for each DVD from the array in a string variable, then prints it. 
	 **/
	public String toString() {
		// Return a string containing all the DVDs in the
		// order they are stored in the array along with
		// the values for numdvds and the length of the array.
		// See homework instructions for proper format.

		String result = "numdvds = " + numdvds + "\n";
		result += "dvdArray.length = " + dvdArray.length + "\n";
		for (int i = 0; i < numdvds; i++)
		{
			result += "dvdArray[" + i + "] = " + dvdArray[i].toString() + "\n";
		}

		return result;
	}

	/**
	 * Used to add or modify a DVD. If the @title is found in the array, then this method modifies its rating and
	 * running time (if they are valid). If it is not in the array, then a new array element is created and added
	 * with the typed @title, @rating and @runningTime.
	 * 
	 * @param title - the title we want to add or modify
	 * @param rating - the rating we want to set to it
	 * @param runningTime - the running time we want to set to it
	 */
	public void addOrModifyDVD(String title, String rating, String runningTime) 
	{
		// NOTE: Be careful. Running time is a string here
		// since the user might enter non-digits when prompted.
		// If the array is full and a new DVD needs to be added,
		// double the size of the array first.
	
		boolean valid = true; //A variable that shows if the typed Rating and Running Time have correct typed values
		
		for (int i = 0; i < runningTime.length() && valid; i++)
		{
			//This loop checks whether the 'runningTime' string is correct (numeric)
			if (runningTime.charAt(i) < '0' || runningTime.charAt(i) > '9') //If one of its symbols is not a digit
			{
				valid = false;
			}
		}
		
		//If running time is a non-positive number, that is also an incorrect value
		if (Integer.parseInt(runningTime) < 1)
		{
			valid = false;
		}
		
		if (!rating.equals("G") && !rating.equals("PG") && !rating.equals("PG-13") 
				&& !rating.equals("R") && !rating.equals("NC-17"))
		{
			//This if-statement checks whether the 'rating' is one of the allowed values
			valid = false;
		}
		
		if (valid) //If values are valid - continue with modifying/adding
		{
			boolean add = true; //This variable shows whether we should add a new DVD or not (if not - modify)
			int index = 0; //'index' is used to show the suitable index of a new element or of an already saved one
			
			for (int i = 0; i < numdvds && add; i++)
			{
				//This loop does a check for the value of 'add'
				if (dvdArray[i].getTitle().equals(title))
				{
					//Once an element with the same title is found, 'add' becomes 'false', loop is over
					add = false;
					//and 'index' shows where our DVD is
					index = i;
				}
			}
			
			if (add) //If 'add' is still 'true', it means the title was not found at the array and we have to add it
			{
				if (numdvds == dvdArray.length) //This check shows if we have to resize the array because it is full
				{
					//A new array is created with twice the size of the old one
					DVD[] newDvdArray = new DVD[dvdArray.length * 2];
					//Save all the values from the old array at the new one
					for (int i = 0; i < numdvds; i++)
					{
						newDvdArray[i] = dvdArray[i];
					}
					
					//Now the old array is the same as before but with twice bigger size
					dvdArray = newDvdArray;
				}
				
				//Now we have to find the correct place of the new DVD in the sorted collection
				while (index < numdvds && title.compareTo(dvdArray[index].getTitle()) >= 0)
				{
					//Every time we go through a title lexicographically less than ours, index increases
					index++;
				}
				
				//Now we shift all the elements from the needed index to the end with 1 place
				for (int i = numdvds; i > index; i--)
				{
					dvdArray[i] = dvdArray[i - 1];
				}
				
				//The new DVD is being positioned at the correct place
				dvdArray[index] = new DVD(title, rating, Integer.parseInt(runningTime));
				
				//The number of the DVDs in the collection is increased
				numdvds++;
			}
			
			else //If the title was found in the array and we just have to modify its rating and running time
			{
				dvdArray[index].setRating(rating);
				dvdArray[index].setRunningTime(Integer.parseInt(runningTime));
			}
		}
		
		modified = true;
	}
	
	
	/**
	 * This method checks if the array contains an element with that @title. If it does - we remove it from the
	 * array and decrease the number of DVDs with one.
	 * 
	 * @param title - the title we are looking for in the array
	 */
	public void removeDVD(String title) 
	{
		int index = 0; //This 'index' is used to find what is the index of the element, we need to remove
		boolean found = false; //'found' stands for showing if the collection contains the title we are looking for
		
		while (!found && index < numdvds) //Until all the elements are gone through or the title is found
		{
			if (dvdArray[index].getTitle().equals(title)) //If title is found
			{
				found = true;
			}
			
			else //If that index' title is not what we are looking for
			{
				index++;
			}
		}
		
		if (found) //If the title was found in the collection - remove it
		{
			dvdArray[index] = null; //Removing the element
			if (index < numdvds - 1) //If it is not the last element, we have to shift the other 1 place forward
			{
				int i = index; 
				while (dvdArray[i] != null || i == index)
				{
					dvdArray[i] = dvdArray[++i];
				}
			}
			
			numdvds--; //Decreasing the number of DVDs
		}
	}
	
	/**
	 * This method goes through the whole array and saves into a string variable all the DVDs with that @rating.
	 * 
	 * @param rating - the rating we are looking for in the array
	 * @return - the string result with all suitable DVDs in it 
	 */
	public String getDVDsByRating(String rating) 
	{
		String result = "";
		
		for (int i = 0; i < numdvds; i++) //Here we create a loop for going through all the DVDs
		{
			if (dvdArray[i].getRating().equals(rating)) //If one with the suitable rating is found, we add it to the string
			{
				result += dvdArray[i].toString() + "\n";
			}
		}
		
		return result;
	}

	/**
	 * This method calculates all the DVDs' running time in one variable.
	 * 
	 * @return - an integer with the running times summed up in it
	 */
	public int getTotalRunningTime() 
	{
		int total = 0; //An integer for the sum of running times of all DVDs
		
		for (int i = 0; i < numdvds; i++)
		{
			total += dvdArray[i].getRunningTime();
		}

		return total;
	}

	/**
	 * Here the data from a file which name we have typed is loaded and read.
	 * 
	 * @param filename - the name of a txt file
	 */
	public void loadData(String filename) 
	{
		sourceName = filename; 
		
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(sourceName)); //An object to open the file
			Scanner scan = new Scanner(in).useDelimiter(",|\n|\r"); //A scanner for better reading the file
			String title, rating, runningTime; //Local helper variables for easier saving each DVD
			
			while (scan.hasNext()) //While the file still has any unread text left
			{
				title = scan.next(); //Reading the title
				rating = scan.next(); //Reading the rating
				runningTime = scan.next(); //Reading the running time
				scan.next(); //Reading the symbols left to the next title
				
				addOrModifyDVD(title, rating, runningTime); //Add or modify this DVD
			}
			
			in.close();
			scan.close();
		}
		
		//Handling the exceptions
		catch (FileNotFoundException e) 
		{
			return;
		}
		
		catch (IOException e)
		{
			System.out.println("Load of directory failed.");
			e.printStackTrace();
			System.exit(1);
			return;
		}		
	}
	
	
	/**
	 * This method saves the new content of the array to the txt file, if the array was modified.
	 */
	public void save() 
	{
		if (modified) //If the array was modified 
		{
			try 
			{
				//Create PrintWriter for saving the txt file
				PrintWriter out = new PrintWriter(new FileWriter(sourceName));
				
				//Saving each element of the array in a specific format
				for (int i = 0; i < numdvds; i++)
				{
					out.println(dvdArray[i].getTitle() + "," + dvdArray[i].getRating()
							+ "," + dvdArray[i].getRunningTime());
				}
				
				//Close the file and reset modified
				out.close();
				modified = false;
			} 
			
			//Handling the exception
			catch (Exception e) 
			{
				System.err.println("Save of directory failed");
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	// Additional private helper methods go here:	
}
