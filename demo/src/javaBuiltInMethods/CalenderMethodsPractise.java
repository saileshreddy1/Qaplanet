package javaBuiltInMethods;

import java.util.Calendar;

public class CalenderMethodsPractise {

	public static void main(String[] args) 
	{
		
		Calendar cal= Calendar.getInstance();
		
		int date=cal.get(Calendar.DATE);
				
		int month=cal.get(Calendar.MONTH)+1;
				
		int year=cal.get(Calendar.YEAR);
		
		System.out.println(date+"/"+month+"/"+year);
		
		int iDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(iDayOfWeek);
		
		int iDayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(iDayOfMonth);
		
		int iDayOfYeay = cal.get(Calendar.DAY_OF_YEAR);
		System.out.println(iDayOfYeay);
		
		int iHours= cal.get(Calendar.HOUR);
				
		int iMinute = cal.get(Calendar.MINUTE);
				
		int iSeconds = cal.get(Calendar.SECOND);
				
		int iMilliSeconds=cal.get(Calendar.MILLISECOND);
				
		System.out.println(iHours+":"+iMinute+":"+iSeconds+":"+iMilliSeconds);
		
	}

}
