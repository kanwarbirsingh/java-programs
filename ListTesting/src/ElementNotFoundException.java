
	public class ElementNotFoundException extends RuntimeException
	{
	    private static final long serialVersionUID = 6949716950385988835L;
	    public ElementNotFoundException (String collection)
	    {
		    super ("The target element is not in this " + collection);
	    }
	}