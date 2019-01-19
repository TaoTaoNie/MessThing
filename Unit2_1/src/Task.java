import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class implements task
 *
 * @author npu
 * @version 1.0
 */
public class Task {
    /**
     * the unique identifier of the task
     */
    private int code;
    /**
     * the title of the task
     */
    private String title;
    /**
     * the simple description of the task
     */
    private String description;
    /**
     * the time when the task is created
     */
    private Date creationDate;
    /**
     * if the task is published
     * 0 : task is published
     * 1 : task is not published
     */
    private int state;

    /**
     * the constructor
     * @param code the code of the task
     * @param title the title of the task
     * @param description the description of the task
     * @param creationDate the date when the task is created
     * @param state the state of the task
     * @throws ParseException if there are any errors in the process of the date transformation
     */
    public Task(int code, String title, String description, String creationDate, int state) throws ParseException{
        this.code = code;
        this.title = title;
        this.description = description;
        this.creationDate = new SimpleDateFormat("yyyy-MM-dd").parse(creationDate);
        this.state = state;
    }

    /**
     * get the code of the task
     * @return the code of the task
     */
    public int getCode() {
        return code;
    }

    /**
     * get the title of the task
     * @return the title of the task
     */
    public String getTitle() {
        return title;
    }

    /**
     * get the description of the task
     * @return the description of the task
     */
    public String getDescription() {
        return description;
    }

    /**
     * get the date when the task is created
     * @return the date when the task is created
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * get the state of the task
     * @return the state of the task
     */
    public int getState() {
        return state;
    }

    /**
     * set the state of the task
     * @param state the new state
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     * this method to get the string to display the object
     * @return a string to display
     */
    @Override
    public String toString() {
        return " title = " + title + ", code = " + code + ", description = " + description + ", creationDate = " + new SimpleDateFormat("yyyy-MM-dd").format(creationDate) + ", state = " + state;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (code != other.code)
			return false;
		return true;
	}

}
