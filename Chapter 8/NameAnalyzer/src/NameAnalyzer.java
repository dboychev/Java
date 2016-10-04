import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.text.DecimalFormat;

public class NameAnalyzer 
{
	public static final int MAX_NUM_OF_CHARS = 15; //Saving the maximum length of a name
	
	
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(System.in); //Creating an object for reading input
		
		String fileName; //The name of the file we have to open
		
		System.out.print("Input name of data file: ");
		fileName = scan.nextLine(); //Scanning the file

		//System.out.println(Arrays.toString(namesArr(readFile(fileName))));
		//System.out.println(Arrays.toString(rankArr(readFile(fileName))));
		System.out.println(graph(namesArr(readFile(fileName)))); //Printing the graph and most used names
		System.out.println(byLength(namesArr(readFile(fileName)), rankArr(readFile(fileName))));
		scan.close();
	}
		
	//Reading the file and saving all its text into a string
	public static String readFile(String fileName) throws IOException 
	{
		Scanner fileScan; //Creating an object for scanning the file
		
		String line = ""; //Saving each line 1 by 1
		String text = line;
		
		fileScan = new Scanner(new File(fileName)); //Scanning the file

		while (fileScan.hasNext()) //While there is still any text in the file
		{
			line = fileScan.nextLine(); //Going to the next line
			
			text += line + "\n"; //Saving the next line into 'text'
		}
		
		
		fileScan.close(); //Closing the scanner
		
		return text;
	}
	
	//Counting the number of all names in the file
	public static int numberOfNames(String text)
	{
		int number = 0; 
		
		for (int i = 0; i < text.length(); i++)
		{
			if (text.charAt(i) == '\n') //Each name is followed by a '\n' at the end of the row
			{							//so we are actually counting the new line symbols
				number++;
			}
		}
		
		return number;
	}
	
	//Creating an array with the names from the string 'text'
	public static String[] namesArr(String text) 
	{
		String[] names = new String[numberOfNames(text)]; //Creating the array
		
		int i = 0, j = 0; //'i' is for all the indexes of names in the array
		while (i < names.length)
		{
			int start = j; //'start' always points to the starting index of each substring
			while (text.charAt(j) != ' ') //Going through the letters of a name until it ends and there is a ' '
			{
				j++; //'j' points to the ending index of the substring
			}
			names[i] = text.substring(start, j); //Each element of the array is created from a substring of a line
			
			i++; //Going to the next element of the array
			while (text.charAt(j) != '\n') //Going to the next line of the text by passing '\n' once
			{
				j++;
			}
			j++;
		}
		
		return names;
	}
	
	//Creating an array with the rankings of the names
	public static int[] rankArr(String text)
	{
		int[] rank = new int[numberOfNames(text)]; //Creating the array
		
		int i = 0, j = 0; //'i' is for all the indexes of names in the array
		while (i < rank.length)
		{
			while (text.charAt(j) < '0' || text.charAt(j) > '9') //Going through the text until reach a number
			{
				j++;
			}
			
			int start = j; //'start' is for the starting index of the substring
			
			while (text.charAt(j) >= '0' && text.charAt(j) <= '9')
			{
				j++; //'j' is increasing until it reaches the first non-number symbol
			}
			rank[i] = Integer.parseInt(text.substring(start, j)); //Converting the substring into a number
			i++; //Going to the next element					  //and saving it into an element of the array
			j++;
		}
		
		return rank;
	}
	
	//Creating the graph of distribution of names
	public static String graph(String[] names)
	{
		String result = "DISTRIBUTION OF NAMES (Total = " + names.length + ")\n";
		DecimalFormat fmt = new DecimalFormat("0.###"); //Rounding to the third decimal

		int count = 0; //Counting the number of all names with that length

		double percent = 0; //Counting the percent that number represents of all the names
		for (int i = 1; i <= MAX_NUM_OF_CHARS; i++) //'i' for the different lengths of the names
		{
			count = 0; //For each different length names counting starts from 0
			for (int j = 0; j < names.length; j++) //Going through all the names
			{
				if (names[j].length() == i) //If the name has that length
				{
					count++;
				}
			}
			percent = 100 / ((double) names.length / count); //Counting the percentage
			
			result += "Length " + i + ":	|" + displayStars(percent) + fmt.format(percent) + "%\n";
		}
		
		return result;
	}
	
	public static String displayStars(double percent)
	{
		percent = (int) (percent + 0.5); //Rounding to an integer
		String result = "";

		for (int i = 0; i < percent; i++)
		{
			result += "*";
		}
		
		return result;
	}
	
	public static String byLength(String[] names, int[]counts)
	{
		String result = "MOST REPORTED NAMES BY LENGTH:\n";
		
		int min = names.length; //'min' is for the lowest number of rank (highest rank) of that length names
		int index = -1; //'index' should be the index of the highest rank name with that length
		for (int i = 1; i <= MAX_NUM_OF_CHARS; i++) //Checking the names with length from 1 to 15
		{
			min = names.length + 1; //'min' is bigger than all the ranks 
			index = -1; //'index' is not a valid index of the array
			for (int j = 0; j < names.length; j++) //Going through all the names
			{
				if (names[j].length() == i) //If the name is with length 'i'
				{
					if (counts[j] < min) //Finding the lowest rank number (highest ranking)
					{
						min = counts[j]; //'min' is the ranking number of the name
						index = j; //'index' is the index of the highest ranking number with that length
					}
				}
			}
			
			result += "Length " + i + ":	";
			if (index == -1)
			{
				result += "none"; //If there is not any name with that length
			}
			else
			{
				result += names[index];
			}
			result += "\n";
		}
		
		return result;
	}
}
