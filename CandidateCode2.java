import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CandidateCode2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// your code goes here
				int[] integerArray = {2,3,5,6,7};//{ 1, 2, 3, 4, 5, 5, 6 };
				//System.out.println(getMinStones(integerArray, 3));
				System.out.println(ThirstyCrowProblem(integerArray,5,2));
	}
	
	public static int ThirstyCrowProblem(int[] input1,int input2,int input3) {
        int totalNumofPots = input2;
        int numPotsOverflow = input3;
        int tempk = 0;

        if(input1 == null || numPotsOverflow < 0 || numPotsOverflow > input1.length || totalNumofPots <= 0 || input1.length != totalNumofPots) {
            return -1;
        }

        if(numPotsOverflow==0) {
            return 0;
        }

        for(int i = 0; i < totalNumofPots; i++) {
            if(input1[i] < 0) {
                return -1;
            } else if (input1[i] == 0) {
                if(++tempk==numPotsOverflow) {
                    return 0;
                }
            }
        }
        Arrays.sort(input1);
        return minStones(input1,numPotsOverflow-tempk,tempk);
    }


    public static int minStones(int[] input, int k, int start) {
         List<Integer> minStones = new ArrayList<Integer>();
         minStones.add(Integer.MAX_VALUE);
         minStones(input,k,start,0,minStones);
         return minStones.get(0);
    }
    public static void minStones(int[] input, int k,int start, int stones, List<Integer> minStns) {

      if(k==0) {
          if(stones < minStns.get(0)) {
              minStns.set(0, stones);
          }
          return;
      }

      int[] clone = null;
      for(int i = start; i <= input.length-1-(k-1);i++) {
          if(input[i] == 0) {
              continue;
          }
          clone = input.clone();
          //change clone
          int stns = 0;
          int tempk = 0;
          for(int j = clone.length-1; j >= i;j--) {
              if(clone[j] == 0) {
                  continue;
              }
              if(clone[j] <= clone[i]) {
                  stns+=clone[j];
                  clone[j] = 0;
                  if(++tempk == k) {
                      break;
                  } else {
                      continue;
                  }
              }
              stns+=clone[i];
              clone[j] -= clone[i];
          }
          minStones(clone,k-tempk,i,stones+stns,minStns);
      }
    }
	
/*	public static int getMinStones(final int a[], final int k) {

		if ((a.length < k)) {
			return -1;
			}

			Arrays.sort(a);
			int i, last, stones1, stones2,stones, count;
			for (i = k; i < a.length && a[k - 1] == a[i]; i++);
			last = a[i - 1];
			stones1 = 0;
			stones2 = 0;
			for (i = 0; i < k; i++)
			{
			stones1 += a[a.length - 1 - i];
			}
			for (i = 0, count = 0; count < k; i++)
			{
			if ((a[a.length - i - 1] > last) )
			{
			stones2 += last;
			}
			else
			{
			stones2 += a[a.length - i - 1];
			count++;
			}
			}
			stones = Math.min(stones1, stones2);
			return stones;
	}*/
	

}
