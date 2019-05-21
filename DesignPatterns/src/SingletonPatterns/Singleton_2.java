package SingletonPatterns;

/**
 * 双重检查枷锁
 * @author leetHuam
 * @version 1.0
 */
public class Singleton_2 {
    private volatile static Singleton_2 singleton;
    private Singleton_2() {

    }
    public static Singleton_2 newInstence() {
        if (singleton == null) {
            synchronized (Singleton_2.class) {
                singleton = new Singleton_2();
            }
        }
        return singleton;
    }
}
