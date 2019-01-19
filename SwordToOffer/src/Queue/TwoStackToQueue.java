package Queue;

import java.util.Stack;

/**
 * 剑指offer-P68
 * 使用两个栈实现一个队列
 * @author leetHuam
 * @version 1.0
 */
public class TwoStackToQueue<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;
    private T data;
    private T head;

    public void appendTail(T node) {
        stack1.push(node);
    }

    public T deleteHead() throws Exception{
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                data = stack1.pop();
                stack2.push(data);
            }
        }
        if (stack2.size() == 0)
            throw new Exception("queue is empty");
        head = stack2.pop();
        return head;
    }
}
