
public class ListTester {

	public static void main(String[] args) {

		CircularlyLinkedList<String> list1 = new CircularlyLinkedList<String>();

		System.out.println("Adding strings to the circular list.");
		list1.add(new String("A"));
		System.out.println(list1);
		list1.add(new String("B"));
		System.out.println(list1);
		list1.add(new String("C"));
		System.out.println(list1);
		list1.add(new String("D"));
		System.out.println(list1);
		list1.add(new String("E"));
		System.out.println(list1);
		list1.add(new String("F"));
		System.out.println(list1);
		list1.add(new String("G"));
		System.out.println(list1);
		list1.add(new String("H"));
		System.out.println(list1);
		list1.add(new String("I"));
		System.out.println(list1);
		
		System.out.println("\nPrinting out lists from a specific index.");
		for (int i = -1; i < 15; i++) {
			System.out.print("List starting from index " + i + ":\t");
			list1.display(i);
		}
		
	}

}
