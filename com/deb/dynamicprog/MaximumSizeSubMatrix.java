package com.deb.dynamicprog;

/*
 * Given a binary matrix, find out the maximum size square sub-matrix with all 1s.

For example, consider the below binary matrix.

 
   0  1  1  0  1 
   1  1  0  1  0 
   0  1  1  1  0
   1  1  1  1  0
   1  1  1  1  1
   0  0  0  0  0
The maximum square sub-matrix with all set bits is

    1  1  1
    1  1  1
    1  1  1
 */

public class MaximumSizeSubMatrix {

    private int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }
    
    public int maxSize(int arr[][]){
        
        int result[][] = new int[arr.length][arr[0].length];
        int max = 0;
        for(int i=0; i < arr.length; i++){
            result[i][0] = arr[i][0];
            /*if (result[i][0] == 1)
            {
                max = 1;
            }*/
        }
        
        for(int i=0; i < arr[0].length; i++){
            result[0][i] = arr[0][i];
           /* if (result[0][i] == 1)
            {
                max = 1;
            }*/
            
        }
        for(int i=1; i < arr.length; i++){
        	 for(int j=1; j < arr[0].length; j++){
        		 if(arr[i][j]==1){
        			result[i][j] = Math.min(result[i][j-1], Math.min(result[i-1][j],result[i-1][j-1]))+1;
        			if(result[i][j]>max){
        				max=result[i][j];
        			}
        		 } else {
        		    result[i][j]=0;
        		 }
        	 }
        }
        return max;
        
    }
    
    
    public static void main(String args[]){
        
        int arr[][] = {{0,1,1,0,1},{1,1,1,0,0},{1,1,1,1,0},{1,1,1,0,1}};
        MaximumSizeSubMatrix mssm = new MaximumSizeSubMatrix();
        int result = mssm.maxSize(arr);
        System.out.print(result);
    }
}
