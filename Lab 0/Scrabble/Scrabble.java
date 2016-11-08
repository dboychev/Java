import java.util.Scanner;

public class Scrabble 
{
	//The array with the points for each letter
	public static int[] scores = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
	
	//This method calculates the sum of all letter's of the word points
	public static int wordPoints(String word)
	{
		int points = 0;
		
		for (int i = 0; i < word.length(); i++)
		{
			if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z')
			{
				points += scores[word.charAt(i) - 97];			
			}
		}
		
		//All the bonuses one by one
		points += longWord(word);
		points += DLS(word);
		points += TLS(word);
		points *= DTWS(word);
		
		return points;
	}

	//If the word has 7 letters or more, additional 50 points are added
	public static int longWord(String word)
	{
		if (word.length() >= 7)
		{
			return 50;
		}
		
		return 0;
	}
	
	//Double letter score bonus
	public static int DLS(String word)
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("Is there a DOUBLE LETTER SCORE? [y/n] ");
		if (scan.nextLine().equals("y"))
		{
			System.out.print("\tWhich letter? ");
			String letter = scan.next();
			char c = letter.charAt(0);
			if (word.contains(letter))
			{
				return scores[c - 97]; //Return the bonus points that should be added
			}
			scan.close();
		}
		
		return 0;
	}
	
	//Triple letter score bonus
	public static int TLS(String word)
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int bonus = 0;
		System.out.print("Is there a TRIPLE LETTER SCORE? [y/n] ");
		if (scan.nextLine().equals("y"))
		{
			System.out.print("\tWhich letter? ");
			String letter = scan.nextLine();
			char c = letter.charAt(0);
			if (word.contains(letter))
			{
				return 2 * scores[c - 97]; //Return the bonus points that should be added
			}
			scan.close();
		}
		
		return 0;
	}
	
	//Double/Triple word score bonus
	public static int DTWS(String word)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Is there a DOUBLE WORD SCORE? [y/n] ");
		if (scan.nextLine().equals("y")) //If yes 
		{
			return 2; //Return what should the points be multiplied with
		}
		else //If no double bonus - ask for a triple bonus
		{
			System.out.print("Is there a TRIPLE WORD SCORE? [y/n] ");
			if (scan.nextLine().equals("y"))
			{
				return 3; //Return what should the points be multiplied with
			}
		}
		
		return 1;
	}
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		String word = "";
		
		System.out.print("Enter word: "); //Creating a string and asking the user to type its word
		word = scan.nextLine();
		System.out.println(wordPoints(word));
		
		scan.close();
	}

}
