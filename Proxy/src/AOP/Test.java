package AOP;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new ManWaiter());
        proxyFactory.setBeforeAdvice(() -> System.out.println("客户你好"));
        proxyFactory.setAfterAdvice(() -> System.out.println("客户再见"));
        Waiter waiter = (Waiter)proxyFactory.creatProxy();
        waiter.server();
    }
}
