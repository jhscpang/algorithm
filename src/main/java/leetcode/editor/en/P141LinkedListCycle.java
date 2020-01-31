//Given a linked list, determine if it has a cycle in it. 
//
// To represent a cycle in the given linked list, we use an integer pos which re
//presents the position (0-indexed) in the linked list where tail connects to. If 
//pos is -1, then there is no cycle in the linked list. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: head = [3,2,0,-4], pos = 1
//Output: true
//Explanation: There is a cycle in the linked list, where tail connects to the s
//econd node.
// 
// 
//
// 
// 
//
// Example 2: 
//
// 
//Input: head = [1,2], pos = 0
//Output: true
//Explanation: There is a cycle in the linked list, where tail connects to the f
//irst node.
// 
// 
//
// 
// 
//
// Example 3: 
//
// 
//Input: head = [1], pos = -1
//Output: false
//Explanation: There is no cycle in the linked list.
// 
// 
//
// 
//
// 
//
// Follow up: 
//
// Can you solve it using O(1) (i.e. constant) memory? 
// Related Topics Linked List Two Pointers

package leetcode.editor.en;

//Java：Linked List Cycle

public class P141LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new P141LinkedListCycle().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            /**
             * 思路：
             * 解法1. 可以利用HashSet，访问过的节点都存上，如果访问的节点在Set中找到，说明有环
             */
            //            Set<ListNode> nodesSeen = new HashSet<>();
            //            while (head != null) {
            //                if (nodesSeen.contains(head)) {
            //                    return true;
            //                } else {
            //                    nodesSeen.add(head);
            //                }
            //                head = head.next;
            //            }
            //            return false;

            /**
             * 解法2. 可以使用快慢指针看是否快指针赶上慢指针
             */
            if (head == null || head.next == null) { // null或者单个节点时一定没环
                return false;
            }
            ListNode slow = head.next;
            ListNode fast = head.next.next;
            while (slow != null && fast != null) {
                if (slow == fast) { // 快慢指针相遇。说明有环
                    return true;
                }
                // 慢指针走一步
                slow = slow.next;
                // 快指针走两步
                fast = fast.next;
                if (fast != null) {
                    fast = fast.next;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}