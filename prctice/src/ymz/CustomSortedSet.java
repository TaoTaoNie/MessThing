package ymz;

import java.util.*;

import static java.util.Collections.binarySearch;

/**
 * @author leetHuam
 * @version 1.0
 */
public class CustomSortedSet<T> implements SortedSet<T> {
    private final List<T> list;

    public CustomSortedSet() {
        list = new LinkedList<T>();
    }

    private CustomSortedSet(List<T> list) {
        this.list = list;
    }

    public String toString() {
        return list.toString();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @SuppressWarnings("Unchecked")
    public boolean contains(Object o) {
        checkForNull(o);
        return binarySearch((List<Comparable<T>>) list, (T) o) >= 0;
    }

    public Iterator<T> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    @SuppressWarnings("unchecked")
    public boolean add(T o) {
        checkForNull(o);
        int ip = binarySearch((List<Comparable<T>>) list, o);
        if (ip < 0) {
            ip = -(ip + 1);
            if (ip == list.size())
                list.add(o);
            else
                list.add(ip, o);
            return true;
        }
        return false;
    }

    public boolean remove(Object o) {
        checkForNull(o);
        return list.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        checkForNull(c);
        return list.containsAll(c);
    }

    public boolean addAll(Collection<? extends T> c) {
        checkForNull(c);
        checkForNullElements(c);
        boolean res = false;
        for (T item : c)
            res |= add(item);
        return res;
    }

    public boolean removeAll(Collection<?> c) {
        checkForNull(c);
        return list.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        checkForNull(c);
        return list.retainAll(c);
    }

    public void clear() {
        list.clear();
    }

    public boolean equals(Object o) {
        return o instanceof CustomSortedSet &&
                list.equals(((CustomSortedSet<?>) o).list);
    }

    public int hashCode() {
        return list.hashCode();
    }

    /*** Methods defined in the SortedSet interface ***/
    public Comparator<? super T> comparator() {
        return null;
    }

    public SortedSet<T> subSet(T fromElement, T toElement) {
        checkForNull(fromElement);
        checkForNull(toElement);
        int fromIndex = list.indexOf(fromElement);
        int toIndex = list.indexOf(toElement);
        checkForValidIndex(fromIndex);
        checkForValidIndex(toIndex);
        try {
            return new CustomSortedSet<T>(
                    list.subList(fromIndex, toIndex));
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * Return
     * @param toElement
     * @return
     */
    public SortedSet<T> headSet(T toElement) {
        checkForNull(toElement);
        int toIndex = list.indexOf(toElement);
        checkForValidIndex(toIndex);
        try {
            return new CustomSortedSet<T>(
                    list.subList(0, toIndex));
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public SortedSet<T> tailSet(T fromElement) {
        checkForNull(fromElement);
        int fromIndex = list.indexOf(fromElement);
        checkForValidIndex(fromIndex);
        try {
            return new CustomSortedSet<T>(
                    list.subList(fromIndex, list.size()));
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public T first() {
        try {
            return list.get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }

    public T last() {
        try {
            return list.get(list.size() - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }

    /*** Utility methods ***/
    private void checkForNullElements(Collection<?> c) {
        for (Iterator<?> it = c.iterator(); it.hasNext(); )
            if (it.next() == null)
                throw new NullPointerException();
    }

    private void checkForNull(Object o) {
        if (o == null)
            throw new NullPointerException();
    }

    private void checkForValidIndex(int idx) {
        if (idx == -1)
            throw new IllegalArgumentException();
    }
}
