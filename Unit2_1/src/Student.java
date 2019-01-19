import java.util.ArrayList;
import java.util.List;

/**
 * This class implements student
 *
 * @author npu
 * @version 1.0
 */
public class Student {
    /**
     * the code of the student
     */
    private int code;
    /**
     * the name of the student
     */
    private String name;
    /**
     * the list of the taskScore
     */
    private List<TaskScore> taskScoreList;

    /**
     * the constructor
     * @param code the code of the student
     * @param name the name of the student
     */
    public Student(int code, String name) {
        this.code = code;
        this.name = name;
        this.taskScoreList = new ArrayList<TaskScore>();
    }

    /**
     * get the code of the student
     * @return the code of the student
     */
    public int getCode() {
        return code;
    }

    /**
     * get the name of the student
     * @return the name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * get the list of the taskScore
     * @return the list of the taskScore
     */
    public List<TaskScore> getTaskScoreList() {
        return taskScoreList;
    }

    /**
     * add taskScore to the list of taskScore
     * @param taskScore the new taskScore
     */
    public void addTaskScore(TaskScore taskScore) {
        this.taskScoreList.add(taskScore);
    }

    /**
     * edit the taskScore
     * @param taskScore the taskScore which need to edit
     */
    public void editTaskScore(TaskScore taskScore) {

    }

    /**
     * this method to get the string to display the object
     * @return a string to display
     */
    @Override
    public String toString() {
        return "Student [name = " + this.name + ", code = " + this.code + "]";
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (code != other.code)
			return false;
		return true;
	}
}
