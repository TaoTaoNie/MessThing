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
    String Serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();
    }
    private void serialize(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("#");
            return;
        }
        builder.append(root.val + "");
        serialize(root.left, builder);
        serialize(root.right, builder);
    }
    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char[] ch = str.toCharArray();
        int length = ch.length;
        return Deserialize(ch, 0, length);
    }

    TreeNode Deserialize(char[] ch, int index, int length) {
        if (index >= length) {
            return null;
        }
        if (ch[index] == '#') {
            return null;
        }
        TreeNode root = new TreeNode(ch[index] - '0');
        root.left = Deserialize(ch, 2 * index + 1, length);
        root.right = Deserialize(ch, 2 * index + 2, length);
        return root;
    }

    public static void main(String[] args) {
        int[] A = {18,12,-18,18,-19,-1,10,10};
        System.out.println(new Test().canThreePartsEqualSum(A));
    }

    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = Power(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {
            result *= base;
        }
        return result;
    }

    public boolean canThreePartsEqualSum(int[] A) {
        if (A == null || A.length <= 0) {
            return false;
        }
        int length = A.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        sum = sum / 3;
        int cur = 0;
        int j = 0;
        for (; j < length; j++) {
            cur += A[j];
            if(cur == sum) {
                j++;
                break;
            }
        }
        int cur2 = 0;
        for (; j < length; j++) {
            cur2 += A[j];
            if (cur2 == sum) {
                j++;
                break;
            }
        }
        if (j < length - 1) {
            return true;
        } else {
            return false;
        }
    }
}
