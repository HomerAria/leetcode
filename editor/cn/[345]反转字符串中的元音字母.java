//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 135 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        char[] sArray = s.toCharArray();
        int left = 0;
        int right = sArray.length - 1;

        while(left < right){
            if(isVowel(sArray[left]) && isVowel(sArray[right])){
                // do swap and two pointers keep approaching
                swap(sArray, left, right);
                left++;
                right--;
            }else{
                // do approaching
                if(!isVowel(sArray[left])){
                    left++;
                }
                if(!isVowel(sArray[right])){
                    right--;
                }
            }
        }
        return new String(sArray);
    }

    /*
    swap the value in element p and element q
    */
    void swap(char[] sArray, int p, int q){
        char temp = sArray[p];
        sArray[p] = sArray[q];
        sArray[q] = temp;
    }

    boolean isVowel(char c){
        if(c == 'a' | c == 'e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' | c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            return true;
        }else{
            return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
