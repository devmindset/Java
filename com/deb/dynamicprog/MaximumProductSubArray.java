package com.deb.dynamicprog;
/**
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 *
 *
 */
public class MaximumProductSubArray {

    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        // maximum[i] means maximum product that can be achieved ending with i
        // minimum[i] means minimum product that can be achieved ending with i
        int[] maximum = new int[nums.length];
        int[] minimum = new int[nums.length];
        maximum[0] = nums[0];
        minimum[0] = nums[0];
        int ans = maximum[0];

        // We should track both the maximum and minimum, since the minus minimum multiplies negative number could become maximum.
        for (int i = 1; i < nums.length; i++) {
            maximum[i] = Math.max(nums[i], Math.max(maximum[i - 1] * nums[i], minimum[i - 1] * nums[i]));
            minimum[i] = Math.min(nums[i], Math.min(maximum[i - 1] * nums[i], minimum[i - 1] * nums[i]));
            ans = Math.max(ans, maximum[i]);
        }

        return ans;
    }
    
    public static void main(String[] args) {
        int[] nums = {-4,-3,-2};
        MaximumProductSubArray mp = new MaximumProductSubArray();
        System.out.println(mp.maxProduct(nums));
    }
}
