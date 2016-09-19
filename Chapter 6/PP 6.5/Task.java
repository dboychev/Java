
public class Task implements Priority
{
	private String name, importance; //Saving the name of the task, the priority rate and the importance level
	private int priority;
	
	public Task(String newName, int newPriority) //Constructor
	{
		name = newName;
		priority = newPriority;
		switch(priority) //Assigning different values on importance level depending on the rate of priority
		{
		case 1:
			importance = "Not important at all.";
			break;
		case 2:
			importance = "Not really important.";
			break;
		case 3:
			importance = "It don't need to be done right now.";
			break;
		case 4:
			importance = "You should look at it soon.";
			break;
		case 5:
			importance = "It should be done really soon.";
			break;
		case 6:
			importance = "You should do it immedeately!";
			break;
			default: //If the rate is bigger than 6 or smaller than 1
				importance = "Invalid input! Importance level rates should be in the range 1 <-> 6!";
				break;
		}
	}
	
	public void setPriority(int newPriority) //Methods from the interface 'Priority'
	{
		priority = newPriority;
	}
	
	public int getPriority()
	{
		return priority;
	}
	
	public String toString() //Printing the information about a task
	{
		String result = "To do: " + name;
		if (priority <= 6 && priority >= 1)
		{
			result += "\nPriority rate: " + priority;
			result += "\nImportance: " + importance;
		}
		else
		{
			result += "\n" + importance;
		}
		
		result += "\n";
		
		return result;
	}
	
}
