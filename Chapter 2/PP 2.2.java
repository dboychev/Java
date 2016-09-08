import java.util.Scanner;

public class Test 
{

	public static void main(String[] args) 
	{
		int num = 0, i = 0;
		Scanner scan = new Scanner (System.in);
		while (i < 3)
		{
			num += scan.nextInt();
			i++;
		}
		
		double average = (double) num / 3;
		System.out.println(average);
	}

}
