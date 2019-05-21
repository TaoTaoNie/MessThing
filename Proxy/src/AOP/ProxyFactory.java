package AOP;

import java.lang.reflect.Proxy;

/**
 * @author leetHuam
 * @version 1.0
 */
public class ProxyFactory {
    private Object target;
    private BeforeAdvice beforeAdvice;
    private AfterAdvice afterAdvice;

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public BeforeAdvice getBeforeAdvice() {
        return beforeAdvice;
    }

    public void setBeforeAdvice(BeforeAdvice beforeAdvice) {
        this.beforeAdvice = beforeAdvice;
    }

    public AfterAdvice getAfterAdvice() {
        return afterAdvice;
    }

    public void setAfterAdvice(AfterAdvice afterAdvice) {
        this.afterAdvice = afterAdvice;
    }

    public Object creatProxy() {
        Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), ((proxy1, method, args) -> {
            if (beforeAdvice != null) {
                beforeAdvice.before();

            }
            Object result = method.invoke(target, args);
            afterAdvice.after();
            return result;
        }));

        return proxy;
    }
}
