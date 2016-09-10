import java.util.Scanner;

public class SumOfCubes
{

	public static void main(String[] args) 
	{
	Scanner scan = new Scanner (System.in);
	int num1, num2;
	System.out.print("Enter first number = ");
	num1 = scan.nextInt();
	
	System.out.print("Enter second number = ");
	num2 = scan.nextInt();
	
	int sum = (int) (Math.pow(num1, 3) + Math.pow(num2, 3));
	System.out.println("Sum of cubes of " + num1 + " and " + num2 + " = " + sum);
	
	scan.close();	
	}

}
