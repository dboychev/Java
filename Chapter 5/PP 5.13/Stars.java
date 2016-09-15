
public class Stars {

	public static void main(String[] args) 
	{
		System.out.println("a.");
		
		for (int i = 10; i > 0; i --)
		{
			int j = 1; //An additional variable
			while (j <= i) //Always starting from 1 and printing '*'s until their number gets 10 - i
			{
				System.out.print("*");
				j++;
			}
			System.out.println(); //Going to the next line
		}
		
		System.out.println("b.");
		
		for (int i = 10; i > 0; i--)
		{
			int blank = 1; //Always starting from 1 and printing blanks until blank gest 10 - i, i is for the stars
			while (blank < i)
			{
				System.out.print(" ");
				blank++;
			}
			int star = 10 - blank + 1; //Star numbers + blank numbers = 10
			for (int j = 0; j < star; j++)
			{
				System.out.print("*");
			}
			System.out.println(); //Going to the next line		
		}
		
		System.out.println("c.");
		
		for (int i = 10; i > 0; i --)
		{
			int blank = 10 - i; //On the 1st row there are no blanks, then their number increases with 1 at each row
			for (int j = 0; j < blank; j++)
			{
				System.out.print(" ");
			}
			
			int star = i; //Number of stars decreases with 1 at each row (from 10 to 1)
			while (star != 0)
			{
				System.out.print("*");
				star--;
			}
			System.out.println(); //Going to the next line
		}
		
		System.out.println("d.");
		
		for (int i = 1; i < 10; i += 2) //Number of stars is always odd between 1 and 9 incl.
		{
			int blank = (9 - i) / 2 - 1; //Number of blank at each side of the stars is equal
			int j = 0;
			while (j <= blank)
			{
				System.out.print(" ");
				j++;
			}
			j = 0;
			while (j < i)
			{
				System.out.print("*");
				j++;
			}
			
			System.out.println(); //Going to the next line
		}
		
		//The same loop - reversed
		for (int i = 9; i > 0; i -= 2)
		{
			int blank = (9 - i) / 2 - 1;
			int j = 0;
			while (j <= blank)
			{
				System.out.print(" ");
				j++;
			}
			j = 0;
			while (j < i)
			{
				System.out.print("*");
				j++;
			}
			
			System.out.println();
		}
	}

}
