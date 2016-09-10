import java.util.Random;
import java.text.DecimalFormat;

public class PhoneNumber 
{

	public static void main(String[] args) 
	{
		Random generator = new Random();
		DecimalFormat fmt = new DecimalFormat ("000");
		DecimalFormat fmt4digits = new DecimalFormat ("0000");
		
		int firstThree = generator.nextInt(777); 
		while (firstThree / 100 == 8 || firstThree / 100 == 9 || firstThree % 10 / 10 == 8 ||
				firstThree % 10 / 10 == 9 || firstThree % 100 == 8 || firstThree % 100 == 9)
		{
			firstThree = generator.nextInt(777);
		}
		
		System.out.print("A random phone number: " + fmt.format(firstThree) + "-" 
		+ fmt.format(generator.nextInt(742)) + "-" + fmt4digits.format(generator.nextInt(10000)));
		
	}

}
