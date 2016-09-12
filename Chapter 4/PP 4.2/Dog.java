
public class Dog 
{
	private String name;
	private int age;
	
	public Dog(String newName, int newAge)
	{
		setName(newName);
		setAge(newAge);
	}
	
	public void setName(String newName)
	{
		name = newName;
	}
	
	public void setAge(int newAge)
	{
		age = newAge;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public int personAge()
	{
		return (age * 7);
	}
	
	public String toString()
	{
		String description = new String("Dog's name: " + name + " | Dog's age: " + age + " | Dog's age in person years: "
				+ personAge());
		
		return description;
	}	
}