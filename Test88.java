import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Test88 {
	
	private static final ThreadLocal<DateFormat> THREAD_LOCAL_DATEFORMAT = new ThreadLocal<DateFormat>() {
	    protected DateFormat initialValue() {
	        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    }
	};

	public static void main(String[] args) {
		
		String[] arr = {null,null,null};
		if(arr!=null){
			System.out.println("Hi");
		}
		
		// TODO Auto-generated method stub
         /*Float arr[]= GeoUtils.getBoundingBox(37.028081F,-84.6262351F,5F,true);
         System.out.println(arr[0]+" - "+arr[1]+" - "+arr[2]+" - "+arr[3]);
         
         DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

         long now = System.currentTimeMillis();

         Calendar calendar = Calendar.getInstance();
         calendar.setTimeInMillis(now);

         System.out.println(now + " = " + formatter.format(calendar.getTime()));
         */
         
         DateFormat formatter = THREAD_LOCAL_DATEFORMAT.get();
         long now = System.currentTimeMillis();
         Calendar calendar = Calendar.getInstance();
         calendar.setTimeInMillis(0);
         System.out.println(now + " = " + formatter.format(calendar.getTime()));
         
         
	}

}
