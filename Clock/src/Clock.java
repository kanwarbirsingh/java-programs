import java.lang.*;

@SuppressWarnings("unused")
public abstract class Clock implements TimePiece
{
	//Enumeration ClockType declared publicly
	public enum ClockType
	{
		natural(0),
		mechanical(1),
		digital(2),
		quantum(3);
		
		int type;
		ClockType(int value)
		{
			type = value;
		}
		int getType()
		{
			return type;
		}
	}
	
	//Variables of Clock Class
	
	private ClockType clockType;
	private double driftPerSecond;
	protected static Time time;
	
	//Default constructor of Clock Class
	
	public Clock()
	{
		
	}
	
	//Parameterized Constructor of Clock Class
	
	public Clock(ClockType clockType,Time t, double driftPerSecond)
	{
		t = new Time();
		time = t;
		setClockType(clockType);
		time.setTime(time);
		setdriftPerSecond(driftPerSecond);
		
		time.setDriftPerSecond(this.driftPerSecond);
		
	}
	
	//Accessor and mutator methods for clock class variables
	
	public void setClockType(ClockType clockType)
	{
		if(clockType == ClockType.natural)
		{
			this.clockType = ClockType.natural;
		}
		else if(clockType == ClockType.mechanical)
		{
			this.clockType = ClockType.mechanical;
		}
		else if(clockType == ClockType.digital)
		{
			this.clockType = ClockType.digital;
		}
		else if(clockType == ClockType.quantum)
		{
			this.clockType = ClockType.quantum;
		}
	}
	ClockType getClockType()
	{
		return this.clockType;
	}
	
	public void setdriftPerSecond(double driftPerSecond)
	{
		this.driftPerSecond = driftPerSecond;
	}
	
	double getdriftPerSecond()
	{
		return driftPerSecond;
	}
	
	//Definitions for Timepiece Interface methods
	
	public void reset()
	{
		time.resetTime(time.startTime());
		time.setTotalDrift(0.0);
		
	}
	
	public void tick()
	{
		time.incrementTime();
	}
	
	
}
