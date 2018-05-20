
import java.awt.BorderLayout;
import java.awt.Font;
//import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.FlowLayout;

/**
 * A window application simulating a stop watch. 
 * 
 */
public class StopWatch extends JFrame
{

	private static final long serialVersionUID = 2481273590514578402L;
	// main panel the other panels are added to
	private JPanel mainPanel;
	// panel for organizing the buttons in the application
	private JPanel buttonPanel;
	// panel for organizing labels and seven-segment displays
	private JPanel watchPanel; 
	// seven-segment displays for each digit in the time
	private SevenSegment hourDigit1;
	private SevenSegment hourDigit0;
	private SevenSegment minuteDigit1;
	private SevenSegment minuteDigit0;
	private SevenSegment secondDigit1;
	private SevenSegment secondDigit0;
	// labels separating hour, minute, second in the time
	private JLabel colon1; 
	private JLabel colon2; 
	// buttons for the operation of the stop watch 
	private JButton startButton;
	private JButton stopButton;
	private JButton resetButton;
	// drives the Time class 
	private Timer timer; 
	// stores the time of the stop watch 
	private Time time;
	// window sizes 
	private final int WINDOW_WIDTH = 910;
	private final int WINDOW_HEIGHT = 370;
	// delay of Timer in milliseconds  == 1 second 
	private final int DELAY = 1000; 	
	
	/**
	 * Constructor - initializes components 
	 */
	public StopWatch()
	{
		// initialize the model for the GUI 
		timer = new Timer(DELAY, new TimerActionListener());
		time = new Time(); 
		// sets up window for application 
		setTitle("Stop Watch");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// labels could be initialized in buildPanels
		colon1 = new JLabel(" : ");	
		colon1.setFont(new Font("Serif", Font.PLAIN, 120));
		colon2 = new JLabel(" : "); 
		colon2.setFont(new Font("Serif", Font.PLAIN, 120));
		
		// key method to creating view for the GUI
		buildPanels();
		getContentPane().add(mainPanel);
		setVisible(true);
	}
	
	/**
	 * Initializes components, assembles them onto panels
	 */
	private void buildPanels()
	{
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
	    buttonPanel = new JPanel();
	    startButton = new JButton("START");
	    startButton.addActionListener(new StartButtonActionListener());
	    stopButton = new JButton("STOP");
	    stopButton.addActionListener(new StopButtonActionListener());
	    resetButton = new JButton("RESET");
	    resetButton.addActionListener(new ResetButtonActionListener());
	    buttonPanel.add(startButton);
	    buttonPanel.add(stopButton);
	    buttonPanel.add(resetButton);
	    mainPanel.add(buttonPanel,BorderLayout.NORTH);
	    watchPanel = new JPanel();
	    
	    hourDigit1 = new SevenSegment();
	    FlowLayout flowLayout = (FlowLayout) hourDigit1.getLayout();
	    flowLayout.setVgap(100);
	    flowLayout.setHgap(50);
	    
	    hourDigit0 = new SevenSegment();
	    FlowLayout flowLayout2 = (FlowLayout) hourDigit0.getLayout();
	    flowLayout2.setVgap(100);
	    flowLayout2.setHgap(50);
	    
	    minuteDigit1 = new SevenSegment();
	    FlowLayout flowLayout3 = (FlowLayout) minuteDigit1.getLayout();
	    flowLayout3.setVgap(100);
	    flowLayout3.setHgap(50);
	    
	    minuteDigit0 = new SevenSegment();
	    FlowLayout flowLayout4 = (FlowLayout) minuteDigit0.getLayout();
	    flowLayout4.setVgap(100);
	    flowLayout4.setHgap(50);
	    
	    secondDigit1 = new SevenSegment();
	    FlowLayout flowLayout5 = (FlowLayout) secondDigit1.getLayout();
	    flowLayout5.setVgap(100);
	    flowLayout5.setHgap(50);
	    
	    secondDigit0 = new SevenSegment();
	    FlowLayout flowLayout6 = (FlowLayout) secondDigit0.getLayout();
	    flowLayout6.setVgap(100);
	    flowLayout6.setHgap(50);
	    watchPanel.add(hourDigit1);
	    watchPanel.add(hourDigit0);
	    watchPanel.add(colon1);
	    watchPanel.add(minuteDigit1);
	    watchPanel.add(minuteDigit0);
	    watchPanel.add(colon2);
	    watchPanel.add(secondDigit1);
	    watchPanel.add(secondDigit0);
	    //drawDigits();
	    mainPanel.add(watchPanel);
	}
	
	/**
	 * Sets, updates seven-segment displays 
	 * using time stored in the Time class object 
	 */
	private void drawDigits()
	{
		hourDigit1.setDigit(time.hour() / 10);
		hourDigit1.redraw();
		hourDigit0.setDigit(time.hour() % 10);
		hourDigit0.redraw();
		minuteDigit1.setDigit(time.minute() / 10);
		minuteDigit1.redraw();
		minuteDigit0.setDigit(time.minute() % 10);
		minuteDigit0.redraw();
		secondDigit1.setDigit(time.second() / 10);
		secondDigit1.redraw();
		secondDigit0.setDigit(time.second() % 10);
		secondDigit0.redraw();		
	}
	
	/**
	 * ActionListener class for the Timer object 
	 *
	 */
	private class TimerActionListener implements ActionListener
	{
		/**
		 * Updates components, variables every 1000 milliseconds
		 */
		@Override
		public void actionPerformed(ActionEvent ae)
		{
			drawDigits();
			timer.setInitialDelay(0);
		    time.incrementTime();
		    
		}	
	}
	
	/**
	 * ActionListener for the startButton 
	 *
	 */
	private class StartButtonActionListener implements ActionListener
	{
		/**
		 * Updates components, variables when start button is clicked 
		 */
		@Override
		public void actionPerformed(ActionEvent ae)
		{
		    timer.start();
		}	
	}

	/**
	 * ActionListener for the stopButton 
	 *
	 */
	private class StopButtonActionListener implements ActionListener
	{
		/**
		 * Updates components, variables when stop button is clicked 
		 */
		@Override
		public void actionPerformed(ActionEvent ae)
		{
		    timer.stop();
		}	
	}
	
	/**
	 * ActionListener for the resetButton
	 *
	 */
	private class ResetButtonActionListener implements ActionListener
	{
		/**
		 * Updates components, variables when reset button is clicked 
		 */
		@Override
		public void actionPerformed(ActionEvent ae)
		{
		    timer.stop();
		    time.resetTime(0);
		    drawDigits();
		}	
	}
	
	/**
	 * main method - initiates the GUI, which 
	 * runs until window is closed.  
	 * @param args- not used 
	 */
	public static void main(String[] args)
	{
		new StopWatch();
	}

}