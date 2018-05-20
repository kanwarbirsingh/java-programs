
/**
 * When a target element is not present in a collection
 *
 * @version summer 2015
 */
public class ElementNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = 6949716950385988835L;

     /**
     * Sets up this exception with an appropriate message.
     */
    public ElementNotFoundException (String collection)
    {
	    super ("The target element is not in this " + collection);
    }
}