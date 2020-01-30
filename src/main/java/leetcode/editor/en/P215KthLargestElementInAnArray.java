//Find the kth largest element in an unsorted array. Note that it is the kth lar
//gest element in the sorted order, not the kth distinct element. 
//
// Example 1: 
//
// 
//Input: [3,2,1,5,6,4] and k = 2
//Output: 5
// 
//
// Example 2: 
//
// 
//Input: [3,2,3,1,2,4,5,5,6] and k = 4
//Output: 4 
//
// Note: 
//You may assume k is always valid, 1 ≤ k ≤ array's length. 
// Related Topics Divide and Conquer Heap

package leetcode.editor.en;

//Java：Kth Largest Element in an Array

import java.util.PriorityQueue;

public class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            /**
             * 思路：k大小的问题可以使用红黑树或者堆
             * java中红黑树的实现有TreeSet，堆的实现有PriorityQueue
             * 本题不能使用TreeSet，因为TreeSet会去重
             */
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int i = 0; i < nums.length; i++) {
                // 维护一个大小为k小顶堆，比顶小的元素直接跳过，比顶大的元素留下
                heap.offer(nums[i]);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
            return heap.peek();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}