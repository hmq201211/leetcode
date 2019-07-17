
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    private int count;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            count = 0;
            return null;
        }
        ListNode next = removeNthFromEnd(head.next, n);
        count++;
        if (count == n) {
            return next;
        }
        head.next = next;
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}