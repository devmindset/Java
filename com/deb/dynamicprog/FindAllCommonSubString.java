package com.deb.dynamicprog;

import java.util.HashSet;
import java.util.Set;
/**
 * http://stackoverflow.com/questions/34805488/finding-all-the-common-substrings-of-given-two-strings
 * @author debojyoti.sarkar
 *
 */
public class FindAllCommonSubString {
	
	public static Set<String> longestCommonSubstrings(String s, String t) {
	    int[][] table = new int[s.length()+1][t.length()+1];
	    int longest = 0;
	    Set<String> result = new HashSet<>();

	    
	    for (int i = 1; i <= s.length(); i++) {
	        for (int j = 1; j <= t.length(); j++) {
	        	if(s.charAt(i-1)==t.charAt(j-1)){
	        		
	        		table[i][j]=table[i-1][j-1]+1;
	        	}

//	        	if(longest<table[i][j]){
//	        	   longest = table[i][j];	
//	        	   result.clear();
//	        	}
//	        	if(longest==table[i][j]){
//	        		System.out.println("Longest - i="+i+" - longest="+longest+" - s.substring(i-longest, i-1)="+s.substring(i-longest, i));
//	        		result.add(s.substring(i-longest, i));
//	        	}
	        }
	    }
	    
	    //Print the matrix to understand the problem
	    /*for (int i = 0; i <=s.length(); i++) {
	        for (int j = 0; j <= t.length(); j++) {
	         	System.out.print(table[i][j]+",");
	        }
	        System.out.println();
	    }*/
	    
	    /*
	     * Find the position of 1 in row and increase the position using diagonally till u find 0. 
	     * The word is starting point of 1 to last non zero value. 
	     */
	    for (int i = 1; i <table.length; i++) {
	        for (int j = 1; j < table[0].length; j++) {
	        	if(table[i][j]==1){
	        		int count =0;	
	        		int start =i;
	        		int end = j;
	        		while(start<table.length && end <table[0].length && table[start][end]!=0 ){
	        			start++;
	        			end++;
	        			count++;
	        		}
	        		if(count>1){
	        		  result.add(s.substring(i-1,(i-1+count)));
	        		}
	        	}
	        }
	    }
	    
	    for (String val : result) {
	        System.out.println(val);
	    }
	    
	    return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestCommonSubstrings("neerajisgreat","rajeatneerajisnotgreat"));
				//"abce","abdce"));
				//"neerajisgreat","rajeatneerajisnotgreat"));
	}
}
