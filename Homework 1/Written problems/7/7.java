public class WP7 
{
	public static int maxElem(int[] arr)
	{
		if (arr.length > 0) //Check if the array is empty
		{
			int max = arr[0]; //Create a 'max' variable that is initially set to be equal to the 1st element
		
			for (int i = 0; i < arr.length; i++)
			{
				if (arr[i] > max) //Check if any of the elements in the array is greater than the 'max' variable
				{
					max = arr[i]; //Change 'max' with the new biggest value
				}
			}
			
			return max;
		}
		
		//If array is empty - return 0
		return 0;
	}

	public static void main(String[] args) 
	{
		int[] numbers = {-5, -3, -255};
		
		System.out.println(maxElem(numbers));
	}

}
