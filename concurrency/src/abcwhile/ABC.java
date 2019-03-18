package abcwhile;

/**
 * 使用sychronized实现三个线程打印ABC问题
 * @author leetHuam
 * @version 1.0
 */
public class ABC {
    public static class ThreadPrinter implements Runnable {
        private String name;
        private Object prev;
        private Object self;

        private ThreadPrinter(String name, Object prev, Object self) {
            this.name = name;
            this.prev = prev;
            this.self = self;
        }

        @Override
        public void run() {
            int count = 10;
            while (count > 0) {
                synchronized (prev) {
                    synchronized (self) {
                        System.out.println(name);
                        count--;
                        self.notifyAll();
                    }
                    try {
                        prev.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public static void main(String[]  args) throws InterruptedException{
            Object a = new Object();
            Object b = new Object();
            Object c = new Object();

            ThreadPrinter pa = new ThreadPrinter("A", c, a);
            ThreadPrinter pb = new ThreadPrinter("B", a, b);
            ThreadPrinter pc = new ThreadPrinter("C", b, c);

            new Thread(pa).start();
            Thread.sleep(10);
            new Thread(pb).start();
            Thread.sleep(10);
            new Thread(pc).start();
            Thread.sleep(10);
        }
    }
}
