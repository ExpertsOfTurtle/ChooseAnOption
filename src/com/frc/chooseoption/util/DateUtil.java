package com.frc.chooseoption.util;

import java.text.SimpleDateFormat;
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
	
}
