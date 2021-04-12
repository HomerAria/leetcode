//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2256 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        // Use stack as a pool of each character in string.
        // If push a right char, the last char will be remove, and
        // id push a wrong char, add it into stack. At last, empty stack is valid.
        Deque<Character> stack = new LinkedList<Character>();
        char[] sArray = s.toCharArray();

        for(int i = 0; i<sArray.length; i++){
            if(!stack.isEmpty()){
                char topC = stack.peek();   // get the element at the top of stack
                // if paired, pop the top element.
                // and if not paired, push current element into stack
                if(isPaired(topC, sArray[i])){
                    stack.pop();
                }else{
                    stack.push(sArray[i]);
                }
            }else{
                stack.push(sArray[i]);
            }
        }

        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    boolean isPaired(char topChar, char currentChar){
        if(topChar == '(' && currentChar == ')') return true;
        if(topChar == '{' && currentChar == '}') return true;
        if(topChar == '[' && currentChar == ']') return true;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
