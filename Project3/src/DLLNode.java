
public class DLLNode<T>
{
	// reference to next node in the list
	DLLNode<T> next;
	// reference to previous node in the list
	DLLNode<T> prev;
	// reference to the element stored in the node
	T element;

	/**
	 * Constructor. 
	 * @param element - reference to object of 
	 * type T 
	 */
	public DLLNode(T element)
	{
		// solitary node that doesn't point to another node yet
		setNext(null);
		setPrev(null);
		// point to the element 
		setElement(element); 
	}
	
	/**
	 * Mutator method for element 
	 * @param element - reference to object 
	 * of type T 
	 */
	public void setElement(T element)
	{
		this.element = element;
	}
	
	/**
	 * Accessor method for element. 
	 * @return - reference to element of type T 
	 */
	public T getElement()
	{
		return element;
	}
	
	/**
	 * Mutator method for next. 
	 * @param node - reference to a node 
	 * of type DLLNode<T> 
	 */
	public void setNext(DLLNode<T> node)
	{
		next = node;
	}
	
	/**
	 * Accessor method for next. 
	 * @return - reference to a node of 
	 * type DLLNode<T> 
	 */
	public DLLNode<T> getNext()
	{
		return next; 
	}
	
	/**
	 * Mutator method for prev. 
	 * @param node - reference to a node 
	 * of type DLLNode<T> 
	 */
	public void setPrev(DLLNode<T> node)
	{
		prev = node;
	}
	
	/**
	 * Accessor method for prev. 
	 * @return - reference to a node of 
	 * type DLLNode<T> 
	 */
	public DLLNode<T> getPrev()
	{
		return prev; 
	}

}
