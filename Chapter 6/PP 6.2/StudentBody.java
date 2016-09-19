
public class StudentBody {

	public static void main(String[] args) //Creating some 'Student' and 'Address' objects and printing them
	{
		Address school = new Address ("800 Lancaster Ave.", "Villanova", "PA", 19085);
		
		Address jHome = new Address ("21 Jump Street", "Lynchburg", "VA", 24551);
		
		Student john = new Student ("John", "Smith", jHome, school, 88, 92, 85);
		
		Address mHome = new Address ("123 Main Street", "Euclid", "OH", 44132);
		
		Student marsha = new Student ("Marsha", "Jones", mHome, school, 75, 60, 49);
		
		System.out.println(john);
		System.out.println();
		System.out.println(marsha);
	}

}
