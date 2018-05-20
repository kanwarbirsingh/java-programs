
import java.util.Arrays;

/**
 * A wrapper class for an array that can hold objects of type T 
 * 
 * @author Matt T 
 * @version summer 2015
 * @param <T> - type of objects stored in the Array collection
 */
public class Array<T> 
{
	private final int DEFAULT_CAPACITY = 100;
	// number of elements in the array, index of next open spot in the array. 
	private int count;
	// array to hold the objects 
	private T[] array;
	
	/**
	 * Default constructor 
	 */
	@SuppressWarnings("unchecked")
	public Array()
	{
		setCount(0);
		// have to create array for Objects because not 
		// know what objects will be stored in the array 
		array = (T[]) new Object[DEFAULT_CAPACITY];
	}
	
	/**
	 * Constructor with capacity specified. 
	 * @param capacity - initial size of the array 
	 */
	@SuppressWarnings("unchecked")
	public Array(int capacity)
	{
		setCount(0);
		// have to create array for Objects because not 
		// know what objects will be stored in the array 
		array = (T[]) new Object[capacity];
	}

	/**
	 * Insert element at a given location. 
	 * @param index - location to add element at 
	 * @param element - of type T 
	 * @return whether or not insert is successful 
	 */
	public boolean insertAt(int index, T element)
	{
		// ensure index is valid
		if(index >= 0 && index <= count)
		{
			// resize, if necessary 
			if(count >= array.length)
			{
				expand();
			}
			// shift elements after index, starting at the back 
			for(int i = count; i > index; i--)
			{
				array[i] = array[i - 1];
			}
			// add element to array
			array[index] = element;
			count++;
			
			return true; 
		}
		else
		{
			return false;
		}
	}	
	
	/**
	 * Increases the capacity of the array by 1.5
	 */
	public void expand()
	{
		array = Arrays.copyOf(array, (int)(array.length*1.5));
	}
	
	/**
	 * Deletes element at given index.
	 * @param element to be deleted 
	 * @return whether delete is successful 
	 */
	public boolean deleteAt(int index)
	{
		// ensure index is valid
		if(index >= 0 && index < count)
		{
			// shift elements to fill gap left by deleted element 
			for(int i = index; i < count - 1; i++)
			{
				array[i] = array[i + 1];
			}
			// set now vacant spot after last element to null 
			array[count - 1] = null;
			count--;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Finds the index in the array of a given element,
	 * returns -1 if not found 
	 * @param element of type T searching for 
	 * @return index of the element, or -1 if not found 
	 */
	public int indexOf(T element)
	{
		// set-up the return value
		int index = -1; 
		// search array for the element
		for(int i = 0; i < count; i++)
		{
			// if found, return index 
			if(array[i] == element)
			{
				return i;
			}
		}
		// if not found, return -1 
		return index;
	}

	/**
	 * Gets the number of elements in the array 
	 * @return number of elements 
	 */
	public int count() 
	{
		return count;
	}

	/**
	 * Sets number of elements in the array 
	 * @param count number of elements 
	 */
	public void setCount(int count) 
	{
		this.count = count;
	}
	
	/**
	 * Gets the element at a given index 
	 * @param index of the element to be returned 
	 * @return element at that index, null if index is out of bounds  
	 */
	public T get(int index)
	{
		// verify index is in bounds of the array 
		if(index >= 0 && index < count)
		{
			return array[index];
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Sets the element at the given index to the given element
	 * @param index of element to be set
	 * @param element of type T to set that index
	 * @return true if able to set that index, false otherwise
	 */
	public boolean set(int index, T element)
	{
		// verify index is in bounds of the array 
		if(index >= 0 && index < count)
		{
			array[index] = element;
			return true; 
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Creates a String of the Objects in the array.
	 * Overrides Object toString method
	 * @return String representing the objects in the array 
	 */
	public String toString()
	{
		String str = new String();
		// get each object, add it String representation to the string 
		for(int i = 0; i < count; i++)
		{
			str += array[i].toString();
			str += "\n";
		}
		str += "\n";
		return str;
	}
}