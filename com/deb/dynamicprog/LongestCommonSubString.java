package com.deb.dynamicprog;

/**
 * http://www.programcreek.com/2015/04/longest-common-substring-java/
 * String A = "tutorialhorizon";

String B = "dynamictutorialProgramming";

Output: Length of Longest Common Substring: 8 ("tutorial")
 * @author debojyoti.sarkar
 *
 */

public class LongestCommonSubString {

	public static int getLongestCommonSubstring(String a, String b){
		int m = a.length();
		int n = b.length();
	 
		int max = 0;
	 
		int[][] dp = new int[m][n];
	 
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(a.charAt(i) == b.charAt(j)){
					if(i==0 || j==0){
						dp[i][j]=1;
					}else{
						dp[i][j] = dp[i-1][j-1]+1;
					}
	 
					if(max < dp[i][j])
						max = dp[i][j];
				}
	 
			}
		}
	 
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getLongestCommonSubstring("aaaa","abcd"));
	}

}
