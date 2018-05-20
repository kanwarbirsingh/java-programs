

/**
 * Interface for a doubly linked list class. 
 * @author Matt T 
 * @version summer 2015
 * @param <T> generic objects can store in list 
 */
public interface DoublyLinkedList<T>
{
	/**
	 * Adds new node to the list, no location specified
	 * @param element - reference to element 
	 * to be inserted of type T 
	 */
	public void add(T element);
	
	/**
	 * Adds new node at the front of the list
	 * @param element - reference to element 
	 * to be inserted of type T 
	 */
	public void addToFront(T element);
	
	/**
	 * Adds new element at the end of the list. 
	 * @param element - reference to element 
	 * to be inserted of type T 
	 */
	public void addToRear(T element);
	
	/**
	 * Add element at a given index location. 
	 * @param index - location to add element at 
	 * @param element - of type T 
	 * @return whether or not insert is successful 
	 */
	public void addAt(int index, T element);
	
	/**
	 * Gets element stored at a given index in the list
	 * @param index of the element to be returned
	 * @return a reference to the element, or null if invalid index 
	 */
	public T get(int index);
	
	/**
	 * Sets element stored at a given index in the list to new element
	 * @param index of the element to be set
	 *@param new element to be set at this index 
	 */
	public void set(int index, T element);
	
	/**
	 * Gets given element in the list
	 * @param index of the element to be returned
	 * @return a reference to the element, or null if invalid index 
	 */
	public T get(T element);
	
	/**
	 * Gets gets index of the given element 
	 * @param element to be found
	 * @return index of the element to be found, -1 if not found
	 */
	public int indexOf(T element);
	
	/**
	 * Remove element at given index from the list 
	 * @param element of type T to be deleted 
	 * @return reference to the node holding that element 
	 */
	public T remove(int index);
	
	/**
	 * Remove a given element from the list 
	 * @param element of type T to be deleted 
	 * @return reference to the node holding that element 
	 */
	public T remove(T element);
	
	/**
	 * The number of elements in the list
	 * @return int number of elements 
	 */
	public int length();
}