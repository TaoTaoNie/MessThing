package SingletonPatterns;

/**
 * 单例模式的懒汉模式,也保证了线程安全
 * @author leetHuam
 * @version 1.0
 */
public class Singleton_1 {
    private static Singleton_1 singleton;

    private Singleton_1(){

    }
    public static synchronized Singleton_1 newInstence() {
        if (singleton == null) {
            singleton = new Singleton_1();
        }
        return singleton;
    }
}
