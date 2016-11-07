import java.util.*;
import java.io.*;

/**
 *   Class that implements a collection of cable tv channels
 *   in an array. 
 */

/**
 * @author student1
 * @author student2
 */

/*
 * Analysis of search performance:
 * 
 * Number of maximum cells needed to be examined in a Linear Search is: 160
 * - Because the number for finding each of the element is equal to its index at the array + 1.
 * - Most cells examined would be needed for the last element to find: 159 + 1 = 160.
 * 
 * Number of maximum cells needed to be examined in a Binary Search is: 8
 * - Because the array can be split on two parts by its middle element at most 8 times before the low index gets
 * bigger than the high index.
 * 
 */


public class CableSystem 
{

	private Channel[] channelArray;
	private int numChannels;
	
	/**
	 * Initializes the cable system with the tv channels specified
	 * in the file given by the name in the parameter. The data in
	 * the file must be in increasing order by channel name,
	 * one channel per line: channel number followed by one space
	 * followed by the channel name.
	 * @param datafilename Name of file with cable tv channel data
	 */
	public CableSystem(String datafilename) 
	{
		
		Scanner filescan = null;
		try 
		{
			filescan = new Scanner(new File(datafilename));
		}
		
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found. Ending program.");
			System.exit(1);
		}

		numChannels = filescan.nextInt();
		filescan.nextLine();					// Why? - To read the other part of the line left and go to the next line 
		channelArray = new Channel[numChannels];
		for (int i = 0; i < numChannels; i++) 
		{
			int number = filescan.nextInt(); 
			String name = filescan.nextLine().substring(1); // Why substring(1)? - Because after reading the integer, the first symbol of the substring left
			//at the row is a blank space
			channelArray[i] = new Channel(number, name);
		}

	}
	
	/**
	 * Searches the cable system for the channel number
	 * given the channel name using linear search. Outputs
	 * the number of channels examined.
	 * @param channelName the name of the channel desired
	 * @return the number of the channel if the cable system has the channel name, -1 otherwise
	 */
	public int search1(String channelName) 
	{
		boolean found = false; //This variable shows us at the end of the method if the channel was found
		
		int i = 0; //Starting index
		int number = -1; //The variable, that will be returned, is initially set to -1
		
		for (i = 0; !found && i < numChannels; i++) //A for loop until the element is found or the search has ended
		{
			if (channelArray[i].getName().compareTo(channelName) == 0)
			{
				found = true; //Once that variable has changed its value, the loop ends
			}
		}
		
		System.out.println("Number of cells examined: " + i );
		
		if (found)
		{
			number = channelArray[i - 1].getNumber();
		}
		
		return number;
	}
	
	/**
	 * Searches the cable system for the channel number
	 * given the channel name using binary search. Outputs
	 * the number of channels examined.
	 * @param channelName the name of the channel desired
	 * @return the number of the channel if the cable system has the channel name, -1 otherwise
	 */
	public int search2(String channelName) 
	{
		boolean found = false; //This variable shows us at the end of the method if the channel was found
		
		//For each try we have a lower bound, an upper bound and a middle variable
		int low = 0; //Low is initially set to the first element's index
		int high = numChannels - 1; //High is initially set to the last element's index
		int middle = (high + low) / 2; //Middle is set to the middle index between high and low
		
		int i = 0; //That variable calculates the cells examined at the search
		int number = -1; //The variable, that will be returned, is initially set to -1
		
		while (!found && high >= low) //Until the element is found or all the elements have been examined
		{
			//If the middle element is what we are looking for
			if (channelArray[middle].getName().compareTo(channelName) == 0)
			{
				found = true;
			}
			
			//If the middle element's name is lexicographically smaller
			else if (channelArray[middle].getName().compareTo(channelName) < 0)
			{
				low = middle + 1;
			}
			
			//If the middle element's name is lexicographically greater			
			else
			{
				high = middle - 1;
			}
			
			if (!found) //If the element is still not found - the middle gets its new value
			{
				middle = (high + low) / 2;
			}
			
			i++;
		}
		
		System.out.println("Number of cells examined: " + i);
		
		if (found)
		{
			number = channelArray[middle].getNumber();
		}
		
		return number;
	}
	

	/**
	 * Returns the contents of the current cable system as a string.
	 * @return The string representation of the entire cable system.
	 */
	public String toString() 
	{

		StringBuilder sb = new StringBuilder();
		sb.append("numChannels = " + numChannels + "\n");
		for (int i = 0; i < channelArray.length; i++) {
			if (channelArray[i] != null)
				sb.append("channelArray[" + i + "] = " + channelArray[i].toString() + "\n");
			else
				sb.append("channelArray[" + i + "] = NULL\n");
		}
		return sb.toString();

	}
	
	// TESTING METHOD
	
	public static void main(String[] args) 
	{
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Input channel data file name: ");
		String filename = scan.nextLine();
		
		CableSystem fios = new CableSystem(filename);
		System.out.println("\nCABLE SYSTEM CHANNELS:");
		System.out.println(fios);		// calls toString implicitly
		
		System.out.println("\nTESTING LINEAR SEARCH:");

		for (int i = 1; i <= 5; i++) { 
			System.out.print("Enter a channel name: ");
			String channelName = scan.nextLine();
			int channelNumber = fios.search1(channelName);
			if (channelNumber != -1)
				System.out.println(channelName + " " + channelNumber);
			else
				System.out.println(channelName + " NOT FOUND");
		}

		System.out.println("\nTESTING BINARY SEARCH:");
		for (int i = 1; i <= 5; i++) { 
			System.out.print("Enter a channel name: ");
			String channelName = scan.nextLine();
			int channelNumber = fios.search2(channelName);
			if (channelNumber != -1)
				System.out.println(channelName + " " + channelNumber);
			else
				System.out.println(channelName + " NOT FOUND");
		}	
	}
	
}
