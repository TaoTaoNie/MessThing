
/**
 * The counter class implements a counter that will roll over to the initial
 * value when it hits the maximum value.
 *
 * @author Charles Hoot
 * @version 4.0
 */
public class Counter {
    // PUT PRIVATE DATA FIELDS HERE
    private int minValue;
    private int maxValue;
    private int currentValue;
    private boolean rolledOver = false;

    /**
     * The default constructor for objects of class Counter.  Minimum is 0 and the maximum
     * is the largest possible integer.
     */
    public Counter() {
        // ADD CODE FOR THE CONSTRUCTOR
        currentValue = minValue = 0;
        maxValue = Integer.MAX_VALUE;
    }


    /**
     * The alternate constructor for objects of class Counter.  The minimum and maximum values are given as parameters.
     * The counter starts at the minimum value.
     *
     * @param min The minimum value that the counter can have
     * @param max The maximum value that the counter can have
     */
    public Counter(int min, int max) {
        // ADD CODE FOR THE ALTERNATE CONSTRUCTOR
        if (min == max)
            throw new CounterInitializationException("min == max");
        if (min > max)
            throw new CounterInitializationException("min > max");
        currentValue = minValue = min;
        maxValue = max;
    }

    /**
     * Determine if two counters are in the same state
     *
     * @param otherObject the object to test against for equality
     * @return true if the objects are in the same state
     */
    public boolean equals(Object otherObject) {
        boolean result = true;
        if (otherObject instanceof Counter) {
            // YOUR CODE GOES HERE
            Counter other = (Counter) otherObject;
            if (minValue != other.minValue || maxValue != other.maxValue || currentValue != other.currentValue || rolledOver != other.rolledOver)
                result = false;
        }
        return result;
    }


    /**
     * Increases the counter by one
     */
    public void increase() {
        // ADD CODE TO INCREASE THE VALUE OF THE COUNTER
        if (currentValue == maxValue) {
            currentValue = minValue;
            rolledOver = true;
        } else {
            currentValue++;
            rolledOver = false;
        }
    }


    /**
     * Decreases the counter by one
     */
    public void decrease() {
        // ADD CODE TO INCREASE THE VALUE OF THE COUNTER
        if (currentValue == minValue) {
            currentValue = maxValue;
            rolledOver = true;
        } else {
            currentValue--;
            rolledOver = false;
        }
    }

    /**
     * Get the value of the counter
     *
     * @return the current value of the counter
     */
    public int value() {
        // CHANGE THE RETURN TO GIVE THE CURRENT VALUE OF THE COUNTER
        return currentValue;

    }


    /**
     * Accessor that allows the client to determine if the counter
     * rolled over on the last count
     *
     * @return true if the counter rolled over
     */
    public boolean rolledOver() {
        // CHANGE THE RETURN TO THE ROLLOVER STATUS OF THE COUNTER
        return rolledOver;
    }

    /**
     * Override the toString method to provide a more informative
     * description of the counter
     *
     * @return a descriptive string about the object
     */
    public String toString() {
        // CHANGE THE RETURN TO A DESCRIPTION OF THE COUNTER
        return "max: " + this.maxValue + " min: " + this.minValue + " current value: " + this.currentValue + " roll over: " + this.rolledOver;
    }

}
