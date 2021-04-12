//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 315 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        // We can use string2charArray function provided by java, and can also use hashMap
        Map<Character, Integer> pool = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            pool.put(c, pool.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            int times = pool.getOrDefault(c, -1);
            times--;

            if(times < 0){
                return false;
            }else if(times == 0){
                pool.remove(c);
            }else{
                pool.put(c, times);
            }
        }
        if(pool.isEmpty()){
            return true;
        }else{
            // s contains redundant character comparing with t.
            return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
