


/**
 * Sort class for sorting indexed lists using Quicksort or Mergesort. 
 * @author Matt T 
 * @version summer 2015
 * @param <T> - generic class of objects index list contains,
 *  must implement Comparable interface 
 */
public  class Sort<T extends Comparable<T>>
{
	// types of sort 
	public enum SortAlgorithm { quicksort, mergesort }; 
	// instance variable for type of sort 
	private SortAlgorithm sortType; 
	
	/**
	 * Constructor - specifies type of sort 
	 * @param sortType
	 */
	public Sort(SortAlgorithm sortType)
	{
		this.sortType = sortType; 
	}
	
	/**
	 *  Sorts a given list using specified algorithm.
	 * @param list that implements IndexedList interface
	 */
	public void sort(IndexedList<T> list)
	{
		switch(sortType)
		{
			case quicksort:
				quicksort(list);
				break;
			case mergesort:
				mergesort(list);
				break;
			default:
		}
	}
	
	/**
	 * Uses Quicksort algorithm to sort list of values 
	 * @param list IndexedList of Comparable values 
	 */
	private void quicksort(IndexedList<T> list)
	{
		quicksort(list, 0, list.size() - 1);
	}
	
	//Method to swap two values/elements in the list
	private void swapReferences(IndexedList<T> list, int index1, int index2) 
	{
		T a = list.get(index1);
		T b = list.get(index2);
		list.set(index1, b);
	    list.set(index2, a);
		
	}
	
	//Method which uses the quicksort algorithm
	private void quicksort(IndexedList<T> list, int start, int stop) 
	{
		if(start >= stop)
		{
			return;	//base case list of 0 or 1 elements
		}
				
		int pivotindex = (start+stop)/2;
		
		swapReferences(list,pivotindex,start);
		T pivot = list.get(start);
		
		int i,j = start;
		
		for(i = start + 1; i <= stop; i++)
		{
			if(list.get(i).compareTo(pivot) <= 0)
			{
				j++;
				swapReferences(list,i,j);
			}
		}
		
		swapReferences(list,start,j);
		quicksort(list,start,j-1);
		quicksort(list,j+1,stop);
		
	}

	

	/**
	 * Uses Mergesort algorithm to sort list of values 
	 * @param list IndexedList of Comparable values 
	 */
	private void mergesort(IndexedList<T> list)
	{
		IndexedList<T> temp = new MyIndexedList<T>(list.size());
		mergesort(list, temp, 0, list.size() - 1);
	}

	//Mergesort Algorithm implemented here
	private void mergesort(IndexedList<T> list, IndexedList<T> temp, int low, int high) 
	{
		if(low < high)
		{
			int center = (low + high)/2 ;
			mergesort(list, temp, low, center);
			mergesort(list, temp, center + 1, high);
			merge(list, temp, low, center + 1, high);
		}
		
	}
	
	//Method merges the two sub-lists ( left and right )
	private void merge(IndexedList<T> list, IndexedList<T> temp, int leftpos, int rightpos, int rightend) 
	{
		int leftend = rightpos - 1;
		int temppos = leftpos ;
		int numelements = rightend - leftpos + 1 ;
		
		//Main Loop
		while(leftpos <= leftend && rightpos <= rightend)
		{
			if(list.get(leftpos).compareTo(list.get(rightpos)) <= 0)
			{
				temp.set(temppos, list.get(leftpos));
				leftpos++;
			}
			else
			{
				temp.set(temppos, list.get(rightpos));
				rightpos++;
			}
			temppos++;
		}
		
		//Copy rest of left half of list to temporary list
		while(leftpos <= leftend)
		{
			temp.set(temppos, list.get(leftpos));
			temppos++;
			leftpos++;
		}
		
		//Copy rest of right half of list to temporary list
		while(rightpos <= rightend)
		{
			temp.set(temppos, list.get(rightpos));
			temppos++;
			rightpos++;
		}
		
		//Copy temporary list back into list
		for(int i = 0; i < numelements; i++, rightend--)
		{
			list.set(rightend, temp.get(rightend));
		}
	}
	
	
}