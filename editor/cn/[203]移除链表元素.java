//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 500 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Style 1: only use current to control the traversal.
//         ListNode dummyHead = new ListNode(0, head);
//         ListNode current = dummyHead;
//
//         while(current.next != null){
//             if(current.next.val == val){
//                 current.next = current.next.next;    // stay & relink
//             }else{
//                 current = current.next;    // move forward
//             }
//         }
//         return dummyHead.next;

        // Style 2: use two nodes: previous and current
        // This style is more friendly, because there will always be two nodes effected in each traversal.
        ListNode dummyHead = new ListNode(0, head);
        style2(dummyHead, val);
        return dummyHead.next;
    }

    void style2(ListNode dummyHead, int val){
        ListNode previous = dummyHead;
        ListNode current = dummyHead.next;

        while(current != null){
            if(current.val == val){
                // remove this node from list.
                // previous node stays and current move forward
                previous.next = current.next;
                current = current.next;
            }else{
                // both previous and current move forward
                previous = previous.next;
                current = current.next;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
