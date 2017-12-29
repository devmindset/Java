
public class MaxSubProductArray {

	public static int maxProduct(int[] nums) {
	    int[] max = new int[nums.length];
	    int[] min = new int[nums.length];
	 
	    max[0] = min[0] = nums[0];
	    int result = nums[0];
	    System.out.println("Number="+nums[0]+" : Max="+max[0]+" : Min="+min[0]);
	    for(int i=1; i<nums.length; i++){
	        if(nums[i]>0){
	            max[i]=Math.max(nums[i], max[i-1]*nums[i]);
	            min[i]=Math.min(nums[i], min[i-1]*nums[i]);
	            System.out.println("Number="+nums[i]+" : Max="+max[i]+" : Min="+min[i]);
	        }else{
	            max[i]=Math.max(nums[i], min[i-1]*nums[i]);
	            min[i]=Math.min(nums[i], max[i-1]*nums[i]);
	            System.out.println("Number="+nums[i]+" : Max="+max[i]+" : Min="+min[i]);
	        }
	 
	        result = Math.max(result, max[i]);
	    }
	 
	    return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2,3,-2,4,2};
		System.out.println(maxProduct(array));
	}

}
