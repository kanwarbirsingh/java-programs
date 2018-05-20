
/**
	 * A 7-segment digital display for swing.
	 *
	 * @author Matt T
	 */
	import java.awt.*;
	import java.awt.geom.GeneralPath;

	import javax.swing.*;
	 
	public class SevenSegment extends JPanel
	{
	   private static final long serialVersionUID = -138113458074854436L;
		// size of component the display is add to 
	   private int width;
	   private int height; 
	   // the digit currently displaying 
	   private int digit; 
	   // default color of the display 
	   private final Color DEFAULT_COLOR = Color.GREEN;
	   // color of the display 
	   private Color color; 
	   
	   /**
	    * Default constructor 
	    */
	   public SevenSegment() 
	   { 
	      setOpaque(false);
	      setColor(DEFAULT_COLOR);
	      setDigit(0); 
	   }
	
	   /**
	    * Constructor for a given digit 
	    * @param digit int corresponding to the digit 
	    */
	   public SevenSegment(int digit)
	   {
		      setOpaque(false);
		      setColor(DEFAULT_COLOR);
		      setDigit(digit); 		   
	   }

	   /**
	    * Constructor for given digit, color 
	    * @param digit int corresponding to the digit 
	    * @param color Color of the display 
	    */
	   public SevenSegment(int digit, Color color)
	   {
		      setOpaque(false);
		      setColor(color);
		      setDigit(digit); 		   
	   }

	   /**
	    * Mutator for the digit 
	    * @param digit what set to 
	    */
	   public void setDigit(int digit)
	   {
		   this.digit = digit; 
	   }

	   /**
	    * Mutator for the color
	    * @param color which color set to 
	    */
	   public void setColor(Color color)
	   {
		   this.color = color;
	   }
	   
	   /**
	    * Forces display to be redrawn, usually after a change 
	    */
	   public void redraw()
	   {
		   repaint();
	   }
	  
	   /**
	    * Paint method for drawing the display on the Graphics object 
	    */
	   @Override public void paint(Graphics g)
	   {
		   // size of the Graphics object 
		   width = getWidth();
		   height = getHeight();
	      Graphics2D g2 = (Graphics2D) g;
	      // make sure can be seen 
	      if(isOpaque())
	      {
	         g.setColor(getBackground());
	         g.fillRect(0, 0, width, height);
	      }
	      g.setColor(getForeground());

	      // draw seven segments for given value of digit 
	      switch(digit)
	      {
			case 0:
			    drawUpperLeft(g2);
			    drawTopMiddle(g2);
			    drawUpperRight(g2);
			    drawLowerLeft(g2);
			    drawBottomMiddle(g2);
			    drawLowerRight(g2);
			    break;
			case 1:
			    drawUpperRight(g2);
			    drawLowerRight(g2);
			    break;
			case 2:
			    drawTopMiddle(g2);
			    drawUpperRight(g2);
			    drawCenterMiddle(g2);
			    drawLowerLeft(g2);
			    drawBottomMiddle(g2);
			    break;
			case 3:
			    drawTopMiddle(g2);
			    drawUpperRight(g2);
			    drawCenterMiddle(g2);
			    drawBottomMiddle(g2);
			    drawLowerRight(g2);
			    break;
			case 4:
			    drawUpperLeft(g2);
			    drawUpperRight(g2);
			    drawCenterMiddle(g2);
			    drawLowerRight(g2);
			    break;
			case 5:
			    drawUpperLeft(g2);
			    drawTopMiddle(g2);
			    drawCenterMiddle(g2);
			    drawBottomMiddle(g2);
			    drawLowerRight(g2);
			    break;
			case 6:
			    drawUpperLeft(g2);
			    drawTopMiddle(g2);
			    drawCenterMiddle(g2);
			    drawLowerLeft(g2);
			    drawBottomMiddle(g2);
			    drawLowerRight(g2);
			    break;
			case 7:
			    drawTopMiddle(g2);
			    drawUpperRight(g2);
			    drawLowerRight(g2);
			    break;
			case 8:
			    drawUpperLeft(g2);
			    drawTopMiddle(g2);
			    drawUpperRight(g2);
			    drawCenterMiddle(g2);
			    drawLowerLeft(g2);
			    drawBottomMiddle(g2);
			    drawLowerRight(g2);
			    break;
			case 9:
			    drawUpperLeft(g2);
			    drawTopMiddle(g2);
			    drawUpperRight(g2);
			    drawCenterMiddle(g2);
			    drawBottomMiddle(g2);
			    drawLowerRight(g2);
			    break;
			default:
			    drawUpperLeft(g2);
			    drawUpperRight(g2);
			    drawCenterMiddle(g2);
			    drawLowerLeft(g2);
			    drawLowerRight(g2);
	      }
	   }
	   
	   /**
	    * Draws upper lefthand segment (B) of the display
	    * @param g2 Graphics object draw segment on 
	    */
	   private void drawUpperLeft(Graphics2D g2)
	   {
		   // draw GeneralPath (filled polygon)
		   int x1Points[] = {10, 10, 15, 20, 30, 30, 20};
		   int y1Points[] = {10, height/2 - 15, height/2 - 4, height/2 - 10, height/2 - 15, 30, 25};
		   GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x1Points.length);
		   //start point of path traversal  
		   polygon.moveTo(x1Points[0], y1Points[0]);
		   // connect each of the points 
		   for (int index = 1; index < x1Points.length; index++) 
		   {
		           polygon.lineTo(x1Points[index], y1Points[index]);
		   }
		   // create polygon from the points 
		   polygon.closePath();
		   // fill it with color, draw it  
		   g2.setPaint(color);
		   g2.fill(polygon);
		   g2.setPaint(g2.getBackground());
		   g2.draw(polygon);
	   }
	   
	   private void drawTopMiddle(Graphics2D g2)
	   {
		   // draw GeneralPath (filled polygon)
		   int x1Points[] = {10, 25, 35, width - 35, width - 25, width - 10};
		   int y1Points[] = {10, 15, 30, 30, 15, 10};
		   GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x1Points.length);
		   //start point of path traversal  
		   polygon.moveTo(x1Points[0], y1Points[0]);
		   // connect each of the points 
		   for (int index = 1; index < x1Points.length; index++) 
		   {
		           polygon.lineTo(x1Points[index], y1Points[index]);
		   }
		   // create polygon from the points 
		   polygon.closePath();
		   // fill it with color, draw it  
		   g2.setPaint(color);
		   g2.fill(polygon);
		   g2.setPaint(g2.getBackground());
		   g2.draw(polygon);
	   }
	   
	   private void drawUpperRight(Graphics2D g2)
	   {
		   // draw GeneralPath (filled polygon)
		   int x1Points[] = {width - 30, width - 30, width - 20, width - 15, width - 10, width - 10, width - 20};
		   int y1Points[] = {30, height/2 - 15, height/2 - 10, height/2 - 4, height/2 - 15, 10, 25};
		   GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x1Points.length);
		   //start point of path traversal  
		   polygon.moveTo(x1Points[0], y1Points[0]);
		   // connect each of the points 
		   for (int index = 1; index < x1Points.length; index++) 
		   {
		           polygon.lineTo(x1Points[index], y1Points[index]);
		   }
		   // create polygon from the points 
		   polygon.closePath();
		   // fill it with color, draw it  
		   g2.setPaint(color);
		   g2.fill(polygon);
		   g2.setPaint(g2.getBackground());
		   g2.draw(polygon);
	   }
	   
	   private void drawCenterMiddle(Graphics2D g2)
	   {
		   // draw GeneralPath (filled polygon)
		   int x1Points[] = {35, 30, 15, 30, 35, width - 35, width - 30, width - 15, width - 30, width - 35};
		   int y1Points[] = {height/2 - 12, height/2 - 5, height/2, height/2 + 5, height/2 + 12, height/2 + 12, height/2 + 5, height/2, height/2 - 5, height/2 - 12};
		   GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x1Points.length);
		   //start point of path traversal  
		   polygon.moveTo(x1Points[0], y1Points[0]);
		   // connect each of the points 
		   for (int index = 1; index < x1Points.length; index++) 
		   {
		           polygon.lineTo(x1Points[index], y1Points[index]);
		   }
		   // create polygon from the points 
		   polygon.closePath();
		   // fill it with color, draw it  
		   g2.setPaint(color);
		   g2.fill(polygon);
		   g2.setPaint(g2.getBackground());
		   g2.draw(polygon);
	   }
	   
	   private void drawLowerLeft(Graphics2D g2)
	   {
		   // draw GeneralPath (filled polygon)
		   int x1Points[] = {10, 10, 20, 30, 30, 20, 15};
		   int y1Points[] = {height/2 + 15, height -10, height - 25, height -30, height/2 + 15, height/2 + 10, height/2 + 4};
		   GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x1Points.length);
		   //start point of path traversal  
		   polygon.moveTo(x1Points[0], y1Points[0]);
		   // connect each of the points 
		   for (int index = 1; index < x1Points.length; index++) 
		   {
		           polygon.lineTo(x1Points[index], y1Points[index]);
		   }
		   // create polygon from the points 
		   polygon.closePath();
		   // fill it with color, draw it  
		   g2.setPaint(color);
		   g2.fill(polygon);
		   g2.setPaint(g2.getBackground());
		   g2.draw(polygon);
	   }
	   
	   private void drawBottomMiddle(Graphics2D g2)
	   {
		   // draw GeneralPath (filled polygon)
		   int x1Points[] = {35, 25, 10, width - 10, width - 25, width - 35};
		   int y1Points[] = {height - 30, height - 15, height - 10, height - 10, height - 15, height - 30};
		   GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x1Points.length);
		   //start point of path traversal  
		   polygon.moveTo(x1Points[0], y1Points[0]);
		   // connect each of the points 
		   for (int index = 1; index < x1Points.length; index++) 
		   {
		           polygon.lineTo(x1Points[index], y1Points[index]);
		   }
		   // create polygon from the points 
		   polygon.closePath();
		   // fill it with color, draw it  
		   g2.setPaint(color);
		   g2.fill(polygon);
		   g2.setPaint(g2.getBackground());
		   g2.draw(polygon);
	   }
	   
	   private void drawLowerRight(Graphics2D g2)
	   {
		   // draw GeneralPath (filled polygon)
		   int x1Points[] = {width - 30, width - 30, width - 20, width - 10, width - 10, width - 15, width - 20};
		   int y1Points[] = {height/2 + 15, height -30, height - 25, height -10, height/2 + 15, height/2 + 4, height/2 + 10};
		   GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x1Points.length);
		   //start point of path traversal  
		   polygon.moveTo(x1Points[0], y1Points[0]);
		   // connect each of the points 
		   for (int index = 1; index < x1Points.length; index++) 
		   {
		           polygon.lineTo(x1Points[index], y1Points[index]);
		   }
		   // create polygon from the points 
		   polygon.closePath();
		   // fill it with color, draw it  
		   g2.setPaint(color);
		   g2.fill(polygon);
		   g2.setPaint(g2.getBackground());
		   g2.draw(polygon);
	   }
	   
	   /**
	    * main method for testing class 
	    * @param args
	    */
	   public static void main(String[] args)
	   {
		   // create a new window 
	      JFrame frame = new JFrame();
	      // add display to it 
	      SevenSegment sSegment = new SevenSegment();
	      // set to 8 
	      sSegment.setDigit(8);
	      // add it to the frame, set its size, and run it
	      frame.add(sSegment);
	      frame.setSize(100, 225);
	      frame.setVisible(true);
	   }
	}