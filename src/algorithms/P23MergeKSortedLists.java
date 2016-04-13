package algorithms;

import java.util.*;

/**
 * Created by fjun on 4/13/16.
 */
public class P23MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        LinkedList<Pair> pairs = new LinkedList<Pair>();
        for (int i = 0; i < lists.length; i ++) {
            ListNode node = lists[i];
            if (node == null) continue;
            pairs.add(new Pair(node.val, i));
        }
        if (pairs.size() == 1) {
            return lists[pairs.get(0).index];
        }
        Collections.sort(pairs, Pair.COMP);
        final ListNode head = new ListNode(0);
        ListNode cur = head;
        Iterator<Pair> iter = pairs.iterator();
        while (iter.hasNext()) {
            Pair pair = iter.next();
            ListNode node = lists[pair.index];
            cur.next = node;
            cur = cur.next;
            if (node.next == null) {
                iter.remove();
            } else {
                pair.min = node.next.val;
            }
            lists[pair.index] = node.next;
            Collections.sort(pairs, Pair.COMP);
        }
        return head.next;
    }

    private static final class Pair {
        int min;
        final int index;
        public Pair(int min, int index) {
            this.min = min;
            this.index = index;
        }

        public static Comparator<Pair> COMP = new Comparator<Pair>() {
                    @Override
                    public int compare(Pair o1, Pair o2) {
                        return Integer.compare(o1.min, o2.min);
                    }
                };

    }
}
