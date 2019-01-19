import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class implements homework task
 *
 * @author npu
 * @version 1.0
 */
public class Homework extends Task {
    /**
     * the deadline to complete the task
     */
    private Date deadline;

    /**
     * the constructor
     * @param code the code of task
     * @param title the title of task
     * @param description the description of task
     * @param creationDate the date when the task is created
     * @param state the state of the task
     * @param deadline the deadline to complete the task
     * @throws ParseException
     */
    public Homework(int code, String title, String description, String creationDate, int state, String deadline) throws ParseException{
        super(code, title, description, creationDate, state);
        this.deadline = new SimpleDateFormat("yyyy-MM-dd").parse(deadline);
    }

    public Date getDeadline() {
        return deadline;
    }

    /**
     * this method to get the string to display the object
     * @return a string to display
     */
    @Override
    public String toString() {
        return "Homework：" + super.toString() + ", deadline = " + new SimpleDateFormat("yyyy-MM-dd").format(deadline);
    }
}
