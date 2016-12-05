import java.io.*;
import java.util.*;

public class NumberPuzzle 
{
	//A global boolean variable that shows if the matrix is filled and the puzzle - done. Initially set to false
    public static boolean isFilled = false;
 
    //A method that checks whether a matrix is filled or still has any empty cells
    public static boolean isFilled(int[][] matrix) 
    {
        for (int i = 0; i < matrix.length; i++) 
        {
            for (int j = 0; j < matrix.length; j++) 
            {
            	//If there is a 0 anywhere, the puzzle is not done yet
                if (matrix[i][j] == 0) 
                {
                    return false;
                }
            }
        }
 
        return true;
    }
 
    //Use Depth-First Search algorithm
    public static void dfs(int[][] matrix, int row, int col, int number) 
    {
    	//Check if the numbers for row and col are not correct or the matrix is already filled
        if (row < 0 || row > matrix.length - 1 || col < 0 || col > matrix.length - 1 || isFilled) 
        {
            return;
        }
 
        //Check if the matrix is filled
        if (isFilled(matrix)) 
        {
        	//If yes, isFilled variable also turns into true
            isFilled = true;
            return;
        }
 
        //The only case when is possible to continue searching for the path
        if (matrix[row][col] == 0) 
        {
        	//The current cell gets the current number
            matrix[row][col] = number;
            
            //Try all the four different moves - up, down, right, left. If program stops in one of them, the right
            //path was found
            dfs(matrix, row + 1, col, number + 1);
            if(isFilled)
            {
                return;
            }
            
            dfs(matrix, row - 1, col, number + 1);
            if(isFilled)
            {
                return;
            }
            
            dfs(matrix, row, col + 1, number + 1);
            if(isFilled)
            {
                return;
            }
            
            dfs(matrix, row, col - 1, number + 1);
            if(isFilled)
            {
                return;
            }
            
            //If program has not stopped yet - no correct path was found. The cell gets the number 0 again
            else
            {
                matrix[row][col] = 0;
            }
            
        }
        
        //Looking at all the other cases
        else 
        {
        	//If the current cell has our number, we have found the needed path - continue with other numbers
            if (matrix[row][col] == number) 
            {
                dfs(matrix, row + 1, col, number + 1);
                dfs(matrix, row - 1, col, number + 1);
                dfs(matrix, row, col + 1, number + 1);
                dfs(matrix, row, col - 1, number + 1);
            } 
            
            //If not - that is not our path, we have to start again from the previous given number
            else 
            {
                return;
            }
        }
    }
 
    //A method to fill the matrix
    private static void fillMatrix(int[][] matrix, int x, int y) 
    {
    	//Create a copy of the matrix to use in each case
        int[][] originalMatrix = Arrays.copyOf(matrix, matrix.length);
        
        //Start depth-first search - looking for the place for the number 2 - firstly at the right neighbor cell
        dfs(matrix, x, y + 1, 2);
      
        //If not filled yet - try with the upper cell, then - the left one, and the one down
        if (!isFilled) 
        {
            matrix = originalMatrix;
            dfs(matrix, x + 1, y, 2);
        }
 
        if (!isFilled) 
        {
            matrix = originalMatrix;
            dfs(matrix, x, y - 1, 2);
        }
 
        if (!isFilled) 
        {
            matrix=originalMatrix;
            dfs(matrix, x-1, y, 2);
        }
    }
 
    //A program for printing the matrix
    public static void printMatrix(int[][] matrix) 
    {
    	//Print the matrix element by element
        for (int i = 0; i < matrix.length; i++) 
        {
            for (int j = 0; j < matrix[i].length; j++) 
            {
                System.out.print(matrix[i][j] + "\t");
            }
 
            //Separating the rows
            System.out.println();
        }
        
        //Another new line
        System.out.println();
    }
 
    public static void main(String[] args) throws FileNotFoundException 
    {
    	//Two variables - one for the number of puzzles, the other - for the size of each puzzle matrix
        int puzzles, size; 
        
        //A scanner to read the data from a file
		BufferedReader in = new BufferedReader(new FileReader("data.txt")); //An object to open the file
		Scanner scan = new Scanner(in);
		
		//First number at the file shows the number of puzzles
        puzzles = scan.nextInt();
        
        //A loop for each of the puzzles
        for (int i = 0; i < puzzles; i++) 
        {
        	//The first number before the matrix shows its size
            size = scan.nextInt();
            
            //Create the matrix with appropriate size
            int[][] matrix = new int[size][size];
            
            //Create two variables to store the location of the smallest number - 1
            int x = 0, y = 0;
            
            //Fill the matrix with the number from the file
            for (int row = 0; row < size; row++) 
            {
                for (int col = 0; col < size; col++) 
                {
                    matrix[row][col] = scan.nextInt();
                    
                    //If there is the number 1 anywhere, save its coordinates
                    if (matrix[row][col] == 1) 
                    {
                        x = row;
                        y = col;
                    }
                }
            }
 
            fillMatrix(matrix, x, y);
            printMatrix(matrix);
            isFilled=false;
            }
        
        scan.close();
    }
}