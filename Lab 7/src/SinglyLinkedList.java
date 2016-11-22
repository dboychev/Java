import java.util.*;

public class SinglyLinkedList<E> extends AbstractCollection<E> {

	private Node<E> head;
	private int numElements;
	
	public SinglyLinkedList() 
	{
		head = null;
		numElements = 0;
	}
	
	private void printInReverse(Node<E> nodePtr)
	{
		if (nodePtr != null)
	    {
			printInReverse(nodePtr.next);
			System.out.println(nodePtr.data);
	    }
	}
	
	/**
	 *  Print the elements of the list in reverse order RECURSIVELY.
	 *  HINT: This is a wrapper method. You will need a private helper method
	 *  that is recursive. (Test code is in this class in the main method.)
	 */
	public void printInReverse() 
	{
		if (head == null)
		{
			System.out.println();
		}
		else
		{
			printInReverse(head);
		}
	}



	/**
	 *  Add element to the list at the head.
	 *  @param element The element to be inserted at the head.
	 *  @return Returns true always since list always changes.
	 */
	public boolean addFirst(E element) {
		head = new Node<E>(element, head);
		numElements++;
		return true;
	}


	/**
	 *  Returns the number of elements in this list.
	 *  @return Returns the number of elements in this list.
	 */
	public int size() {
		return numElements;
	}

	/**
	 *  Remove element from the head of this list.
	 *  @return Returns the element at the head of this list.
	 *  @throws NoSuchElementException if this list is empty.
	 */
	public E removeFirst() {
		if (head == null) 
			throw new NoSuchElementException();
		E result = head.data;
		head = head.next;
		numElements--;
		return result;
	}

	public String toString() {
		String result = "";
		Node<E> nodeRef = head;
		while (nodeRef != null) {
			result += nodeRef.data;
			nodeRef = nodeRef.next;
			if (nodeRef != null)
				result += "\n";
		}
		return result;
	}

	/**
	 *  Add element to the list at the head at the given index.
	 *  @param index The index in the list where the element should be inserted.
	 *  @param element The element to be inserted.
	 *  @return Returns true always since list always changes.
	 *  @throws IndexOutOfBoundsException if the index is negative or greater than the size of the list.
	 */
	public boolean add(int index, E element) {
		if (index < 0 || index > size())
			throw new IndexOutOfBoundsException();
		if (index == 0) {
			return addFirst(element);
		}
		Node<E> newNode = new Node<E>(element);
		Node<E> nodeRef = head;
		for (int i = 1; i < index; i++) 
			nodeRef = nodeRef.next;
		newNode.next = nodeRef.next;
		nodeRef.next = newNode;
		numElements++;
		return true;
	}
	
	/**
	 *  Remove element from the list at the given index.
	 *  @param index The index in the list where the element should be removed.
	 *  @return The element being removed.
	 *  @throws IndexOutOfBoundsException if the index is negative or greater than or equal to the size of the list.
	 */
	public E remove(int index) {
		if (index < 0 || index >= size())
		   throw new IndexOutOfBoundsException();
		if (index == 0) {
			return removeFirst();
		}
		Node<E> nodeRef = head;
		for (int i = 1; i < index; i++)
			nodeRef = nodeRef.next;
		E result = nodeRef.next.data;
		nodeRef.next = nodeRef.next.next;
		numElements--;
		return result;
	}


	/**
	 *  Get an iterator for this list.
	 *  @return A new iterator set at the beginning of this list.
	 */
	public Iterator<E> iterator() {
		return new SLLIterator();
	}
	
	private class SLLIterator implements Iterator<E> {
		private Node<E> nodePtr;
		private Node<E> prevPtr;
		private Node<E> prev2Ptr;
		private boolean okToRemove;
		private SLLIterator()  {
			nodePtr = head;
			prevPtr = null;
			prev2Ptr = null;
			okToRemove = false;
		}
		public boolean hasNext() {
			return nodePtr != null;
		}
		public E next() {
			if (nodePtr == null)
				throw new NoSuchElementException();
			E result = nodePtr.data;
			prev2Ptr = prevPtr;
			prevPtr = nodePtr;
			nodePtr = nodePtr.next;
			okToRemove = true;
			return result;
		}

		public void remove() {
			if (!okToRemove)
				throw new IllegalStateException();
			if (prev2Ptr == null) 
				head = nodePtr;
			else 
				prev2Ptr.next = nodePtr;
			prevPtr = prev2Ptr;
			okToRemove = false;
		}
		
	}

	private static class Node<E> {
		private E data;
		private Node<E> next;
		private Node(E element) {
			data = element;
			next = null;
		}
		private Node(E element, Node<E> nodeRef) {
			data = element;
			next = nodeRef;
		}
	}	

	public static void main(String[] args) {
		// TESTER for printInReverse for lab exercise

                SinglyLinkedList<Integer>  list1 = new SinglyLinkedList<Integer>();
                list1.addFirst(1);
                list1.addFirst(30);
                list1.addFirst(50);
                list1.addFirst(17);   
		list1.addFirst(49);
		list1.addFirst(26);
		list1.addFirst(88);
		// List: 88 26 49 17 50 30 1
		System.out.println("\nList 1:\n" + list1);
		System.out.println("List 1 in reverse: ");
		list1.printInReverse();

		SinglyLinkedList<String>  list2 = new SinglyLinkedList<String>();
		list2.addFirst("Genesis");
		list2.addFirst("ABBA");
		list2.addFirst("The Stooges");
		list2.addFirst("Jimmy Cliff");
		list2.addFirst("The Hollies");
		// list2: The Hollies, Jimmy Cliff, The Stooges, ABBA, Genesis
		System.out.println("\nList 2:\n" + list2);
		System.out.println("List 2 in reverse: ");
		list2.printInReverse();

		SinglyLinkedList<String> list3 = new SinglyLinkedList<String>();
		list3.addFirst("Pittsburgh");
		// list3: Pittsburgh
		System.out.println("\nList 3:\n" + list3);
		System.out.println("List 3 in reverse: ");
		list3.printInReverse();

		SinglyLinkedList<Integer> list4 = new SinglyLinkedList<Integer>();
		// list4: (empty)
		System.out.println("\nList 4:\n" + list4);
		System.out.println("List 4 in reverse: ");
		list4.printInReverse();
	}

}
