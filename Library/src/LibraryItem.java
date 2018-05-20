package assignTwoStudent30130595;

public class LibraryItem 
{
	private String title;
	private String ID_code;
	private int yearOfPublication;
	private boolean onLoan;
	private double replacementCost;
	
	public LibraryItem()
	{
		title = new String ("");
		ID_code = new String ("");
		yearOfPublication = 0;
		onLoan = false;
		replacementCost = 0.0;
	}
	
	public LibraryItem(String _title, String _ID_code, int _yearOfPublication, boolean _onLoan, double _replacementCost)
	{
		setTitle(_title);
		setID_code(_ID_code);
		setyearOfPublication(_yearOfPublication);
		setonLoan(_onLoan);
		setreplacementCost(_replacementCost);
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public boolean setTitle(String _title)
	{
		if(_title != "")
		{
			title = new String(_title);
			return true;
		}
		else
		{
			if(title == "")
			{
				title = "Invalid Title";
			}
			return false;
		}
	}
	
	
	
	public String getID_code()
	{
		return ID_code;
	}
	
	public void setID_code(String _ID_code)
	{
		ID_code = _ID_code;
	}
	
	public int getyearOfPublication()
	{
		return yearOfPublication;
	}
	
	public void setyearOfPublication(int _yearOfPublication)
	{
		yearOfPublication = _yearOfPublication;
	}
	
	public boolean getonLoan()
	{
		return onLoan;
	}
	
	public void setonLoan(boolean _onLoan)
	{
		onLoan = _onLoan;
	}
	
	public double getreplacementCost()
	{
		return replacementCost;
	}
	
	public boolean setreplacementCost(double _replacementCost)
	{
		if(_replacementCost <= 0)
		{
			return false;
		}
		replacementCost = _replacementCost;
		return true;
	}
	
	public String toString()
	{
		return "";
	}
}
