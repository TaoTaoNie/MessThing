package AOP;

/**
 * @author leetHuam
 * @version 1.0
 */
public class ManWaiter implements Waiter {
    @Override
    public void server() {
        System.out.println("服务中");
    }
}
