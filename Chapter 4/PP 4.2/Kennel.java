
public class Kennel 
{
	

	public static void main(String[] args) 
	{
		Dog dog1, dog2, dog3;
		
		dog1 = new Dog("Doggy 1", 3);
		System.out.println(dog1.getName());
		System.out.println(dog1.getAge());
		System.out.println(dog1.personAge());
		System.out.println(dog1.toString());
		System.out.println();
		
		dog2 = new Dog("Doggy 2", 4);
		System.out.println(dog2.getName());
		System.out.println(dog2.getAge());
		System.out.println(dog2.personAge());
		System.out.println(dog2.toString());
		System.out.println();
		
		dog3 = new Dog("Doggy 3", 5);
		System.out.println(dog3.getName());
		System.out.println(dog3.getAge());
		System.out.println(dog3.personAge());
		System.out.println(dog3.toString());
		System.out.println();
		
		dog1.setName("Charles");
		dog1.setAge(11);
		System.out.println(dog1.getName());
		System.out.println(dog1.getAge());
		System.out.println(dog1.personAge());
		System.out.println(dog1.toString());
		System.out.println();
		
		dog2.setName("Lucky");
		dog2.setAge(8);
		System.out.println(dog2.getName());
		System.out.println(dog2.getAge());
		System.out.println(dog2.personAge());
		System.out.println(dog2.toString());
		System.out.println();
		
		dog3.setName("Beethoven");
		dog3.setAge(1);
		System.out.println(dog3.getName());
		System.out.println(dog3.getAge());
		System.out.println(dog3.personAge());
		System.out.println(dog3.toString());
		System.out.println();
	}

}
