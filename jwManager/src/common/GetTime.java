package common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTime {
		public static String getnowtime(){
			Date d=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");		
			return sdf.format(d);
		}
}
