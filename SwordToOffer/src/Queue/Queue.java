package Queue;

import java.util.LinkedList;

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
        new Queue().printFromTopToBottom(node1);
        System.out.println();
        new Queue().print(node1);
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
