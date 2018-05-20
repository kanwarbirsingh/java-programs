package assignTwoStudent30130595;

public class Magazine extends LibraryItem 
{
	int numPages;
	boolean hardback;
	String publisher;
	
	Magazine()
	{
		super("","",0,false,0);
	}
	
	Magazine(String title, String ID_code, int yearOfPublication, boolean onLoan, double replacementCost, 
			int numPages, boolean hardback, String publisher)
	{
		super(title,ID_code,yearOfPublication,onLoan,replacementCost);
		setNumPages(numPages);
		setHardback(hardback);
		setPublisher(publisher);
	}
	
	public int getNumPages()
	{
		return this.numPages;
	}
	public boolean setNumPages(int _numPages)
	{
		if(_numPages < 1)
		{
			this.numPages = 1;
			return false;
		}
		this.numPages = _numPages;
		return true;
	}
	
	public boolean getHardback()
	{
		return this.hardback;
	}
	public void setHardback(boolean _hardback)
	{
		this.hardback = _hardback;
	}
	
	public String getPublisher()
	{
		return this.publisher;
	}
	public void setPublisher(String _publisher)
	{
		this.publisher = _publisher;
	}
	
	public String toString()
	{
		return getTitle()+"\t\t"+getID_code()+"\t"+getyearOfPublication()+
				"\t"+getonLoan()+"\t"+getreplacementCost()+
				"\t"+getNumPages()+"\t"+getHardback()+"\t"+getPublisher();
	}
}
