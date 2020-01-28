//Given a non-empty array of integers, return the third maximum number in this a
//rray. If it does not exist, return the maximum number. The time complexity must 
//be in O(n). 
//
// Example 1: 
// 
//Input: [3, 2, 1]
//
//Output: 1
//
//Explanation: The third maximum is 1.
// 
// 
//
// Example 2: 
// 
//Input: [1, 2]
//
//Output: 2
//
//Explanation: The third maximum does not exist, so the maximum (2) is returned 
//instead.
// 
// 
//
// Example 3: 
// 
//Input: [2, 2, 3, 1]
//
//Output: 1
//
//Explanation: Note that the third maximum here means the third maximum distinct
// number.
//Both numbers with value 2 are both considered as second maximum.
// 
// Related Topics Array

package leetcode.editor.en;

//Java：Third Maximum Number

import java.util.TreeSet;

public class P414ThirdMaximumNumber {
    public static void main(String[] args) {
        Solution solution = new P414ThirdMaximumNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int thirdMax(int[] nums) {
            /**
             * 维护一个大小为3的红黑树，TreeSet是红黑树的一个实现，可以直接使用
             * 其中，first()是最小元素，last()是最大元素
             */
            TreeSet<Integer> set = new TreeSet<>();
            for (Integer elem : nums) {
                set.add(elem);
                if (set.size() > 3) {
                    set.remove(set.first());
                }
            }
            return set.size() < 3 ? set.last() : set.first();   // set.last() 里面最大的元素
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}