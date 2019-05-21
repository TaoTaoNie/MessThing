package waitnotify;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author leetHuam
 * @version 1.0
 */
public class WaitNotify {
    private static final Object object = new Object();
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println("线程1 获取到监视器锁");
                    try {
                        object.wait();
                        System.out.println("线程1 恢复了，我为什么这么久才恢复呢？因为被通知后我还需重新获取锁才能执行啊。");
                    } catch (InterruptedException e) {
                        System.out.println("线程1 即使是中断老子，老子也要获取到锁再被中断!");
                    }
                }
            }
        }, "线程1");
        thread1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println("线程2 拿到了监视器锁。为什么呢？因为线程1在wait时候会释放锁");
                    thread1.interrupt();
                    System.out.println("线程2 中断了线程1，畜生啊！");
                    System.out.println("线程2 休息3秒再说。");
                    try {
                        Thread.sleep(3000);
                        System.out.println("线程2 休息完了。注意了，调用sleep与调用wait不同的是不会释放监视器锁的");
                    } catch (InterruptedException e) {

                    }
                    System.out.println("线程2 休息完了，结束操作！");
                }
            }
        }, "线程2").start();
    }

}
