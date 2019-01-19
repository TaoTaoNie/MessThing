/**
 * This class implements taskScore
 *
 * @author npu
 * @version 1.0
 */
public class TaskScore {
    /**
     * the score of the task
     */
    private float score;
    /**
     * the task
     */
    private Task task;
    /**
     * the student
     */
    private Student student;

    /**
     * the constructor
     * @param score the score of the task
     * @param task the task
     * @param student the student who owen the task and score
     */
    public TaskScore(float score, Task task, Student student) {
        this.score = score;
        this.task = task;
        this.student = student;
    }

    /**
     * get the score
     * @return the score
     */
    public float getScore() {
        return score;
    }

    /**
     * get the task
     * @return the task
     */
    public Task getTask() {
        return task;
    }

    /**
     * get the student
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * set the score
     * @param score the new score
     */
    public void setScore(float score) {
        this.score = score;
    }

    /**
     * this method to get the string to display the object
     * @return a string to display
     */
    @Override
    public String toString() {
        return task.toString() + ", score = " + this.score;
    }
}
