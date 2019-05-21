package Tree;

/**
 * 剑指offer-P63
 * @author leetHuam
 * @version 1.0
 */
public class BinaryTree {

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序和中序遍历的结果中都不含重复的数字
     * @param pre 前序序列
     * @param in 中序序列
     * @return 返回创建好的节点
     */
    public static BinaryTreeNode construct(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length <= 0 || in.length <= 0) {
            return null;
        }
        return constructCore(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private static BinaryTreeNode constructCore(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        int rootValue = pre[startPre];
        BinaryTreeNode root = new BinaryTreeNode(rootValue);
        for (int i = startIn; i <= endIn; i++) {
            if (pre[startPre] == in[i]) {
                root.left = constructCore(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = constructCore(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
            }
        }
        return root;
    }

    /**
     * 输入某二叉树的后序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序和中序遍历的结果中都不含重复的数字
     * @param post 输入的后序序列
     * @param in 输入的中序序列
     * @return 返回创建好的节点
     */
    public static BinaryTreeNode behindConstruct(int[] post, int[] in) {
        if (post == null || in == null || post.length <= 0 || in.length <= 0) {
            return null;
        }
        return constructCore2(post, 0, post.length - 1, in, 0, in.length - 1);
    }

    private static BinaryTreeNode constructCore2(int[] post, int startPost, int endPost, int[] in, int startIn, int endIn) {
        if (startPost > endPost || startIn > endIn) {
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(post[endPost]);
        for (int i = startIn; i <= endIn; i++) {
            if (post[endPost] == in[i]) {
                root.left = constructCore2(post, startPost, endPost - i + startIn - 1, in, startIn, i - 1);
                root.right = constructCore2(post, endPost - i + startIn, endPost - 1, in, i + 1, endIn);
            }
        }
        return root;
    }

    /**
     * 剑指offer-P65
     * 给定一棵二叉树和其中一个节点，找出中序遍历序列的下一个节点。树中的节点除了有两个分别指向左、右节点的引用，还有一个指向父节点的引用
     * @param root 该列表或者可以理解为该数
     * @return 下一个节点
     */
    public static BinaryTreeNode getNext(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode next = null;
        if(root.right != null) {
            BinaryTreeNode right = root.right;
            while (right.left != null) {
                right = right.left;
            }
            next = right;
        }else if (root.parent != null) {
            BinaryTreeNode current = root;
            BinaryTreeNode parent = root.parent;
            while (parent != null && current == parent.right) {
                current = parent;
                parent = parent.parent;
            }
            next = parent;
        }
        return next;
    }

    /**
     * 剑指offer-P148
     * 题目描述
     *          输入两颗二叉树 A 和 B ，判断 B 是不是 A 的子结构。
     * @param root1 二叉树 A
     * @param root2 二叉树 B
     * @return 如果 B 是 A 的子结构返回 true，不是则返回 false
     */
    private boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null ||  root2 == null) {
            return false;
        }
        boolean result = false;
        if (root1.value == root2.value) {
            result = doesTree1HasTree2(root1, root2);
        }
        if (!result) {
            result = hasSubTree(root1.left, root2);
        }
        if (!result) {
            result = hasSubTree(root1.right, root2);
        }
        return result;
    }

    private boolean doesTree1HasTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null) {
            return false;
        }
        if (root2 == null) {
            return true;
        }
        if (root1.value != root2.value)
            return false;
        return doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
    }

    /**
     * 剑指offer-P157
     * 题目描述
     *          请完成一个函数，输入一颗二叉树，该函数输出它的镜像
     * @param root 该二叉树的根节点
     */
    private void mirrorRecursively(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            mirrorRecursively(root.left);
        }
        if (root.right != null) {
            mirrorRecursively(root.right);
        }
    }

    /**
     * 剑指offer-P159
     * 题目描述
     *          请实现一个函数，用来判断一颗二叉树是不是对称的。如果一颗二叉树和它的镜像一样，那么它是对称的。
     * @param root 该二叉树的根节点
     * @return 如果该二叉树是对称的返回 true，不是则返回 false。
     */
    private boolean isSymmetrical(BinaryTreeNode root) {
        return isSymmetrical(root, root);
    }

    private boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.value != root2.value)
            return false;
        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode treeNode = construct(pre, in);
        System.out.println(treeNode);
    }
}

class BinaryTreeNode {
    public int value;
    BinaryTreeNode parent = null;
    BinaryTreeNode left = null;
    BinaryTreeNode right = null;
    public BinaryTreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode [data = " + value + ", left = \n" + left + ", right = \n" + right + "]";
    }
}
