import java.util.ArrayList;
import java.util.List;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Controller {
    private List<Event> eventList = new ArrayList<>();
    public void addEvent(Event c) {eventList.add(c);}
    public void run() {
        while (eventList.size() > 0) {
            for (Event event : new ArrayList<>(eventList)) {
                if (event.ready()) {
                    System.out.println(event);
                    event.action();
                    eventList.remove(event);
                }
            }
        }
    }
}
