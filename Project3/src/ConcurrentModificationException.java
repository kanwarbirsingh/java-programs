
/**
 * Represents the situation when a collection has been modified after 
 * iterator has been instantiated.
 *
 * @version summer 2015
 */
public class ConcurrentModificationException extends RuntimeException
{
	private static final long serialVersionUID = -8167249487235865250L;

	/**
     * Sets up this exception with an appropriate message.
     * @param collection the name of the collection
     */
    public ConcurrentModificationException (String collection)
    {
        super ("The " + collection + " has been modified.");
    }
}