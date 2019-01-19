package ObserverPatterns;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        WechatServer server = new WechatServer();

        Observer james = new User("james");
        Observer kobe = new User("kobe");
        Observer jordan = new User("jordan");

        server.registerObserver(james);
        server.registerObserver(kobe);
        server.registerObserver(jordan);

        server.setInformation("hello china");

        server.removeObserver(james);
        server.setInformation("hello USA");
    }
}
