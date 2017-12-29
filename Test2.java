import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Test2 {

	static int checkBal(int start,int middle,int last,int[] B){
		int sumStart=0;
		int sumEnd=0;
		for(int w=start;w<middle;w++){
			sumStart+=B[w];
		}
		for(int w=middle+1;w<last;w++){
			sumEnd+=B[w];
		}
		if(sumStart==sumEnd){
		  return middle+1;	
		} else {
			return -1; 	
		}
	}
	
	static int balanceSum(int[] A) {
		
        if(A==null || A.length<1 ){
			return -1;
		}
        
		int len = A.length;

		for(int i =1;i<len;i++){
			if(i!=0){
				int val =checkBal(0,i,len,A);
				if(val!=-1){
					return val;
				}
			}
		}
		return -1;
		
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] A={3,1,3,1};
		System.out.println(balanceSum(A));
		
	}*/
	
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName =  "D:\\workspaces\\2016\\may19_Shopsmall\\Test\\src\\output.txt";//System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        
        int _A_size = 0;
        _A_size = Integer.parseInt(in.nextLine().trim());
        int[] _A = new int[_A_size];
        int _A_item;
        for(int _A_i = 0; _A_i < _A_size; _A_i++) {
            _A_item = Integer.parseInt(in.nextLine().trim());
            _A[_A_i] = _A_item;
        }
        
        res = balanceSum(_A);
        bw.write(String.valueOf(res));
        bw.newLine();
        
        bw.close();
    }
	

}
