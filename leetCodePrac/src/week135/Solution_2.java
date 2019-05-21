package week135;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Solution_2 {
    private static TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        List<Integer> listCopy = new ArrayList<>(list);
        int length = list.size();
        for (int i = length - 2; i >= 0; i--) {
            list.set(i, list.get(i) + list.get(i + 1));
        }
        Map<Integer, Integer> map = new HashMap<>(length);
        for (int j = 0; j < length; j++) {
            map.put(listCopy.get(j), list.get(j));
        }
        refresh(root, map);
        return root;
    }

    private static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    private static void refresh(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        root.val = map.get(root.val);
        refresh(root.left, map);
        refresh(root.right, map);
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node1.left = node0;
        node1.right = node2;
        node2.right = node3;
        node4.left = node1;
        node4.right = node6;
        node6.left = node5;
        node6.right = node7;
        node7.right = node8;
        System.out.println(bstToGst(node4));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}
