
import java.io.File;
import java.util.Scanner;

/**
 * Execute a Josephus death circle on the names in a given file (one name per line) by
 * skipping given number of people between executions. The unlucky soldiers are collected
 * in a Queue.
 * 
 * @author mvail
 * @author Matt T 
 */
public class JosephusQueue 
{

	/**
	 * @param args [skip count] [namesFile]
	 */
	public static void main(String[] args) 
	{
		if (args.length != 2) 
		{
			System.out.println("Usage: java JosephusQueue [int i] [namesFile]");
			System.out.println("\tInteger i is the number of people to skip between swings of the sword.");
			System.exit(1);
		}
		
		Queue<String> herd = new Queue<String>();
				
		int skipNumber = 1;
		try 
		{
			skipNumber = Integer.parseInt(args[0]);
			if (skipNumber < 1) 
			{
				System.out.println("Invalid argument. Must have a positive integer for number of people to skip.");
				System.exit(1);
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Invalid argument. Must have a positive integer for number of people to skip.");
			System.exit(1);
		}
		
		try 
		{
			Scanner scan = new Scanner(new File(args[1]));
			while (scan.hasNextLine()) 
			{
				String name = scan.nextLine().trim();
				if (name.length() > 0) 
				{
					herd.enqueue(name);
				}
			}
			scan.close();
		} 
		catch (Exception e) 
		{
			System.out.println("Invalid file argument. Cannot open or read " + args[1]);
			System.exit(1);
		}
		
		if (herd.isEmpty()) 
		{
			System.out.println("Failure! You can't have a death circle without at least 2 people!");
		} 
		else 
		{
			//who's present?
			System.out.println("The " + herd.size() + " not-so-lucky soldiers facing death or capture:");
			System.out.println(herd.toString());
			
			//cull the herd
			cull(herd, skipNumber);
		
			//who's left?
			if (herd.isEmpty()) 
			{
				System.out.println("These people are incompetant. No one survived.");
			} 
			else if (herd.size() > 1) 
			{
				System.out.println("Cowards! There are " + herd.size() + " survivors!");
			} 
			else 
			{
				System.out.println("The lucky survivor who faces capture rather than death: " + herd.dequeue());
			}
		}
	}
	
	/**
	 * Skip (i-1) people and kill the ith one until only one person remains.
	 * @param herd collection of potential martyrs
	 * @param skipNumber how many people skip before a kill in each round of culling
	 */
	private static void cull(Queue<String> herd, int skipNumber) 
	{
		int victimNumber = 1;
		while (herd.size() > 1) 
		{
			for (int i = 0; i < skipNumber - 1; i++) 
			{
				herd.enqueue(herd.dequeue());
			}
			System.out.printf("Victim %2d: %s\n", victimNumber, herd.dequeue());
			victimNumber++;
		}
	}
}