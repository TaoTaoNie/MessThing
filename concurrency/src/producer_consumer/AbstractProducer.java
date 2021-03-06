package producer_consumer;

/**
 * @author leetHuam
 * @version 1.0
 */
public abstract class AbstractProducer implements Producer, Runnable{
    @Override
    public void run() {
        while(true) {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
