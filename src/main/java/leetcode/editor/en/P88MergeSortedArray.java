 //Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one
// sorted array. 
//
// Note: 
//
// 
// The number of elements initialized in nums1 and nums2 are m and n respectivel
//y. 
// You may assume that nums1 has enough space (size that is greater or equal to 
//m + n) to hold additional elements from nums2. 
// 
//
// Example: 
//
// 
//Input:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//Output: [1,2,2,3,5,6]
// Related Topics Array Two Pointers


package leetcode.editor.en;

//Java：Merge Sorted Array

public class P88MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new P88MergeSortedArray().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1;
        int tail2 = n - 1;
        int index = m + n - 1;
        // 从后往前比较，避免过多移动元素
        while (tail1 >= 0 && tail2 >= 0) {
            if (nums1[tail1] > nums2[tail2]) {
                nums1[index--] = nums1[tail1];
                tail1--;
            } else {
                nums1[index--] = nums2[tail2];
                tail2--;
            }
        }
        // 处理剩余的num2
        while (tail2 >= 0) {
            nums1[index--] = nums2[tail2--];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}