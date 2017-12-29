/**
 * You have User’s web access pattern in the form of URLs for a specific website. How will you determine whether the user actually backtracked to the home page from some webpage of the website.

So a user is currently accessing the website, hence we are receiving continuous stream of inputs from the user in the form urls

assume “1” is a url, “2” is a url and so on, the patterns can be:

1 2 3 4 5 4 3 2 1 4 5 6 7 ……..
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String str="1 2 1 4 5 4 3 2 1 4 5 6 7";
       List<String> strLst = new LinkedList<String>();
       List<Integer> posLst = new ArrayList<Integer>(); 
       List<String> oneLst= new ArrayList<String>();
       StringTokenizer st = new StringTokenizer(str," ");
       int count =0;
       while(st.hasMoreTokens()){
    	   String val="";
    	   val=st.nextToken();
    	   if(val.equals("1")){
    		   posLst.add(count);
    		   oneLst.add(val);
    		} else {
    			if(oneLst.indexOf("1")==oneLst.lastIndexOf("1")){
    				oneLst.add(val);
    			} else if( oneLst.indexOf("1")!=oneLst.lastIndexOf("1")){
    				checkBackTrack(oneLst);
    				oneLst.clear();
    				oneLst.add("1");
    				oneLst.add(val);
    			}
    		}
    	   count++;
    	   
       }

       int m=7;
       for(int w=m-1, p=1;w>0;w--,p++){
    	   for(int k=0;k<w;k++){
    		   System.out.print(" ");
    	   }
    	   for(int q=0;q<p;q++){
    		   System.out.print("#");
    	   }
    	   System.out.println();
       }
       
       
       
       
       
       
       
       
	}
	
	static void checkBackTrack(List<String> oneLst){
		System.out.println("Inside="+oneLst.toString());
		int leng= oneLst.size();
		int middle=leng/2;
		int start=0;
		int end = leng-1;
		int backFlag=0;
		for(int i=0;i<middle;i++){
			if(oneLst.get(start).equals(oneLst.get(end))){
			  ;	
			} else {
				backFlag=1;
				break;
			}
			start++;
			end--;
		}
		if(backFlag==0){
			System.out.println(oneLst.toString());
		}
	}
	

}
