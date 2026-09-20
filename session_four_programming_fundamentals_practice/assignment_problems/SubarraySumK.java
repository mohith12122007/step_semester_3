package session_four_programming_fundamentals_practice.assignment_problems;

import java.util.HashMap;

public class SubarraySumK {

    static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixFreq = new HashMap<>();
        prefixFreq.put(0, 1); // "empty prefix" base case

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            // A subarray ending here sums to k if (currentSum - k) was seen before
            if (prefixFreq.containsKey(currentSum - k)) {
                count += prefixFreq.get(currentSum - k);
            }

            prefixFreq.put(currentSum, prefixFreq.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));  // 2
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0)); // 3
    }
}