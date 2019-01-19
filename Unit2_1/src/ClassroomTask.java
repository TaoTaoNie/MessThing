import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements classroom task
 *
 * @author npu
 * @version 1.0
 */
public class ClassroomTask extends Task {
    /**
     * the list of student who need to complete the task
     */
    private List<Student> listOfStudent;

    /**
     * the constructor of the class
     * @param code the code of the task
     * @param title the title of the task
     * @param description the simple description of the task
     * @param creationDate the date when the task was created
     * @param state the state of the task
     * @throws ParseException if there are any errors in the process of date transformation
     */
    public ClassroomTask(int code, String title, String description, String creationDate, int state) throws ParseException{
        super(code, title, description, creationDate, state);
        this.listOfStudent = new ArrayList<Student>();
    }

    /**
     * this method to get the list of student
     * @return the list of student
     */
    public List<Student> getListOfStudent() {
        return listOfStudent;
    }

    /**
     * this method to get the string to display the object
     * @return a string to display
     */
    @Override
    public String toString() {
        return "Classroom task：" + super.toString();
    }
}
