
public class DoublyLinkedList<T> 
{
		// references to node at the front, back 
		// of the list
		private DLLNode<T> head, tail;
		// number of elements in the list 
		private int length;
		
		/**
		 * Default constructor - empty list. 
		 */
		public DoublyLinkedList()
		{
			head = tail = null;
			length = 0;
		}
		
		/**
		 * Constructor with given element 
		 * @param element - reference to object of 
		 * type T 
		 */
		public DoublyLinkedList(T element)
		{
			DLLNode<T> node = new DLLNode<T>(element);
			head = tail = node;
			length = 1;
		}
		
		/**
		 * Inserts new element at the end of the list. 
		 * @param element - reference to element 
		 * to be inserted of type T 
		 */
		public void insertAtBack(T element)
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
				node.setPrev(tail);
				tail.setNext(node);
			}
			// reset tail to new node
			setTail(node);
			// update length 
			length++;
		}
		
		/**
		 * Inserts new node at the front of the list
		 * @param element - reference to element 
		 * to be inserted of type T 
		 */
		public void insertAtFront(T element)
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
				head.setPrev(node);
				node.setNext(head);
			}
			// set head to the new node 
			setHead(node);
			// update length 
			length++;
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
			// assume element not found 
			DLLNode<T> node = null;
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
			return node;
		}
		
		/**
		 * Finds the node storing the element previous to the given element. 
		 * 
		 * @param element of type T after the element searching for 
		 * @return reference to node previous to the node with the given element 
		 */
		public DLLNode<T> findPrevious(T element)
		{
			// assume element not found 
			DLLNode<T> node = null;
			// begin search at the front of the list
			DLLNode<T> current = head; 
			// continue until reach end of list 
			while(current != null)
			{
				// if find element, return that node 
				if(current.getNext() != null && current.getNext().getElement() == element)
				{
					return current;
				}
				// update current
				current = current.getNext();
			}
			// not found, so return 
			return node;
		}
		
		/**
		 * Remove a given element from the list 
		 * @param element of type T to be deleted 
		 * @return reference to the node holding that element 
		 */
		public DLLNode<T> delete(T element)
		{
			// assume element not found 
			DLLNode<T> node = null;
			// find the element in the list
			DLLNode<T> result = find(element);
			// if node is found 
			if(result != null)
			{
				DLLNode<T> temp;
				// if at head of list, have more work to do 
				if(result == head)
				{
					// if tail is also head 
					if(length == 1)
					{
						setTail(null);
					}
					temp = head;
					setHead(temp.getNext());
					head.setPrev(temp.getPrev());
					// remove node from the list 
					temp.setPrev(null);
					temp.setNext(null);
				}
				
				// if delete tail, have to reset tail
				else if(result == tail)
				{
					temp = result.getPrev();
					setTail(temp);
					temp.setNext(null);
					//remove node from the list
					result.setNext(null);
					result.setPrev(null);
				}
				
				// node is not the head 
				else
				{
					// have to get previous to maintain links in list 
					
					temp = result.getPrev();
					DLLNode<T> temp1 = result.getNext();
					temp.setNext(result.getNext());
					temp1.setPrev(temp);
					// remove node from list 
					result.setPrev(null);
					result.setNext(null);
				}
				length--;
				return result; 
			}
			//not found, so return
			else
			{
				return node;
			}
			
			
		}
		
		/**
		 * Accessor method for head.
		 * @return - reference to SLLNode<T>
		 * that represents front of the list. 
		 */
		public DLLNode<T> head()
		{
			return head;
		}

		/**
		 * Accessor method for tail.
		 * @return - reference to SLLNode<T> 
		 * that represents the end of the list. 
		 */
		public DLLNode<T> tail()
		{
			return tail;
		}

		/**
		 * Mutator method for head. 
		 * @param node - reference to a node 
		 * of type SLLNode<T> 
		 */
		public void setHead(DLLNode<T> node)
		{
			head = node;
		}
		
		/**
		 * Mutator method for tail. 
		 * @param node - reference to a node of type 
		 * SLLNode<T> 
		 */
		public void setTail(DLLNode<T> node)
		{
			tail = node; 
		}
}
