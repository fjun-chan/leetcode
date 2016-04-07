package algorithms;

/**
 * Created by fjun on 4/6/16.
 */
public class P328OddEvenLinkedList {
    /**
     * 分裂成两个List，最后再合并起来。
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode evenList = head.next;
        ListNode curOdd = head, curEven = head.next;
        while (curEven != null && curEven.next != null) {
            curOdd.next = curEven.next;
            curOdd = curOdd.next;

            curEven.next = curOdd.next;
            curEven = curEven.next;
        }
        curOdd.next = evenList;
        return head;
    }

    public static ListNode oddEvenListV1(ListNode head) {
        int round = 1;
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            if (next == null) {
                break;
            }
            ListNode parent = null;
            ListNode found = next;
            for (int i = 0; i < round; i ++) {
                parent = found;
                found = found.next;
                if (found == null) {
                    break;
                }
            }
            if (found == null) {
                break;
            }
            node.next = found;
            parent.next = found.next;
            found.next = next;
            node = found;
            round ++;
        }
        return head;
    }
}
