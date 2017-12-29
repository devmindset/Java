package deb;

/**
 * 
 * @author debojyoti.sarkar
 *
 * Print all possible paths from top left to col row of a mXn matrix
 * The problem is to print all the possible paths from top left to col row of a mXn matrix with the 
 * constraints that from each cell you can either move only to row or down
 */
public class PrintAllPossiblePathMatrix {
    static int totalRow = 3,  totalCol =3;
    static int marks[][]= {{1,2,3},{4,5,6},{7,8,9}};
    		//{{50,60,55,67,70},{62,65,70,70,81},{72,66,77,80,69}};
	public static void calculate(int row, int col, String path){
		
		if(row == totalRow -1){
			for(int i = col;i<totalCol;i++){
				path= path+"-"+marks[row][i];
			}
			System.out.println(path);
			return;
		}
		
		if( col == (totalCol-1) ){
		   	for(int i = row;i<totalRow;i++){
		   		path= path+"-"+marks[i][col];
		   	}
		   	System.out.println(path);
		   	return;
		}
		 path = path +"-"+ marks[row][col];
		calculate(row+1,col,path);
		calculate(row,col+1,path);
	}
	
	public static void main(String[] args) {
		// 5 X 3 Matrix
		
		int row =marks.length;
		int col = marks[0].length;
		calculate(0,0,"");
		
	}

}
