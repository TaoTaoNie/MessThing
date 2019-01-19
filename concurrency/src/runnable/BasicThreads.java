package runnable;

/**
 * @author leetHuam
 * @version 1.0
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread thread = new Thread(new LiftOff());
        thread.start();
        System.out.println("Waiting for runnable.LiftOff");
    }
}
