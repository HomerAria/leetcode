//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 644 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        // two pointers, or use subString() function
        int slow = 0;
        if(needle == null || needle.length() == 0) {
            return slow;
        }

        /**
        // Solution 1: use java function, substring() and equals() for String class
        for(int i = 0 ; i < 1 + haystack.length() - needle.length() ; i++) {
            if(haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
        **/

        // Solution 2: two pointers
        // Slow pointer store the hit place, and fast point go through all needle chars in each haystack loop
        while(slow < 1 + haystack.length() - needle.length()) {
            // go through all chars in needle
            int fast = 0;
            while(fast < needle.length()){
                if(haystack.charAt(slow + fast) != needle.charAt(fast)){
                    break;
                }else if(fast + 1 == needle.length()){
                    // loop to the end char in needle
                    return slow;
                }
                fast++;
            }
            slow++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
