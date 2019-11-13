package util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;

public class Validation {

	public static boolean validDate(String date, String format)
	{
	    SimpleDateFormat sdf = new SimpleDateFormat(format);
	    sdf.setLenient(false);
	    return sdf.parse(date, new ParsePosition(0)) != null;
	}
	
	
}
