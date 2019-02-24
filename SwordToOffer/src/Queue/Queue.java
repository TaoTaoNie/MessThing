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
            System.out.println(node.value);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }
}

class BTNode {
    int value;
    BTNode left;
    BTNode right;
}
