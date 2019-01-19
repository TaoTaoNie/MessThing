import java.util.Queue;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Producer {
    public static void produce(Queue<Command> queue) {
        queue.offer(new Command("load"));
        queue.offer(new Command("delete"));
        queue.offer(new Command("save"));
        queue.offer(new Command("exit"));
    }
}
