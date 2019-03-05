package Array;

import java.util.Stack;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Test {
    Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    public void push(int node) {
        data.push(node);
        if (min.size() == 0 || node < min.peek()) {
            min.push(node);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        if (data.size() > 0 && min.size() > 0) {
            data.pop();
            min.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.push(3);
        System.out.println(test.min());
        test.push(4);
        System.out.println(test.min());
        test.push(2);
        System.out.println(test.min());
    }
}
