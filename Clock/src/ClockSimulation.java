


@SuppressWarnings("rawtypes")
public class ClockSimulation extends Bag
{
	//Static variable accessed in all concrete classes
	public static int run = 1;

	// Main Function starts here
	public static void main(String[] args) 
	{
		
		Bag<Clock> clock =  new Bag<Clock>(); //Creating a container to store elements of Clock type
		
		//Simulation of clocks for one day starts here
		
		System.out.println("Simulation of Clocks after one day\n");
		Clock clock1 = new Sundial();
		clock1.display();
		Clock clock2 = new CuckooClock();
		clock2.display();
		Clock clock3 = new GrandfatherClock();
		clock3.display();
		Clock clock4 = new WristWatch();
		clock4.display();
		Clock clock5 = new AtomicClock();
		clock5.display();
		run = 2;
		clock1.reset();
		clock2.reset();
		clock3.reset();
		clock4.reset();
		clock5.reset();
		
		//Simulation of clocks for one week starts here
		
		System.out.println("Simulation of Clocks after one week\n");
		Clock clock1_1 = new Sundial();
		clock1_1.display();
		Clock clock2_1 = new CuckooClock();
		clock2_1.display();
		Clock clock3_1 = new GrandfatherClock();
		clock3_1.display();
		Clock clock4_1 = new WristWatch();
		clock4_1.display();
		Clock clock5_1 = new AtomicClock();
		clock5_1.display();
		run = 3;
		clock1_1.reset();
		clock2_1.reset();
		clock3_1.reset();
		clock4_1.reset();
		clock5_1.reset();
		
		//Simulation of clocks for one month starts here
		
		System.out.println("Simulation of Clocks after one month\n");
		Clock clock1_2 = new Sundial();
		clock1_2.display();
		Clock clock2_2 = new CuckooClock();
		clock2_2.display();
		Clock clock3_2 = new GrandfatherClock();
		clock3_2.display();
		Clock clock4_2 = new WristWatch();
		clock4_2.display();
		Clock clock5_2 = new AtomicClock();
		clock5_2.display();
		run = 4;
		clock1_2.reset();
		clock2_2.reset();
		clock3_2.reset();
		clock4_2.reset();
		clock5_2.reset();
		
		//Simulation of clocks for one year starts here
		
		System.out.println("Simulation of Clocks after one year\n");
		Clock clock1_3 = new Sundial();
		clock1_3.display();
		Clock clock2_3 = new CuckooClock();
		clock2_3.display();
		Clock clock3_3 = new GrandfatherClock();
		clock3_3.display();
		Clock clock4_3 = new WristWatch();
		clock4_3.display();
		Clock clock5_3 = new AtomicClock();
		clock5_3.display();
		run = 5;
		clock1_3.reset();
		clock2_3.reset();
		clock3_3.reset();
		clock4_3.reset();
		clock5_3.reset();
		
		//Inserting clock objects in the created container
		
		clock.insert(clock1);
		System.out.println("Sundial Inserted Successfully");
		
		clock.insert(clock2);
		System.out.println("Cuckoo Clock Inserted Successfully");
		
		clock.insert(clock3);
		System.out.println("Grandfather Clock Inserted Successfully");
		
		clock.insert(clock4);
		System.out.println("Wrist Watch Inserted Successfully");
		
		clock.insert(clock5);
		System.out.println("Atomic Clock Inserted Successfully");
		
		
		
		
		
		
		
		
		
		
	}

}
