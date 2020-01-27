//Given an integer array nums, find the contiguous subarray (containing at least
// one number) which has the largest sum and return its sum. 
//
// Example: 
//
// 
//Input: [-2,1,-3,4,-1,2,1,-5,4],
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Follow up: 
//
// If you have figured out the O(n) solution, try coding another solution using 
//the divide and conquer approach, which is more subtle. 
// Related Topics Array Divide and Conquer Dynamic Programming


package leetcode.editor.en;

//Java：Maximum Subarray

public class P53MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new P53MaximumSubarray().new Solution();
        // TO TEST
        int[] nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int tempMaxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 如果之前的数组和与当前元素相加小于该元素本身，说明之前的产生的数组和产生了负效果，应该放弃
            tempMaxSum = Math.max(tempMaxSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, tempMaxSum);
        }
        return maxSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}