package Array;

import java.util.*;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Test {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(pRoot);
        int start = 0, end = 1;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            TreeNode node  = queue.poll();
            list.add(node.val);
            start++;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (start == end) {
                end = queue.size();
                start = 0;
                result.add(list);
            }
        }
        return result;
    }
    public int InversePairs(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int length = array.length;
        int times = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 1; j < length; j++) {
                if (array[j - 1] > array[j]) {
                    times++;
                }
            }
        }
        return times;
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];



            } else if (result == array[i]) {
                times++;
            } else {
                times--;
            }
        }
        if (!checkIfThanHalf(array, result)) {
            result = 0;
        }
        return result;
    }

    private boolean checkIfThanHalf(int[] array, int result) {
        boolean thanHalf = true;
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) {
                times++;
            }
        }
        if (times * 2 <= array.length) {
            thanHalf = false;
        }
        return thanHalf;
    }
    public static void main(String[] args) {
        int[] nums = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        int k = 4;
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        Test test = new Test();
        String s = test.Serialize(root);
        System.out.println(test.Serialize(test.Deserialize(s)));

//        System.out.println(new Test().InversePairs(nums));
    }
    String Serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int n = depth(root);
        double numbers = Math.pow(2, n) - 1;
        while (!queue.isEmpty() && numbers > 0) {
            TreeNode node = queue.poll();
            String s;
            if (node.val == Integer.MIN_VALUE) {
                s = "#";
            }else {
                s = node.val +"";
            }
            str.append(s);
            numbers--;
            if (node.left == null) {
                TreeNode tmp = new TreeNode(Integer.MIN_VALUE);
                queue.add(tmp);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right == null) {
                TreeNode tmp2 = new TreeNode(Integer.MIN_VALUE);
                queue.add(tmp2);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return str.toString();
    }
    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char[] chars = str.toCharArray();
        return Deserialize(chars, 0, chars.length);
    }
    private TreeNode Deserialize(char[] chars, int index, int length) {
        if (index >= length) {
            return null;
        }
        if (chars[index] == '#') {
            return null;
        }
        TreeNode node = new TreeNode(chars[index]);
        node.left = Deserialize(chars, 2 * index + 1, length);
        node.right = Deserialize(chars, 2 * index + 2, length);
        return node;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return left < right ? right + 1 : left + 1;
    }

    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    private int count = 0;
    public void Insert(Integer num) {
        if ((count & 1) == 0) {
            maxHeap.offer(num);
            int temp = maxHeap.poll();
            minHeap.offer(temp);
        } else {
            minHeap.offer(num);
            int temp = minHeap.poll();
            maxHeap.offer(temp);
        }
        count++;
    }

    public Double GetMedian() {
        if ((count & 1) == 0) {
            return (double)((minHeap.peek() + maxHeap.peek()) / 2);
        } else {
            return (double)minHeap.peek();
        }
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] vis = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (search(matrix, rows, cols, i, j, 0, str, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean search(char[] matrix, int rows, int cols, int r, int c, int k, char[] str, boolean[] vis) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r * cols + c] != str[k] || vis[r * cols + c]) {
            return false;
        }
        if (k == str.length - 1) {
            return true;
        }
        vis[r * cols + c] = true;
        if (search(matrix, rows, cols, r + 1, c, k + 1, str, vis) ||
                search(matrix, rows, cols, r, c + 1, k + 1, str, vis) ||
                search(matrix, rows, cols, r - 1, c, k + 1, str, vis) ||
                search(matrix, rows, cols, r, c - 1, k + 1, str, vis)) {
            return true;
        }
        vis[r * cols + c] = false;
        return false;
    }
}
