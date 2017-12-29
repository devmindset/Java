package com.deb.dynamicprog;
/**
 * Created by gzhang on 3/13/16.
 *
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right or corner at any point in time.
 *
 */
public class MinPathSum {

	public int minPathSum(int[][] grid) {
		if(grid.length ==0 || grid[0].length==0){
			return 0;
		}
		int[][] matrix = new int[grid.length][grid[0].length];
		matrix[0][0] =  grid[0][0];
		for(int i=1;i<grid.length;i++){
			matrix[i][0]= matrix[i-1][0]+grid[i][0];
		}
		for(int i=1;i<grid[0].length;i++){
			matrix[0][i]= matrix[0][i-1] + grid[0][i];
		}
		int min =0;
		for(int i=1;i<grid.length;i++){
			for(int j=1;j<grid[0].length;j++){
				min = Math.min(matrix[i][j-1], Math.min(matrix[i-1][j],matrix[i-1][j-1]));
				matrix[i][j] = min + grid[i][j]; 
			}
		}
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j]+",");
			}
			System.out.println();
		}
			
		
		
		return matrix[grid.length-1][grid[0].length-1];
	}
	
	public static void main(String[] args) {
		int arr[][] = {{1,2,3},{4,8,2},{1,5,3}};
		MinPathSum mps = new MinPathSum();
		System.out.println(mps.minPathSum(arr));
	}

}
