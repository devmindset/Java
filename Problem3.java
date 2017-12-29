import java.util.Arrays;

/*
 * http://www.geeksforgeeks.org/sort-array-wave-form-2/
 * Sort an array in wave form
 * Given an unsorted array of integers, sort the array into a wave like array.
 * An array ‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..
 * 
 */
public class Problem3 {

	public void sortInWave(int[] arr, int n){
        //Sort the array 
		Arrays.sort(arr);
		//1,2,5,10,23,49,90
		// Swap the element with adjacent element 
		for(int i =0;i<n;i+=2){
			if(i!=n-1){
			   int num = arr[i+1];
			   arr[i+1]= arr[i];
			   arr[i]= num;
			}
		}
	}
	
	public static void main(String[] args) {
		Problem3 ob = new Problem3();
        int arr[] = {10, 90, 49, 2, 1, 5, 23};
        int n = arr.length;
        ob.sortInWave(arr, n);
        for (int i : arr)
            System.out.print(i + " ");
       //Output = 2 1 10 5 49 23 90 
	}

}
