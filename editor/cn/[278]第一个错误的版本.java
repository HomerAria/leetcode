//你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有
//版本都是错的。 
//
// 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。 
//
// 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误
//的版本。你应该尽量减少对调用 API 的次数。 
//
// 示例: 
//
// 给定 n = 5，并且 version = 4 是第一个错误的版本。
//
//调用 isBadVersion(3) -> false
//调用 isBadVersion(5) -> true
//调用 isBadVersion(4) -> true
//
//所以，4 是第一个错误的版本。  
// Related Topics 二分查找 
// 👍 261 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    int mTarget;

    public int firstBadVersion(int n) {
        mTarget = 0;

        doBS(1, n);
        return mTarget;
    }

    /*
    Use binary search, set the start condition for each recursive
    */
    void doBS(int lower, int upper){
        // GUI: the first wrong version(target) must in range, if target can be ensure, return.
        // If target is not sure, go to next depth.
        if(lower == upper){
            mTarget = lower;
            return;
        }

        // DI: reset the lower and upper for next depth
        int middle = lower + (upper - lower)/2;   // get integer downwards
        // cut the wrong branch: to ensure target must in [lower, upper]
        if(isBadVersion(middle) == true){
            doBS(lower, middle);
        }else{
            doBS(middle + 1, upper);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
