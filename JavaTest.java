import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;


public class JavaTest {
public static void main(String[] args){
	double d = 25.000;
	System.out.println(d%10);
	HashMap<Integer,String> map = new HashMap<Integer,String>();
	System.out.println(map);
	map.put(1,"2");
	System.out.println(map);
	
	int x = -4;
	System.out.println(x>>2);
	
	
	
/*	BufferedReader br = null;
    int mod =0;
    int p =0;
    try {
        int count =0;
        br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            System.out.print("Enter Mod : ");
            mod = Integer.parseInt((String)br.readLine());
            count++;
            System.out.print("Enter P : ");
             p = Integer.parseInt((String)br.readLine());
            count++;

        }

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/
	
	
	BufferedReader br = null;
    int mod =0;
    int p =0;
    String arrayVal = null;
    try {
        int count =0;
        br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            System.out.print("Enter Number : ");
            arrayVal = br.readLine();
            break;
            

        }

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

   String[] arr = arrayVal.split(" ");
   int count = 0;
   for(int i =0;i<arr.length;i++){
	   for(int j =0;j<arr.length;j++){
		   if(i!=j){
			  if(euler(Integer.parseInt(arr[i]),Integer.parseInt(arr[j])) == 1){
				  System.out.println(arr[i]+","+arr[j]);
				  count++;
			  }
		   }
	   }
   }
   System.out.println(count);
    
    
	
	
	/*int flag =0;
	int p =11;
	int mod =5;
	mod =mod%p;
	for(int i=2;i<p;i++){
		if((i*i)%p == mod){
		   flag=1;	
		}
	}
	System.out.println(flag);*/
	
}

public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
    for(int i: nums){
        q.offer(i);
 
        if(q.size()>k){
            q.poll();
        }
    }
 
    return q.peek();
}


static int euler(int p,int mod){
	int flag=0;
	mod =mod%p;
	for(int i=2;i<p;i++){
		if((i*i)%p == mod){
		   flag=1;	
		   break;
		}
	}
	return flag;
}
}
