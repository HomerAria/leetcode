//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 913 👎 0


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
    public boolean isPalindrome(ListNode head) {
        // Solution 1:  reserve the origin link and compare two links
        // Space O(n) and time also O(n)
        return compareTwoLinks(head);

        // Solution 2: put link into the ArrayList or other Collection easier to handle
        // Then use two pointers to handle palindrome

        // Solution 3: recursion
        //
    }

    boolean compareTwoLinks(ListNode head){
        // this node belongs to the new link, and will move forward with origin link
        // The new link will always create a new
        ListNode currentNew = null;

        // a node in origin link which keep moving forward
        ListNode currentOld = head;

        while(currentOld != null){
            ListNode tempNew = new ListNode(currentOld.val, currentNew);

            // two current nodes move forward
            currentNew = tempNew;
            currentOld = currentOld.next;
        }

        // Now, currentNew points to the head of the new list
        // and head still points to the head of origin list. Two list has the same length
        while(head != null){
            if(currentNew.val != head.val){
                return false;
            }
            currentNew = currentNew.next;
            head = head.next;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
