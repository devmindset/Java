import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    
    public static long toAscii(String s){
        StringBuilder sb = new StringBuilder();
        long asciiInt;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            asciiInt = (int)c; 
           // System.out.println(c +"="+asciiInt);
            sb.append(asciiInt);
        }
        return Long.parseLong(sb.toString());
}

    private static final long MEGABYTE = 1024L * 1024L;

	  public static long bytesToMegabytes(long bytes) {
	    return bytes / MEGABYTE;
	  }
    
    public static void main(String[] args) {
    	long curr = System.currentTimeMillis();
    	
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String str1;
        String str2;
       // Scanner scanIn = new Scanner(System.in);
        str1 = "This documentation concerns the non-distributed, non-Hadoop-based recommender engine / collaborative filtering code inside Mahout. It was formerly a separate project called \"Taste\" and has continued development inside Mahout alongside other Hadoop-based code.";
        		//"welcometojava";//scanIn.nextLine();
        str2 = "3";//scanIn.nextLine();
        //scanIn.close();   
        //List<String> list = new ArrayList<String>();
        int val = Integer.parseInt(str2);
        //for(int i=str1.length()-1;i>=0;i=i-val){
        //   list.add(str1.substring(i-val,i)); 
        //}
        String minStr,maxStr;
        TreeMap<Long,String> map = new TreeMap<Long,String>();
        for(int i=0;i<=(str1.length()-val);i++){
        	//System.out.println(i+"----"+val);
            minStr = str1.substring(i,val+i);
            //System.out.println(minStr);
            long ascii =  toAscii(minStr);
            map.put(ascii,minStr);
        }
        //Map.Entry<String,String> entry=map.entrySet().iterator().next();
        //String value=entry.getValue();
        Entry ent = map.lastEntry();
        System.out.println( ent.getValue());
        Entry<Long,String> ent2 = map.firstEntry();
        System.out.println(ent2.getValue());
        System.out.println(System.currentTimeMillis()-curr);
        
        //Used memory is bytes: 238904
        //Used memory is megabytes: 0
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);
        System.out.println("Used memory is megabytes: "+ bytesToMegabytes(memory));
        
        
    }
}