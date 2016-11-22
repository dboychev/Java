
public class SumComputer {

	public static void main(String[] args) {

		System.out.println("The sum of the integers 1 to 6 is: "
			+ sum(6));
		System.out.println("The sum of the integers 1 to 10 is: "
			+ sum(10));
		System.out.println("The sum of the integers 1 to 15 is: "
			+ sum(15));
		System.out.println("The sum of the integers 1 to 24 is: "
			+ sum(24));
		System.out.println("The sum of the integers 1 to 1 is: "
			+ sum(1));
	}

	public static int sum(int n) 
	{
		if (n == 1)
		{
			return 1;
		}
		
		else
		{
			return n + sum(n - 1);
		}
	}


}
