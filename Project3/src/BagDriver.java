
/**
 * Driver class for the Bag class. 
 * 
 * @version summer 2015
 */

public class BagDriver 
{
	private static Bag<Integer> bag;

	/**
	 * Adds given Integer to the bag
	 * 
	 * @param i
	 * 			Integer added to the bag
	 */
	public static void add(Integer i) 
	{
		bag.insert(i);
		bag.print();
		System.out.println("Number of occurrences of " + i + " is "
				+ bag.occurrences(i) + "\n\n");
	}

	/**
	 * Removes given item from the list.
	 * 
	 * @param i
	 * 			Integer that's to be removed
	 */
	public static void remove(Integer i) 
	{
		if (bag.remove(i)) 
		{
			System.out.println("Removed " + i + " from the bag.");
		} 
		else 
		{
			System.out.println("Failed to remove " + i + " from the bag");
		}
		bag.print();
		System.out.println("Number of occurrences of " + i + " is "
				+ bag.occurrences(i) + "\n\n");
	}

	/**
	 * Main method for testing Bag class. 
	 */
	public static void main(String[] args) 
	{
		bag = new Bag<Integer>();
		add(0);
		add(4);
		add(6);
		add(4);
		add(4);
		add(7);
		add(19);
		add(5);
		add(7);
		remove(4);
		remove(8);
		remove(5);
		remove(4);
		add(4);
		remove(3);
		remove(7);
		add(18);
		remove(18);
		add(18);
		remove(19);
		remove(7);
		remove(4);
		add(8);
	}
}