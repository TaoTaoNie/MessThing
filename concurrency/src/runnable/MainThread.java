package runnable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author leetHuam
 * @version 1.0
 */
public class MainThread {
    private static ReentrantLock LOCK = new ReentrantLock();
    private static int state = 0;

    public static void main(String[] args) throws InterruptedException {

//        for (int i = 0; i < 5; i++) {
//            Thread t = new Thread(new LiftOff());
//            t.start();
//            t.join();
//        }
//        System.out.println("Main thread********");
//        LiftOff launch = new LiftOff();
//        launch.run();
        ThreadA a = new ThreadA();
        a.start();
//        a.join();
        ThreadB b = new ThreadB();
        b.start();
//        b.join();
        ThreadC c = new ThreadC();
        c.start();
//        c.join();
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    LOCK.lock();
                    while (state % 3 == 0) {
                        System.out.println("A");
                        state++;
                        i++;
                    }
                } finally {
                    LOCK.unlock();
                }
            }
        }

    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    LOCK.lock();
                    while (state % 3 == 1) {
                        System.out.println("B");
                        state++;
                        i++;
                    }
                } finally {
                    LOCK.unlock();
                }
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    LOCK.lock();
                    while (state % 3 == 2) {
                        System.out.println("C");
                        state++;
                        i++;
                    }
                } finally {
                    LOCK.unlock();
                }
            }
        }
    }
}
