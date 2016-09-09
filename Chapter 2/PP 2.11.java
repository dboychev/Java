import java.util.Scanner;

public class Test 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner (System.in);
		int num, den;
		System.out.print("Numerator: ");
		num = scan.nextInt();
		System.out.print("Denominator: ");
		den = scan.nextInt();
		double fraction = (double) num / den;
		System.out.print(num + " / " + den + " = " + fraction);
	}

}