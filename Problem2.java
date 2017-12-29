/**
 * http://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
 * Find position of an element in a sorted array of infinite numbers
 * 
 * @author debojyoti.sarkar
 *
 */
public class Problem2 {

	static int start =0;
	static int end =0;
	
	private static int binarySearch(int arr[],int stPos, int endPos,int number){
		int mid = (stPos+endPos)/2;
		if(arr[mid]==number){
			System.out.println("Element Position = "+mid);
			return mid;
		} else if(arr[mid]>=number){
			endPos = mid;
			binarySearch(arr,stPos,endPos,number);
		} else if(arr[mid]<number){
			stPos = mid+1;
			binarySearch(arr,stPos,endPos,number);
		}
		return mid;
	}
	
	private static void findPos(int array[],int number){
		//Start Pos
		int i = 0;
		//End Pos
		int j = 1;
		System.out.println(i +"  ****  "+j);
		while(array[j]<number){
				i=j;
				j=j*2;
				System.out.println(i +"  ****  "+j);
		}
		start = i;
		end = j;
	}
	
	
	
	public static void main(String[] args){
		
		int arr[] = new int[]{3, 5, 7, 9, 10, 90, 
                100, 130, 140, 160, 170};
		int findNum = 170;
        findPos(arr,findNum);
        int ans =  binarySearch(arr,start,end,findNum);
        if (ans==-1)
           System.out.println("Element not found");
        else
           System.out.println("Element found at index " + ans);
	}
}
