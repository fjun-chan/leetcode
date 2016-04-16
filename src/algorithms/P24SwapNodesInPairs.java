package algorithms;

/**
 * 24. Swap Nodes in Pairs
 *  Given a linked list, swap every two adjacent nodes and return its head.
 *
 *  For example,
 *  Given 1->2->3->4, you should return the list as 2->1->4->3.
 *  Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 * Created by fjun on 4/16/16.
 */
public class P24SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        final ListNode result = new ListNode(0);
        ListNode pre = result, first = head, second = first == null ? null : first.next;
        while(first != null && second != null) {
            final ListNode next = second.next;
            first.next = next;
            second.next = first;
            pre.next = second;

            pre = first;
            first = next;
            second = first == null ? null : first.next;
        }
        if (first != null) {
            pre.next = first;
        }
        return result.next;
    }
}
