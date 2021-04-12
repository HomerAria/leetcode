//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 611 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int mTarget;

    public int mySqrt(int x) {
        mTarget = 1;
        doBS(1, x + 1, x);
        return mTarget -1;
    }

    /*
    Find the target in range [0, x], (target + 1) is the first number which square value bigger than x
    */
    void doBS(int lower, int upper, int squareVal){
        // GUI
        if(lower == upper){
            mTarget = lower;
            return;
        }

        // DI
        int middle = lower + (upper - lower) / 2;
        if((long)middle * middle > squareVal){
            doBS(lower, middle, squareVal);
        }else{
            doBS(middle + 1, upper, squareVal);
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)
