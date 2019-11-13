package util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Validation {

	public static boolean validDate(String date, String format)
	{
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate.parse(date, dtf);
			return true;
		}
		catch(Exception e) {
			return false;
		}

	}
	
	public static boolean validNumeric(String number)
	{
		try {
			double no = Double.parseDouble(number);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
}
