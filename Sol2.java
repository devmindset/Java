

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Sol2 {
	
	 private static final long MEGABYTE = 1024L * 1024L;

	  public static long bytesToMegabytes(long bytes) {
	    return bytes / MEGABYTE;
	  }

	public static void main(String[] args) {
		long curr = System.currentTimeMillis();
		// TODO Auto-generated method stub
		String str="This documentation concerns the non-distributed, non-Hadoop-based recommender engine / collaborative filtering code inside Mahout. It was formerly a separate project called \"Taste\" and has continued development inside Mahout alongside other Hadoop-based code.";//"welcometojava";
		int x=3;
		char[] chrArr = new char[3];
		List<String> logArrList = new ArrayList<String>(); 
		char[] strChar = str.toCharArray();
		for (int i=0;i<=strChar.length-x;i++){
			for(int j=0;j<x;j++){
				chrArr[j]=strChar[i+j];
			}
			logArrList.add(String.valueOf(chrArr));
		}
        System.out.println(Collections.min(logArrList));
        System.out.println(Collections.max(logArrList));
        System.out.println(System.currentTimeMillis()-curr);
     
        //Used memory is bytes: 237328
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
