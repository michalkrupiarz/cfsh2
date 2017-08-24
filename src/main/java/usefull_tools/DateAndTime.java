package usefull_tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateAndTime {
	public String getCurrentDateAndTimeForDBQuerrys() {
		Calendar currDate = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dateToCheck = format.format(currDate.getTime());
		return dateToCheck;
	}
	public String getCurrentDateForDBQuerrys() {
		Calendar currDate = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateToCheck = format.format(currDate.getTime());
		return dateToCheck;
	}
	public String getDateEalier(int days) {
		Calendar currDate = Calendar.getInstance();
		currDate.add(Calendar.DATE, -days);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateToCheck = format.format(currDate.getTime());
		return dateToCheck;
	}
	public String getDateFurther(int days) {
		Calendar currDate = Calendar.getInstance();
		currDate.add(Calendar.DATE, days);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateToCheck = format.format(currDate.getTime());
		return dateToCheck;
	}
	public Calendar getCurrentDateAndTimeForDBQuerrysAsCalendar() {
		return Calendar.getInstance();
	}
}
