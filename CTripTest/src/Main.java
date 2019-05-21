import java.util.*;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            String[] strs = s.split(",");
            Set<String> set = new HashSet<>();
            boolean hasRing = false;
            for (String temp : strs) {
                if (set.contains(temp)) {
                    hasRing = true;
                    break;
                } else {
                    set.add(temp);
                }
            }
            System.out.println(hasRing);
        }
}
