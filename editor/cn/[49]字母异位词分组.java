//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 609 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringPool = new HashMap<String, List<String>>();

        for(String str : strs){
            // sort char in str
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String strSorted = new String(strArray);

            // put str into right place of stringPool
            List<String> list = stringPool.getOrDefault(strSorted, new ArrayList<String>());
            list.add(str);
            stringPool.put(strSorted, list);
        }
        return new ArrayList<List<String>>(stringPool.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
