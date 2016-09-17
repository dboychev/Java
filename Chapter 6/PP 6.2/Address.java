
public class Address 
{
	private String streetAddress, city, state;
	private long zipCode;
	
	public Address (String newStreetAddress, String newCity, String newState, long newZipCode)
	{
		streetAddress = newStreetAddress;
		city = newCity;
		state = newState;
		zipCode = newZipCode;
	}
	
	public String toString()
	{
		String result;
		
		result = streetAddress + "\n";
		result += city + ", " + state + " " + zipCode;
		
		return result;
	}
}
