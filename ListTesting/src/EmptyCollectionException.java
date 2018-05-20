
public class EmptyCollectionException extends RuntimeException
{
    private static final long serialVersionUID = -624523466718375506L;
    public EmptyCollectionException (String collection)
    {
        super ("The " + collection + " is empty.");
    }
}