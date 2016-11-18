import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Chemistry 
{
	//Create an array with all the elements. The number of protons in each is equal to its index + 1
	private static String[] elements = {"H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne",
			"Na", "Mg", "Al", "Si", "P", "S", "Cl", "Ar", "K", "Ca",
			"Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn",
			"Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr", "Y", "Zr",
			"Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn",
			"Sb", "Te", "I", "Xe"};

	//A method that finds the number of protons in an element according to the table (the array)
	private static int protons(String element)
	{
		for (int i = 0; i < elements.length; i++)
		{
			if (elements[i].equals(element))
			{
				return i + 1;
			}
		}
		return 0;
	}
	
	//A function that finds and calculates the number of protons in all of the elements
	public static int calculate(String str)
	{
		//Two strings - one for going through all the elements, second for popping them out of the stack
		String elem = "";
		String curElem = "";

		//Some variables, first calculates the total number of protons, second helps adding an element's protons
		//to the total, the third one is used in inner calculations where there are parentheses
		int protons = 0;
		int newProtons = 0;
		int protonsInner = 0;
		
		//A variable that shows how many times an element is at the formula, second is for going through the string
		int coef = 0;
		int i = 0;
		
		//A stack - elements are pushed in it when there are any parentheses at the expression
		Stack<String> s = new Stack<String>();
		
		//Going through all the symbols of the expression
		while (i < str.length())
		{
			//Coef and newProtons are initially set to 0, protonsInner also, but only if the stack is empty
			coef = 0;
			newProtons = 0;
			if (s.isEmpty())
			{
				protonsInner = 0;
			}
			
			//If the next symbol is a capital letter, that means - a new element
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
			{
				//Save the name
				elem = str.charAt(i) + "";
				//Check if has a second letter (a small one)
				while (i < str.length() - 1 && str.charAt(i + 1) >= 'a' && str.charAt(i + 1) <= 'z')
				{
					i++;
					elem += str.charAt(i);
				}
				
				//Check if there is a number after the element
				while (i < str.length() - 1 && str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9')
				{
					//If it is, that would be the coefficient that shows the times that elements is at the formula
					i++;
					coef = coef * 10 + Integer.parseInt(str.charAt(i) + "");
				}
				
				//If stack is not empty (it means there is at least one "(" at it), start pushing the next elements
				//or parentheses ("(") until a ")" is reached
				if (!s.isEmpty())
				{
					//If the element has a coefficient, push it to the stack
					s.push(elem);
					if (coef > 1)
					{
						s.push(coef + "");
					}
				}
				
				//If stack is empty, just save the number of protons
				else
				{
					newProtons = protons(elem);
				}
			}
			
			//If the next symbol is "(" - start pushing elements to the stack
			else if (str.charAt(i) == '(')	
			{
				s.push(str.charAt(i) + "");
			}
			//If the next symbol is ")" - start popping elements from the stack until a "(" is reached
			else if (str.charAt(i) == ')')
			{
				//Every popped elements are saved at that string
				curElem = s.pop();
				
				//If it is not a "(", check what it really is
				while (!curElem.equals("("))
				{
					//If it is a number
					if (curElem.matches("[2-9]+"))
					{
						//Calculate the protons with the coefficient
						protonsInner += Integer.parseInt(curElem) * protons(s.pop());
					}
					else
					{
						protonsInner += protons(curElem);
					}
					
					//Pop the next element
					curElem = s.pop();
				}
				
				//If the next element is a coefficient, save it
				while (i < str.length() - 1 && str.charAt(i + 1) >= '2' && str.charAt(i + 1) <= '9')
				{
					i++;
					coef = coef * 10 + Integer.parseInt(str.charAt(i) + "");
				}
				
				//If the stack is not empty, save a local value that will be used later
				if (!s.isEmpty() && coef > 1)
				{
					protonsInner *= coef;
				}
				//If the stack is already empty, add the protons to the total number
				else
				{
					newProtons = protonsInner;
				}
			}
			
			//If there is a saved coefficient - calculate the protons with it
			if (coef < 2)
			{
				coef = 1;
			}
			protons += coef * newProtons;
			i++;
		}
		
		return protons;
	}

	
	public static void main(String[] args) 
	{
		//Create an object for reading input
		Scanner scan = new Scanner(System.in);
		//Two strings - for reading each line and for saving the result
		String str = "";
		String result = "";
		
		//User can choose from 2 options - testing from a file or console
		System.out.print("Choose how you want to read data: file - console (f/c)? ");
		
		//If file is chosen
		if (scan.next().equals("f"))
		{
			//Name of the file should be typed
			System.out.print("Type the name of the file: ");
			String fileName = scan.next();
			
			//If the name is correct and the file does exist
			try
			{
				//Create an object to read the file 
				BufferedReader in = new BufferedReader(new FileReader(fileName));
				//While there is still any unread text left at the file
				while ((str = in.readLine()) != null)
				{
					result += calculate(str) + "\n";
				}
				
				in.close();
			}
			
			//If file can not be opened
			catch (FileNotFoundException e)
			{
				System.out.println("File not found!");
			}
			
			catch (IOException e)
			{
				System.out.println("Load of directory failed!");
			}
		}
		
		//If the user chose the console
		else
		{		
			//Type the number of calculations
			int lines = scan.nextInt();
			
			//Type each expression that has to be calculated
			for (int i = 0; i < lines; i++)
			{
				str = scan.next();
				result += calculate(str) + "\n";
			}
		}	
		
		//Print the result
		System.out.println(result);
	}

}
