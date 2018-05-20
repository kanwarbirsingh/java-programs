

import java.util.Arrays;

/**
 * An unordered, indexed container that holds items of type T 
 * using an array implementation. 
 * @author Matt T 
 * @version summer 2015
 */
public class Bag<T>
{
	private int size; 
	private T[] data;  // array to hold objects of type T in the Bag
	private int count; // number of integers stored in the array

	/**
	 * Default constructor creates an empty Bag
	 */
	@SuppressWarnings("unchecked")
	public Bag() 
	{
		size = 100;
		data = (T[])new Object[size];
		count = 0;
	}

	/**
	 * Inserts a new item in the bag. 
	 *@param item - of type T to be inserted into the list
	 */
	public void insert(T item) 
	{
		if (count >= size) 
		{
			resize();		// expand size of bag 
		} 
		else 
		{
			data[count] = item;
			count++;
		}
	}

	/**
	 * Increases size of the bag by one half  
	 */
	private void resize()
	{
		size *= 0.5; 
		data = Arrays.copyOf(data, size);
	}
	
	/**
	 * Remove item from the bag. 
	 * @param target - item of type T looking for in the list
	 *  @return boolean - whether target is found
	 */
	public boolean remove(T target) 
	{
		for (int i = 0; i < count; i++) 
		{
			if (data[i] == target) 
			{
				data[i] = data[count-1];
				data[count - 1] = null;
				count--;
				return true;
			}
		}
		return false;
	}

	/**
	 * Retrieve items from bag 
	 * @param index - integer index into bag
	 */
	public T retrieve(int index)
	{
		return data[index];
	}
	
	/**
	 * Counts the number of occurrences of an item in the bag 
	 * 
	 * @param target - item of type T to be counted
	 * @return integer - number of times target occurs in the Bag
	 */
	public int occurrences(T target) 
	{
		int answer = 0;
		for (int i = 0; i < count; i++) 
		{
			if (target == data[i]) 
			{
				answer++;
			}
		}
		return answer;
	}

	/**
	 * Size of the bag. 
	 * @return integer - number of items in the bag
	 */
	public int size() 
	{
		return count;
	}

	/**
	 * Print elements of the bag.
	 */
	public void print() 
	{
		System.out.println("The bag has " + count + " elements:");
		if (count > 0) 
		{
			System.out.print(data[0].toString());
			for (int i = 1; i < count; i++) 
			{
				System.out.print(", " + data[i]);
			}
			System.out.println();
		}
	}
}
