package session_four_programming_fundamentals_practice.class_problems;

public class StockProfit {

    static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // If selling today gives a better profit, update maxProfit
            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }

            // Update the lowest price seen so far
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 5
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));    // 0
    }
}