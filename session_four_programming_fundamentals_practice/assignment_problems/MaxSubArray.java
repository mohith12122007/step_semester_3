package session_four_programming_fundamentals_practice.assignment_problems;
public class MaxSubArray {

    static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int bestSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Extend the running subarray, or restart fresh from here
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Keep track of the best sum seen so far
            bestSum = Math.max(bestSum, currentSum);
        }

        return bestSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
        System.out.println(maxSubArray(new int[]{-3, -1, -2}));                   // -1
    }
}