package deb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Rajat {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] ={1456,213,345671,43218,-123};
		String result = findQualifiedNumbers(arr);
		//String result = patterNumbers("MNM");
          System.out.println(result);
	}
	
	static String findQualifiedNumbers(int[] num){
		System.out.println("Num = "+ num.length);
		if(null!=num && num.length!=0) {
			Arrays.sort(num);
		List<String> result = new ArrayList<String>();
		int len = num.length;
		for(int i =0 ;i<len;i++){
			String str =  String.valueOf(num[i]);
			if(str.contains("1")  && str.contains("2") && str.contains("3")){
				result.add(str);
			}
		}

		if(null!=result && result.size()>0){
			Collections.sort(result);
			Iterator itr=result.iterator();
			String numberStr="";
			int cout=0;
			while(itr.hasNext()){
				
				if(cout==0){
					numberStr=numberStr+itr.next();
				}
				else{
					numberStr=numberStr+","+itr.next();
				}
				cout++;
			}
			return numberStr;
		} else {
			return "-1";
		}
		} else {
			return "-1";
		}
		
	}
	
	static String mVal = "21";
	static String nVal = "12";
	
	static int patterNumbers(String pattern){
		char[] array = pattern.toCharArray();
		//List<Integer> result = new ArrayList<Integer>();
		String str  = "";
		int len = array.length;
		int small =0;
		int large =0;
		String strSmall="";
		String strLarge ="";
		int num = -1;
		int j =len+1;
		for(int i=1;i<=len+1;i++){
			strSmall=strSmall+i;
			strLarge=strLarge+j;
			j--;
		}
		small = Integer.parseInt(strSmall);
		large = Integer.parseInt(strLarge);
		
		System.out.println(small+"  "+large);
		
		/*char temp[] = new char[pattern.length()];
		
		for(int k=0; k<pattern.length(); k++){
			if(pattern.charAt(k)=='M'){ //Descending
				temp[k] = 'M';
			}else if(pattern.charAt(k)=='N'){ //Ascending
				temp[k] = 'N';
			}
		}*/
		
		char temp[] = pattern.toCharArray();
		
		String result ="";
		boolean flag = false;
		for(int i = small;i<=large;i++){
			flag = false;
			char[] numArray = String.valueOf(i).toCharArray();
			Set<Integer> set = new HashSet<Integer>();
			for(int p=0;p<len+1;p++){
				set.add(numArray[p]-'0');
			}
			if(set.size()==len+1  && !String.valueOf(i).contains("0")){
			for(int w=0;w<len;w++){
				if( (temp[w]=='M' && ((numArray[w] -'0') > (numArray[w+1] -'0'))) ||
				(temp[w]=='N' && ((numArray[w] -'0') < (numArray[w+1] -'0'))) ){
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				num =i;
				System.out.println("Found = "+i);
				break;
			}
			}
		}
		
		if(!flag) {
			System.out.println("Number not Found ");
		}
		
		
		
		return num;
	}
	
	

}
