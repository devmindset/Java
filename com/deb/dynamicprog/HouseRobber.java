package com.deb.dynamicprog;

public class HouseRobber {

	  /**
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed,
     * the only constraint stopping you from robbing each of them is that
     * adjacent houses have security system connected and it will automatically contact the police
     * if two adjacent houses were broken into on the same night.
     *
     * Given a list of non-negative integers representing the amount of money of each house,
     * determine the maximum amount of money you can rob tonight without alerting the police.
     *
     *
     *
     * Let sum[i] be the maximum amount of money when robber comes at i,
     * he can either rob it or not depending on the money robbed at i-1 and i-2.
     *
     * corner case: sum[0] = num[0], sum[1] = max(num[0],num[1])
     *
     * generally, at position i, sum[i] = max(sum[i-1], sum[i-2]+num[i])
     *
     *
     * Key points:
     * 1. Formula: dp[i] = max(dp[i - 1], dp[i - 2] + nums[i]),
     *    Means either (rob No.i house + result from robbing previous i - 2)
     *    Or (not rob No.i house + result from  robbing previous i - 1)
     *
     * @param nums
     * @return
     */
	public int rob(int[] nums){
		int val = 0;
		int len = nums.length;
		int max =0;
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0],nums[1]);
		for(int i=2;i<len;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);			
		}
		return dp[len-1];
	}
	/**
	 * https://github.com/guibin/AlgoPractice/blob/master/src/main/java/algo/dp/HouseRobber.java
	 * 
	 * Note: This is an extension of House Robber.
	 *
	 * After robbing those houses on that street,
	 * the thief has found himself a new place for his thievery so that he will not get too much attention.
	 * This time, all houses at this place are arranged in a circle.
	 * That means the first house is the neighbor of the last one.
	 * Meanwhile, the security system for these houses remain the same as for those in the previous street.
	 *
	 * Given a list of non-negative integers representing the amount of money of each house,
	 * determine the maximum amount of money you can rob tonight without alerting the police.
	 *
	 *
	 * This problem is similar with rob a the strait street, just divide the problems into two cases:
	 * 1. Don't rob the num[0] house.
	 * 2. Don't rob the num[1] house.
	 *
	 * @param nums
	 * @return
	 */
	public int robCircle(int[] nums){
		int len = nums.length;
		int[] dp = new int[nums.length];
        int val = Math.max(robCirc(nums,0,len-1), robCirc(nums,1,len));			
		return val;
	}
	
	public int robCirc(int[] nums, int start,int end){
		int len = end-start;
		if (len == 0) return 0;
        if (len == 1) return nums[start];
		int[] dp = new int[len];
		dp[0] = nums[start];
		dp[1] = Math.max(nums[start],nums[start+1]);
		for(int i=2;i<len;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[start+i]);			
		}
		return dp[len-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseRobber hr = new HouseRobber();
        int[] nums = {1,1,2,1};
        System.out.println(hr.rob(nums));
        System.out.println(hr.robCircle(nums));
	}

}
