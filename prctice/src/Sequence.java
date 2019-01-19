import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }

    public class SequenceSelector implements Selector {
        private int i = 0;
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        public Sequence outer() {
            return Sequence.this;
        }

        @Override
        public void next() {
            if (i < items.length)
                i++;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) throws ParseException{
//        Sequence sequence = new Sequence(10);
//        for(int i = 0; i < 10; i++) {
//            sequence.add(new TestString(Integer.toString(i)));
//        }
//        Selector selector = sequence.selector();
//        while(!selector.end()) {
//            System.out.print(selector.current() + " ");
//            selector.next();
//        }
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = simpleDateFormat.parse("2018-9-17");
//        System.out.println(simpleDateFormat.format(date));
    }
}
