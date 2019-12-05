/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 *  
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * @Description: swapPairs
     * dummy is ahead of the the swap elements
     * by manipulating next next.next and next.next.next to do the swapping
     * at least, move the dummy pointer two positions further.
     * @Params: [head]
     * @Create: 2019/12/5 11:12
     * @Return: ListNode
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode toReturn = dummy;
        while (dummy.next != null && dummy.next.next != null) {
            ListNode temp = dummy.next;
            ListNode next = dummy.next.next.next;
            dummy.next = dummy.next.next;
            dummy.next.next = temp;
            temp.next = next;
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
