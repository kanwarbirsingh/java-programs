
/**
 *  Class representing a doubly linked list 
 *  that stores elements of type T and 
 *  implements DoublyLinkedList interface
 * @author Matt T
 * @version 2015
 * @param <T>- element stored in the list 
 */
public class MyDoublyLinkedList<T> implements DoublyLinkedList<T>
{
	// references to node at the front, back 
	// of the list
	private DLLNode<T> head, tail;
	// number of elements in the list 
	private int length;
	
	/**
	 * Default constructor - empty list. 
	 */
	public MyDoublyLinkedList()
	{
		head = tail = null;
		length = 0;
	}
	
	/**
	 * Constructor with given element 
	 * @param element - reference to object of 
	 * type T 
	 */
	public MyDoublyLinkedList(T element)
	{
		DLLNode<T> node = new DLLNode<T>(element);
		head = tail = node;
		length = 1;
	}
	
	/**
	 * Searches for given element in the list,
	 * returns reference to it if it exists,
	 * null otherwise. 
	 * @param element - reference to element 
	 * searching for 
	 * @return reference to an element of type T 
	 * or null 
	 */
	public DLLNode<T> find(T element)
	{
		// begin search at the front of the list
		DLLNode<T> current = head; 
		// continue until reach end of list 
		while(current != null)
		{
			// if find element, return that node 
			if(current.getElement() == element)
			{
				return current;
			}
			// update current
			current = current.getNext();
		}
		// not found, so return 
		return current;
	}

	/**
	 * Returns reference to node at a given index, null if not found
	 * @param index of node to be found
	 * @return reference to DLLNode<T>, or null if not found
	 */
	private DLLNode<T> find(int index)
	{
		// start at beginning of list
		DLLNode<T> current = head;
		// advance to node at given index 
		for(int i = 0; i < index; i++)
		{
			current = current.getNext();
		}
		return current;
	}

	/**
	 * Accessor method for head.
	 * @return - reference to DLLNode<T>
	 * that represents front of the list. 
	 */
	public DLLNode<T> head()
	{
		return head;
	}

	/**
	 * Accessor method for tail.
	 * @return - reference to DLLNode<T> 
	 * that represents the end of the list. 
	 */
	public DLLNode<T> tail()
	{
		return tail;
	}

	/**
	 * Mutator method for head. 
	 * @param node - reference to a node 
	 * of type DLLNode<T> 
	 */
	public void setHead(DLLNode<T> node)
	{
		head = node;
	}
	
	/**
	 * Mutator method for tail. 
	 * @param node - reference to a node of type 
	 * DLLNode<T> 
	 */
	public void setTail(DLLNode<T> node)
	{
		tail = node; 
	}
	
	@Override
	public int length()
	{
		return length;
	}
	
	@Override
	public T get(int index)
	{
		// set default return value
		T result = null;
		// get node at given index 
		DLLNode<T> node = find(index);
		// if found
		if(node != null)
		{
			result = node.getElement();
		}
		return result;
	}

	@Override
	public void add(T element)
	{
		// by default, add to end of list 
		addToRear(element);
	}

	@Override
	public void addToFront(T element)
	{
		// create new node with given element 
		DLLNode<T> node = new DLLNode<T>(element);
		// if empty list, set tail to this node 
		if(length == 0)
		{
			setTail(node);
		}
		// if one or more node in the list 
		else
		{
			// attach node to the front of the list 
			node.setNext(head);
			head.setPrevious(node);
		}
		// set head to the new node 
		setHead(node);
		// update length 
		length++;		
	}
	
	@Override
	public void addToRear(T element)
	{
		// create new node with given element 
		DLLNode<T> node = new DLLNode<T>(element);
		// if empty list, have to set head to this node
		if(length == 0)
		{
			setHead(node);
		}
		// list with one or more nodes 
		else
		{
			// attach new node to back of the list 
			tail.setNext(node);
			node.setPrevious(tail);
		}
		// reset tail to new node
		setTail(node);
		// update length 
		length++;
	}

	@Override
	public void addAt(int index, T element)
	{
		DLLNode<T> currNode, prevNode; 
		// if add to front
		if(index == 0)
		{
			addToFront(element);
		}
		// if add to back 
		else if(index == length)
		{
			addToRear(element);
		}
		// otherwise, have to find index of node where insert 
		else
		{
			DLLNode<T> newNode = new DLLNode<T>(element);
			// get node at given index 
			currNode = find(index);
			// update links to add the new node 
			prevNode = currNode.getPrevious();
			prevNode.setNext(newNode);
			newNode.setPrevious(prevNode);
			newNode.setNext(currNode);
			currNode.setPrevious(newNode);
		}
	}

	@Override
	public void set(int index, T element)
	{
		// get node at given index
		DLLNode<T> node = find(index);
		// if found 
		if(node != null)
		{
			node.setElement(element);
		}
	}

	@Override
	public T get(T element)
	{
		// set default return value
		T result = null;
		// find node with the element
		DLLNode<T> node = find(element);
		// node is found
		if(node != null)
		{
			result = node.getElement();
		}
		return result;
	}

	@Override
	public int indexOf(T element)
	{
		// set default return value
		int index = -1;
		// start at front of list
		DLLNode<T> node = head;
		// until not at end of list
		while(node != null)
		{
			// update index 
			index++;
			// if found
			if(node.getElement() == element)
			{
				return index;
			}
			// go to next node
			node = node.getNext();
		}
		return index;
	}

	@Override
	public T remove(int index)
	{
		// find the element in the list
		DLLNode<T> node = find(index);
		DLLNode<T> temp;
		// if node is found 
		if(node != null)
		{
			// if at head of list, have more work to do 
			if(node == head)
			{
				// if tail is also head 
				if(length == 1)
				{
					setTail(null);
				}
				temp = head;
				setHead(temp.getNext());
				head.setPrevious(null);
				// remove node from the list 
				temp.setNext(null);
			}
			// node is not the head 
			else
			{
				// have to get previous to maintain links in list 
				temp = node.getPrevious();
				// if delete tail, have to rest tail 
				if(node == tail)
				{
					setTail(temp);
				}
				temp.setNext(node.getNext());
				temp.getNext().setPrevious(temp);
				// remove node from list 
				node.setNext(null);
				node.setPrevious(null);
			}
			length--;
		}
		return node.getElement(); 	
	}

	@Override
	public T remove(T element)
	{
		T result; 
		// get index of element
		int index = indexOf(element);
		// get reference to the element 
		result = get(index);
		// remove using other remove method
		remove(index);
		return result; 
	}
}