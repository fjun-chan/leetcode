package algorithms;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should
 * be made by splicing together the nodes of the first two lists.
 *
 * Subscribe to see which companies asked this question
 *
 * Created by fjun on 4/12/16.
 */
public class P21MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(-1);
        final ListNode head = cur;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return head.next;
    }
}
