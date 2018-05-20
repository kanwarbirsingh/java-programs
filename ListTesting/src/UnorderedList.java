
public interface UnorderedList<T> extends List<T>
{
    public void addToFront(T element);  
    public void addToRear(T element); 
    public void addAfter(T element, T target);
}