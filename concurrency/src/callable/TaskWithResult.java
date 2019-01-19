package callable;

import java.util.concurrent.Callable;

/**
 * @author leetHuam
 * @version 1.0
 */
public class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id) {
        this.id = id;
    }

    public String call() {
        return "result of TaskWithResult " + id;
    }
}
