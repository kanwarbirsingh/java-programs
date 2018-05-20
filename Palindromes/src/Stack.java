//Stack class extends Array class
public class Stack<T> extends Array<T>
{
	//Instance Variables
	private final int DEFAULT_CAPACITY=100;
	private int top;
	private T[] StackArray;
	
	//Default Constructor
	@SuppressWarnings("unchecked")
	public Stack()
	{
		
		StackArray = (T[]) new Object[DEFAULT_CAPACITY];
		top = 0;
	}
	
	//Parametrized constructor
	@SuppressWarnings("unchecked")
	public Stack(int capacity)
	{
		
		StackArray = (T[]) new Object[capacity];
		top = 0;
	}
	
	//Push method for stack
	public void push(T element) 
	{
		if(top == StackArray.length)
		{
			expand();
		}
		
			StackArray[top] = element;
			top++;
		
	}
	
	//Check whether the stack is empty or not
	public boolean isEmpty() 
	{
		if(top == 0)
		{
			return true;
		}
		return false;
	}

	//Pop method for stack
	//Throws EmptyCollectionException if stack is empty
	public T pop() 
	{
		if(!isEmpty())
		{
				top--;
				T value = StackArray[top];
				
				return value;
			
		}
		else
		{
			throw new EmptyCollectionException("Stack");
			
		}
	}
	
	//Peep method for stack
	//Throws EmptyCollectionException if stack is empty
	public T peek()
	{
		if(!isEmpty())
		{
			return StackArray[top];
		}
		else
		{
			throw new EmptyCollectionException("Stack");
		}
	}
	
	//Creates a string of objects in the array
	public String toString()
	{
		String str = new String();
		// get each object, add it String representation to the string 
		for(int i = 0; i < top; i++)
		{
			str += StackArray[i].toString();
			str += "\n";
		}
		str += "\n";
		return str;
	}

}
