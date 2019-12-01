/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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

    /**
     * @Description: addTwoNumbers_2
     * case 1: there are two digits then do sum over two digits and carry: sum = l1 + l2 + carry;  value = sum % 10;  carry = sum / 10;
     * case 2: there is only one digit then do sum over the digit and carry: sum = l + carry;  value = sum % 10;  carry = sum / 10;
     * case 1: there is only the carry left: sum = carry;  value = sum % 10;  carry = sum / 10;
     * @Params: [l1, l2]
     * @Create: 2019/12/1 15:22
     * @Return: ListNode
     */
    public ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode toReturn = new ListNode(0);
        ListNode current = toReturn;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            int value = sum % 10;
            current.next = new ListNode(value);
            current = current.next;

            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            int value = sum % 10;
            current.next = new ListNode(value);
            current = current.next;

            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            int value = sum % 10;
            current.next = new ListNode(value);
            current = current.next;

            l2 = l2.next;
        }
        if (carry != 0) {
            current.next = new ListNode(1);
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