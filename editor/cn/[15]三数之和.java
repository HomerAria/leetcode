//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3091 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> mResult;

    public List<List<Integer>> threeSum(int[] nums) {
        mResult = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || nums[i] != nums[i - 1]){
                checkTwoSum(nums, i + 1, nums[i]);
            }
        }
        return mResult;
    }

    /*
    calculate two sum with target: -currentElement
    */
    void checkTwoSum(int[] nums, int start, int currentElement){
        int left = start;
        int right = nums.length - 1;

        // two pointer approaching
        int lastLeft = 0;
        while(left < right){
            int sum = nums[left] + nums[right] + currentElement;
            if(sum == 0){
                List<Integer> combination = new ArrayList<Integer>();
                combination.add(currentElement);
                combination.add(nums[left]);
                combination.add(nums[right]);
                mResult.add(combination);

                // result is not identical, so there might be other result
                // repeated element should be remove from here.
                while(left < right){
                    left++;
                    if(nums[left] != nums[left - 1]){
                        break;
                    }
                }
            }else if(sum > 0){
                right--;
            }else{
                left++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
