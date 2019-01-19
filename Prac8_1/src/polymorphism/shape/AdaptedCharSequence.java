package polymorphism.shape;

import java.nio.CharBuffer;
import java.util.Scanner;

public class AdaptedCharSequence extends CharSequence implements Readable{
    private int count;
    public AdaptedCharSequence(int count) {
        this.count = count;
    }

    public int read(CharBuffer charBuffer) {
        if (count-- == 0) {
            return -1;
        }
        char[] buffer = generate();
        charBuffer.put(buffer);
        return buffer.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new AdaptedCharSequence(10));
        while (scanner.hasNext())
            System.out.println(scanner.next());
    }
}
