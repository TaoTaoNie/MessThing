package list;

import java.util.List;

/**
 * 剑指offer-P58
 * @author leetHuam
 * @version 1.0
 */
public class PrintListReversingly {
    /**
     * 输入一个链表的头节点，从尾到头反过来打印出每个节点的值（可以使用递归，如果链表过长，则使用栈即可）
     * @param listNode 输入的链表
     */
    private static void printListFromTailToHead(ListNode listNode) {
        if (listNode == null)
            return;
        if (listNode.next != null) {
            printListFromTailToHead(listNode.next);
        }
        System.out.println(listNode.value);

    }

    /**
     * 剑指offer-P119
     * 题目描述
     *          在 O(1) 时间内删除链表节点， 给定单向链表的头节点的引用和一个节点引用，定义一个函数在 O(1) 时间内删除该节点
     * @param head 该链表的头节点
     * @param toDeleteNode  需要删除的节点
     */
    private static void deleteNode(ListNode head, ListNode toDeleteNode) {
        if (head == null || toDeleteNode == null)
            return;
        if (toDeleteNode.next != null) {
            ListNode next = toDeleteNode.next;
            toDeleteNode.next = next.next;
            toDeleteNode.value = next.value;
            next = null;
        } else if (head == toDeleteNode) {
            head = null;
        } else {
            while (head.next != toDeleteNode) {
                head = head.next;
            }
            head.next = null;
        }
    }

    /**
     * 剑指offer-P122
     * 题目描述
     *          删除链表中的重复的节点，在一个排序的链表中，如何删除重复的节点？
     * @param head 链表头节点
     */
    private static void deleteDuplication(ListNode head) {
        if (head == null)
            return;
        ListNode pPreNode = null;
        ListNode pNode = head;
        while (pNode != null) {
            boolean needDelete = false;
            ListNode pNext = pNode.next;
            if (pNext != null && pNext.value == pNode.value)
                needDelete = true;
            if (!needDelete) {
                pPreNode = pNode;
                pNode = pNode.next;
            } else {
                int value = pNode.value;
                ListNode pToBeDel = pNode;
                while (pToBeDel != null && pPreNode.value == value) {
                    pNext = pToBeDel.next;
                    pToBeDel = pNext;
                }
                if (pPreNode == null)
                    head = pNext;
                else
                    pPreNode.next = pNext;
                pNode = pNext;
            }
        }
    }

    /**
     * 剑指offer-P134
     * 题目描述
     *          输入一个链表，输出该链表中倒数第 k 个节点
     * @param listHead 被查找的链表
     * @param k 倒数第 k 个
     * @return 链表中的倒数第 k 个节点
     * 举一反三
     *          当我们用一个指针遍历链表不能解决问题时，可以尝试使用两个指针来遍历链表。可以让其中一个指针遍历的速度快一些，或者让它先在
     *          链表上走若干步
     */
    private ListNode findKthFromTail(ListNode listHead, int k) {
        if (listHead == null || k <= 0)
            return null;
        ListNode pAhead = listHead;
        ListNode pBehind = null;
        for (int i = 0; i < k - 1; i++) {
            if (pAhead.next != null)
                pAhead = pAhead.next;
            else
                return null;
        }
        pBehind = listHead;
        while (pAhead.next != null) {
            pAhead = pAhead.next;
            pBehind = pBehind.next;
        }
        return pBehind;
    }

    /**
     * 剑指offer-P139
     * 题目描述
     *          如果一个链表中包含环，如何找出环的入口节点？
     * @param head 该链表
     * @return 链表中的环的入口节点
     */
    private ListNode entryNodeOfLoop(ListNode head) {
        if (head == null)
            return null;
        ListNode meetingNode = meetingNode(head);
        /*链表中没有环的情况下直接返回null*/
        if (meetingNode == null)
            return null;
        int nodesInLoop = 1;
        ListNode node1 = meetingNode;
        while (node1.next != meetingNode) {
            node1 = node1.next;
            ++nodesInLoop;
        }
        node1 = head;
        for (int i = 0; i < nodesInLoop; i++) {
            node1 = node1.next;
        }
        ListNode node2 = head;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    /**
     * 判断一个链表中是否有环
     * @param head 该链表
     * @return 返回该环中的某个节点
     */
    private ListNode meetingNode(ListNode head) {
        ListNode slow = head.next;
        if (slow == null)
            return null;
        ListNode fast = slow.next;
        while (fast != null && slow != null) {
            if (slow == fast)
                return fast;
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        return null;
    }

    /**
     * 剑指offer-P142
     * 题目描述
     *          定义一个函数，输入一个链表的头节点，反转该链表并输出反转后的链表的头节点。
     * @param head 该链表
     * @return 反转之后的链表的头节点
     */
    private ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode reverseHead = null;
        ListNode node = head;
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            if (next == null)
                reverseHead = node;
            node.next = pre;
            pre = node;
            node = next;
        }
        return reverseHead;
    }

    /**
     * 剑指offer-P145
     * 题目描述
     *          输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然使递增排序的。
     * @param head1 第一个排序的链表
     * @param head2 第二个排序的链表
     * @return 合并之后的链表头节点
     */
    private ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null)
            return head2;
        else if (head2 == null)
            return head1;
        ListNode mergeHead = null;
        if (head1.value < head2.value) {
            mergeHead = head1;
            mergeHead.next = merge(head1.next, head2);
        }else {
            mergeHead = head2;
            mergeHead.next = merge(head1, head2.next);
        }
        return mergeHead;
    }

    /**
     * 剑指offer-P187
     * 题目描述：
     *          请实现一个函数复制一个复杂链表，在复杂链表中，每个节点有一个指针next指向下一个节点，还有另一个指针sibling指向
     *          链表中的任意节点或者null
     * @param pHead 该链表的头节点
     */
    public void cloneNodes(ListNode pHead) {
        ListNode pNode = pHead;
        while (pNode != null) {
            ListNode pCloned = new ListNode();
            pCloned.value = pNode.value;
            pCloned.next = pNode.next;
            pCloned.sibling = null;
            pNode.next = pCloned;
            pNode = pCloned.next;
        }
    }

    public void connectSiblingNodes(ListNode pHead) {
        ListNode pNode = pHead;
        while (pNode != null) {
            ListNode pCloned = pNode.next;
            if (pNode.sibling != null) {
                pCloned.sibling = pNode.sibling.next;
            }
            pNode = pCloned.next;
        }
    }

    public ListNode reconnectNodes(ListNode pHead) {
        ListNode pNode = pHead;
        ListNode pClonedHead = null;
        ListNode pClonedNode = null;
        if (pNode != null) {
            pClonedHead = pClonedNode = pNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        while (pNode != null) {
            pClonedNode.next = pNode.next;
            pClonedNode = pClonedNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        return pClonedHead;
    }
    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4);
        listNode4.next = listNode5;
        ListNode listNode3 = new ListNode(3);
        listNode3.next = listNode4;
        ListNode listNode2 = new ListNode(2);
        listNode2.next = listNode3;
        ListNode listNode1 = new ListNode(1);
        listNode1.next = listNode2;
        listNode5.next = listNode3;
        System.out.println(new PrintListReversingly().entryNodeOfLoop(listNode1));
    }

}

class ListNode {
    int value;
    ListNode next = null;
    ListNode sibling = null;
    ListNode(){}
    ListNode(int val) {
        this.value = val;
    }
    @Override
    public String toString() {
        return "value: " + value;
    }
}

