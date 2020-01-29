//Given an array nums of n integers where n > 1, return an array output such tha
//t output[i] is equal to the product of all the elements of nums except nums[i]. 
//
//
// Example: 
//
// 
//Input:  [1,2,3,4]
//Output: [24,12,8,6]
// 
//
// Note: Please solve it without division and in O(n). 
//
// Follow up: 
//Could you solve it with constant space complexity? (The output array does not 
//count as extra space for the purpose of space complexity analysis.) 
// Related Topics Array

package leetcode.editor.en;

//Java：Product of Array Except Self

public class P238ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new P238ProductOfArrayExceptSelf().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            /**
             * 思路：两次遍历，第一次遍历将对应的位置设置成该位置左边元素的乘积
             * 第二次遍历将对应的位置存储的左边元素的乘机再乘右边元素的乘积，得到最终结果
             */
            int[] result = new int[nums.length];
            int k = 1;
            // 第一次遍历，设置左边元素的乘积
            for (int i = 0; i < nums.length; i++) {
                result[i] = k;
                k *= nums[i]; // k保留该位置与之前元素的乘积，在下个元素时使用
            }
            // 第二次遍历，设置右边元素的乘积
            k = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                result[i] *= k; // 此时数组等于左边的 * 该数右边的。
                k *= nums[i]; // k保留该位置与之后元素的乘积
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}