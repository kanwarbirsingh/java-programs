import java.util.Iterator;


public class Bag<T> 
{
	private DoublyLinkedList<T> newList;	//New Doubly Linked list to hold objects of type t
	private int count; // number of integers stored in the linked list
	private int modCount; // number of modifications, used for iterator
	
	/**
	 * Default constructor creates an empty Bag
	 */
	public Bag() 
	{
		newList = new DoublyLinkedList<T>();
		count = 0;
		modCount = 0;
	}
	
	/**
	 * Constructor that initializes capacity. 
	 * @param capacity
	 */
	public Bag(int capacity) 
	{
		newList = new DoublyLinkedList<T>();
		count = 0;
		modCount = 0;
	}
	
	/**
	 * Inserts a new item in the bag. 
	 *@param item - of type T to be inserted into the list
	 */
	public void insert(T item) 
	{
		newList.insertAtBack(item);
		count++;
		modCount++;
	}
	
	/**
	 * Remove item from the bag. 
	 * @param target - item of type T looking for in the list
	 *  @return boolean - whether target is found
	 */
	public boolean remove(T target) 
	{
		while(newList.find(target)!=null)
		{
		newList.delete(target);
		count--;
		modCount++;
		return true;
		}
		return false;
		
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
		
		DLLNode<T> current = newList.head();
		
		while(current != null)
		{
		T value = current.getElement();
		if(value == target)
		{
			answer++;
		}
		current = current.getNext();
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
	 * Print contents of the bag.
	 */
	public void print() 
	{
		System.out.println("The bag has " + count + " elements:");
		// use iterator to go through contents of the bag 
		Iterator<T> itr = new BagIterator();
		T element;
		// print out first element without comma
		if(itr.hasNext())
		{
			element = itr.next();
			System.out.print(element.toString());
		}
		// go through rest of the list
		while(itr.hasNext())
		{
			element = itr.next();
			System.out.print(", " + element.toString());
		}
		System.out.println();
	}
	
	/**
	 * Returns a BagIterator for element of the type T. 
	 * 
	 * @return an Iterator for a Bag of the 
	 * elements of type T
	 */
	public Iterator<T> iterator()
	{
		return new BagIterator();
	}

	/**
	 * An inner iterator class for the Bag class. 
	 * 
	 */
	private class BagIterator implements Iterator<T>
	{
		// keeps track of number of modifications since the 
		// iterator was instantiated.
		private int iteratorModCount;
		// index of current node in the list 
		// iterator located between this location and the previous index
		private int current;
		// reference to current element in the node in the list
		private DLLNode<T> currentelement;
		
		/**
		 * Default constructor 
		 */
		public BagIterator()
		{
			// set modification count to count for the outer class 
			iteratorModCount = modCount;
			current = 0;
			currentelement = newList.head();
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
			if (currentelement != null)
                return true;
            else
                return false;
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
			T node = currentelement.getElement();
			currentelement = currentelement.getNext();
			// update position in the list
			current++;

			// return reference to the element just pointing to
			return (node);
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}
}
