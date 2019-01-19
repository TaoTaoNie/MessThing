import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class implements experiment task
 *
 * @author npu
 * @version 1.0
 */
public class Experiment extends Task {
    /**
     * the deadline to complete the task
     */
    private Date deadline;
    /**
     * the number of the java files of the task
     */
    private int numberOfJavaFile;

    /**
     * the constructor
     * @param code the code of the task
     * @param title the title of the task
     * @param description the description of the task
     * @param creationDate the date when the task is created
     * @param state the state of the task
     * @param deadline the deadline to complete task
     * @param numberOfJavaFile the number of the java files of the task
     * @throws ParseException if there are any errors in the process of the date transformation
     */
    public Experiment(int code, String title, String description, String creationDate, int state, String deadline, int numberOfJavaFile) throws ParseException{
        super(code, title, description, creationDate, state);
        this.deadline = new SimpleDateFormat("yyyy-MM-dd").parse(deadline);
        this.numberOfJavaFile = numberOfJavaFile;
    }

    public Date getDeadline() {
        return deadline;
    }

    public int getNumberOfJavaFile() {
        return numberOfJavaFile;
    }

    /**
     * this method to get the string to display the object
     * @return a string to display
     */
    @Override
    public String toString() {
        return "Experiment：" + super.toString() + ", deadline = " + new SimpleDateFormat("yyyy-MM-dd").format(deadline) + ", numberOfJavaFile = " + numberOfJavaFile;
    }
}
