/**
 * @author leetHuam
 * @version 1.0
 */
public class BasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i ++)
            new Thread(new LiftOff()).run();
        System.out.println("Waiting for LiftOff");
    }
}
