//Given a collection of intervals, merge all overlapping intervals. 
//
// Example 1: 
//
// 
//Input: [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping. 
//
// NOTE: input types have been changed on April 15, 2019. Please reset to defaul
//t code definition to get new method signature. 
// Related Topics Array Sort

package leetcode.editor.en;

//Java：Merge Intervals

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class P56MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new P56MergeIntervals().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路：按每个区间的左边界进行从小到大排序，从第二个区间开始，分别和前一个区间比较
         * 如果该区间的左边界小于等于前一个区间的右边界，则说明相交，然后新的区间左边界使用前一个区间的左，右边界使用较大的
         * 如果该区间的左边界大于前一个区间的右边界，则说明不相交
         */
        private class IntervalComparator implements Comparator<int[]> {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1; // 从小到大排序
            }
        }

        public int[][] merge(int[][] intervals) {
            LinkedList<int[]> mergeList = new LinkedList<>();
            if (intervals.length == 0) {
                return mergeList.toArray(new int[0][]);
            }
            // 用左边界进行从小到大排序
            Collections.sort(Arrays.asList(intervals), new IntervalComparator());
            // 执行合并
            mergeList.add(intervals[0]);
            for (int i = 1; i < intervals.length; i++) {
                int[] current = mergeList.getLast();
                if (intervals[i][0] > current[1]) { // 如果新区间左边界大于当前区间右边界，说明一定不相交
                    mergeList.add(intervals[i]);
                } else { // 否则，使用右边界作为当前区间的右边界
                    current[1] = Math.max(current[1], intervals[i][1]);
                }
            }
            return mergeList.toArray(new int[mergeList.size()][]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}