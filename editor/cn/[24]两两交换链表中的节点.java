//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 链表 
// 👍 758 👎 0


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
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode currentNode = dummyNode;
        while(currentNode.next != null && currentNode.next.next != null) {
            doSwap(currentNode);
            currentNode = currentNode.next.next;     // CurrentNode moves forward by two steps.
        }
        return dummyNode.next;
    }

    /**
     * Swap procedure in the center, regardless the corner cases & ending condition
     */
    public void doSwap(ListNode currentNode) {
        ListNode temp = currentNode.next;     // needed, or you will lose currentNode.next

        currentNode.next = temp.next;
        temp.next = currentNode.next.next;
        currentNode.next.next = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
