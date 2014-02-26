package com.withparadox2.grayhours.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by withparadox2 on 14-2-20.
 */
public class Util {


	public static int dip2px(int dipValue) {
		float reSize = GlobalContext.getInstance().getResources().getDisplayMetrics().density;
		return (int) ((dipValue * reSize) + 0.5);
	}

	public static int px2dip(int pxValue) {
		float reSize = GlobalContext.getInstance().getResources().getDisplayMetrics().density;
		return (int) ((pxValue / reSize) + 0.5);
	}

	public static float sp2px(int spValue) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue,
			GlobalContext.getInstance().getResources().getDisplayMetrics());
	}

	public static String getCurrentDate(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(calendar.getTime());
	}

	public static String convertSecondsToMinuteHourString(int time){
		StringBuilder formatTimeStringBuilder = new StringBuilder();
		int seconds = time % 60;
		int minutes = time / 60;
		int hours = minutes / 60;
		minutes = minutes % 60;
		formatTimeStringBuilder.append(formatNumLessThanTen(hours))
				.append(":")
				.append(formatNumLessThanTen(minutes))
				.append(":")
				.append(formatNumLessThanTen(seconds));
		return formatTimeStringBuilder.toString();
	}

	public static String formatNumLessThanTen(int num){
		return num < 10 ? "0" + num : String.valueOf(num);
	}

	public static String convertSecondsToHours(int seconds){
		int minutes = seconds/60;
		if(minutes/60 < 1){
			return String.valueOf(minutes) + "'";
		}
		return String.valueOf(minutes/60) + "h" + String.valueOf(minutes%60) + "m";
	}



}