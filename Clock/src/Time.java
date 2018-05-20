

/**
 * A class for keeping track of time. 
 * @author Matt T 
 * @version summer 2015
 */
public class Time
{
	// constants for calculating time in seconds 
	private final int SECONDS_PER_MINUTE = 60;
	private final int MINUTES_PER_HOUR = 60;
	private final int HOURS_PER_DAY = 24; 
	// data members 
	private int hour;		
	private int minute;
	private int second;
	private int secondsPerTick;
	private long startTime;	// start time in seconds 
	private long deltaTime;	// amount of time passed since startTime in seconds
	private double totalDrift; 		// how much time has been lost since start time
	private double driftPerSecond; // amount of drift each second 
	
	/**
	 * Default constructor - time set to midnight, 1 second per tick, zero drift 
	 */
	public Time()
	{
		this(0, 0, 0, 1, 0);
	}
	
	/**`	
	 * Constructor for Time class. 
	 * @param hour - integer representing the hour 
 	 * @param minute - integer representing the minute
	 * @param second - integer representing the second 
	 * @param secondsPerTick - integer representing seconds per tick 
	 * @param driftPerSecond - double representing amount of drift per second 
	 */
	public Time(int hour, int minute, int second, int secondsPerTick, double driftPerSecond)
	{
		setTime(hour, minute, second, secondsPerTick);
		setDriftPerSecond(driftPerSecond	);
		recordStartTime();
	}
	
	/**
	 * Initialize startTime - the initial time in seconds. 
	 */
	private void recordStartTime()
	{
		setStartTime( hour * MINUTES_PER_HOUR * SECONDS_PER_MINUTE +
							 minute * SECONDS_PER_MINUTE +
							 second); 
	}
	
	/**
	 * Increment the time by the number of seconds 
	 * the time advances each tick. 
	 */
	public void incrementTime()
	{
		// update deltaTime 
		deltaTime += secondsPerTick; 
		// update drift
		totalDrift += driftPerSecond; 
		
		// compute new time in terms of seconds
		long seconds = hour * MINUTES_PER_HOUR * SECONDS_PER_MINUTE +
								minute * SECONDS_PER_MINUTE +
								second + 
								secondsPerTick; 
		// If new time is greater than the seconds in a day, adjust new time
		// to number of seconds past midnight. 
		if(seconds > (HOURS_PER_DAY * MINUTES_PER_HOUR * SECONDS_PER_MINUTE))
		{
			seconds -= HOURS_PER_DAY * MINUTES_PER_HOUR * SECONDS_PER_MINUTE;
		}
		// update time 
		resetTime(seconds);
	}
	
	/**
	 * Reset the time to a given time, in seconds.  
	 */
	public void resetTime(long newTime)
	{
		// newTime in seconds, have to calculate number of hours / minutes 
		setHour( (int)(newTime / (MINUTES_PER_HOUR * SECONDS_PER_MINUTE)) );
		newTime -= hour * (MINUTES_PER_HOUR * SECONDS_PER_MINUTE);
		// get number of minutes
		setMinute( (int)(newTime / SECONDS_PER_MINUTE) );
		// what is left if number of seconds 
		newTime -= minute * SECONDS_PER_MINUTE; 
		setSecond( (int)newTime ); 
	}
	
	/**
	 * Display the values stored in this instance of a Time object 
	 */
	public void displayTime()
	{
		int drift = (int)totalDrift; 	// subtract drift from time
		// compute time adjusted for drift in seconds
		long seconds = hour * MINUTES_PER_HOUR * SECONDS_PER_MINUTE +
								minute * SECONDS_PER_MINUTE +
								second - 
								drift; 
		
		// calculate new hour 
		int newHour = (int)(seconds / (MINUTES_PER_HOUR * SECONDS_PER_MINUTE));
		seconds -= newHour * (MINUTES_PER_HOUR * SECONDS_PER_MINUTE);
		// get number of minutes
		int newMinute = (int)(seconds / SECONDS_PER_MINUTE);
		// what is left if number of seconds 
		seconds -= newMinute * SECONDS_PER_MINUTE; 
		int newSecond = (int)seconds; 

		System.out.printf("%2d:%02d:%02d", newHour, newMinute, newSecond);
	}
	
