

/**
 * IndexedList defines the interface to an indexed list collection. Elements
 * are referenced by contiguous numeric indexes.
 *
 * @version summer 2015
 */
public interface IndexedList<T> extends List<T>
{
    /**  
     * Inserts the specified element at the specified index. 
     * 
     * @param index   the index into the array to which the element is to be inserted.
     * @param element the element to be inserted into the array
     * @throws IndexOutOfBoundsException if the index is out of range 
     */
    public void addAt(int index, T element);

    /**  
     * Sets the element at the specified index. 
     *
     * @param index   the index into the array to which the element is to be set
     * @param element the element to be set into the list
     * @throws IndexOutOfBoundsException if the index is out of range 
     */
    public void set(int index, T element);

    /**  
     * Adds the specified element to the rear of this list. 
     *
     * @param element  the element to be added to the rear of the list    
     */
    public void add(T element);

    /**  
     * Returns a reference to the element at the specified index. 
     *
     * @param index  the index to which the reference is to be retrieved from
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T get(int index);

    /**  
     * Returns the index of the specified element. 
     *
     * @param element  the element for the index is to be retrieved
     * @return the integer index for this element or 
     * @throws ElementNotFoundException if element is not in the list    
     */
    public int indexOf(T element);

	/**  
     * Returns the element at the specified element. 
     *
     * @param index the index of the element to be retrieved
     * @return the element at the given index
     * @throws IndexOutOfBoundsException if the index is out of range 
     */
    public T removeAt(int index);
}