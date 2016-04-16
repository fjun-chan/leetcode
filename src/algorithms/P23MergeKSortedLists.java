package algorithms;

import java.util.*;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Created by fjun on 4/13/16.
 */
public class P23MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        LinkedList<Pair> heap = new LinkedList<Pair>();
        for (int i = 0; i < lists.length; i ++) {
            ListNode node = lists[i];
            if (node == null) continue;
            heap.add(new Pair(node.val, i));
        }
        if (heap.size() == 1) {
            return lists[heap.get(0).index];
        }
        Collections.sort(heap, Pair.COMP);
        final ListNode head = new ListNode(0);
        ListNode cur = head;
        while(!heap.isEmpty()) {
            final Pair pair = heap.removeFirst();
            final ListNode node = lists[pair.index];
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                pair.min = node.next.val;
                lists[pair.index] = node.next;
                insertSortedHeap(heap, pair);
            }
        }
        return head.next;
    }

    private static void insertSortedHeap(LinkedList<Pair> heap, Pair pair) {
        int index = 0;
        final int len = heap.size();
        while (index < len) {
            if (heap.get(index).min > pair.min) {
                break;
            }
            index ++;
        }
        heap.add(index, pair);
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
