import java.util.Random;

public class RuntimeAnalyzer 
{
	//Runtime complexity:
	//n = arr.length
	//First loop - 0 to n - 1
	//Second loop - 0 to n - 1 decreasing 
	//Third loop - start to end increasing
	//n * (n - ...) * (n - ...)
	//O(n ^ 3)
	public static int algOne(int[] arr)
	{
		//'maxSum' is the variable that keeps the value of max array's sum of all arrays
		//'newSum' is the sum calculated after each loop
		//'n' shows the length of the array
		int maxSum = 0, newSum = 0, n = arr.length;
		int start, end;
		
		//A variable to show the number of assignments
		int counter = 0;
				
		//A loop from 0 to the length of the array. 'i' is used to calculate the size of the array - where it ends
		for (int i = 0; i < arr.length; i++)
		{
			counter++;
			
			//A inner loop from 0 to 'n' - 1. 'j' is used to show the start index while 'n' decreases each time the 
			//length of the subarray is increased
			for (int j = 0; j < n; j++)
			{
				counter++;
				
				newSum = 0;
				
				start = j;
				end = start + i;
				
				//Calculate the sum of all subarrays
				for (int l = start; l <= end; l++)
				{
					counter++;
					newSum += arr[l];
				}
				
				//If it is bigger than the default value, we change it
				if (newSum > maxSum)
				{
					maxSum = newSum;
				}
			}
			
			n--;
		}
		
		return counter;
	}
	
	//Runtime complexity:
	//n = arr.length
	//First loop - 0 to n - 1
	//Second loop - 0 increasing to n - 1 
	//n * (n - ...)
	//O(n ^ 2)
	public static int algTwo(int[] arr)
	{
		//'maxSum' is the variable that keeps the value of max array's sum of all arrays
		//'newSum' is the sum calculated after each loop
		//'n' shows the length of the array
		int maxSum = 0, newSum = 0, n = arr.length;
		
		//A variable to show the number of assignments
		int counter = 0;
		
		//A loop from 0 to 'n' - 1 that shows the starting index - 'i'
		for (int i = 0; i < n; i++)
		{
			counter++;
			
			newSum = 0;
			
			//An inner loop from 'i' to 'n' - 1. It increases each time, 'i' is increased. 'j' - the end of subarray
			for (int j = i; j < n; j++)
			{
				counter++;
				newSum += arr[j];

				//If it is bigger than the previous max sum, we change it
				if (newSum > maxSum)
				{
					maxSum = newSum;
				}
			}
		}
		
		return counter;
	}
	
	//Runtime complexity:
	//n = arr.length
	//Inner loop - 0 increasing to n - 1
	//Main loop - 0 increasing to the first element that is not gone through to n - 1 
	//n + 1
	//O(n)
	public static int algThree(int[] arr)
	{
		//'maxSum' is the variable that keeps the value of max array's sum of all arrays
		//'newSum' is the sum calculated after each loop
		//'n' shows the length of the array
		int maxSum = 0, newSum = 0, n = arr.length;
		int start = 0, end;
		
		//A variable to show the number of assignments
		int counter = 0;
		
		//A 'while' loop until all the elements pass the position of starting element of the subarray
		while (start < n)
		{
			newSum = 0;
			end = start;
			
			//'end' is equal to 'start' and slowly increases until it reaches 'n' or the new sum is negative
			while (end < n && newSum >= 0)
			{
				//New subarray sum is calculated by adding the new 'end' index element to the old subarray sum
				newSum += arr[end];
				//If it is bigger than the previous max sum, we change it
				if (newSum > maxSum)
				{
					maxSum = newSum;
				}
				
				//If the sum is still not negative, the next element becomes the last one of the subarray
				if (newSum >= 0)
				{
					end++;
					counter++;
				}
			}
			
			//Out of the loop - the next subarray starts from the element after the 'end' index' one
			start = end + 1;
			counter++;
		}
		
		return counter;
	}
	
	public static void main(String[] args) 
	{
		Random generator = new Random();
		
		int alg1 = 0;
		int alg2 = 0;
		int alg3 = 0;
		
		System.out.println("AVERAGE NUMBER OF ASSIGNMENT STATEMENTS\nEXECUTED OVER 2000 TRIALS:\n\n"
				+ "size\tAlg1\tAlg2\tAlg3");
		
		for (int i = 5; i < 51; i += 5)
		{
			alg1 = 0;
			alg2 = 0;
			alg3 = 0;
			
			for (int l = 0; l < 2000; l++)
			{
				int[] arr = new int[i];
				
				for (int j = 0; j < arr.length; j++)
				{
					arr[j] = generator.nextInt(110) - 10;
				}
				
				alg1 += algOne(arr);
				alg2 += algTwo(arr);
				alg3 += algThree(arr);
			}
			
			alg1 /= 2000;
			alg2 /= 2000;
			alg3 /= 2000;
			
			System.out.println(i + "\t" + alg1 + "\t" + alg2 + "\t" + alg3);
		}
		
	}

}
