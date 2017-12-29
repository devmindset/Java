import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * In the sorted array of integers how to find sum of two numbers is x
 * (This will be teh input provided by user) (with time complexity O(n))
 * @author debojyoti.sarkar
 *
 */
public class Problem1 {
    public static void main(String[] args){
    	int[] numbers = { 2, 4, 3, 5, 7, 8, 9 }; 
    	int[] numbersWithDuplicates = { 2, 4, 3, 5, 6, -2, 4, 7, 8, 9 }; 
    	//Only works for non duplicate and positive number
    	//findNum(numbers, 7); 
    	//prettyPrint(numbersWithDuplicates, 7);
    	findNum2(numbers, 7); 
    }
    //Approach 1  - O(n) time
    private static void findNum(int[] arr,int sum){
    	
    	if(arr.length<2){
    		return;
    	}
    	
    	Arrays.sort(arr);
    	
    	int first = arr[0];
    	int last = arr[arr.length-1];
    	int len = arr.length;
    	if(sum<first || sum>(arr[len-2]+last)){
    		return;
    	}
    	int i=0;
    	
    	boolean[] boolArray = new boolean[10000];
    	int remaining = 0;
    	for(int j =0;j<len;j++){
    	    remaining = sum - arr[j];
    		if(remaining >=0 && boolArray[remaining]){
    		   System.out.println("Pair for sum "+ sum +" = ("+ arr[j]+","+remaining+"),");	
    		}
    		boolArray[arr[j]] = true;
    	}
    	
    }

    //Approach 2
    private static void findNum2(int[] arr,int sum){
    	if(arr.length<2){
    		return;
    	}
    	
    	Arrays.sort(arr);
    	
    	int first = arr[0];
    	int last = arr[arr.length-1];
    	int len = arr.length;
    	if(sum<first || sum>(arr[len-2]+last)){
    		return;
    	}
    	//2, 3, 4, 5, 7, 8, 9
    	int i=0;
    	int j =1;
    	while(i<len && j<len){
    		int temp = sum - arr[i];
    		if(temp == arr[j]){
    		   System.out.println("Pair = ("+arr[i]+","+arr[j]+")");
    		   i++;
    		} else if(temp > arr[j]){
    			j++;
    		} else if(temp < arr[j]){
    			j=i+1;
    		}
    	}
    }

    private static void findNum3(int[] arr,int sum){
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	
    	for(int i = 0;i<map.size();i++){
    		
    	}
    	
    	
    }

}
