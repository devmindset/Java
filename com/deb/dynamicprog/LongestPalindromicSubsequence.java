package com.deb.dynamicprog;

public class LongestPalindromicSubsequence {

	public static String longestPalindrome(String s) {
	    if(s==null || s.length()<=1)
	        return s;
	 
	    int len = s.length();
	    int maxLen = 1;
	    boolean [][] dp = new boolean[len][len];
	 
	    String longest = null;
	    for(int l=0; l<s.length(); l++){
	        for(int i=0; i<len-l; i++){
	            int j = i+l;
	            System.out.println("i="+i+" j="+j+"  j-i="+(j-i)+" s.charAt(i)="+s.charAt(i)+" s.charAt(j)="+s.charAt(j));
	            if(s.charAt(i)==s.charAt(j) && (j-i<=2||dp[i+1][j-1])){
	                dp[i][j]=true;
	 
	                if(j-i+1>maxLen){
	                   maxLen = j-i+1; 
	                   longest = s.substring(i, j+1);
	                }
	            }
	        }
	    }
	 
	    return longest;
	}
	
	public static void longestPalindromeApproach2(String s) {
	    //if(s==null || s.length()<=1)
	    //    return s;
	 
	    char[] strChar = s.toCharArray();
	    int len = s.length();
	    int maxLen = 1;
	    int[][] dp = new int[len][len];
	    
	    for(int i=0;i<len;i++){
	    	dp[i][i] =1;
	    }
	    
	    for(int i =2;i<=len;i++){
	    	for(int j=0;j<len-i+1;j++){
	    		int k = j+i-1;
	    		if(strChar[j]==strChar[k] && i==2){
	    			dp[j][k] = 2;
	    		} else if(strChar[j]==strChar[k]){
	    			dp[j][k] = dp[j+1][k-1]+2;
	    		} else {
	    			dp[j][k] = 	Math.max(dp[j+1][k], dp[j][k-1]);
	    		}
	    	}
	    }
	    System.out.println("***************************");
	    System.out.println(dp[0][len-1]);
	    System.out.println("***************************");
	    for(int i=0;i<len;i++){
	    	for(int j=0;j<len;j++){
	    		System.out.print(dp[i][j]+",");
	    	}
	    	System.out.println("");
	    }
	    

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.println( longestPalindrome("dabcba") );
     longestPalindromeApproach2("dabcba");
     
	}

}
