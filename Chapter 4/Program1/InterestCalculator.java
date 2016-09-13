import java.util.Scanner;
import java.text.DecimalFormat;

public class InterestCalculator 
{
	private double deposit;
	private double interestRate;
	private int times;
	
	public InterestCalculator(double newDeposit, double newInterestRate, int newTimes)
	{
		setDeposit(newDeposit);
		setInterestRate(newInterestRate);
		setTimes(newTimes);
	}
	
	public void setDeposit(double newDeposit)
	{
		deposit = newDeposit;
	}
	
	public void setInterestRate(double newInterestRate)
	{
		interestRate = newInterestRate;
	}
	
	public void setTimes(int newTimes)
	{
		times = newTimes;
	}
	
	public double getDeposit()
	{
		return deposit;
	}
	
	public double getInterestRate()
	{
		return interestRate;
	}
	
	public int getTimes()
	{
		return times;
	}

	public static void displayBanner()
	{
		System.out.println("*********************************\n" 
				+ "UBB BANK - CERTIFICATE OF DEPOSIT\n" 
				+ "*********************************");
	}
	
	public String toString()
	{
		DecimalFormat fmt = new DecimalFormat("0.##");	
		String info = new String("Initial Deposit: " + getDeposit() + "\n"
		+ "Interest Rate: " + getInterestRate() + "%\n"
		+ "Number of Interest Payments: " + getTimes() + "\n"
		+ "Final amount: " + fmt.format(deposit * (Math.pow(1 + (interestRate / 100), times))));
		
		return info;
	}
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		double deposit;
		double interestRate;
		int times;
		
		System.out.print("Deposit: ");
		deposit = scan.nextDouble();
		System.out.print("Interest rate: ");
		interestRate = scan.nextDouble();
		System.out.print("Times: ");
		times = scan.nextInt();
	
		InterestCalculator calc;
		calc = new InterestCalculator(deposit, interestRate, times);
		calc.displayBanner();
		System.out.println(calc.toString());
	}
}
