import java.util.HashMap;
import java.util.Scanner;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
//        String str = "";
//        System.out.println(myAtoi(str));
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        swapPairs(node1).string();
    }

    public static int myAtoi(String str) {
        if (str == null || str.length() <= 0) {
            return -1;
        }
        int result = 0, sign = 1, length = str.length();
        int index = 0;
        while (str.charAt(index) == ' ') {
            index++;
        }
        if (str.charAt(index) == '+') {
            sign = 1;
            index++;
        } else if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        for (;index < length && str.charAt(index) >= '0' && str.charAt(index) <= '9'; index++) {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && str.charAt(index) > '7')) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + str.charAt(index) - '0';
        }
        return result * sign;
    }

    private static void quickSort(int[] numbers, int left, int right) {
        int i = left, j = right, base = numbers[left];
        while (i < j) {
            while (numbers[j] <= base && j > i) {
                j--;
            }
            if (j > i) {
                numbers[i] = numbers[j];
                i++;
                while (numbers[i] >= base && i < j) {
                    i++;
                }
                if (i < j) {
                    numbers[j] = numbers[i];
                    j--;
                }
            }
        }
        numbers[i] = base;
        if (left < (i - 1)) {
            quickSort(numbers, left, i - 1);
        }
        if ((j + 1) < right) {
            quickSort(numbers, j + 1, right);
        }
    }

    private static boolean contains1(int[] coins, int length) {
        for (int i = 0; i < length; i++) {
            if (coins[i] == 1)
                return true;
        }
        return false;
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode node1 = head;
        ListNode node2 = head.next;
        node1.next = node2.next;
        node2.next = node1;
        head = node2;
        while (node1.next != null && node1.next.next != null) {
            ListNode temp = node1;
            node1 = node1.next;
            node2 = node1.next;
            node1.next = node2.next;
            node2.next = node1;
            temp.next = node2;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public void string() {
        System.out.println(this.val + " ");
        ListNode node = this.next;
        while (node != null) {
            System.out.println(node.val + " ");
            node = node.next;
        }
    }
}