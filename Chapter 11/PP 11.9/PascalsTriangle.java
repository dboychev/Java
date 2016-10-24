import java.util.Random; 
import java.util.Scanner;

public class PascalsTriangle 
{
	
	public static void Pascal(int n, int[] arr)
	{
		if (arr.length <= n) //Executed until the array size get bigger than 'n'
		{
			int[] newArr = new int[arr.length + 1]; //Creating a new array with a size bigger with 1
			
			//1st and last element are always 0
			newArr[0] = 1;
			newArr[newArr.length - 1] = 1;
			
			for (int i = 1; i < arr.length; i++)
			{
				//Each row's element is equal to the sum of the upper row's elements with the same index and the same index - 1
				newArr[i] = arr[i] + arr[i - 1];
			}
			
			for (int i = 0; i <= n - newArr.length; i++)
			{
				//Printing the suitable number of tabs so the numbers can form a symmetric figure
				System.out.print("\t"); 
			}
			
			for (int i = 0; i < arr.length; i++)
			{
				System.out.print(arr[i] + "\t\t"); //Printing all the elements on the row separated by two tabs
			}
			System.out.println(); //Printing a new line after each row of Pascal's Triangle
				
			Pascal(n, newArr); //Calling the function again
		}
	}
	
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in); //Creating an object for reading input
				
		System.out.print("Number of rows = "); //The user sets the number of rows
		int n = scan.nextInt();
		
		int[] arr = new int[0]; //Creating an array that will keep each row's values
		
		Pascal(n, arr);
		
		scan.close();
	}

}
