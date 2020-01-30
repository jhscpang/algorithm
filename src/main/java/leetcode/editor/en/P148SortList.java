//Sort a linked list in O(n log n) time using constant space complexity. 
//
// Example 1: 
//
// 
//Input: 4->2->1->3
//Output: 1->2->3->4
// 
//
// Example 2: 
//
// 
//Input: -1->5->3->4->0
//Output: -1->0->3->4->5 
// Related Topics Linked List Sort

package leetcode.editor.en;

//Java：Sort List

public class P148SortList {
    public static void main(String[] args) {
        Solution solution = new P148SortList().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode sortList(ListNode head) {
            /**
             * 思路：时间复杂度O(nlogn)联想到二分法，由二分法联想到归并排序
             * 归并排序有两步：
             * 1. cut: 偶数个节点时平分，奇数个节点时左边比右边多一个
             * 2. merge：将两个排序链表合并，转化为一个排序链表。
             *
             * 使用递归比较好理解，但是会占用空间，这里就先写基于递归的
             */
            if (head == null || head.next == null) {
                return head;
            }
            // 1. cut阶段，定义快慢指针找出需要切断的地方进行切断
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next; // 慢指针走一步
                fast = fast.next.next; // 快指针走两步
            }
            ListNode tmp = slow.next; // 从slow处断开，tmp用来保存后半部份的head
            slow.next = null; // 断开前后部分
            // 对两部分进行递归
            ListNode left = sortList(head);
            ListNode right = sortList(tmp);
            // 2. merge
            ListNode dummyHead = new ListNode(0);
            tmp = dummyHead;
            while (left != null && right != null) { // 左右两部分进行合并
                if (left.val < right.val) {
                    tmp.next = left;
                    left = left.next;
                } else {
                    tmp.next = right;
                    right = right.next;
                }
                tmp = tmp.next;
            }
            tmp.next = left == null ? right : left; // 把多余的部分链到后面
            return dummyHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}