package runnable;

/**
 * @author leetHuam
 * @version 1.0
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
            new Thread(new LiftOff()).start();
        System.out.println("waiting for runnable.LiftOff");
    }
}
