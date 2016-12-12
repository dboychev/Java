public class HeapSort
{
	// Simple application to use a heap to sort an array of data
	// Application inserts each value of the array into a 
	// minheap one element at a time. Then application removes
	// the min from the minheap repeatedly until the minheap is
	// empty to get the elements in non-decreasing order.

	public static void main(String[] args) {

		int[] values = {52, 35, 71, 49, 20, 95, 66, 18, 87 };

		MinHeap heap = new MinHeap();
		System.out.println("Heap: " + heap + "\n");

		for (int i : values) {
			heap.insert(i);
			System.out.println("Inserting " + i + ":");
			System.out.println("Heap: " + heap + "\n");
		}

		System.out.println();
		int[] sortedValues = new int[9];
		for (int i = 0; i < 9; i++) {
			sortedValues[i] = heap.remove();
			System.out.println("Removing " + sortedValues[i] + ":");
			System.out.println("Heap: " + heap + "\n");
		}

		System.out.println("SORTED ARRAY:");
		for (int i : sortedValues)
			System.out.print(i + " ");
		System.out.println();

	}

}
