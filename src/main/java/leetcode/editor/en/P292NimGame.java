//You are playing the following Nim Game with your friend: There is a heap of st
//ones on the table, each time one of you take turns to remove 1 to 3 stones. The 
//one who removes the last stone will be the winner. You will take the first turn 
//to remove the stones. 
//
// Both of you are very clever and have optimal strategies for the game. Write a
// function to determine whether you can win the game given the number of stones i
//n the heap. 
//
// Example: 
//
// 
//Input: 4
//Output: false 
//Explanation: If there are 4 stones in the heap, then you will never win the ga
//me;
//             No matter 1, 2, or 3 stones you remove, the last stone will alway
//s be 
//             removed by your friend. Related Topics Brainteaser Minimax

package leetcode.editor.en;

//Java：Nim Game

public class P292NimGame {
    public static void main(String[] args) {
        Solution solution = new P292NimGame().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canWinNim(int n) {
            /**
             * 思路：这是一道脑筋急转弯题，如果堆中石头的数量 n 不能被 4 整除，那么你总是可以赢得 Nim 游戏的胜利。
             * 推理：
             * 如果石头堆中只有一块、两块、或是三块石头，那么在你的回合，你就可以把全部石子拿走，从而在游戏中取胜，
             * 如果有五块、六块、或是七块石头，你可以控制自己拿取的石头数，总是恰好给你的对手留下四块石头，使他输掉这场比赛。
             * 但是如果石头堆里有八块石头，对方总是可以给你留下4块。
             */
            return (n % 4 != 0);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}