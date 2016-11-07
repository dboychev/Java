
public class MethodTester 
{
	public static int algOne(int[] arr)
	{
		//'maxSum' is the variable that keeps the value of max array's sum of all arrays
		//'newSum' is the sum calculated after each loop
		//'n' shows the length of the array
		int maxSum = 0, newSum = 0, n = arr.length;
		int start, end;
				
		//A loop from 0 to the length of the array. 'i' is used to calculate the size of the array - where it ends
		for (int i = 0; i < arr.length; i++)
		{
			//A inner loop from 0 to 'n' - 1. 'j' is used to show the start index while 'n' decreases each time the 
			//length of the subarray is increased
			for (int j = 0; j < n; j++)
			{
				newSum = 0;
				
				start = j;
				end = start + i;
				
				//Calculate the sum of all subarrays
				for (int l = start; l <= end; l++)
				{
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
		
		return maxSum;
	}
	
	public static int algTwo(int[] arr)
	{
		//'maxSum' is the variable that keeps the value of max array's sum of all arrays
		//'newSum' is the sum calculated after each loop
		//'n' shows the length of the array
		int maxSum = 0, newSum = 0, n = arr.length;
		
		//A loop from 0 to 'n' - 1 that shows the starting index - 'i'
		for (int i = 0; i < n; i++)
		{
			newSum = 0;
			
			//An inner loop from 'i' to 'n' - 1. It increases each time, 'i' is increased. 'j' - the end of subarray
			for (int j = i; j < n; j++)
			{
				newSum += arr[j];

				//If it is bigger than the previous max sum, we change it
				if (newSum > maxSum)
				{
					maxSum = newSum;
				}
			}
		}
		
		return maxSum;
	}
	
	public static int algThree(int[] arr)
	{
		//'maxSum' is the variable that keeps the value of max array's sum of all arrays
		//'newSum' is the sum calculated after each loop
		//'n' shows the length of the array
		int maxSum = 0, newSum = 0, n = arr.length;
		int start = 0, end;
		
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
				}
			}
			
			//Out of the loop - the next subarray starts from the element after the 'end' index' one
			start = end + 1;
		}
		
		return maxSum;
	}
	
	
	public static void main(String[] args) 
	{
		int[] A1 = {-1, 12, -3, 14, -4, 3};
		int[] A2 = {2, -3, 5, -1, 0, 7};
		
		System.out.println("Algorithm 1 - A1: " + algOne(A1));
		System.out.println("Algorithm 1 - A2: " + algOne(A2));
		System.out.println();
		
		System.out.println("Algorithm 2 - A1: " + algTwo(A1));
		System.out.println("Algorithm 2 - A2: " + algTwo(A2));
		System.out.println();
		
		System.out.println("Algorithm 3 - A1: " + algThree(A1));
		System.out.println("Algorithm 3 - A2: " + algThree(A2));
	}

}
