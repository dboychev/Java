import java.util.Scanner;

public class Test 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner (System.in);
		int side;
		System.out.print("Enter the length of the square's side: ");
		side = scan.nextInt();
		System.out.println("Perimeter of the square: " + (side * 4));
		System.out.println("Area of the square: " + (side * side));
	}
}