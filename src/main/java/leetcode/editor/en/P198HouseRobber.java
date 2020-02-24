//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed, the only constraint stopping you from r
//obbing each of them is that adjacent houses have security system connected and i
//t will automatically contact the police if two adjacent houses were broken into 
//on the same night. 
//
// Given a list of non-negative integers representing the amount of money of eac
//h house, determine the maximum amount of money you can rob tonight without alert
//ing the police. 
//
// Example 1: 
//
// 
//Input: [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//             Total amount you can rob = 1 + 3 = 4. 
//
// Example 2: 
//
// 
//Input: [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 
//(money = 1).
//             Total amount you can rob = 2 + 9 + 1 = 12.
// 
// Related Topics Dynamic Programming

package leetcode.editor.en;

//Java：House Robber

public class P198HouseRobber {
    public static void main(String[] args) {
        Solution solution = new P198HouseRobber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            /**
             * 思路：一个变量记录之前的最大值，一个记录当前最大值
             */
            int prevMax = 0;
            int currMax = 0;
            for (int x : nums) {
                int temp = currMax;
                currMax = Math.max(prevMax + x, currMax);
                prevMax = temp;
            }
            return currMax;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}