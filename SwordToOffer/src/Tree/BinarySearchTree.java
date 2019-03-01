package Tree;

import java.util.Stack;

/**
 * @author leetHuam
 * @version 1.0
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private BSTreeNode<T> root;

    /**
     * 该二叉搜索树的前序遍历算法
     * @param root 该二叉搜索树的根节点
     */
    private void preOrder(BSTreeNode<T> root) {
        if (root != null) {
            System.out.println(root.key);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    /**
     * 该二叉搜索树的中序遍历算法
     * @param root 该二叉搜素树的根节点
     */
    private void inOrder(BSTreeNode<T> root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.key);
            inOrder(root.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    /**
     * 该二叉搜索树的后序遍历算法
     * @param root 该二叉搜索树的根节点
     */
    private void postOrder(BSTreeNode<T> root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.key);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    /**
     * 递归版本的二叉搜索树中的搜索方法
     * @param x 二叉搜索树的一个节点
     * @param key 搜索的值
     * @return 搜到的节点
     */
    private BSTreeNode<T> iterativeSearch(BSTreeNode<T> x, T key) {
        if (x == null)
            return x;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return iterativeSearch(x.left, key);
        else if (cmp > 0)
            return iterativeSearch(x.right, key);
        else
            return x;
    }

    public BSTreeNode<T> iterativeSearch(T key) {
        return iterativeSearch(root, key);
    }

    /**
     * 非递归实现二叉搜索树的查找，利用的是二叉树的性质，很好遍历
     * @param x 二叉树中的某一个节点
     * @param key 查找的那个值
     * @return 查找到节点
     */
    private BSTreeNode<T> search(BSTreeNode<T> x, T key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp > 0)
                x = x.right;
            else if (cmp < 0)
                x = x.left;
            else
                return x;
        }
        return x;
    }

    public void search(T key) {
        search(root, key);
    }

    /**
     * 查找该二叉搜索树的最大值
     * @param root 该二叉搜索树的根节点
     * @return 查找到的最大的二叉树的节点
     */
    private BSTreeNode<T> maximum(BSTreeNode<T> root) {
        if (root == null)
            return null;
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public T maximum() {
        BSTreeNode<T> temp = maximum(root);
        return temp.key;
    }

    /**
     * 查找该二叉搜索树的最小值
     * @param root 该二叉搜索树的根节点
     * @return 查找到的最小的节点
     */
    private BSTreeNode<T> minimum(BSTreeNode<T> root) {
        if (root == null)
            return null;
        while (root.left != null)
            root = root.left;
        return root;
    }

    public T minimum() {
        BSTreeNode<T> temp = minimum(root);
        return temp.key;
    }

    /**
     * 查找指定节点的前驱节点（前驱节点是指小于该节点的最大节点）
     * 如果该节点有左子树，则要找的这个左子树中最大的节点
     * 如果该节点没有左子树，则这个节点的前驱在其某个父节点那，就应该顺着该节点的父节点一直往上找，直到找到一个父节点 P 是该、其父节点 Q 的
     * 右孩子，则这个节点 Q 就是要找的前驱节点
     * @param x 该指定节点
     * @return 返回找到的前驱节点
     */
    public BSTreeNode<T> predecessor(BSTreeNode<T> x) {
        if (x.left != null)
            return maximum(x.left);
        BSTreeNode<T> y = x.parent;
        while ((y != null) && (x == y.left)) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    /**
     * 查找指定节点的后继节点（后继节点是指大于该节点的最小节点）
     * 如果该节点有右子树，则要找该节点的右子树中最小的节点
     * 如果该节点没有右子树，则这个节点的后继是这个节点的某个父节点，就应该顺着该节点的父节点一直往上找，直到找到一父节点 P 是其父节点 Q 的
     * 左孩子，则这个节点 Q 就是要找的后继节点
     * @param x 指定的节点
     * @return 找到的后继节点
     */
    public BSTreeNode<T> postdecessor(BSTreeNode<T> x) {
        if (x.right != null)
            return minimum(x.right);
        BSTreeNode<T> y = x.parent;
        while ((y != null) && x == y.right) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    /**
     * 二叉搜索树的插入算法
     * 如果该二叉树为空的话，则插入为根节点
     * 否则开始查找，查找到插入节点的父节，然后再判断该插入应该是左孩子还是右孩子
     * @param bst 插入的二叉树
     * @param insert 被插入的节点
     */
    private void insert(BinarySearchTree<T> bst, BSTreeNode<T> insert) {
        if (bst.root == null)
            bst.root = insert;
        else {
            BSTreeNode<T> parent = null;
            BSTreeNode<T> current = bst.root;
            while (current != null) {
                if (insert.key.compareTo(current.key) > 0) {
                    parent = current;
                    current = current.right;
                } else if (insert.key.compareTo(current.key) < 0) {
                    parent = current;
                    current = current.left;
                } else
                    return;
            }
            if (parent.key.compareTo(insert.key) > 0) {
                parent.left = insert;
                insert.parent = parent;
            }
            else {
                parent.right = insert;
                insert.parent = parent;
            }
        }
    }

    public void insert(T key) {
        BSTreeNode<T> insert = new BSTreeNode<>(key, null, null, null);
        if (insert != null)
            insert(this, insert);
    }

    public static void main(String[] args) {
    }
}

class BSTreeNode<T extends Comparable<T>> {
    T key;
    BSTreeNode<T> left;
    BSTreeNode<T> right;
    BSTreeNode<T> parent;
    public BSTreeNode(T key, BSTreeNode<T> left, BSTreeNode<T> right, BSTreeNode<T> parent) {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.key = key;
    }
}

class A {

}

class B extends A {

}