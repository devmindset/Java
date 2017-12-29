package com.deb.dynamicprog;

public class MaxSumForNonAdjacentElements {
	/**
	 * Date 11/03/2016
	 * @author Tushar Roy
	 *
	 * Find maximum sum for non adjacent elements.
	 * Variation is finding maximum sum non adjacent elements assuming its a circular array.
	 * So first element cannot be with last element.
	 *
	 * Time complexity O(n)
	 * Space complexity O(1)
	 *
	 * https://leetcode.com/problems/house-robber/
	 * https://leetcode.com/problems/house-robber-ii/
	 */
	
	public int maxSum(int[] arr){
		int len = arr.length;
		int[] dp = new int[len];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);
	    for(int i=2;i<len;i++){
	    	dp[i]= Math.max(dp[i-1], dp[i-2]+arr[i]);
	    }
		return dp[len-1];
	}

	public static void main(String[] args) {
        MaxSumForNonAdjacentElements msn = new MaxSumForNonAdjacentElements();
        int arr[] = { 2, 10, 13, 4, 2, 15, 10 };
        System.out.println(msn.maxSum(arr));
       // System.out.println(msn.maxSum(arr, arr.length-1));
	}
}
