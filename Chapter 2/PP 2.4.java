import java.util.Scanner;

public class Test
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner (System.in);
		double Fahr, Cel;
		System.out.print("Fahrenheit temp: ");
		Fahr = scan.nextDouble();
		Cel = (Fahr - 32) / 1.8;
		System.out.println("Celsius temp: " + Cel);
	}

}