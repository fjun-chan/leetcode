package algorithms;

/**
 * 237. Delete Node in a Linked List
 *
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 *  Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
 *  the linked list should become 1 -> 2 -> 4 after calling your function.
 *
 * Created by fjun on 4/4/16.
 */
public class P237DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        if (next == null) {
            return;
        }
        node.val = next.val;
        node.next = next.next;
    }
}
