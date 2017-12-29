import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ProductMatchingFinal {
	public static Set<String> ss= new HashSet<String>();
    static int max=0; 
    static Map<Integer,String> mp = new LinkedHashMap<Integer,String>();
    static Map<Integer,String> productMap = new LinkedHashMap<Integer,String>();
    static Map<Integer,String> customerMap = new LinkedHashMap<Integer,String>();
	public static String matching(String input1) {
		int prodCounter = -1;
		if(input1!=null && input1.length()>0) {
			Matcher m = Pattern.compile("\\((.*?)\\)").matcher(input1);
			while(m.find()) {
			    System.out.println(m.group(1));
			    String str = m.group(1);
			    String[] loc=str.split(",");
			    for(int i=0;i<loc.length;i++){
			    	String prod=loc[i].split("-")[0];
			    	if(!productMap.isEmpty() && productMap.containsValue(prod)){
			    		;
			    	} else {
			    		prodCounter++;
			    		productMap.put(prodCounter, prod);
			    	}
			    }
			}	
		//Generate data in 2d array
		String[] arr = input1.split("\\)");
		int numCust=arr.length;
		int[][] arrVal = new int[numCust][prodCounter+1];
		for(int i=0;i<numCust;i++){
			if(arr[i].split("\\(").length==2){
				customerMap.put(i, arr[i].split("\\(")[0]);
				String[] strSp = arr[i].split("\\(")[1].split(",");
				for(int j=0;j<strSp.length;j++){
					String[] subStr = strSp[j].split("-");
					////////////////////////
					int key =0;
					for (Map.Entry<Integer,String> entry : productMap.entrySet()) {
					    if(subStr[0].equals(entry.getValue())){
					    	key = Integer.valueOf(entry.getKey());
					    	break;
					    }
					}
					int prodIdVal = key;
					int like = Integer.parseInt(subStr[1]);
					if(like>0 && like<=10){
					   arrVal[i][prodIdVal] = like;
					} else {
						System.out.println("Matching not possible");
						return "Matching not possible";			
					}
					///////////////////////////
				}
			} else {
				System.out.println("Matching not possible");
				return "Matching not possible";	
			}
		}
		//Call method
		int counter =0;
		for(int i=0;i<numCust;i++){
       	    for(int j=0;j<(prodCounter+1);j++){
       		    if(arrVal[i][j]!=0){
        		   counter = calculate(arrVal,i,j,numCust,(prodCounter+1))==1?++counter:counter;
       		    }
       	    }
        }
		String output ="";
		if(counter==0){
			System.out.println("Matching not possible");
			output = "Matching not possible";
		} else {
			String temp1="";
			int countVal =0;
			Iterator<String> st = ss.iterator();
	        while(st.hasNext()){
	        	output=st.next();
	        	if(output.indexOf(max+"_")!=-1){
	        		if(countVal==0){
	        			temp1= temp1+output+"#";
	        			countVal++;
	        		} else {
	        			countVal++;
	        			temp1= temp1+countVal+output.substring(output.indexOf("_")+1)+"#";	        			
	        		}
	        	}
	        }
	        temp1=temp1.trim();
	        temp1=temp1.replace("_","");
	        output=temp1.substring(0,temp1.length()-1);
	        System.out.println(output);
		}
		return output;
	  }
		return "Matching not possible";
    }
	
	public static int calculate(int org[][], int x,int y,int numCust,int prodCounterVal){
		int arr[][] = new int[numCust][prodCounterVal];
		for(int i=0;i<numCust;i++){
			for(int j =0;j<prodCounterVal;j++){
			    arr[i][j]=org[i][j];
			}
		}
		// Fill the row with zero
		 for(int w=0;w<prodCounterVal;w++){
			 if(y!=w){
			   arr[x][w]=0;
			 }
		 }
		 // Fill the column with zero
		 for(int w=0;w<numCust;w++){
			 if(x!=w){
			   arr[w][y]=0;
			 }
	     }
		int count=0;
		int arrcopy[][] = new int[numCust][prodCounterVal];
		arrcopy[x][y]= arr[x][y];
		for(int i=0;i<numCust;i++){
	       	 for(int j=0;j<prodCounterVal;j++){
	       		 if(arr[i][j]!=0){
	       			arrcopy[i][j]= arr[i][j];
	       		    count++;
	       			// Fill the row with zero
	   			     for(int w=0;w<prodCounterVal;w++){
	      				 if(j!=w){
	      				   arr[i][w]=0;
	      				 }
	      			 }
	   			     // Fill the column with zero
	   			     for(int w=0;w<numCust;w++){
	      				 if(i!=w){
	      				   arr[w][j]=0;
	      				 }
	      			 }
	       			 break;
	       		 }
	       	 }
        }
		int sum =0;
		int flagVal=0;
		if(count==numCust){
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<numCust;i++){
				for(int j =0;j<prodCounterVal;j++){
					if(arrcopy[i][j]!=0){
						sb.append("("+customerMap.get(i)+","+productMap.get(j)+")");
					  sum+=arrcopy[i][j];
					}
				}
			}
			if(max<sum){
			   max=sum;
			}
			sb.insert(0,sum+"_");
			ss.add(sb.toString());
			flagVal=1;
		}
		return flagVal;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String str=
		//C1(P2-5,P4-3)C2(P1-4,P2-6)C3(P1-7,P3-5,P4-6)C4(P4-10,P5-5)C5(P4-9,P5-3)
		//C1(P1-5,P2-5,P3-5)C2(P1-6,P2-6,P3-6)C3(P1-7,P2-7,P3-7)
		//matching("C1(P2-5,P4-3)C2(P1-4,P2-6)C3(P1-7,P3-5,P4-6)C4(P4-10,P5-5)C5(P4-9,P5-3)");
		//C1(P2-5,P4-3)C2(P1-4,P2-6)C3(P1-7,P3-5,P4-6)C4(P4-10,P5-5)C5()
		//C1(P4-5,P5-5,P6-5)C2(P4-6,P5-6,P6-6)C3(P4-7,P5-7,P6-7)
		matching("C1(P4-5,P10-5)C2(P4-6)C3()");
	}
}
