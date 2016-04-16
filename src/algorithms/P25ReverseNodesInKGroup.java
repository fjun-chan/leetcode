package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Created by fjun on 4/16/16.
 */
public class P25ReverseNodesInKGroup {

    public ListNode reverseKGroup1ms(ListNode head, int k) {
        final ListNode result = new ListNode(0);
        result.next = head;
        ListNode last = result;
        int cnt = 0;
        ListNode pointer = head;
        ListNode search = head;
        while (search != null) {
            cnt ++;
            ListNode nextSearch = search.next;
            if (cnt % k == 0) {
                ListNode cur = pointer;
                ListNode pre = null;
                for (int i = 0; i < k; i ++) {
                    ListNode next = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                }
                last.next = search;
                last = pointer;
                pointer.next = nextSearch;
                pointer = nextSearch;
            }
            search = nextSearch;
        }
        return result.next;
    }

    public ListNode reverseKGroup14ms(ListNode head, int k) {
        final ListNode result = new ListNode(0);
        List<ListNode> stack = new ArrayList<ListNode>(k);
        ListNode cur = result;
        int index = 0;
        while (head != null) {
            stack.add(index ++, head);
            head = head.next;
            if (index == k) {
                for (int i = 1; i <= k; i ++) {
                    cur.next = stack.get(k - i);
                    cur = cur.next;
                }
                index = 0;
            }
        }
        if (index != 0) {
            boolean reverse = index == k;
            for (int i = 1; i <= index; i ++) {
                cur.next = reverse ? stack.get(k - i) : stack.get(i - 1);
                cur = cur.next;
            }
        }
        cur.next = null;
        return result.next;
    }
}
