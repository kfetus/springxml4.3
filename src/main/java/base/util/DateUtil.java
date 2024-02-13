package base.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String getNowDateFormat(String format) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(now);
	}
	
	public static void main(String arg[]) {
		System.out.println(getNowDateFormat("YYYY-MM-DD HH:mm:ss"));
	}
}
