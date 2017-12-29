import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Test3 {


   /* static long countX(String[] steps) {
       int len =  steps.length;
       int[] arrrow = new int[len];
       int[] arrcol = new int[len];
       int rowMax=0;
       int colMax=0;
       for(int i =0;i<len;i++){
    	   arrrow[i]= Integer.parseInt(steps[i].split(" ")[0]);
    	   if(rowMax<arrrow[i]){
    		   rowMax=arrrow[i];
    	   }
    	   arrcol[i]= Integer.parseInt(steps[i].split(" ")[1]);
    	   if(colMax<arrcol[i]){
    		   colMax=arrcol[i];
    	   }
       }
       int[][] matrix = new int[rowMax][colMax];
       for(int i =0;i<len;i++){
    	   for(int w=0;w<arrrow[i];w++){
    		   for(int x=0;x<arrcol[i];x++){
    			   matrix[w][x] ++;
        	   }   
    	   }
    	}
    	long maxVal=0L;
    	long count=0L;
    	
    	for(int i=0;i<rowMax;i++){
    		for(int j=0;j<colMax;j++){
    			if(maxVal<matrix[i][j]){
    				maxVal=matrix[i][j];
    				count=0L;
    				count++;
    			} else if(maxVal==matrix[i][j]){
    				count++;
    			} 
    		}
    	}
    	
     return count;
    }*/
	
	 static long countX(String[] steps) {
	       int len =  steps.length;
	       int[] arrrow = new int[len];
	       int[] arrcol = new int[len];
	       int rowMax=0;
	       int colMax=0;
	       Map<String,Integer> map = new LinkedHashMap<String,Integer>();
	       for(int i =0;i<len;i++){
	    	   arrrow[i]= Integer.parseInt(steps[i].split(" ")[0]);
	    	   if(rowMax<arrrow[i]){
	    		   rowMax=arrrow[i];
	    	   }
	    	   arrcol[i]= Integer.parseInt(steps[i].split(" ")[1]);
	    	   if(colMax<arrcol[i]){
	    		   colMax=arrcol[i];
	    	   }
	    	   
	    	   for(int w=0;w<arrrow[i];w++){
	    		   for(int x=0;x<arrcol[i];x++){
	    			   //matrix[w][x] ++;
	    			   
	    			   Integer val = map.get(w+","+x);
	    			   if(val!=null){
	    			      map.put(w+","+x, val++);
	    			   } else {
	    				   map.put(w+","+x, 1); 
	    			   }
	        	   }   
	    	   }
	       }
	       
	       int[][] matrix = new int[rowMax][colMax];
	       for(int i =0;i<len;i++){
	    	   for(int w=0;w<arrrow[i];w++){
	    		   for(int x=0;x<arrcol[i];x++){
	    			   matrix[w][x] ++;
	        	   }   
	    	   }
	    	}
	    	long maxVal=0L;
	    	long count=0L;
	    	
	    	for(int i=0;i<rowMax;i++){
	    		for(int j=0;j<colMax;j++){
	    			if(maxVal<matrix[i][j]){
	    				maxVal=matrix[i][j];
	    				count=0L;
	    				count++;
	    			} else if(maxVal==matrix[i][j]){
	    				count++;
	    			} 
	    		}
	    	}
	    	
	     return count;
	    }
	
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = "D:\\workspaces\\2016\\may19_Shopsmall\\Test\\src\\output.txt";//System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        long res;
        
        int _steps_size = 0;
        _steps_size = Integer.parseInt(in.nextLine().trim());
        String[] _steps = new String[_steps_size];
        String _steps_item;
        for(int _steps_i = 0; _steps_i < _steps_size; _steps_i++) {
            try {
                _steps_item = in.nextLine();
            } catch (Exception e) {
                _steps_item = null;
            }
            _steps[_steps_i] = _steps_item;
        }
        
        res = countX(_steps);
        bw.write(String.valueOf(res));
        bw.newLine();
        
        bw.close();
    }

}
