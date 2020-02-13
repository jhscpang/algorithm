//Given an array of non-negative integers, you are initially positioned at the f
//irst index of the array. 
//
// Each element in the array represents your maximum jump length at that positio
//n. 
//
// Determine if you are able to reach the last index. 
//
// Example 1: 
//
// 
//Input: [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum
//             jump length is 0, which makes it impossible to reach the last ind
//ex.
// 
// Related Topics Array Greedy

package leetcode.editor.en;

//Java：Jump Game

public class P55JumpGame {
    public static void main(String[] args) {
        Solution solution = new P55JumpGame().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路：1.最先直观想到的方法是基于递归，站在一个点上，对每一个可能跳跃的点都使用递归，但是运行超限了，需要减少重复
         */
        //        public boolean canJump(int[] nums) {
        //            if (nums == null || nums.length == 0) {
        //                return false;
        //            }
        //            return canJumpFromPosition(0, nums);
        //        }
        //
        //        private boolean canJumpFromPosition(int pos, int[] nums) {
        //            if (pos == nums.length - 1) {
        //                return true;
        //            }
        //            // 这里做边界检查，跳跃的最远距离不能超过数组长度
        //            int maxNextPos = Math.min(pos + nums[pos], nums.length - 1);
        //            // 优先尝试大步跳，因为越大步越可能先到终点
        //            for (int nextPos = maxNextPos; nextPos > pos; nextPos--) {
        //                // 递归
        //                if (canJumpFromPosition(nextPos, nums)) {
        //                    return true;
        //                }
        //            }
        //            return false;
        //        }

        /**
         * 思路：2. 对思路1 进行优化，对跑过的位置进行标记，如果能达到钟点记为1.达不到记为-1
         * 可以AC
         */
        //        int[] flag;
        //        public boolean canJump(int[] nums) {
        //            if (nums == null || nums.length == 0) {
        //                return false;
        //            }
        //            flag = new int[nums.length];
        //            flag[nums.length - 1] = 1; // 最后一个点肯定能到终点，记为1
        //            return canJumpFromPosition(0, nums);
        //        }
        //
        //        private boolean canJumpFromPosition(int pos, int[] nums) {
        //            if (flag[pos] != 0) {
        //                return flag[pos] == 1;
        //            }
        //            // 这里做边界检查，跳跃的最远距离不能超过数组长度
        //            int maxNextPos = Math.min(pos + nums[pos], nums.length - 1);
        //            // 优先尝试大步跳，因为越大步越可能先到终点
        //            for (int nextPos = maxNextPos; nextPos > pos; nextPos--) {
        //                // 递归
        //                if (canJumpFromPosition(nextPos, nums)) {
        //                    flag[pos] = 1;
        //                    return true;
        //                }
        //            }
        //            flag[pos] = -1;
        //            return false;
        //        }

        /**
         * 思路：3. 由于思路2是自上而下的，因此需要递归，反过来想，如果我们从自下而上开始，就可以免去递归
         * 具体见：https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode/
         */
//        public boolean canJump(int[] nums) {
//            if (nums == null || nums.length == 0) {
//                return false;
//            }
//            int[] flag = new int[nums.length];
//            flag[nums.length - 1] = 1; // 最后一个点肯定能到终点，记为1
//
//            for (int i = nums.length - 2; i >= 0; i--) { // 从右往左试
//                int furthestJump = Math.min(i + nums[i], nums.length - 1);
//                for (int j = i + 1; j <= furthestJump; j++) {
//                    if (flag[j] == 1) {
//                        flag[i] = 1;
//                        break;
//                    }
//                }
//            }
//            return flag[0] == 1;
//        }

        /**
         * 思路：4.基于思路3，不再记录所有可达位置，而是只记录最左边可达的位置，
         * 然后看每个节点是否存在一步跳跃可以到最左可达位置
         */
        public boolean canJump(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int lastPos = nums.length - 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (i + nums[i] >= lastPos) { // 如果i位置可达，则更新最左可达位置
                    lastPos = i;
                }
            }
            return lastPos == 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}