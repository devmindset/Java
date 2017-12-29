package com.deb.dynamicprog;

/**
 * Given two strings, s1 and s2 and edit oper­a­tions (given below). Write an algo­rithm to find min­i­mum num­ber oper­a­tions required to con­vert string s1 into s2.

Allowed Oper­a­tions:

Inser­tion — Insert a new character.
Dele­tion — Delete a character.
Replace — Replace one char­ac­ter by another.
Exam­ple:

String s1 = "horizon"
String  s2 = "horzon"
Output: 1  {remove 'i' from string s1}
 * @author debojyoti.sarkar
 *
 */

public class EditDistance {
    public static void main(String[] args){
	
    	String str1="bat";
    	String str2 = "catt";
    	int len1 = str1.length();
    	int len2 = str2.length();
    	int[][] dp=new int[len1+1][len2+1];
    	//If we delete all characters then number of operations need to do
    	for(int i=0;i<=len1;i++){
    		dp[i][0]=i;
    	}
    	//If we insert/replace all characters then number of operations need to do
    	for(int j=0;j<=len1;j++){
    		dp[0][j]=j;
    	}
    	
    	for(int i=1;i<len1;i++){
    		for(int j=1;j<len2;j++){
    			if(str1.charAt(i-1)== str2.charAt(j-1)){
    				// <-- word1(i) == word2(j)
    			   dp[i][j] = dp[i-1][j-1];	
    			} else {
    				// After draw a matrix, it is very easy to figure it out.
                    // dp[i-1][j-1] : replace word1(i) with word2(j), because word1(0, i-1) == word2(0, j-1);
                    // dp[i  ][j-1] : insert word(j), because word1(0, i) == word2(0, j-1)
                    // dp[i-1][j  ] : delete word(i), because word1(0, i-1) == word2(0, j)
    			   dp[i][j]= Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]))+1; 	
    			}
    		}
    	}
    	for(int i=0;i<=len1;i++){
    		for(int j=0;j<=len2;j++){
    			System.out.print(dp[i][j]+",");		
    		}
    		System.out.println();
    	}
    	System.out.println(dp[len1-1][len2-1]);
    	
    	
    	
    }
}
