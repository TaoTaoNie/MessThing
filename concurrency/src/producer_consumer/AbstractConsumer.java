package producer_consumer;

/**
 * @author leetHuam
 * @version 1.0
 */
public abstract class AbstractConsumer implements Runnable, Consumer{
    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
