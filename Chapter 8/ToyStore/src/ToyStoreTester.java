import java.util.*;
import java.io.*;

public class ToyStoreTester
{
	public static void main(String[] args) throws IOException
	{
		// Create a toy store with no bins initially

		ToyStore myStore = new ToyStore();

		// Read from a text file to create an initial set of bins

		Scanner filescan = new Scanner(new File("toydata.txt"));
		while (filescan.hasNextLine())
		{
			String line = filescan.nextLine();
			if (line.length() > 0)		// is the line not empty?
			{
				Scanner linescan = new Scanner(line);
				linescan = linescan.useDelimiter(",");	// use , as separator of data on each line
				String nameOfToy = linescan.next();
				int quantityOfToy = linescan.nextInt();
				myStore.createBin(nameOfToy, quantityOfToy);
				linescan.close();
			}
		}
		System.out.println("\n" + myStore);

		Scanner scan = new Scanner(System.in);
		boolean done = false;

		while (!done)
		{
			System.out.println("MENU:");
			System.out.println("C - Count the toys in the store");
			System.out.println("R - Return a toy back to store");
			System.out.println("B - Buy a toy from store");
			System.out.println("Q - Quit");
			System.out.print("ENTER CHOICE: ");
			String response = scan.nextLine();
			switch (response.toUpperCase().charAt(0))
			{
				case 'C':
				System.out.println("TOTAL NUMBER OF TOYS: " + myStore.countToys());
				System.out.println("\n" + myStore);
				break;

				case 'R':
				System.out.print("Input name of toy: ");
				response = scan.nextLine();
				myStore.returnToy(response);
				System.out.println("\n" + myStore);
				break;

				case 'B':
				System.out.print("Input name of toy: ");
				response = scan.nextLine();
				myStore.buyToy(response);
				System.out.println("\n" + myStore);
				break;

				case 'Q':
				done = true;
				break;

				default:
				System.out.println("UNKNOWN MENU OPTION");
			}
		}
		


		System.out.println("END OF TOY STORE TESTER");
		filescan.close();
		scan.close();
	}
}
