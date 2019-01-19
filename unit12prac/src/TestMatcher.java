import java.io.StringReader;
import java.util.regex.Pattern;

/**
 * @author leetHuam
 * @version 1.0
 */
public class TestMatcher {
    public static void main(String[] args){
        try {
            throw new NumberFormatException();
        }catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 3; i++)
            System.out.println(i);
    }
}
