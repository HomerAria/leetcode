//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5353 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;    // Head node, which will stay. If use dummy head, return dummy.next
        ListNode tail = null;    // current node, which will move forward

        while(l1 != null || l2 != null) {
            int l1Value = (l1 == null) ? 0 : l1.val;
            int l2Value = (l2 == null) ? 0 : l2.val;

            if(head == null){
                // Initial head and tail node. Head node will stay still and tail node will continuously move to next.
                head = new ListNode((l1Value + l2Value)%10);
                tail = head;
            }else{
                // Implement object tail, then this object tail represent the new ListNode.
                tail.next = new ListNode((l1Value + l2Value + carry)%10);
                tail = tail.next;
            }

            carry = (l1Value + l2Value + carry)/10;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }

        // Make sure no carry left.
        // Furthermore, "carry == 0" can also be put into the while-loop condition
        if(carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
