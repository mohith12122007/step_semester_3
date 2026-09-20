package session_four_programming_fundamentals_practice.class_problems;

import java.util.Arrays;

public class RotateArray {

    static int[] rotateArray(int[] nums, int k) {
        k = k % nums.length; // reduce k first

        int[] newArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            newArray[(i + k) % nums.length] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3))); // [5, 6, 7, 1, 2, 3, 4]
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2}, 3)));               // [2, 1]
    }
}