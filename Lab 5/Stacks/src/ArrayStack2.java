
import java.util.*;

public class ArrayStack2<E> implements LIFOStack<E>
{
	private E[] dataArray;
	private int dataPtr;
	private final int top = 0;

	public ArrayStack2()
	{
		dataArray = (E[])new Object[1];
		dataPtr = -1;
	}

	public void push(E element) 
	{
		if (dataArray.length == dataPtr + 1)
		{
			reallocate();
		}
		
		for (int i = dataPtr + 1; i > 0; i--)
		{
			dataArray[i] = dataArray[i - 1];
		}
		
		dataArray[top] = element;
		
		dataPtr++;
	}

	private void reallocate() 
	{
		E[] newDataArray = (E[]) new Object[dataArray.length * 2];
		for (int i = 0; i < dataArray.length; i++)
		{
			newDataArray[i] = dataArray[i];
		}
		
		dataArray = newDataArray;	
	}

	public boolean isEmpty() 
	{
		return (dataArray[top] == null);
	}

	public E pop() 
	{
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}
		else
		{
			E removed = dataArray[top];
	
			for (int i = 0; i < dataPtr ; i++)
			{
				dataArray[i] = dataArray[i + 1];
			}		
			
			dataArray[dataPtr] = null;
			
			dataPtr--;
			
			return removed;
		}
	}

	public E peek() 
	{
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}
		
		else
		{
			return dataArray[top];
		}
	}
	
	public String toString()
	{
		String result = "";
		
		for (int i = 0; i <= dataPtr; i++)
		{
			result += dataArray[i] + " ";
		}
		
		return result;		
	}

	
}
