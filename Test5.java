
public class Test5 {
	
	static String merge(String a, String b){
	   char[] strA=a.toCharArray();
	   char[] strB = b.toCharArray();
	   int lenA=a.length();
	   int lenB=b.length();
	   StringBuilder sb = new StringBuilder(lenA+lenB);
	   int len = lenA>lenB?lenA:lenB;
	   //abc de
	   for(int i=0;i<len;i++){
		   if(lenA>i){
		     sb.append(strA[i]);
		   }
		   if(lenB>i){
			 sb.append(strB[i]);
		   }
	   }
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(merge("abceee","defghi"));
       String str="ERROR: NEMO | Backend SOLR Error ";
       System.out.println(str.replace("|", "#"));
	}
}
