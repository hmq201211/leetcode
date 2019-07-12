class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode toReturn = null;
        ListNode current = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            carry += (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            ListNode listNode = new ListNode(carry % 10);
            carry /= 10;
            if (toReturn == null) {
                toReturn = listNode;
                current = toReturn;
            } else {
                current.next = listNode;
                current = current.next;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return toReturn;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}