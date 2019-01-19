package concurrency;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Singleton {
    private static Singleton singleton = new Singleton();
    public static Singleton getInstance() {
        return singleton;
    }
}