	/**
	 * Sets time 
	 * @param time - object of type Time 
	 */
	public void setTime(Time time)
	{
		setTime(time.hour, time.minute, time.second, time.secondsPerTick);
	}
	
	/**
	 * Sets time
	 * @param hour - integer representing the hour 
 	 * @param minute - integer representing the minute
	 * @param second - integer representing the second 
	 * @param secondsPerTick - integer representing seconds per tick 
	 */
	public void setTime(int hour, int minute, int second, int secondsPerTick)
	{
		setHour(hour);
		setMinute(minute);
		setSecond(second);
		setSecondsPerTick(secondsPerTick);
		setDeltaTime(0);
		setTotalDrift(0.0);
	}
	
	/**
	 * Gets hour 
	 * @return hour - integer representing the hour 
	 */
	public int hour()
	{
		return hour;
	}
	/**
	 * Sets hour
	 * @param hour - integer representing the hour 
	 */
	public void setHour(int hour)
	{
		this.hour = hour;
	}
	
	/**
	 * Gets minute
	 * @return minute - integer representing the minute 
	 */
	public int minute()
	{
		return minute;
	}
	/**
	 * Sets minute 
	 * @param minute - integer representing the minute 
	 */
	public void setMinute(int minute)
	{
		this.minute = minute;
	}
	
	/**
	 * Gets second
	 * @return second - integer representing the second 
	 */
	public int second()
	{
		return second;
	}
	
	/**
	 * Sets second 
	 * @param second - integer representing the second 
	 */
	public void setSecond(int second)
	{
		this.second = second;
	}
	
	/**
	 * Gets secondsPerTick
	 * @return secondsPerTick - integer representing seconds per tick 
	 */
	public int secondsPerTick()
	{
		return secondsPerTick;
	}
	
	/**
	 * Sets secondsPerTick 
	 * @param secondsPerTick - integer representing seconds per tick
	 */
	public void setSecondsPerTick(int secondsPerTick)
	{
		this.secondsPerTick = secondsPerTick;
	}
	
	/**
	 * Gets startTime
	 * @return startTime - long integer representing the start time in seconds 
	 */
	public long startTime()
	{
		return startTime;
	}
	
	/**
	 * Sets startTime 
	 * @param startTime - long integer representing the start time in seconds 
	 */
	public void setStartTime(long startTime)
	{
		this.startTime = startTime;
	}
	
	/**
	 * Gets deltaTime.
	 * @return deltaTime - long integer representing the change in time 
	 * since startTime in seconds 
	 */
	public long deltaTime()
	{
		return deltaTime;
	}
	
	/**
	 * Sets deltaTime
	 * @param deltaTime - long integer representing the change in time 
	 * since startTime in seconds 
	 */
	public void setDeltaTime(long deltaTime)
	{
		this.deltaTime = deltaTime;
	}

	/**
	 * Get totalDrift
	 * @return totalDrift - double representing total amount of drift 
	 */
	public double totalDrift()
	{
		return totalDrift;
	}

	/**
	 * Set totalDrift 
	 * @param totalDrift - double representing total amount of drift 
	 */
	public void setTotalDrift(double totalDrift)
	{
		this.totalDrift = totalDrift;
	}

	/**
	 * Get driftPerSecond
	 * @return driftPerSecond - double representing amount of drift per second 
	 */
	public double driftPerSecond()
	{
		return driftPerSecond;
	}

	/**
	 * Set driftPerSecond 
	 * @param driftPerSecond - double representing amount of drift per second 
	 */
	public void setDriftPerSecond(double driftPerSecond)
	{
		this.driftPerSecond = driftPerSecond;
	}
} // Time class 
