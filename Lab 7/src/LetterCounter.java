
public class LetterCounter {

	public static void main(String[] args) {


		System.out.println("The number of A's in ABCABA is " + 
			count("ABCABA", 'A'));
		System.out.println("The number of B's in ABCABA is " + 
			count("ABCABA", 'B'));
		System.out.println("The number of C's in ABCABA is " + 
			count("ABCABA", 'C'));
		System.out.println("The number of D's in ABCABA is " + 
			count("ABCABA", 'D'));
		System.out.println("The number of E's in EEEEEFEEEEE is " +
			count("EEEEEFEEEEE", 'E'));

	}

	public static int count(String s, char c) 
	{  
		if (s.length() == 0)
		{
			return 0;
		}
		
		else
		{
			if (s.charAt(0) == c)
			{
				return 1 + count(s.substring(1), c);
			}
			else
			{
				return count(s.substring(1), c);
			}
		}
	}


}
