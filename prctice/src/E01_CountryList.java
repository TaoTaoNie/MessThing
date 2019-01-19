import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author leetHuam
 * @version 1.0
 */
public class E01_CountryList {
    private static Random random = new Random(47);
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(Countries.names(8));
        Collections.sort(list);
        System.out.println("sorted: " + list);
        for (int i = 1; i < 5; i++) {
            Collections.shuffle(list);
            System.out.println("shuffled (" + i + "): " + list);
        }
    }
}
