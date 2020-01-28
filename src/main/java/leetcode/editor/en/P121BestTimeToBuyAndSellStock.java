//Say you have an array for which the ith element is the price of a given stock 
//on day i. 
//
// If you were only permitted to complete at most one transaction (i.e., buy one
// and sell one share of the stock), design an algorithm to find the maximum profi
//t. 
//
// Note that you cannot sell a stock before you buy one. 
//
// Example 1: 
//
// 
//Input: [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 
//6-1 = 5.
//             Not 7-1 = 6, as selling price needs to be larger than buying pric
//e.
// 
//
// Example 2: 
//
// 
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
// 
// Related Topics Array Dynamic Programming

package leetcode.editor.en;

//Java：Best Time to Buy and Sell Stock

public class P121BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new P121BestTimeToBuyAndSellStock().new Solution();
        // TO TEST
        int[] prices = new int[] {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            /**
             * 思路：分别记录最低谷和最大利润
             */
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int minPrice = Integer.MAX_VALUE; // 记录最小的低谷
            int maxProfit = 0; // 记录最大的利润
            for (int i = 0; i < prices.length; i++) {
                // 用最小低谷后面的点的差与最大利润比较
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
                // 记录最小价格
                minPrice = Math.min(minPrice, prices[i]);
            }
            return maxProfit;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}