

/** Represents a node in doubly linked list 
 *   that holds a reference to an element of type T. 
 * @author Matt T 
 * @version summer 2015
 * @param <T> - class of objects held by the node 
 */
public class DLLNode<T>
{
	// reference to next, previous nodes in the list
	DLLNode<T> next, previous;
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
		setPrevious(null);
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
	 * Mutator method for previous. 
	 * @param node - reference to a node 
	 * of type DLLNode<T> 
	 */
	public void setPrevious(DLLNode<T> node)
	{
		previous = node;
	}

	/**
	 * Accessor method for next. 
	 * @return - reference to a node of 
	 * type SSLNode<T> 
	 */
	public DLLNode<T> getNext()
	{
		return next; 
	}

	/**
	 * Accessor method for previous. 
	 * @return - reference to a node of 
	 * type DLLNode<T> 
	 */
	public DLLNode<T> getPrevious()
	{
		return previous; 
	}

}