
public class WristWatch extends Clock
{
	 static Time t;
	 
	 //Default Constructor
	 
	WristWatch()
	{
		super(ClockType.digital, t, 0.000034722);
	}
	
	//Parameterized Constructor
	
	WristWatch(ClockType clockType, Time t, double driftPerSecond) 
	{
		
		
	}

	//Definition for one method of Timepiece Interface
	
	@Override
	public void display() 
	{
		
		if(ClockSimulation.run == 1)
		{
		for(int i=0;i<86400;i++)
		{
		System.out.print("Wrist Watch time ["); 
		time.displayTime(); 
		System.out.print("] - total drift = ");
		System.out.printf("%.2f", time.totalDrift());
		System.out.println(" seconds.");
		tick();
		}
		}
		else if(ClockSimulation.run == 2)
		{
			for(int i=0;i<604800;i++)
			{
			System.out.print("Wrist Watch time ["); 
			time.displayTime(); 
			System.out.print("] - total drift = ");
			System.out.printf("%.2f", time.totalDrift());
			System.out.println(" seconds.");
			tick();
			}
		}
		else if(ClockSimulation.run == 3)
		{
			for(int i=0;i<2592000;i++)
			{
			System.out.print("Wrist Watch time ["); 
			time.displayTime(); 
			System.out.print("] - total drift = ");
			System.out.printf("%.2f", time.totalDrift());
			System.out.println(" seconds.");
			tick();
			}
		}
		else if(ClockSimulation.run == 4)
		{
			for(int i=0;i<31536000;i++)
			{
			System.out.print("Wrist Watch time ["); 
			time.displayTime(); 
			System.out.print("] - total drift = ");
			System.out.printf("%.2f", time.totalDrift());
			System.out.println(" seconds.");
			tick();
			}
		}
	}

}
