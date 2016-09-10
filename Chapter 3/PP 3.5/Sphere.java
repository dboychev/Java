import java.util.Scanner;
import java.text.DecimalFormat;

public class Sphere 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner (System.in);
		DecimalFormat fmt = new DecimalFormat("0.####");
		
		System.out.print("Radius = ");
		double radius = scan.nextDouble();
		while (radius <= 0)
		{
			System.out.print("Invalid Input! Enter a positive value!\nRadius = ");
			radius = scan.nextDouble();
		}
		
		double Volume = 4 * Math.PI * Math.pow(radius, 3) / 3;
		double SurfaceArea = 4 * Math.PI * Math.pow(radius, 2);
		
		System.out.println("Volume = " + fmt.format(Volume));
		System.out.println("Surface Area = " + fmt.format(SurfaceArea));
		
		scan.close();
	}

}
