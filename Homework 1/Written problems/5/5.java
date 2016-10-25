import java.util.Scanner; 

public class WP5 
{

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
				
		System.out.print("Enter names: ");
		String names = scan.nextLine();

		String result = "";
		scan = new Scanner(names).useDelimiter("d,"); //',' is now set as a delimiter
		while (scan.hasNext()) //After each ',' result will get the name and separate it with the next by a new line
		{
			result += scan.next() + "\n";
		}
		
		System.out.println(result);
		scan.close();		
	}

}
