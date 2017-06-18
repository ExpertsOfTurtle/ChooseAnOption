package com.frc.chooseoption.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static final String DATE_PATTERN = "yyyyMMdd";
	public static final String TIME_PATTERN = "HHmmss";
	public static final String DATETIME_PATTERN = "yyyyMMddHHmmss";
	public static String getDateTime(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String rs = sdf.format(new Date());
		return rs;
	}
	public static String getTodayDate() {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		String rs = sdf.format(new Date());
		return rs;
	}
	public static String getNowTime() {
		SimpleDateFormat sdf = new SimpleDateFormat(TIME_PATTERN);
		String rs = sdf.format(new Date());
		return rs;
	}
	
	public static String getRequestDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		String rs = sdf.format(new Date());
		return rs;
	}
	public static String getDateAfterToday(long day) {
		long todayLong = new Date().getTime();
		todayLong += day * 24 * 60 * 60 * 1000;
		Date date = new Date(todayLong);
		SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_PATTERN);
		String rs = sdf.format(date);
		return rs;
	}
	public static String getSundayOfThisWeek() {
		Calendar c = Calendar.getInstance();
		int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0){
			day_of_week = 7;
		}
		c.add(Calendar.DATE, -day_of_week + 7);
		//  return df2.format(c.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		String rs = sdf.format(c.getTime());
		return rs;
	}
	
	public static String getDateAfterYear() {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR,1);
		String rs = sdf.format(c.getTime());
		return rs;
	}
	
}
