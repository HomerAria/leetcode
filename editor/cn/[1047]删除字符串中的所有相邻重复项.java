//给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。 
//
// 在 S 上反复执行重复项删除操作，直到无法继续删除。 
//
// 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。 
//
// 
//
// 示例： 
//
// 输入："abbaca"
//输出："ca"
//解释：
//例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又
//只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 20000 
// S 仅由小写英文字母组成。 
// 
// Related Topics 栈 
// 👍 242 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicates(String S) {
        Deque<Character> stack = new LinkedList<Character>();
        char[] sArray = S.toCharArray();

        for(int i=0; i<sArray.length; i++){
            if(!stack.isEmpty()){
                char topC = stack.peek();

                if(topC == sArray[i]){
                    // repeated character
                    stack.pop();
                }else{
                    stack.push(sArray[i]);
                }
            }else{
                stack.push(sArray[i]);
            }
        }

        // pop element and generate the result string
        // Mind the pop sequence of a stack
        char[] resultArray = new char[stack.size()];
        for(int i = stack.size() - 1; i >= 0; i--){
            resultArray[i] = stack.pop();
        }
        return String.valueOf(resultArray);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
