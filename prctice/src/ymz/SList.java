package ymz;

import java.util.NoSuchElementException;

/**
 * @author leetHuam
 * @version 1.0
 */
public class SList<T> {
    private final Link<T> header = new Link<T>(null, null);

    SList() {
        header.next = header;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (SListIterator<T> iterator = iterator(); iterator.hasNext(); ) {
            T element = iterator.next();
            stringBuilder.append(element == this ? "(this SList)" : String.valueOf(element));
            if (iterator.hasNext())
                stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static class Link<T> {
        T element;
        Link<T> next;

        Link(T element, Link<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    public SListIterator<T> iterator() {
        return new SListIteratorImpl();
    }

    private class SListIteratorImpl implements SListIterator<T> {
        private Link<T> lastReturned = header;
        private Link<T> next;

        SListIteratorImpl() {
            next = header.next;
        }

        public boolean hasNext() {
            return next != header;
        }

        public T next() {
            if (next == header)
                throw new NoSuchElementException();
            lastReturned = next;
            next = next.next;
            return lastReturned.element;
        }

        public void remove() {
            if (lastReturned == header)
                throw new IllegalStateException();
            // Find an element before the last returned one
            for (Link<T> curr = header; ; curr = curr.next)
                if (curr.next == lastReturned) {
                    curr.next = lastReturned.next;
                    break;
                }
            lastReturned = header;
        }

        public void add(T element) {
            lastReturned = header;
            Link<T> newLink = new Link<T>(element, next);
            if (header.next == header) // Empty list
                header.next = newLink;
            else {
                // Find an element before the one pointed by 'next'
                for (Link<T> curr = header; ; curr = curr.next)
                    if (curr.next == next) {
                        curr.next = newLink;
                        break;
                    }
            }
        }
    }
}


