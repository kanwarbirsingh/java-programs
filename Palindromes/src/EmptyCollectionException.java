
/**
 * Represents the situation in which a collection is empty.
 *
 * @version summer 2015
 */
public class EmptyCollectionException extends RuntimeException
{
    private static final long serialVersionUID = -624523466718375506L;

    /**
     * Sets up this exception with an appropriate message.
     * @param collection the name of the collection
     */
    public EmptyCollectionException (String collection)
    {
        super ("The " + collection + " is empty.");
    }
}