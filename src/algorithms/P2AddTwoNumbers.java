package algorithms;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * <p>
 *
 * Created by fjun on 4/7/16.
 */
public class P2AddTwoNumbers {
    public ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2, cur = head;
        int carry = 0;
        while (p != null || q != null) {
            int v1 = p == null ? 0 : p.val;
            int v2 = q == null ? 0 : q.val;
            int sum = v1 + v2 + carry;
            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            cur = cur.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return head.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            ListNode cur = new ListNode(sum % 10);
            carry = sum / 10;
            if (head == null) {
                head = cur;
                tail = head;
            } else {
                tail.next = cur;
                tail = cur;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode exist = l1 != null ? l1 : (l2 != null ? l2 : null);
        while (exist != null) {
            int sum = exist.val + carry;
            ListNode cur = new ListNode(sum % 10);
            carry = sum / 10;
            if (head == null) {
                head = cur;
                tail = head;
            } else {
                tail.next = cur;
                tail = cur;
            }
            exist = exist.next;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
            tail = tail.next;
        }
        tail.next = null;
        return head;
    }
}
