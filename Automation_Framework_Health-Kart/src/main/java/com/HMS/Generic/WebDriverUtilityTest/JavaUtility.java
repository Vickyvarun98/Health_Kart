package com.HMS.Generic.WebDriverUtilityTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int generateRandomNumber(int num) {
		Random r = new Random();
		int randnum = r.nextInt(num);
		return randnum;
	}

	public int generateRandomNumber() {
		Random r = new Random();
		int randnum = r.nextInt(100);
		return randnum;
	}

	public String getCurrentDate() {
		Date d = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String CurrentDate = sim.format(d);
		return CurrentDate;
	}

	public String getCurrentDate(String format) {
		Date d = new Date();
		SimpleDateFormat sim = new SimpleDateFormat(format);
		String CurrentDate = sim.format(d);
		return CurrentDate;
	}

	public String getRequiredDate(int days) {
		Date d = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		sim.format(d);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String ReqDate = sim.format(cal.getTime());
		return ReqDate;
	}

	public String getRequiredDate(String format, int days) {
		Date d = new Date();
		SimpleDateFormat sim = new SimpleDateFormat(format);
		sim.format(d);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String ReqDate = sim.format(cal.getTime());
		return ReqDate;
	}

	public String getRequiredDate() {
		Date d = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		sim.format(d);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String ReqDate = sim.format(cal.getTime());
		return ReqDate;
	}

	
	public String getCurrentDatewithTime() {
		Date d = new Date();
		String[] split = d.toString().split(" ");
		String day = split[0];
		String month = split[1];
		String date = split[2];
		String time = split[3].replace(":", "-");
		String standard = split[4];
		String year = split[5];
		
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String CurrentDate = sim.format(d);
		return CurrentDate+" "+time;
	}
	public String getTime() {
		Date d = new Date();
		String[] split = d.toString().split(" ");
		String day = split[0];
		String month = split[1];
		String date = split[2];
		String time = split[3].replace(":", ":");
		String standard = split[4];
		String year = split[5];
		
	//	SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		
		return time;
	}

}
