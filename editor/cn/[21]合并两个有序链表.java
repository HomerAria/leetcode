//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1602 👎 0


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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Solution 1: traversal
        // Both dummyHead & current are necessary, because current will move to tail,
        // and a head should stay to tell where is head.
//         ListNode dummyHead = new ListNode(0);
//         ListNode current = dummyHead;
//
//         while(l1 != null && l2 != null){
//             if(l1.val < l2.val){
//                 // current node link to l1 node
//                 current.next = l1;
//                 l1 = l1.next;    // move forward
//             }else{
//                 current.next = l2;
//                 l2 = l2.next;
//             }
//             current = current.next;
//         }
//
//         // add the unused tail
//         if(l1 != null){
//             current.next = l1;
//         }
//         if(l2 != null){
//             current.next = l2;
//         }
//
//         return dummyHead.next;

        // Solution 2: recursion
        mResult = new ListNode(0);
        relinkTo(mResult, l1, l2);
        return mResult.next;
    }

    ListNode mResult;

    void relinkTo(ListNode current, ListNode l1, ListNode l2){
        // GUI
        if(l1 == null){
            current.next = l2;
            return;
        }
        if(l2 == null){
            current.next = l1;
            return;
        }

        // DI
        if(l1.val < l2.val){
            current.next = l1;
            l1 = l1.next;
        }else{
            current.next = l2;
            l2 = l2.next;
        }
        relinkTo(current.next, l1, l2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
