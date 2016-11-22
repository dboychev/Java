import java.util.*;

public class PermutationGenerator {

	public static void main(String[] args) {
	
	    ArrayList<String> perms;
	    
	    System.out.println("\nThe permutations of ABC are:");
	    perms = makePermutations("ABC");
	    for (String s: perms) {
	          System.out.println(s);
	    }

	    System.out.println("\nThe permutations of STACK are:");
	    perms = makePermutations("STACK");
	    for (String s: perms) {
	          System.out.println(s);
	    }
	    
	    System.out.println("\nThe permutations of C are:");
	    perms = makePermutations("C");
	    for (String s: perms) {
	          System.out.println(s);
	    }

	    
	}

	public static ArrayList<String> makePermutations(String s) 
	{
		ArrayList<String> list = new ArrayList<String>();
		if (s.length() == 1)
		{
			list.add(s);
			return list;
		}
		
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			String left = s.substring(0, i) + s.substring(i + 1);
			ArrayList<String> helper = makePermutations(left);
			
			for (String sp: helper)
			{
				list.add(c + sp);
			}
		}
		
		return list;
		
	}
}
