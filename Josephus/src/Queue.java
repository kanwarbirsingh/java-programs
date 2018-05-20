
//Queue class using Singly Linked List data structure implementation
//Stores elements of type T

public class Queue<T> 
{
	//References to node at front and end
	private SLLNode<T> front,end;
	//Size of the list/queue
	private int size;
	
	//Default Constructor - Empty Queue
	public Queue()
	{
		setFront(setEnd(null));
		size = 0;
	}
	
	//Parametrized Constructor - Queue with one element
	public Queue(T element)
	{
		SLLNode<T> node = new SLLNode<T>(element);
		setFront(setEnd(node));
		size = 1;
	}
	
	//Method to add an element to the queue
	//@param T element - reference to object of type T
	public void enqueue(T element) 
	{
		// create new node with given element 
				SLLNode<T> node = new SLLNode<T>(element);
				// if empty list/queue, have to set head to this node
				if(size == 0)
				{
					setFront(node);
				}
				// list/queue with one or more nodes 
				else
				{
					// attach new node to back of the list 
					end.setNext(node);
				}
				// reset tail to new node
				setEnd(node);
				// update size
		size++;
	}

	//Method checks whether the queue is empty or not
	//Returns true or false accordingly
	public boolean isEmpty() 
	{
		if(size == 0)
		{
			return true;
		}
		return false;
	}

	//Returns the size of the queue
	public int size() 
	{
		return size;
	}

	//Method to remove an element from the queue(front of the queue)
	//Throws EmptyCollectionException if the queue is empty
	public T dequeue() 
	{
		if(isEmpty())
		{
			throw new EmptyCollectionException("queue");
		}
		SLLNode<T> node = front;
		front = node.getNext();
		if(front == null)
		{
			end = null;
		}
		size--;
		return node.getElement();
	}

	//Accessor method for front node of queue
	public SLLNode<T> front() {
		return front;
	}

	//Mutator method for front node of queue
	public void setFront(SLLNode<T> front) {
		this.front = front;
	}

	//Accessor method for end node of queue
	public SLLNode<T> end() {
		return end;
	}

	//Mutator method for end node of queue
	public SLLNode<T> setEnd(SLLNode<T> end) {
		this.end = end;
		return end;
	}
	
	//Returns elements of the queue in a string format
	public String toString()
	{
		String str = new String("LinkedQueue [");
		SLLNode<T> node = front;
		
		//Prints out first element
		str+= node.getElement();
		node = node.getNext();
		
		//Prints other elements of the queue
		while(node != end.getNext())
		{
			str += ", " + node.getElement();
			node = node.getNext();
		}
		str += "]";
		//All elements printed
		return str;
		
	}
}
