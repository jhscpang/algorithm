//Given an array of size n, find the majority element. The majority element is t
//he element that appears more than ⌊ n/2 ⌋ times. 
//
// You may assume that the array is non-empty and the majority element always ex
//ist in the array. 
//
// Example 1: 
//
// 
//Input: [3,2,3]
//Output: 3 
//
// Example 2: 
//
// 
//Input: [2,2,1,1,1,2,2]
//Output: 2
// 
// Related Topics Array Divide and Conquer Bit Manipulation

package leetcode.editor.en;

//Java：Majority Element

public class P169MajorityElement {
    public static void main(String[] args) {
        Solution solution = new P169MajorityElement().new Solution();
        // TO TEST
        int[] nums = new int[] {3, 2, 3};
        System.out.println(solution.majorityElement(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            /**
             * 可以使用如下几种方式：
             * 1. 将数组进行排序，由于众数占大多数，因此取最中间那个数肯定是众数
             * 2. 使用HashMap存储进行统计，最后选择值最大的那个key
             * 3. 摩尔投票法。原理是众数和非众数同时做等量加减，最后剩下的肯定是众数
             */
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int length = nums.length;
            int major = 0;
            int count = 0;
            for (int i = 0; i < length; i++) {
                if (count == 0) {
                    major = nums[i];
                }
                count = major == nums[i] ? ++count : --count;
            }
            return major;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}