package com.deb.dynamicprog;

public class MaximumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        /* Key point:
	         * 1. Compare nums[i] with nums[i] + max_sum_till_curr, choose the bigger one.
	         * 2. Check max_sum_till_curr, if it is bigger than ans, update ans.
	         */
        int sum=0;
        int max =0;
		int[] arr= {-2,1,-3,4,-1,2,1,-5,4};
		for(int i=0;i<arr.length;i++){
			sum = Math.max(sum+arr[i],arr[i]);
			max= Math.max(sum,max);
		}
		System.out.println(max);
		
	}

}
