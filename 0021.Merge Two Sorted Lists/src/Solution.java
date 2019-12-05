/**
 * @ClassName: Leetcode->Solution
 * @Description: Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: Mingqing Hou
 * @Create: 2019-12-05 10:23
 **/


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode toReturn = dummy;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                dummy.next = l2;
                return toReturn.next;
            } else if (l2 == null) {
                dummy.next = l1;
                return toReturn.next;
            } else {
                if (l1.val < l2.val) {
                    dummy.next = l1;
                    l1 = l1.next;
                } else {
                    dummy.next = l2;
                    l2 = l2.next;
                }
                dummy = dummy.next;
            }
        }
        return toReturn.next;
    }
}
