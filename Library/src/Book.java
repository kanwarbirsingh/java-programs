package assignTwoStudent30130595;

public class Book extends LibraryItem
{
	String author;
	int numPages;
	boolean hardback;
	boolean fiction;
	String publisher;
	
	public Book()
	{
		super("","",0,false,0);
	}
	
	public Book(String title, String ID_code, int yearOfPublication, boolean onLoan, double replacementCost,
			String author, int numPages, boolean hardback, boolean fiction, String publisher)
	{
		super(title,ID_code,yearOfPublication,onLoan,replacementCost);
		setAuthor(author);
		setNumPages(numPages);
		setHardback(hardback);
		setFiction(fiction);
		setPublisher(publisher);
	}
	
	public String getAuthor()
	{
		return this.author;
	}
	public boolean setAuthor(String _author)
	{
		if(_author != "")
		{
			this.author = _author;
			return true;
		}
		else
		{
			this.author = "Unknown";
			return false;
		}
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
		else
		{
			this.numPages = _numPages;
			return true;
		}
	}
	
	public boolean getHardback()
	{
		return this.hardback;
	}
	public void setHardback(boolean _hardback)
	{
		this.hardback = _hardback;
	}
	
	public boolean getFiction()
	{
		return this.fiction;
	}
	public void setFiction(boolean _fiction)
	{
		this.fiction = _fiction;
	}
	
	public String getPublisher()
	{
		return this.publisher;
	}
	public void setPublisher(String _publisher)
	{
		this.publisher = _publisher;
	}
	
	@SuppressWarnings("null")
	public boolean equalsIgnorecase(Book anotherBook)
	{
	Book[] items = null;
	int numItems = 0;
	
	for (int i = 0; i < (numItems -1); i++)
	{
	       for(int j = 0; j < (numItems - (i +1)); j++)
	       {
	                if( (anotherBook.getTitle() == (items[j]).getTitle() ) && (anotherBook.getAuthor() == (items[j + 1]).getAuthor()) )
	                {
	                            return true;
	                }
	        }
	}	
			return false;
	}
	
	public String toString()
	{
		return getTitle()+"\t\t"+getID_code()+"\t"+getyearOfPublication()+"\t"
				+getonLoan()+"\t"+getreplacementCost()+"\t"+getAuthor()+"\t"+getNumPages()+
				"\t"+getHardback()+"\t"+getFiction()+"\t"+getPublisher();
	}
}
