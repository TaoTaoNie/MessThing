package ymz;

public interface SListIterator<T> {
    boolean hasNext();
    T next();
    void remove();
    void add(T element);
}
