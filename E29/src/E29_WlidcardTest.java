/**
 * @author leetHuam
 * @version 1.0
 */
public class E29_WlidcardTest<T> {
    private int index = 0;
    private Object[] storage;
    public E29_WlidcardTest(int size) {
        storage = new Object[size];
    }

    public void push(T item) {
        storage[index++] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        return (T)storage[--index];
    }
}

class GenericCast {
    public static final int SIZE = 10;
    public static void main(String[] args) {
        E29_WlidcardTest<String> strings = new E29_WlidcardTest<String>(SIZE);
        for (String s : "A B C D E F G H I J".split(" "))
            strings.push(s);
        for (int i = 0; i < SIZE; ++i) {
            String s  = strings.pop();
            System.out.println(s);
        }
    }
}
