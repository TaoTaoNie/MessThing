package abcwhile;

import java.util.concurrent.Semaphore;

/**
 * @author leetHuam
 * @version 1.0
 */
public class ABC_Semaphore {
    // 以A开始的信号量,初始信号量数量为1
    private static Semaphore A = new Semaphore(1);
    // B、C信号量,A完成后开始,初始信号数量为0
    private static Semaphore B = new Semaphore(0);
    private static Semaphore C = new Semaphore(0);

    static class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    A.acquire();
                    System.out.println("A");
                    i++;
                    B.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    B.acquire();
                    System.out.println("B");
                    i++;
                    C.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10;) {
                try {
                    C.acquire();
                    System.out.println("C");
                    i++;
                    A.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}
