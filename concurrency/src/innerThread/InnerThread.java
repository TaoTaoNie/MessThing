package innerThread;

import static java.lang.Thread.sleep;

/**
 * @author leetHuam
 * @version 1.0
 */
public class InnerThread {
    private int countDown = 5;
    private Inner inner;
    private class Inner extends Thread {
        Inner(String name) {
            super(name);
            start();
        }

        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0)
                        return;
                    sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }

        public String toString() {
            return getName() + ": " + countDown;
        }
    }

    public InnerThread(String name) {
        inner = new Inner(name);
    }
}
