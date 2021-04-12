//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 348 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        // prepare input data
        boolean result = true;
        char[] sArray = s.toLowerCase().toCharArray();
        int left = 0;
        int right = sArray.length - 1;

        // two pointers approach from two sides.
        while(left <= right){
            boolean leftIsLetter = Character.isLetterOrDigit(sArray[left]);
            boolean rightIsLetter = Character.isLetterOrDigit(sArray[right]);

            if(leftIsLetter && rightIsLetter){
                if(sArray[left] != sArray[right]){
                    return false;
                }else{
                    result = true;
                    left++;
                    right--;
                }
            }else{
                // jump the invalid character
                if(!leftIsLetter){
                    left++;
                }
                if(!rightIsLetter){
                    right--;
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
