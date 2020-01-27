//Given a sorted array and a target value, return the index if the target is fou
//nd. If not, return the index where it would be if it were inserted in order. 
//
// You may assume no duplicates in the array. 
//
// Example 1: 
//
// 
//Input: [1,3,5,6], 5
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: [1,3,5,6], 2
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: [1,3,5,6], 7
//Output: 4
// 
//
// Example 4: 
//
// 
//Input: [1,3,5,6], 0
//Output: 0
// 
// Related Topics Array Binary Search


package leetcode.editor.en;

//Java：Search Insert Position

public class P35SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new P35SearchInsertPosition().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int low = 0;
        int high = nums.length - 1;
        // 使用二分查找
        while (low <= high) { // 注意这里必须是<=
            int middle = (high - low) / 2 + low;
            if (target == nums[middle]) {
                return middle;
            } else if (target > nums[middle]) {
                low = middle + 1;
            } else if (target < nums[middle]) {
                high = middle - 1;
            }
        }
        return low;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}