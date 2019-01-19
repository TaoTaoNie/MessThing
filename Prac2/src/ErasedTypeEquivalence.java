import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author leetHuam
 * @version 1.0
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
    }
}
