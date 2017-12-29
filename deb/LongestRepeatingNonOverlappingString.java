package deb;


public class LongestRepeatingNonOverlappingString {
	
	public static int lcsDynamic(char str1[],char str2[]){
	    
        int temp[][] = new int[str1.length + 1][str2.length + 1];
        int max = 0;
        for(int i=1; i < temp.length; i++){
            for(int j=1; j < temp[i].length; j++){
                if(str1[i-1] == str2[j-1]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                }
                else
                {
                    temp[i][j] = Math.max(temp[i][j-1],temp[i-1][j]);
                }
                if(temp[i][j] > max){
                    max = temp[i][j];
                }
            }
        }  
        
        
        for(int i=1; i < temp.length; i++){
            for(int j=1; j < temp[i].length; j++){
                System.out.print(temp[i][j]+","); 	
            }
            System.out.println();
        }
        
        return max;
    
    }

	public static void main(String[] args) {
		
		String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";
        
        int result = lcsDynamic(str1.toCharArray(), str2.toCharArray());
        System.out.println(result);
		
		// TODO Auto-generated method stub
		 int max = 0;
         String str = "aabaabaaba"; 
        		 //"banana";
         int len = str.length();
         int[][] array = new int[len+1][len+1];
         char[] strArray = str.toCharArray();
         for(int i =1;i<=len;i++){
        	 for(int j = i+1;j<=len;j++){
        		 System.out.println(strArray[i-1]+" ---- "+strArray[j-1]);
        		 if(strArray[i-1]==strArray[j-1] && array[i-1][j-1] <(j-i)){
        			 array[i][j] = array[i-1][j-1]+1;
        			 if(max<array[i][j]){
        				 max = array[i][j];
        			 }
        		 } else {
        			 array[i][j] = 0;
        		 }
        	 }
         }
         /*System.out.println(max);
         for(int i=0;i<len+1;i++){
        	 for(int j=0;j<len+1;j++){
        		 System.out.print(array[i][j]+",");
        	 }
        	 System.out.println();
         }*/
         
	}

}
