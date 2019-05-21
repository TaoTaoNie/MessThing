package abcwhile;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author leetHuam
 * @version 1.0
 */
public class ABC_CONDITION2 {
    static private ReentrantLock lock = new ReentrantLock();
    static private Condition A = lock.newCondition();
    static private Condition B = lock.newCondition();
    static private Condition C = lock.newCondition();
    static private int state = 0;

    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    lock.lock();
                    while (state % 3 != 0) {
                        A.await();
                    }
                    System.out.println("A");
                    state++;
                    i++;
                    B.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    lock.lock();
                    while (state % 3 != 1) {
                        B.await();
                    }
                    System.out.println("B");
                    state++;
                    i++;
                    C.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    lock.lock();
                    while (state % 3 != 2) {
                        C.await();
                    }
                    System.out.println("C");
                    state++;
                    i++;
                    A.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        ThreadC c = new ThreadC();
        a.start();
        b.start();
        c.start();
    }
}
