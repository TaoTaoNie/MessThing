import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author leetHuam
 * @version 1.0
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random random = new Random(47);
        for(int i = 0; i < 10; i++) {
            priorityQueue.offer(random.nextInt(i + 10));
        }
    }
}
