package algorithms;

/**
 * Reverse a singly linked list.
 *
 * Created by fjun on 4/5/16.
 */
public class P206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

