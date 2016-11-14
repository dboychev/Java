import java.util.*;

public class SparseMatrixTester {

	public static void main(String[] args) {
		
		int numRows;
		int numColumns;
		
		printDirections();
		
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("Input number of rows for sparse matrix: ");
			try {
				numRows = scan.nextInt();
			} catch (NumberFormatException e) {
				numRows = 0;
			}
			System.out.println("Number of rows: " + numRows);
		} while (numRows <= 0);
		do {
			System.out.print("Input number of columns for sparse matrix: ");
			try {
				numColumns = scan.nextInt();
			} catch (NumberFormatException e) {
				numColumns = 0;
			}
			System.out.println("Number of columns: " + numColumns);
		} while (numColumns <= 0);
		scan.nextLine();				// clear input buffer
		
		SparseMatrix m = new SparseMatrix(numRows,numColumns);
		printMatrixByRows(m);
		printMatrixByColumns(m);
		System.out.println();

		boolean done = false;

		while (!done) {
			System.out.print("Input: ");
			String input = scan.nextLine();
			Scanner linescan = new Scanner(input);
			int data;
			int row; 
			int col;
			try {
				data = linescan.nextInt();
				row = linescan.nextInt();
				col = linescan.nextInt();
			} catch (NoSuchElementException e) {
				data = 0;
				row = -1;
				col = -1;
			}
			try {
				if (row == -1 && col == -1 && data == -1) 
					done = true;
				else {
					m.set(data, row, col);
					System.out.println("Storing " + data + " in row " + row + " column " + col);
					printMatrixByRows(m);
					printMatrixByColumns(m);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("ERROR: Invalid row or column.");
			}
			System.out.println();
		}
		
		SparseMatrix m2 = m.transpose();
		System.out.println("The TRANSPOSE of your matrix is: ");
		printMatrixByRows(m2);
		printMatrixByColumns(m2);

	}
		
	public static void printMatrixByRows(SparseMatrix m) {
		System.out.println("Sparse Matrix by Rows:");
		int numRows = m.getNumRows();
		int numColumns = m.getNumColumns();
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				System.out.print(m.getByRow(i, j) + "\t");
			}
			System.out.println("[" + m.getNumElementsInRow(i) + "]");
		}
		for (int j = 0; j < numColumns; j++) {
			System.out.print("[" + m.getNumElementsInColumn(j) + "]\t");
		}
		System.out.println();	
	}
	
	public static void printMatrixByColumns(SparseMatrix m) {
		System.out.println("Sparse Matrix by Columns:");
		int numRows = m.getNumRows();
		int numColumns = m.getNumColumns();
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColumns; j++) {
				System.out.print(m.getByColumn(i, j) + "\t");
			}
			System.out.println("[" + m.getNumElementsInRow(i) + "]");
		}
		for (int j = 0; j < numColumns; j++) {
			System.out.print("[" + m.getNumElementsInColumn(j) + "]\t");
		}
		System.out.println();	
	}
	
	public static void printDirections() {
		System.out.println("SPARSE MATRIX TESTER");
		System.out.println("At each prompt, input a triple: data row column");
		System.out.println("For example, to set row 2 column 1 to the value 43,");
		System.out.println("you would input 43 2 1");
		System.out.println("Input -1 -1 -1 to exit input loop.");
		System.out.println("Once you exit input loop, the transpose will be displayed.");
	}

}
