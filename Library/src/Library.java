package assignTwoStudent30130595;

public class Library
{
	String name;
	LibraryItem itemlist[];
	
	int maxItems=10; // default maximum number of items is 10
	int currsize;
	
	Book b;
	
	public Library()
	{
		itemlist = new LibraryItem[maxItems];
		currsize = 0;
	}
	
	public Library(String initName, int maxItems)
	{
		setName(initName);
		itemlist = new LibraryItem[maxItems];
		currsize = 0;
	}
	
	
	public String getName()
	{
		return this.name;
	}
	
	public int getcurrsize()
	{
		return this.currsize;
	}
	
	public boolean setName(String newName)
	{
		this.name = newName;
		return true;
	}
	
	public boolean addItem(LibraryItem newItem)
	{
		if(currsize<maxItems)
		{
			itemlist[currsize++] = newItem;
			return true;
		}
		else
		{
			System.out.println("Library is Full.");
			return false;
		}
		
	}
	
	
	public String toString()
	{
		String result ="";
		for (int i = 0 ; i < currsize; i++)
			result = result + itemlist[i].toString() +"; \r\n\n";
		return (result);
	}
	
	public void mySort() 
	{ 
		LibraryItem tempitem;
		
		for (int i = 0; i < (currsize -1); i++)
		{
		       for(int j = 0; j < (currsize - (i +1)); j++)
		       {
		                if( ((itemlist[j]).getTitle().charAt(0)) > ((itemlist[j + 1]).getTitle().charAt(0)) )
		                {
		                            tempitem = itemlist [j + 1];
		                            itemlist [j + 1]= itemlist [j];
		                            itemlist [j] = tempitem;
		                }
		        }
		}	
	}
}
