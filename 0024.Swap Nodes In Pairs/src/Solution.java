public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode toReturn = dummy;
        while (dummy.next != null && dummy.next.next != null) {
            ListNode temp = dummy.next;
            ListNode next = dummy.next.next.next;
            dummy.next = dummy.next.next;
            temp.next = next;
            dummy.next.next = temp;
            dummy = dummy.next.next;
        }
        return toReturn.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
