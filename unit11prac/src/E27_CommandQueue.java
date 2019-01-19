import java.util.LinkedList;
import java.util.Queue;

/**
 * @author leetHuam
 * @version 1.0
 */
public class E27_CommandQueue {
    public static void main(String[] args) {
        Queue<Command> cmds = new LinkedList<Command>();
        Producer.produce(cmds);
        Consumer.consume(cmds);
    }
}
