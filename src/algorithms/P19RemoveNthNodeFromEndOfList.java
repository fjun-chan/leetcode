package algorithms;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Created by fjun on 4/12/16.
 */
public class P19RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode r = head;
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int num = list.size();
        if (n > num) {
            return r;
        }
        if (num - n - 1 < 0) {
            return r.next;
        }
        ListNode toDel = list.get(num - n);
        ListNode pre = list.get(num - n - 1);
        pre.next = toDel.next;
        return r;
    }

    public ListNode removeNthFromEnd3ms(ListNode head, int n) {
        ListNode r = head;
        Stack<ListNode> stack = new Stack<ListNode>();
        int num = 0;
        while (head != null) {
            stack.push(head);
            num ++;
            head = head.next;
        }
        if (n > num) {
            return head;
        }
        ListNode toDel = null;
        for (int i = 0; i < n; i ++) {
            toDel = stack.pop();
        }
        if (toDel != null) {
            ListNode pre = stack.isEmpty() ? null : stack.pop();
            if (pre == null) {
                return r.next;
            }
            pre.next = toDel.next;
        }
        return r;
    }
}
