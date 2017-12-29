package com.deb.dynamicprog;

import java.util.Arrays;

//Ref _https://www.youtube.com/watch?v=CE2b_-XfVDk
/**
 * Example:

A[] = {3, 4, 1, 5}

i=1 , LIS(1) = 1

i=2 , LIS(2) = 1+ Max(LIS(1)) = 1 +1 =2 (4>3)

i=3 , LIS(3) = 1 (1>3, 1>4)

i=4 , LIS(4) = 1+ Max(LIS(1),LIS(2), LIS(3))

= 1 + Max(1,2,1) = 3
 * @author debojyoti.sarkar
 *
 */
public class LongestIncresingSubsequence {

	public static int longestIncrSubseq(int[] arr){
		int max =0;
		int len = arr.length;
		int[] maxArr = new int[len];
		//Atleast longest increasing subsequence At any position is 1. 
		//So lets fill the array with 1. 
	    Arrays.fill(maxArr, 1); 
		for(int i=0;i<len;i++){
			for(int j=0;j<i;j++){
				if(arr[i]>arr[j]){
				   maxArr[i]= Math.max(maxArr[j]+1, maxArr[i]); 	
				}
			}
		}
		int pos =0;
		for(int i=0;i<len;i++){
			if(max<maxArr[i]){
				max=maxArr[i];
				pos=i;
			}
			
		}
		//Print the values
		//0 8 4 12 2 10 6 14 1 9 5 13 3 11 7 15 = arr
		//1 2 2 3  2 3  3 4  2 4 3 5  3 5  4 6 = maxArr
        // output =	0 2 6 9 11 15
		int val=max-1;
		System.out.print(arr[pos]+",");
		for(int i=pos-1;i>=0;i--){
			if(val==maxArr[i]){
				System.out.print(arr[i]+",");
				val--;
			}
		}
		System.out.println();
		
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};//{3, 4, 1, 5};
		System.out.println(longestIncrSubseq(arr));
	}

}
