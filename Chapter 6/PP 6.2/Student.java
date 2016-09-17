
public class Student 
{
	private String firstName, lastName;
	private Address homeAddress, schoolAddress;
	private int test1, test2, test3;
	
	public Student (String newFirstName, String newLastName, Address newHomeAddress, Address newSchoolAddress, int newTest1, int newTest2, int newTest3)
	{
		firstName = newFirstName;
		lastName = newLastName;
		homeAddress = newHomeAddress;
		schoolAddress = newSchoolAddress;
		test1 = newTest1;
		test2 = newTest2;
		test3 = newTest3;		
	}
	
	public Student (String newFirstName, String newLastName, Address newHomeAddress, Address newSchoolAddress)
	{
		firstName = newFirstName;
		lastName = newLastName;
		homeAddress = newHomeAddress;
		schoolAddress = newSchoolAddress;
		test1 = 0;
		test2 = 0;
		test3 = 0;		
	}
	
	public void setTestScore(int testNumber, int score)
	{
		switch(testNumber)
		{
		case 1:
			test1 = score;
			break;
		case 2:
			test2 = score;
			break;
		case 3:
			test3 = score;
			break;
		}
	}
	
	public int getTestScore(int testNumber)
	{
		int score = 0;
		switch(testNumber)
		{
		case 1:
			score = test1;
			break;
		case 2:
			score = test2;
			break;
		case 3:
			score = test3;
			break;
		}
		
		return score;
	}
	
	public double average()
	{
		return (double)(test1 + test2 + test3) / 3;
	}
	
	public String toString()
	{
		String result;
		
		result = firstName + " " + lastName + "\n";
		result += "Home Address:\n" + homeAddress + "\n";
		result += "School Address:\n" + schoolAddress;
		result += "Test Scores:\n" + "Test 1: " + getTestScore(1) + "\n";
		result += "Test 2: " + getTestScore(2) + "\n";
		result += "Test 3: " + getTestScore(3) + "\n";
		result += "Average Score: " + average() + "\n";
		
		return result;
	}
	
	
	
}
