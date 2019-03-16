package Tree;

/**
 * @author leetHuam
 * @version 1.0
 */
public class AVLTree {
    private AVLTreeNode root;

    /**
     * 递归计算节点的高度
     * @param root 该节点
     * @return 返回节点的高度
     */
    private int treeHeight(AVLTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
        }
    }

    /**
     * 计算节点的平衡因子，即节点的左右子树的高度差（0，1，-1），平衡因子大于 1 说明该树需要修正
     * @param root 该节点
     * @return 该节点的平衡因子
     */
    private int treeBalanceFactor(AVLTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return root.left.height - root.right.height;
        }
    }

    /**
     * 对数进行右旋操作，使其为平衡二叉树
     * @param root 该数的根节点
     * @return 新的平衡树的根节点
     */
    private AVLTreeNode rightRotation(AVLTreeNode root) {
        AVLTreeNode newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        newRoot.height = Math.max(newRoot.left.height, newRoot.right.height) + 1;
        root.height = Math.max(root.left.height, root.right.height) + 1;
        return newRoot;
    }

    /**
     * 对树进行左旋操作，使其成为平衡儿茶素
     * @param root 该树的根节点
     * @return 新的平衡树的根节点
     */
    private AVLTreeNode leftRotation(AVLTreeNode root) {
        AVLTreeNode newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        newRoot.height = Math.max(newRoot.left.height, newRoot.right.height) + 1;
        root.height = Math.max(root.left.height, root.right.height) + 1;
        return newRoot;
    }

    private AVLTreeNode treeBalance(AVLTreeNode root) {
        int factor = treeBalanceFactor(root);
        if (factor > 1 && treeBalanceFactor(root.left) > 0) {
            // LL情况
            return rightRotation(root);
        } else if (factor > 1 && treeBalanceFactor(root.left) <= 0) {
            // LR情况
            root.left = leftRotation(root.left);
            return rightRotation(root);
        } else if (factor < 1 && treeBalanceFactor(root.right) < 0) {
            // RR情况
            return leftRotation(root);
        } else if (factor < 1 && treeBalanceFactor(root.right) >= 0) {
            // RL情况
            root.right = rightRotation(root.right);
            return leftRotation(root);
        } else {
            return root;
        }
    }
}

class AVLTreeNode {
    AVLTreeNode left;
    AVLTreeNode right;
    int height;
    int key;
}
