
public class RationalNumber implements Comparable
{
	private int numerator, denominator;
	
	public RationalNumber(int newNumerator, int newDenominator) //Constructor
	{
		if (newDenominator == 0)
		{
			newDenominator = 1;
		}
		
		if (newDenominator < 0) //Making the numerator store the sign
		{ 
			newNumerator = newNumerator * -1;
			newDenominator = newDenominator * -1;
		}
		
		numerator = newNumerator;
		denominator = newDenominator;
		
		reduce();
	}
	
	public int getNumerator() //Getters of 'numerator' and 'denominator'
	{
		return numerator;
	}
	
	public int getDenominator()
	{
		return denominator;
	}
	
	public RationalNumber reciprocal() //A function for finding the reciprocal of the number
	{
		return new RationalNumber(denominator, numerator);
	}
	
	public RationalNumber add(RationalNumber op2) //Adding the parameter number to the other number
	{
		int commonDenominator = denominator * op2.getDenominator();
		int numerator1 = numerator * op2.getDenominator();
		int numerator2 = op2.getNumerator() * denominator;
		int sum = numerator1 + numerator2;
		
		return new RationalNumber(sum, commonDenominator);
	}
	
	public RationalNumber subtract(RationalNumber op2) //Subtracting the parameter number from this rational one
	{
		int commonDenominator = denominator * op2.getDenominator();
		int numerator1 = numerator * op2.getDenominator();
		int numerator2 = op2.getNumerator() * denominator;
		int difference = numerator1 - numerator2;
		
		return new RationalNumber(difference, commonDenominator);
	}
	
	public RationalNumber multiply(RationalNumber op2) //Multiplying this rational number by the parameter number
	{
		int numer = numerator * op2.getNumerator();
		int denom = denominator * op2.getDenominator();
		
		return new RationalNumber(numer, denom);
	}
	
	public RationalNumber divide(RationalNumber op2) //Dividing this rational number by the parameter number
	{
		return multiply(op2.reciprocal());
	}
	
	public boolean isLike(RationalNumber op2) //Checking if the numbers are equal
	{
		return (numerator == op2.getNumerator() && denominator == op2.getDenominator());
	}
	
	public String toString() //Printing the number
	{
		String result;
		
		if (numerator == 0)
		{
			result = "0";
		}
		else
		{
			if (denominator == 1)
			{
				result = numerator + "";
			}
			else
			{
				result = numerator + "/" + denominator;
			}
		}

		return result;
	}
	
	private void reduce() //Reducing the rational number by dividing both numerator and denominator by their gcd
	{
		if (numerator != 0)
		{
			int common = gcd (Math.abs(numerator), denominator);
			
			numerator = numerator / common;
			denominator = denominator / common;
		}
	}
	
	private int gcd(int num1, int num2) //Finding the greatest common divisor of two integers
	{
		while (num1 != num2)
		{
			if (num1 > num2)
			{
				num1 = num1 - num2;
			}
			else
			{
				num2 = num2 - num1;
			}
		}
		
		return num1;
	}
	
	public boolean compare(RationalNumber op2) //Implementing the method from the 'Comparable' interface
	{
		float tolerance = 0.0001f;
		if (this.equivalent() - op2.equivalent() > tolerance || this.equivalent() - op2.equivalent() < -tolerance)
		{
			return false;
		}
		else
		{
			return true;
		}
	
	}
	
	public float equivalent() //Implementing the method from the 'Comparable' interface
	{
		return (float)numerator / denominator;
	}
	
}
	
	