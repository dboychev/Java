/**
 * 
 * @author dimo
 *
 */
public class SparseMatrix extends Object
{
	//4 fields - 2 integers for the number of rows and columns, two Node arrays for storing the nodes in them
	private int rows;
	private int cols;
	private Node[] refByRow;
	private Node[] refByCol;
	
	/**
	 *  Create a new sparse matrix of integers with r rows and c columns.
	 * 
	 * @param r - the number of rows in the sparse matrix
	 * @param c - the number of columns in the sparse matrix
	 */
	public SparseMatrix(int r, int c)
	{
		//If the values for row and column are not valid
		if (c < 1 || r < 1)
		{
			rows = 5;
			cols = 5;
		}
		else
		{
			rows = r;
			cols = c;
		}
		
		//Creating the arrays
		refByRow = new Node[rows];
		refByCol = new Node[cols];
	}
	
	/**
	 * Get the number of rows in this sparse matrix.
	 * 
	 * @return - the number of rows in this sparse matrix
	 */
	public int getNumRows()
	{
		return rows;
	}
	
	/**
	 * Get the number of columns in this sparse matrix.
	 * 
	 * @return - the number of columns in this sparse matrix
	 */
	public int getNumColumns()
	{
		return cols;
	}
	
	/**
	 * Set the given row and column of this sparse matrix to the given value.
	 * 
	 * @param newValue - the value to store in the sparse matrix
	 * @param newRow - the row where the value is to be stored
	 * @param newCol - the column where the value is to be stored
	 */
	public void set(int newValue, int newRow, int newCol)
	{
		//If the values for the new node's position and its value are valid
		if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && newValue >= 0)
		{
			//Check if the place is already taken
			if (checkForNode(newRow, newCol))
			{
				//If it is - check what is the new value
				if (newValue > 0)
				{
					//If it is bigger than 0, we just change the value of the node on that place
					Node temp = refByRow[newRow];
					while (temp.row != newRow)
					{
						temp = temp.nextC;
					}
					
					temp.value = newValue;
				}
				
				//If the value is 0, we delete the node
				if (newValue == 0)
				{
					deleteNode(newRow, newCol);
				}
			}
			
			else
			{
				//If place is free - a new node is created and added
				if (newValue > 0)
				{
					connectNode(newValue, newRow, newCol);
				}
			}
		}
	}
	
	/**
	 * Helper function that deletes a node from its row and column.
	 * 
	 * @param row - the row where the node is
	 * @param col - the column where the node is
	 */
	private void deleteNode(int row, int col)
	{
		//A temp node to help findin the the nodes before that one which should be deleted
		Node temp = refByRow[row];
		if (temp.col != col || temp.row != row)
		{
			//Going through the nodes in the row 1 by 1
			while (temp.nextC.row != row || temp.nextC.col != col)
			{
				temp = temp.nextC;
			}
			
			//Skipping that one element - it is removed from the row
			temp.nextC = temp.nextC.nextC;
		}
		else
		{
			//If it was the first one at the row
			refByRow[row] = temp.nextC;
			temp = null;
		}
		
		//Doing the same for the other array
		temp = refByCol[col];
		if (temp.col != col || temp.row != row)
		{
			//Going through all the nodes until the correct one si found
			while (temp.nextR.row != row || temp.nextR.col != col)
			{
				temp = temp.nextR;
			}
			temp.nextR = temp.nextR.nextR;
		}
		else
		{
			//If it was the first one at the column
			refByCol[col] = temp.nextR;
			temp = null;
		}
	}
	
	/**
	 * A helper function that creates the connections between a new node in the arrays and the other nodes.
	 * 
	 * @param newValue - the value of the new node
	 * @param newRow - the row of the new node
	 * @param newCol - the column of the new node
	 */
	private void connectNode(int newValue, int newRow, int newCol)
	{
		//Create the new node that should be added
		Node newNode = new Node(newValue, newRow, newCol);
		//Create a temp node that will be used to help adding the other
		Node temp = null;
		//If the row is empty, it becomes the first element on it
		if (refByRow[newRow] == null)
		{
			refByRow[newRow] = newNode;
		}
		
		else
		{
			//If it was not empty
			temp = refByRow[newRow];
			
			//Find the correct place for the new node
			while (temp.nextC != null && temp.nextC.row < newRow)
			{	
				temp = temp.nextC;
			}
	
			newNode.nextC = temp.nextC;
			temp.nextC = newNode;
			
		}
		
		
		//Do the same with the other array
		if (refByCol[newCol] == null)
		{
			refByCol[newCol] = newNode;
		}
		
		else
		{
			temp = refByCol[newCol];
				
			while (temp.nextR != null && temp.nextR.col < newCol)
			{
				temp = temp.nextR;
			}
			
			newNode.nextR = temp.nextR;
			temp.nextR = newNode;		
		}
	}
	
	/**
	 * A helper function that shows if a node's place is already taken in the list.
	 * 
	 * @param row - the row of the node
	 * @param col - the column of the node
	 * @return - true if the place is taken, false - if it is free
	 */
	private boolean checkForNode(int row, int col)
	{
		//Create a boolean variable to show us if what we wanted is done
		boolean exists = false;
		//Create a temp node
		Node temp = refByRow[row];
		while (temp != null && !exists)
		{
			//If we reach that place with the desired row and column, the loop should be stopped
			if (temp.row == row && temp.col == col)
			{
				//Change the value of the boolean
				exists = true;
			}
			//Going through the nodes
			temp = temp.nextC;
		}
		
		return exists;
	}
	
	/**
	 * Gets the value stored at the given row and column of this sparse matrix by scanning across the given row.
	 * 
	 * @param row - the row of the desired value
	 * @param column - the column of the desired value
	 * @return - the value stored at the given row and column
	 */
	public int getByRow (int row, int column)
	{
		//Create a variable, initially set to 0
		int value = 0;
		
		//Create a temp node
		Node temp = refByRow[row];
	
		//Go through all the nodes
		while (temp != null && value == 0)
		{
			if (temp.row == row && temp.col == column)
			{
				//Assign value the value of the desired node
				value = temp.value;
			}
			
			temp = temp.nextC;
		}
		
		return value;
	}
	
	/**
	 * Gets the value stored at the given row and column of this sparse matrix by scanning down the given column.
	 * 
	 * @param row - the row of the desired value
	 * @param column - the column of the desired value
	 * @return - the value stored at the given row and column
	 */
	public int getByColumn (int row, int column)
	{
		int value = 0;
		
		Node temp = refByCol[column];
	
		while (temp != null && value == 0)
		{
			if (temp.col == column && temp.row == row)
			{
				value =  temp.value;
			}
			
			temp = temp.nextR;
		}
			
		return value;
	}
	
	/**
	 * Gets the number of elements stored in the given row of this sparse matrix (for debugging purposes).
	 * 
	 * @param row - the desired row to analyze
	 * @return - the number of elements stored in the given row in this sparse matrix
	 */
	public int getNumElementsInRow(int row)
	{
		int counter = 0;

		//Go through all the elements in a row until a null object is reached
		Node temp = refByRow[row];
		while (temp != null)
		{
			//Counter increases on each step 
			counter++;
			temp = temp.nextC;
		}
		
		return counter;
	}
	
	/**
	 * Gets the number of elements stored in the given column of this sparse matrix (for debugging purposes).
	 * 
	 * @param col - the desired column to analyze
	 * @return - the number of elements stored in the given column in this sparse matrix
	 */
	public int getNumElementsInColumn(int col)
	{
		int counter = 0;

		Node temp = refByCol[col];
		while (temp != null)
		{
			counter++;
			temp = temp.nextR;
		}
				
		return counter;
	}
	
	/**
	 * Returns the transpose of this sparse matrix.
	 * 
	 * @return - a new sparse matrix containing the transpose of this sparse matrix
	 */
	public SparseMatrix transpose()
	{
		//Create a new matrix object
		SparseMatrix newMatrix = new SparseMatrix(cols, rows);
		for (int i = 0; i < rows; i++)
		{
			if (refByRow[i] != null)
			{
				//Set all of its nodes but with swapped rows and columns
				newMatrix.set(refByRow[i].value, refByRow[i].col, refByRow[i].row);
			}
		}
			
		return newMatrix;
	}
	
	/**
	 * 
	 * @author dimo
	 *
	 */
	public class Node
	{
		int value, row, col;
		Node nextR, nextC;
				
		/**
		 * Constructor of a node.
		 * 
		 * @param v - value of the element
		 * @param r - row of the node's place
		 * @param c - columns of the node's place
		 */
		public Node(int v, int r, int c)
		{
			value = v;
			row = r;
			col = c;
			nextR = null;
			nextC = null;
		}
	}
	
}
