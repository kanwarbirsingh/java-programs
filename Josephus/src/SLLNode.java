
/** Represents a node in singly linked list 
 *   that holds a reference to an element of 
 *   type T. 
 * @author Matt T 
 * @version summer 2015
 * @param <T> - class of objects held by the node 
 */
public class SLLNode<T>
{
	// reference to next node in the list
	SLLNode<T> next;
	// reference to the element stored in the node
	T element;
	
	/**
	 * Constructor. 
	 * @param element - reference to object of 
	 * type T 
	 */
	public SLLNode(T element)
	{
		// solitary node that doesn't point to another node yet
		setNext(null);				
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
	 * of type SSLNode<T> 
	 */
	public void setNext(SLLNode<T> node)
	{
		next = node;
	}
	
	/**
	 * Accessor method for next. 
	 * @return - reference to a node of 
	 * type SSLNode<T> 
	 */
	public SLLNode<T> getNext()
	{
		return next; 
	}
}