//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 1147 👎 0


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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode slow = dummyHead;
        ListNode fast = head;
        if(n == 0){
            return head;
        }

        while(fast.next != null){
            if(n > 1){
                n--;
                fast = fast.next;
            }else{
                fast = fast.next;
                slow = slow.next;
            }
        }

        // remove slow from list
        // now, slow stay the the node before target node
        if(slow.next != null){
            slow.next = slow.next.next;
            return dummyHead.next;
        }else{
            return null;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
