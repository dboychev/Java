import java.util.Scanner;

public class Test {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner (System.in);
		int hours = -1, minutes = -1, seconds = -1;
		while (hours < 0)
		{
			System.out.print("Enter the number of hours: ");
			hours = scan.nextInt();
		}
		
		while (minutes < 0)
		{
			System.out.print("Enter the number of minutes: ");
			minutes = scan.nextInt();
		}
		
		while (seconds < 0)
		{
			System.out.print("Enter the number of seconds: ");
			seconds = scan.nextInt();
		}
		
		System.out.println((hours * 3600 + minutes * 60 + seconds));
	}
}
