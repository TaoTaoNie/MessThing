package SingletonPatterns;

/**
 * 单例模式的饿汉加载
 * @author leetHuam
 * @version 1.0
 */
public class Singleton_3 {
    private static Singleton_3 singleton = new Singleton_3();
    private Singleton_3() {

    }
    public static Singleton_3 newInstence() {
        return singleton;
    }
}
