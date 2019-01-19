import java.io.IOException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;

/**
 * @author leetHuam
 * @version 1.0
 */
public class ResponsiveUI extends Thread {
    private static volatile double d = 1;
    public ResponsiveUI() {
//        setDaemon(true);
        start();
    }

    public void run() {
        while(true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] main) throws IOException{
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}
