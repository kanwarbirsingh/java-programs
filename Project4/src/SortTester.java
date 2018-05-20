
import java.util.Random;

/**
 * Tester class for Sort class. Runs tests for indexed lists:
 * 		- with all the same value
 * 		- already sorted 
 *      - lists sorted in descending order
 *      - lists with randomly distributed values 
 * @author Matt T
 * @version summer 2015
 */
public class SortTester
{
	private static final int SIZE = 20; 
	private static final int MAX = 100;
	/** 
	 * Sorts collection of Integers using either Quicksort or Merge Sort 
	 * 
	 * @param args - "-q" or "-m" for Quicksort and Merge Sort, respectively
	 */
	public static void main(String[] args)
	{	
		// class variable for sorting the indexed list
		Sort<Integer> sort; 
		// list to be sorted 
		IndexedList<Integer> list = null; 		
		
		// process command-line args
		if(args.length == 1)	
		{		
			if(args[0].equals("-q"))
			{
				sort = new Sort<Integer>(Sort.SortAlgorithm.quicksort);
				runTests(list, sort);
			}
			else if(args[0].equals("-m"))		
			{	
				sort = new Sort<Integer>(Sort.SortAlgorithm.mergesort);
				runTests(list, sort);
			}
		}
	}	
	
	/**
	 * Runs tests for Sort class: all same, in descending order, and random values
	 * @param list IndexedList of Integers 
	 */
	private static void runTests(IndexedList<Integer> list, Sort<Integer> sort)
	{
		Integer[] sameArray = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
		Integer[] sortedArray = {2, 3, 7, 10, 13, 15, 23, 25, 25, 31, 33, 39, 43, 56, 89, 93, 93, 95, 97, 99};
		Integer[] descendingArray = {99, 87, 76, 56, 54, 45, 43, 41, 38, 34, 31, 25, 23, 18, 12, 11, 11, 5, 2, 1};
		
		list = new MyIndexedList<Integer>(sameArray, SIZE);
		System.out.println("All the same values: ");
		System.out.println(list.toString());
		System.out.println("After sort");
		sort.sort(list);
		System.out.println(list.toString());
		System.out.println();
		
		list = new MyIndexedList<Integer>(sortedArray, SIZE);
		System.out.println("Sorted List: ");
		System.out.println(list.toString());
		System.out.println("After sort:");
		sort.sort(list);
		System.out.println(list.toString());
		System.out.println();
		
		list = new MyIndexedList<Integer>(descendingArray, SIZE);
		System.out.println("Sorted in descending order: ");
		System.out.println(list.toString());
		System.out.println("After sort:");
		sort.sort(list);
		System.out.println(list.toString());
		System.out.println();
		
		list = new MyIndexedList<Integer>();
		randomizeList(list);
		System.out.println("Random list 1: ");
		System.out.println(list.toString());
		System.out.println("After sort:");
		sort.sort(list);
		System.out.println(list.toString());
		System.out.println();

		list = new MyIndexedList<Integer>();
		randomizeList(list);
		System.out.println("Random list 2: ");
		System.out.println(list.toString());
		System.out.println("After sort:");
		sort.sort(list);
		System.out.println(list.toString());
		System.out.println();				
	}
	
	private static void randomizeList(IndexedList<Integer> list)
	{
		Random randNum = new Random(); 
		for(int i = 0; i < SIZE; i++)
		{
			list.add(randNum.nextInt(MAX));
		}
	}


}