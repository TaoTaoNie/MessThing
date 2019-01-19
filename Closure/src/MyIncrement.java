/**
 * @author leetHuam
 * @version 1.0
 */
public class MyIncrement {
    public void increment() {System.out.println("Other operation");}
    static void f(MyIncrement myIncrement) {myIncrement.increment();}
}
