package Queue;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Queue {
    /**
     * 剑指offer-P171
     * 题目描述：
     *          从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     * @param root 该二叉树的根节点
     */
    public void printFromTopToBottom(BTNode root) {
        if (root == null)
            return;
        java.util.Queue<BTNode> queue = new LinkedList<BTNode>();
        queue.add(root);
        while (queue.size() != 0) {
            BTNode node = queue.poll();
            System.out.print(node.value + " ");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }

    /**
     * 剑指offer-P174
     * 题目描述：
     *          从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印一行。
     * @param root 该二叉树的根节点
     */
    public void print(BTNode root) {
        if (root == null)
            return;
        java.util.Queue<BTNode> queue = new LinkedList<BTNode>();
        queue.add(root);
        int toBePrint = 1;
        int nextLevel = 0;
        while (!queue.isEmpty()) {
            BTNode node = queue.peek();
            System.out.print(node.value + " ");
            if (node.left != null) {
                queue.add(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevel++;
            }
            queue.remove();
            --toBePrint;
            if (toBePrint == 0) {
                System.out.println();
                toBePrint = nextLevel;
                nextLevel = 0;
            }
        }
    }

    /**
     * 剑指offer-P176
     * 题目描述：
     *          请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照
     *          从左到右的顺序打印，其他行一次类推。
     * @param root 该二叉树的根节点
     */
    public void printZ(BTNode root) {
        if (root == null)
            return;
        // stack1 用来缓存奇数层节点
        Stack<BTNode> stack1 = new Stack<BTNode>();
        // stack2 用来缓存偶数层节点
        Stack<BTNode> stack2 = new Stack<BTNode>();
        int level = 1;
        stack1.push(root);
        while (!stack1.empty() || !stack2.empty()) {
            if (level % 2 == 1) {
                while (!stack1.empty()) {
                    BTNode node = stack1.pop();
                    System.out.print(node.value + " ");
                    if (node.left != null)
                        stack2.push(node.left);
                    if (node.right != null)
                        stack2.push(node.right);
                }
                level++;
            }else {
                while (!stack2.empty()) {
                    BTNode node = stack2.pop();
                    System.out.print(node.value + " ");
                    if (node.right != null)
                        stack1.push(node.right);
                    if (node.left != null)
                        stack1.push(node.left);
                }
                level++;
            }
        }
    }

    /**
     * 剑指offer-P179
     * 题目描述：
     *          输入一个整数数组，判断该数组是不是某二叉搜素树的后序遍历结果。如果是则返回true，否则返回false。假设输入的数组的任意两个
     *          数字都互不相同。
     * @param sequence 输入的数组
     * @return 返回是否是二叉树搜索树的后序遍历序列
     */
    public boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null)
            return false;
        return verifySequenceOfBST1(sequence, 0, sequence.length - 1);
    }

    public boolean verifySequenceOfBST1(int[] sequence,int start, int end) {
        if (start > end)
            return false;
        int root = sequence[end];
        int i = 0;
        for (; i < end; ++i) {
            if (sequence[i] > root)
                break;
        }
        int j = i;
        for (; j < end; ++j) {
            if (sequence[j] < root)
                return false;
        }
        boolean left = true;
        if (i > start)
            left = verifySequenceOfBST1(sequence, start, i - 1);
        boolean right = true;
        if (i < end) {
            right = verifySequenceOfBST1(sequence, i, end - 1);
        }
        return (left && right);
    }

    public static void main(String[] args) {
        BTNode node1 = new BTNode(8);
        BTNode node2 = new BTNode(6);
        BTNode node3 = new BTNode(10);
        BTNode node4 = new BTNode(5);
        BTNode node5 = new BTNode(7);
        BTNode node6 = new BTNode(9);
        BTNode node7 = new BTNode(11);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        int[] sequence = {5, 7, 6, 9, 11, 10, 8};
        new Queue().printFromTopToBottom(node1);
        System.out.println();
        new Queue().print(node1);
        new Queue().printZ(node1);
        System.out.println(new Queue().verifySequenceOfBST(sequence));
    }
}

class BTNode {
    int value;
    BTNode left;
    BTNode right;
    BTNode(int value) {
        this.value = value;
    }
}
