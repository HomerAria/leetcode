//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1388 👎 0


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
    public ListNode reverseList(ListNode head) {
        // Style 1
//         if(head == null) {
//             return head;
//         }
//
//         // for non-null condition
//         ListNode currentNode = null;
//         while(true) {
//             ListNode tempNext = head.next;    // Place the head in next loop
//             head.next = currentNode;
//             currentNode = head;
//             head = tempNext;
//
//             // end condition
//             if(head == null) {
//                 break;
//             }
//         }
//         return currentNode;

        // Style 2: with two pointers(nodes)
//         return style2(head);

        // Style 3: with teo pointers, use recursion instead of traversal
        // set null as the initial state of previous (the dummy head)
        reverseTwo(null, head);
        return mResult;
    }

    ListNode style2(ListNode head){
        // the initial state of two pointers: current node and previous node
        // The first previous node is a dummyHead, which is null.
        ListNode previous = null;
        ListNode current = head;

        while(current != null){
            // reverse the link
            ListNode temp = current.next;
            current.next = previous;

            // two pointers move forward
            previous = current;
            current = temp;
        }
        return previous;
    }

    ListNode mResult;
    void reverseTwo(ListNode previous, ListNode current){
        // GUI: arrive to the tail and return
        if(current == null){
            mResult = previous;
            return;
        }

        // DI: relink & move two pointer forward
        ListNode temp = current.next;
        current.next = previous;

        previous = current;
        current = temp;
        reverseTwo(previous, current);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
