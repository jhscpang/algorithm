//Given an array of integers that is already sorted in ascending order, find two
// numbers such that they add up to a specific target number. 
//
// The function twoSum should return indices of the two numbers such that they a
//dd up to the target, where index1 must be less than index2. 
//
// Note: 
//
// 
// Your returned answers (both index1 and index2) are not zero-based. 
// You may assume that each input would have exactly one solution and you may no
//t use the same element twice. 
// 
//
// Example: 
//
// 
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2. 
// Related Topics Array Two Pointers Binary Search

package leetcode.editor.en;

//Java：Two Sum II - Input array is sorted

public class P167TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new P167TwoSumIiInputArrayIsSorted().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            // 思路：有序数组使用双指针，代替HashMap
            int[] result = new int[2];
            if (numbers == null || numbers.length == 0) {
                return result;
            }
            int low = 0;
            int high = numbers.length - 1;
            while (low < high) {
                int tmp = numbers[low] + numbers[high];
                if (tmp == target) {
                    result[0] = low + 1;
                    result[1] = high + 1;
                    break;
                } else if (tmp > target) {
                    high--;
                } else {
                    low++;
                }
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}