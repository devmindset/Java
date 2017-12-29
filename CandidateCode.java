import java.util.ArrayList;
import java.util.List;


public class CandidateCode {

    public static int cadbury(int input1,int input2,int input3,int input4)
    {
    	List<String> strList = new ArrayList<String>();  
    	for(int i=input1;i<=input2;i++){
    		for(int j=input3;j<=input4;j++){
    			strList.add(i+","+j);
    		}
    	}
    	for(String str:strList){
    		String[] val = str.split(",");
    		int val2 = countStudent(Integer.parseInt(val[0]),Integer.parseInt(val[1]));
    		System.out.println(" Length = "+val[0]+" - Breadth = "+val[1] +" - "+val2);
    	}
    	return 0;
    }
   static int stuCount=0;
    public static int countStudent(int length,int breadth){
    	if(length>breadth){
    		length=length-breadth;
    		stuCount++;
    		countStudent(length,breadth);
    	}else if(length<breadth){
    		breadth=breadth-length;
    		stuCount++;
    		countStudent(length,breadth);
    	}else if(length==breadth){
    		stuCount++;
    	}
    	return stuCount;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		cadbury(5,6,3,4);
	}

}
