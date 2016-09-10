import java.util.Scanner;

public class Distance 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner (System.in);
		int x1, y1, x2, y2;
		
		System.out.print("Enter first point coordinates:\nX = ");
		x1 = scan.nextInt();
		System.out.print("Y = ");
		y1 = scan.nextInt();
		
		System.out.print("Enter second point coordinates:\nX = ");
		x2 = scan.nextInt();
		System.out.print("Y = ");
		y2 = scan.nextInt();
		
		System.out.println("Distance between X and Y: " + Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
		
		scan.close();
	}

}
