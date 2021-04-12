//实现一个基本的计算器来计算一个简单的字符串表达式的值。 
//
// 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
//
// 示例 1: 
//
// 输入: "3+2*2"
//输出: 7
// 
//
// 示例 2: 
//
// 输入: " 3/2 "
//输出: 1 
//
// 示例 3: 
//
// 输入: " 3+5 / 2 "
//输出: 5
// 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 栈 字符串 
// 👍 224 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        s = s.trim();
        return doCalculate(s.toCharArray());
    }

    private int doCalculate(char[] charList){
        int temp = 0;
        // This '+' operation can be regard as the default operation before the first number
        char operation = '+';   // operation need to be stored here, because operation will be used after the number next to it shows.
        Deque<Integer> sumElements = new LinkedList<Integer>();

        for(int i = 0; i < charList.length; i++){
            // trim
            if(charList[i] == ' ') continue;

            // from the number, might contain several digit
            if(Character.isDigit(charList[i])){
                temp = temp * 10 + Integer.parseInt(String.valueOf(charList[i]));
            }

            // condition1: prevent goes into during a number;
            // condition2: at the bottom of string
            if(!Character.isDigit(charList[i]) || i == charList.length -1){
                if(operation == '+'){
                    sumElements.push(temp);
                }else if(operation == '-'){
                    sumElements.push(-temp);
                }else if(operation == '*'){
                    temp = temp * sumElements.pop();
                    sumElements.push(temp);
                }else if(operation == '/'){
                    // order matters
                    temp = sumElements.pop() / temp;
                    sumElements.push(temp);
                }

                operation = charList[i];
                temp = 0;
            }
        }

        // stack stores all elements should be summed up.
        int result = 0;
        while(!sumElements.isEmpty()){
            result = result + sumElements.pop();
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
