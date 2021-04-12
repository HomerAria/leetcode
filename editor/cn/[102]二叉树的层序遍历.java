//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 721 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        /**
        // Solution 1: DFS with recursion
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        DFS(result, root, 0);
        return result;
        **/

        // Solution 2: BFS with iteration
        return BFS(root);
    }

    public List<List<Integer>> BFS(TreeNode root){
        // store all node in one level with FIFO
        Queue<TreeNode> levelQueue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }

        levelQueue.offer(root);
        while(!levelQueue.isEmpty()){
            int currentLevelSize = levelQueue.size();
            List<Integer> levelList = new ArrayList<Integer>();   // store all value at this level

            // get all the val of node in levelQueue and put it into levelList.
            // Then put all the next-level node into levelQueue orderly.
            // "Orderly" is maintained by the data structure "Queue".
            for(int i = 0; i < currentLevelSize; i++){
                TreeNode currentNode = levelQueue.poll();
                levelList.add(currentNode.val);
                if(currentNode.left != null){
                    levelQueue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    levelQueue.offer(currentNode.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }

    // use pre-order
    public void DFS(List<List<Integer>> list, TreeNode current, int level){
        if(current == null){
            return;
        }
        int currentLevel = list.size();
        if(level == currentLevel){
            // first time comes to this level, so you need insert a new list
            List<Integer> levelList = new ArrayList<Integer>();
            levelList.add(current.val);
            list.add(levelList);
        }else{
            // not the first time at this level
            List<Integer> levelList = list.get(level);
            levelList.add(current.val);
        }
        DFS(list, current.left, level + 1);
        DFS(list, current.right, level + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
