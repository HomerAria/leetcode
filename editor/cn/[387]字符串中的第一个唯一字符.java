//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 297 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        // true-->unique, false-->duplicated
        Map<Character, Boolean> pool = new HashMap<Character, Boolean>();
        for(int i = 0; i < s.length(); i++){
            if(pool.containsKey(s.charAt(i))){
                pool.put(s.charAt(i), false);
            }else{
                pool.put(s.charAt(i), true);
            }
        }
        for(int i = 0; i < s.length(); i++){
            if(pool.get(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
