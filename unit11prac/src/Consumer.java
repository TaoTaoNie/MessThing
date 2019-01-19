import java.util.Queue;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Consumer {
    public static void consume(Queue<Command> queue) {
        while (queue.peek() != null) {
            queue.remove().operation();
        }
    }
}
