package algorithms;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you
 * like (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time (ie,
 * you must sell the stock before you buy again).
 *
 * Created by fjun on 4/5/16.
 */
public class P122BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 300}));
    }

    /**
     *  这道题表达不太清晰：你可以在任意的一天进行股票交易，可以同时买入和卖出，但不能持有多支股票。
     *  于是：对于[1, 2, 3, 300]
     *  最高收益的交易：
     *  Day1: 买入            收益 -1
     *  Day2: 卖出并买入     收益 0
     *  Day3: 卖出并买入     收益 0
     *  Day4: 卖出            收益 300
     */
    public static int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i ++) {
            int diff = prices[i + 1] - prices[i];
            if (diff > 0) {
                sum += diff;
            }
        }
        return sum;
    }
}
