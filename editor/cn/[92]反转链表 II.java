//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 597 👎 0


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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // need four critical nodes:
        // nodeA: node[m-2], |m|, nodeB: node[m-1];
        // nodeC: node[n-1], |n|, nodeD: node[n];
        ListNode nodeA = null, nodeB = null, nodeC = null, nodeD = null;
        ListNode currentNode = head;
        ListNode dummy = null;
        int index = 0;

        // corner cases
        if(m == 1){
            nodeA = null;
            nodeB = currentNode;
        }

        while(index < n) {
            if(index <= (m - 2)){
                // store key nodes
                if(index == m - 2){
                    nodeA = currentNode;
                    nodeB = currentNode.next;
                }

                // no linkedList reserve
                currentNode = currentNode.next;
            }else {
                // store key nodes
                if(index == n - 1){
                    nodeC = currentNode;
                    nodeD = currentNode.next;
                }

                // do linkedList reserve
                ListNode temp = currentNode.next;
                currentNode.next = dummy;

                // dummy & currentNode move forward
                dummy = currentNode;
                currentNode = temp;
            }
            index++;
        }

        // reform the linkedList
        if(nodeA != null){
            nodeA.next = nodeC;
            nodeB.next = nodeD;
            return head;
        }else{
            nodeB.next = nodeD;
            return nodeC;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
