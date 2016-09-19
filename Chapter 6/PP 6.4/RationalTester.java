
public class RationalTester {

	public static void main(String[] args) //Creating some objects with some operations between them, printing them
	{
		RationalNumber r1 = new RationalNumber(6, 8);
		RationalNumber r2 = new RationalNumber(1, 3);
		RationalNumber r3, r4, r5, r6, r7;
		
		System.out.println("First rational number: " + r1);
		System.out.println("Second rational number: " + r2);
		
		if (r1.isLike(r2))
		{
			System.out.println("r1 and r2 are equal.");
		}
		else
		{
			System.out.println("r1 and r2 are NOT equal.");
		}
		
		r3 = r1.reciprocal();
		System.out.println("The reciprocal of r1 is: " + r3);
		
		r4 = r1.add(r2);
		r5 = r1.subtract(r2);
		r6 = r1.multiply(r2);
		r7 = r1.divide(r2);
		
		System.out.println("r1 + r2: " + r4);
		System.out.println("r1 - r2: " + r5);
		System.out.println("r1 * r2: " + r6);
		System.out.println("r1 / r2: " + r7);
		System.out.println();
		System.out.println("r1 decimal equivalent: " + r1.equivalent());
		System.out.println("r2 decimal equivalent: " + r2.equivalent());
		System.out.println("reciprocal of r1 decimal equivalent: " + r3.equivalent());
		System.out.println("r1 + r2 decimal equivalent: " + r4.equivalent());
		System.out.println("r1 - r2 decimal equivalent: " + r5.equivalent());
		System.out.println("r1 * r2 decimal equivalent: " + r6.equivalent());
		System.out.println("r1 / r2 decimal equivalent: " + r7.equivalent());
		
		System.out.println(r1.compare(r2));
	
	}

}
