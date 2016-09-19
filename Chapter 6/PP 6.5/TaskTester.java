
public class TaskTester 
{

	public static void main(String[] args) 
	{
		Task task1 = new Task("Go to work.", 6); //Creating some objects with different values
		Task task2 = new Task("Repair the car.", 5);
		Task task3 = new Task("Paint the walls.", 2);
		Task task4 = new Task("Pay your bill.", 4);
		Task task5 = new Task("Buy new shoes.", 3);
		Task task6 = new Task("Travel to Dubai.", 1);

		System.out.println(task1); //Printing the objects information
		System.out.println(task2);
		System.out.println(task3);
		System.out.println(task4);
		System.out.println(task5);
		System.out.println(task6);
	}

}
