import java.util.Scanner;

public class PP 
{	
	public static String encrypt(char[][] arr, String text)
	{
		String result = "";
		
		int index = 0; //This variable is used for going through the string
		int size = text.length(); //This variable is used for searching for non-letter symbols in the string
		
		for (int i = 0; i < text.length(); i++)
		{

			//If a symbol is a non-alphabetical one, it is removed
			while (i < size && (text.charAt(i) < 'A' || text.charAt(i) > 'Z') && text.charAt(i) != ' ')
			{
				text = text.substring(0, i) + text.substring(i + 1, text.length());
				size--; //It decreases when a symbol is removed
			}
		}
		
		text = new String(text.toUpperCase()); //Here 'text' is set to be with UPPER CASE letters only
		
		System.out.println(text); //The first version of the keyword (not sorted by symbols) is printed
		
		while (index < text.length()) //Going through the string
		{
			if (text.charAt(index) >= 'A' && text.charAt(index) <= 'Y')
			{
				for (int i = 0; i < arr.length; i++)
				{
					for (int j = 0; j < arr[0].length; j++)
					{
						if (text.charAt(index) == arr[i][j])
						{
							result += i + "" + j; //To result is added the suitable number combination of the letter
						}
					}
				}
			}
			
			else if (text.charAt(index) == 'Z') //If the letter is 'Z' it takes "Q"'s number from the array
			{
				result += 31 + "";
			}
			
			else //If the next symbol is not a letter, but a blank space, a blank space is added
			{
				result += " ";
			}
			
			index++;
		}
		
		System.out.println(result); //Here the first numeric combination of the string is printed
		
		return result;
	}
	
	public static String[][] grid(String keyWord, String text, char[][] arr)
	{
		//The grid with the numbers is being created:
		
		int columns = keyWord.length(); //Number of columns is equal to the length of the key word
		int size = 0;
		int index = 0;
		
		String encrypted = encrypt(arr, text); //Here we get the encrypted numeric combination of the string
		
		while (index < encrypted.length()) //Going through the combination symbol by symbol
		{
			if (encrypted.charAt(index) != ' ')
			{
				size++; //Getting the size of the combination without the non-numeric symbols (ex. blank spaces)
			}
			
			index++;
		}
		
		int rows = size / columns; 
		//Number is rows is calculated by checking how many symbols we have to write in the grid and how many rows
		//we would need for all of them if the number of columns is already calculated
		
		//If the rows are not enough and we need to have a new row (not a full one) to store another symbol left
		if (size % columns != 0)
		{
			rows++;
		}
		
		String[][] grid = new String[rows][columns];
		
		//This variable is used to prevent saving non-numeric symbols at the grid, it counts symbols of that kind
		int buffer = 0;
		
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				if (i * columns + j + buffer >= encrypted.length())
				{
					//If we have gone through the whole string, the empty spaces, left at the grid, are filled with blanks
					grid[i][j] = " ";
				}
				
				else
				{
					if (encrypted.charAt(i * columns + j + buffer) == ' ')
					{
						//Next symbol is a blank space, it must not be saved and 'buffer' should be increased
						buffer++;
					}
					
					//Saving the elements to the next empty position
					grid[i][j] = "" + encrypted.charAt(i * (columns) + j + buffer);
				}				
			}
		}
		
		System.out.println(printKW(keyWord));
		System.out.println(printGrid(grid));
	
		
		return grid;
	}
	
	public static String arrangeGrid(String keyWord, String text, char[][] arr)
	{
		String[][] arrGrid = grid(keyWord, text, arr);
		
		//Sorting the key word's symbols and rearranging the grid after that 
		for (int i = 0; i < keyWord.length(); i++)
		{
			for (int j = i + 1; j < keyWord.length(); j++)
			{
				if (keyWord.charAt(i) > keyWord.charAt(j))
				{
					char c1 = keyWord.charAt(i);
					char c2 = keyWord.charAt(j);
					
					swapArr(i, j, arrGrid);
					keyWord = keyWord.substring(0, i) + c2 + keyWord.substring(i + 1, j) + c1 + keyWord.substring(j + 1, keyWord.length());
				}
			}
		}

		String result = "";
		
		for (int i = 0; i < arrGrid[0].length; i++)
		{
			for (int j = 0; j < arrGrid.length; j++)
			{
				if (arrGrid[j][i] != " ")
				{
					result += arrGrid[j][i];
				}
			}
			
			//Saving the combination of numbers to a string
			result += " ";
		}
		
		System.out.println(printKW(keyWord));
		System.out.println(printGrid(arrGrid));
		
		return result;
	}
	
	public static void swapArr(int r1, int r2, String[][] arr)
	{
		//A helper function - with it we swap the columns of the grid, when the key word is being sorted
		
		String[] temp = new String[arr.length];
		
		for (int i = 0; i < temp.length; i++)
		{
			temp[i] = arr[i][r1];
			arr[i][r1] = arr[i][r2];
			arr[i][r2] = temp[i];
		}
	}
	
	public static boolean validKW(String keyWord)
	{
		//A function that checks if the type key word is valid
		
		boolean valid = true;
		
		if (keyWord.length() < 1) //If nothing is typed, the user should try again
		{
			valid = false;
		}
		
		else //If the key word contains a non-alphabetical symbol, it is invalid
		{			
			for (int i = 0; i < keyWord.length() - 1; i++)
			{
				if (keyWord.charAt(i) < 'A' || keyWord.charAt(i) > 'Z')
				{
					valid = false;
				}
				
				for (int j = i + 1; j < keyWord.length(); j++)
				{
					if (keyWord.charAt(i) == keyWord.charAt(j)) //If two symbols are equal, the key word is not valid
					{
						valid = false;
					}
				}
			}
		}
		
		return valid;
	}
	
	public static String printGrid(String[][] grid)
	{
		//A function that helps for the grid to be printed correctly
		
		String result = "";
		
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[0].length; j++)
			{
				result += grid[i][j] + " ";
			}
			result += "\n";
		}
		
		return result;
	}
	
	public static String printKW(String keyWord)
	{
		//A function that helps for the key word to be printed correctly and with blank spaces between the letters
		
		String result = "";
		
		for (int i = 0; i < keyWord.length(); i++)
		{
			result += keyWord.charAt(i) + " ";
		}
		
		return result;
	}
	
	public static void main(String[] args) 
	{
		char[][] alpha = new char[5][5]; //A 2-D array for all the alphabet letters
		
		for (int i = 0; i < alpha.length; i++)
		{
			for (int j = 0; j < alpha[0].length; j++)
			{
				alpha[i][j] = (char) ('A' + i * 5 + j); //Each element of the array is connected to a suitabel leter
			}
		}
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter your message: ");
		String text = scan.nextLine();
		
		String keyWord = "";
		while (!validKW(keyWord))
		{
			//The user types a key word until it is a valid one
			System.out.print("Please enter your key word: ");
			keyWord = scan.nextLine().toUpperCase();
		}
		
		System.out.println(arrangeGrid(keyWord, text, alpha));

		scan.close();
	}

}
