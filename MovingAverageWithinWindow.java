import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * Hide Company Tags
 *
 * Key points:
 * 1. Use queue to keep the elements within the window.
 * 2. Use sum to decrease the tail and increase the head.
 *
 */

class MovingAverage{
	
	public MovingAverage(int windowSize){
		assert windowSize > 0 :"Window Size should be positive";
		this.window = windowSize;
	}
	
	/*
     * You can only access the methods in the LinkedList that are available in the Queue<String> interface,
     * which includes support for enqueuing and dequeuing elements. This would be useful if you needed to
     * write a program that used a queue for various operations and wanted to implement that queue by
     * using a linked list.
     */
	Queue<Integer> queue = new LinkedList<Integer>();
	int window;
	double sum;

	public double average(int num){
		
		if(queue.size()<window){
			//You can use add also but using offer u will have better adv----
			//Inserts the specified element into this queue if it is possible to do so immediately without
			//violating capacity restrictions. When using a capacity-restricted queue, this method is 
			//generally preferable to add, which can fail to insert an element only by throwing an 
			//exception.
			//queue.add(num);
			queue.offer(num);
			sum +=num;
			return sum/queue.size();
		} else {
			int headElement = queue.poll();
			queue.add(num);
			sum = sum - headElement + num;
			return sum/queue.size();
		}
	}
	
	
	
	
}

public class MovingAverageWithinWindow {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int windowSize =4;
		Integer arr[] = {10, 20, 30, 40, 50, 60,90};
		MovingAverage avg = new MovingAverage(windowSize);
	    int k=0;
	    
	    for(int i =0;i<arr.length;i++){
	    	double val = avg.average(arr[i]);
	    	if(i>=(windowSize-1)){
	    		System.out.print("Average of [");
	    		for(int j=k;j<(k+windowSize);j++){
	    	        System.out.print(arr[j]);
	    	        if(j!=(k+windowSize-1)){
	    	        	System.out.print(", ");
	    	        }
	    	    }
	    		System.out.print("] = "+val);
	    		k++;
	    		System.out.println();
	        }
	   }
	}
}

