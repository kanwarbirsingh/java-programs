
import java.util.Iterator;

/**
 * Indexed list class that implements the IndexedList interface. 
 * Uses DoublyLinkedList to implement the list. 
 * @author Matt T 
 * @version summer 2015
 * @param <T> generic type of objects stored in list 
 */
public class MyIndexedList<T> implements IndexedList<T>
{
	// list storing objects 
	private DoublyLinkedList<T> list;
	// for Iterator, counts number of list modifications 
	private int modCount; 
	
	/**
	 * Default constructor - empty list
	 */
	public MyIndexedList()
	{
		list = new MyDoublyLinkedList<T>();
		modCount = 0; 
	}
	
	/**
	 * Constructor for list of given size
	 * All entries are null 
	 * @param size int of size of list 
	 */
	public MyIndexedList(int size)
	{
		list = new MyDoublyLinkedList<T>();
		for(int i = 0; i < size; i++)
		{
			list.addAt(i, null); 
		}
		modCount = size; 
	}
	
	/**
	 * Constructor - initialize to a given array of values
	 * @param size of array
	 * @param array of T values 
	 */
	public MyIndexedList(T[] array, int size)
	{
		list = new MyDoublyLinkedList<T>();
		for(int i = 0; i < size; i++)
		{
			list.addToRear(array[i]); 
		}
		modCount = size; 
	}

	@Override
	public T removeFirst()
	{
		T result = null;
		if(isEmpty())
		{
			throw new EmptyCollectionException("MyIndexedList");
		}
		else
		{
			result = first();
			list.remove(0);
			modCount++;
		}
		return result;
	}

	@Override
	public T removeLast()
	{
		T result;
		if(isEmpty())
		{
			throw new EmptyCollectionException("MyIndexedList");
		}
		else
		{
			result = last();
			list.remove(size() - 1);
			modCount++;
		}
		return result;
	}

	@Override
	public T remove(T element)
	{
		T result = null; 
		int index = list.indexOf(element);
		// if not found index == -1 
		if(index < 0)
		{
			throw new ElementNotFoundException("MyIndexedList");
		}
		else
		{
			result = list.get(index);
			list.remove(index);
			modCount++;
		}
		return result;
	}

	@Override
	public T first()
	{
		return list.get(0);
	}

	@Override
	public T last()
	{
		return list.get(size() - 1);
	}

	@Override
	public boolean contains(T target)
	{
		// if target found, index == -1
		if(list.indexOf(target) != -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isEmpty()
	{
		if(size() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int size()
	{
		return list.length();
	}

	@Override
	public Iterator<T> iterator()
	{
		return new MyIndexedListIterator(); 
	}

	@Override
	public void addAt(int index, T element)
	{
		if(index < 0 || index >= size())
		{
			throw new IndexOutOfBoundsException("MyIndexedList");
		}
		else
		{
			list.addAt(index, element);
			modCount++;
		}
	}

	@Override
	public void set(int index, T element)
	{
		if(index < 0 || index >= size())
		{
			throw new IndexOutOfBoundsException("MyIndexedList");
		}
		else
		{
			list.set(index, element);
			modCount++;
		}
	}

	@Override
	public void add(T element)
	{
		list.addAt(size(), element);
		modCount++;
	}

	@Override
	public T get(int index)
	{
		if(index < 0 || index >= size())
		{
			throw new IndexOutOfBoundsException("MyIndexedList");
		}
		return list.get(index);
	}

	@Override
	public int indexOf(T element)
	{
		int index = list.indexOf(element);
		// if not found, index == -1
		if(index == -1)
		{
			throw new ElementNotFoundException("MyIndexedList");
		}
		return index;
	}

	@Override
	public T removeAt(int index)
	{
		T result = null;
		if(index < 0 || index >= size())
		{
			throw new IndexOutOfBoundsException("MyIndexedList");
		}
		else
		{
			result = list.get(index);
			list.remove(index);
			modCount++;
		}
		return result; 
	}
	
	/**
	 * String representation of list. 
	 * @return String of the list 
	 */
	public String toString()
	{
		String str = "[";
		if(list.get(0) != null)
		{
			str += list.get(0).toString(); 
		}
		for(int i = 1; i < list.length(); i++)
		{
			str += ",";
			str += list.get(i);
		}
		str += "]";
		return str;
	}

	/**
	 * An inner iterator class for the MyIndexedList class. 
	 * 
	 * @author Matt T 
	 * @version summer 2015
	 */
	private class MyIndexedListIterator implements Iterator<T>
	{
		// keeps track of number of modifications since the 
		// iterator was instantiated.
		private int iteratorModCount;
		// index of current node in the list 
		// iterator located between this location and the previous index
		private int current;
		
		/**
		 * Default constructor 
		 */
		public MyIndexedListIterator()
		{
			// set modification count to count for the outer class 
			iteratorModCount = modCount;
			current = 0;
		}

		/**
		 * Checks if a modification has been done since the Iterator 
		 * was instantiated
		 * 
		 * @throws ConcurrentModificationException
		 */
		private void checkMod()
		{
			// counts don't match 
			if(iteratorModCount != modCount)
			{
				throw new ConcurrentModificationException("BagIterator"); 
			}
		}
		
		/**
		 * Returns true if there's another unexamined element in the list.
		 * 
		 * @return boolean, true if another element in the list, false otherwise
		 * @throws ConcurrentModificationException 
		 */
		public boolean hasNext() throws ConcurrentModificationException 
		{
			// if  list has been changed since the iterator was instantiated
			checkMod(); 
			// otherwise, determine whether have reached end of the list or not 
			return (current + 1 <= size()); 
		}
		
		/**
		 * Returns a reference to the next element in the list. 
		 * 
		 * @return a reference to an element of the type T
		 * @throws ElementNotFoundException
		 */
		public T next() throws ElementNotFoundException 
		{
			checkMod();
			// check if any more elements in the list
			if(!hasNext())
			{
				throw new ElementNotFoundException("Bag");
			}
			// update position in the list
			current++;

			// return reference to the element just pointing to
			return list.get(current - 1);
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}

}