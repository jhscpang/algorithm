//Given a linked list, rotate the list to the right by k places, where k is non-
//negative. 
//
// Example 1: 
//
// 
//Input: 1->2->3->4->5->NULL, k = 2
//Output: 4->5->1->2->3->NULL
//Explanation:
//rotate 1 steps to the right: 5->1->2->3->4->NULL
//rotate 2 steps to the right: 4->5->1->2->3->NULL
// 
//
// Example 2: 
//
// 
//Input: 0->1->2->NULL, k = 4
//Output: 2->0->1->NULL
//Explanation:
//rotate 1 steps to the right: 2->0->1->NULL
//rotate 2 steps to the right: 1->2->0->NULL
//rotate 3 steps to the right: 0->1->2->NULL
//rotate 4 steps to the right: 2->0->1->NULL 
// Related Topics Linked List Two Pointers

package leetcode.editor.en;

//Java：Rotate List

public class P61RotateList {
    public static void main(String[] args) {
        Solution solution = new P61RotateList().new Solution();
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
        public ListNode rotateRight(ListNode head, int k) {
            /**
             * 思路：旋转链表不像旋转数组那样涉及到元素的移动，链表旋转更多的是指针操作
             * 步骤如下：
             * 先确定链表长度，并且将链表链接成环
             * 然后对k取模，找到环状链表该断开的位置进行断开
             */
            if (head == null || head.next == null) {
                return head;
            }
            // 确定链表长度，并且将链表链接成环
            int len = 1;
            ListNode tmp = head;
            while (tmp.next != null) {
                len++;
                tmp = tmp.next;
            }
            tmp.next = head;
            tmp = head;
            // 对k取模，找到需要断开的点
            int step = len - (k % len) - 1;
            while (step > 0) {
                step--;
                tmp = tmp.next;
            }
            head = tmp.next; // 经过step步后，tmp和tmp.next之间是需要断开的点
            tmp.next = null;
            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}