import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Hex {
    public static String format(byte[] data) {
        StringBuilder result = new StringBuilder();
        StringTokenizer
        int n = 0;
        for(byte b : data) {
            if (n % 16 == 0) {
                result.append(String.format("%05X: ", n));
            }
            result.append(String.format("%02X: ", b));
            n++;
            if (n % 16 == 0)
                result.append("\n");
        }
        result.append("\n");
        return result.toString();
    }

    public static void main(String[] args) throws Exception{
    }
}
