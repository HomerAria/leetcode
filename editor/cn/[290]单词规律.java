//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 
// 👍 288 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        StringBuilder word = new StringBuilder();
        List<String> wordList = new ArrayList<String>();
        int stringStart = 0;
        s.trim();

        /**
        // get word
        while(stringStart < s.length()){
            if(s.charAt(stringStart) != ' '){
                word.append(s.charAt(stringStart));
            }else if(word.length() > 0){
                // get a full word
                wordList.add(word.toString());
                word.setLength(0);
            }
            stringStart++;
        }
        // get the last word
        if(word.length() > 0){
            wordList.add(word.toString());
        }
        **/

        String[] wordArray = s.split(" ");

        if(wordArray.length != pattern.length()){
            return false;
        }
        // start comparing
        Map<Character, Integer> charTable = new HashMap<Character, Integer>();
        Map<String, Integer> wordTable = new HashMap<String, Integer>();

        for(int i = 0; i < pattern.length(); i++){
            String currentString = wordArray[i];
            char currentChar = pattern.charAt(i);

            if(!charTable.containsKey(currentChar)){
                charTable.put(currentChar, i);
            }
            if(!wordTable.containsKey(currentString)){
                wordTable.put(currentString, i);
            }
            if(!charTable.get(currentChar).equals(wordTable.get(currentString))){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
