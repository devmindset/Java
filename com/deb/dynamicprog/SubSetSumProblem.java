package com.deb.dynamicprog;

/*
 *
 * Given an array of non negative numbers and a total, is there subset of numbers in this array which adds up
 * to given total. Another variation is given an array is it possible to split it up into 2 equal
 * sum partitions. Partition need not be equal sized. Just equal sum.
 *
 * Time complexity - O(input.size * total_sum)
 * Space complexity - O(input.size*total_sum)
 *
 * Youtube video - https://youtu.be/s6FhG--P7z0
 */

public class SubSetSumProblem {
	boolean[][] temp;
	public static void main(String[] args) {
        //int arr1[] = {2, 3, 7, 8}; int sum =11;
		int arr1[] = {1, 3, 7, 8}; int sum =11;
		//int[] arr1 = { 3, 2, 7, 1}; int sum = 6;
        SubSetSumProblem ss = new SubSetSumProblem();
        System.out.println(ss.subsetSum(arr1, sum));
	}

	private boolean subsetSum(int[] input, int expectedSum) {
		temp = new boolean[input.length+1][expectedSum+1]; 
		
		//if my sum is zero then I can make it using all the value including zero
		//eg. (0,2),(0,2,3)
		for(int i=0;i<=input.length;i++)
			temp[i][0]= Boolean.TRUE;
		
        // If we have 0 elements other than 1st number all values are zero 		
		for(int i=0;i<=expectedSum;i++) {
		    if(i==0){
		    	temp[0][i]= Boolean.TRUE; 	
		    } else {
		    	temp[0][i]= Boolean.FALSE;	
		    }
		}
		
		for(int i=1;i<=input.length;i++){
			for(int j=1;j<=expectedSum;j++){
				if(j-input[i-1]>=0){
				   temp[i][j]= temp[i-1][j] || temp[i-1][j-input[i-1]];	
				} else {
				   temp[i][j]= temp[i-1][j];	
				}
			}
		}
		
		
		for(int i=0;i<=input.length;i++) {
			for(int j=0;j<=expectedSum;j++) {
				System.out.print( ((temp[i][j]== true)?"1":"0") +",");
			}
			System.out.println();
		}
		
		int j=expectedSum;		
		for(int i=input.length;i>0;) {
			if(temp[i][j]==Boolean.TRUE && temp[i-1][j]==Boolean.TRUE){
			   i--;
			} else if(temp[i][j]==Boolean.TRUE && temp[i-1][j]==Boolean.FALSE){
				System.out.print(input[i-1] +",");
				j=j-input[i-1];
			} 
		}
		System.out.println();
		return temp[input.length][expectedSum];
	}
	
	public void print_paths(int[] input, int expectedSum){
		
		
	}
	
}
