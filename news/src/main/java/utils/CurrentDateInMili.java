package utils;

import java.util.Date;

public class CurrentDateInMili {
	
	
	public static long getCurrentTime()
	{
	 Date date = new Date();
	 
	 long timeMilli = date.getTime();
	 
	 return timeMilli;
	}
}
