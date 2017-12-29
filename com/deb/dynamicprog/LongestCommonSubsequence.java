package com.deb.dynamicprog;

/**
 * 
 * String A = " AABCDEBAZ";

Longest Palindromic subsequence: ABCBA or ABDBA or ABEBA

There are many subsequences can be found which are palindrome like, AA, BCB, ABA, BB etc
 but we need to find the one with the maximum length.

 * @author debojyoti.sarkar
 *
 */
public class LongestCommonSubsequence {

	public static int getLongestCommonSubsequence(String a, String b){
		int m = a.length();
		int n = b.length();
		int[][] dp = new int[m+1][n+1];
	 
		for(int i=0; i<=m; i++){
			for(int j=0; j<=n; j++){
				if(i==0 || j==0){
					dp[i][j]=0;
				}else if(a.charAt(i-1)==b.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
	 
		return dp[m][n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getLongestCommonSubsequence("abde","abcd"));
	}

}
