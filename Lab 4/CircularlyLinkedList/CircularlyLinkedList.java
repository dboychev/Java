
public class CircularlyLinkedList<E> {

	// NOTE: This linked list can store objects that are not Comparable

	// DO NOT ADD ANY ADDITIONAL FIELDS FOR THIS EXERCISE
	private Node<E> head;
	private int numElements;
		
	public CircularlyLinkedList() 
	{
		head = null;
		numElements = 0;
	}
	
	public String toString() 
	{
		String result = "numElements = " + numElements + ": ";
		if (head != null) {
			Node<E> nodePtr = head;
			do 
			{
				result += nodePtr.data + " ";
				nodePtr = nodePtr.next;
			} while (nodePtr != head);
		}
		return result;
	}
	
	public void add(E element) 
	{
		//Create a new node that should be added with the data typed
		Node<E> newNode = new Node<E> (element);
		//If the list is empty
		if (numElements == 0)
		{
			//The new element is now the head of the list, it points to itself
			head = newNode;
			head.next = head;
		}
		//If there are any elements in the list
		else
		{
			//The new element points to the first element
			newNode.next = head.next;
			//The head now points to our new element
			head.next = newNode;
		}
		
		//Increase the number of nodes
		numElements++;
	}
	
	public void display(int index) 
	{
		//If index is invalid (negative)
		if (index < 0)
		{
			System.out.println("Error! Index can not be negative!");
		}
		//If index is valid
		else
		{
			//Create a temporary node equal to head
			Node<E> temp = head;
			//By a for loop get that node to the starting index
			for (int i = 0; i < index; i++)
			{
				temp = temp.next;
			}
			//A helper variable
			int i = 0;
			//Until it reaches the number of elements, temp goes through them and prints them one by one
			while (i < numElements)
			{
				System.out.print(temp.data + " ");
				temp = temp.next;
				i++;
			}
			System.out.println();
		}
	}
	
	private static class Node<E> 
	{
		
		private E data;
		private Node<E> next;
		
		public Node(E element) 
		{
			data = element;
			next = null;
		}
	}
	
}
