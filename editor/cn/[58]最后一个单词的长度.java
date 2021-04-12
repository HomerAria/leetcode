//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串 
// 👍 262 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        // corner case
        if(s == null || s.length() < 1){
            return 0;
        }

        /**
        // Solution 1: two pointers
        // This is a more general solution, which not only could return the length
        // but also return the last world.
        int slow = -1;   // stay at the start of last word. You cannot sure the first character before starting loop
        int fast = 0;
        int count = 0;

        while(fast < s.length()) {
            if(slow < 0) {
                if(s.charAt(fast) != ' '){
                    // Which means no character occurs yet. Here is to initialize the slow point
                    slow = fast;
                    count = 1;
                }
            }else{
                if(s.charAt(fast) == ' ' && fast < s.length() - 1 && s.charAt(fast + 1) != ' '){
                    // Move slow pointer just before the beginning of a word
                    slow = fast + 1;
                }
                if(s.charAt(fast) != ' ' && s.charAt(slow) != ' '){
                    // current loop is still in somewhere of a word.
                    count = fast - slow + 1;
                }
            }
            fast++;
        }
        return count;
        **/

        // Solution 2: more efficient one.
        int lastLength = 0;
        for(int i = s.length() -1; i >= 0; i--){
            if(s.charAt(i) != ' '){
                lastLength++;
            }
            if(lastLength > 0 && s.charAt(i) == ' '){
                break;
            }
        }
        return lastLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
