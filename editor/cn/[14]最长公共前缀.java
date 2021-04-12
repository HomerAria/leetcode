//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1386 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // notice the difference between prefix & substring
        if(strs == null || strs.length == 0){
            return "";
        }

        // Solution 1: use indexOf() function
        String target = strs[0];

        for(int i = 1; i < strs.length; i++) {
            // indexof() return 0 is the right answer, number>0 is not prefix.
            while(strs[i].indexOf(target) != 0){
                // substring the string from the tail
                target = target.substring(0, target.length()-1);
                if(target.length() == 0){
                    return target;
                }
            }
        }
        return target;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
