package com.u4f.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil
{

	  public  static void main(String[] args)  
	{
		  String res = addMins(StringToDate("2015-02-29 13:9:30"), 0);
		  System.out.println(res);
	}
	  
	 public static String addMins(Date now,int mins )
	{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.MINUTE,mins);
		return sdf.format(cal.getTime());   	
	}
	 
    /**
    * 
    * @return eg:2015-01-01 01:01:01
    */
	public static String getNowTime()
	{
		java.util.Date utilDate = new java.util.Date();  
		java.sql.Date nowDay = new java.sql.Date(utilDate.getTime());  
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(nowDay);  
	}
	
	 /**
	   * 
	   * @return eg:2015-01-01
	   */
	public static String getNowTimeWithoutHourAndMin()
	{
		java.util.Date utilDate = new java.util.Date();  
		java.sql.Date nowDay = new java.sql.Date(utilDate.getTime());  
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(nowDay)+" ";  
	}
	
	/**
	 * 
	 * @param last 前一个日期
	 * @param now  后一个日期
	 * @return 两个日期相差的天数
	 */
	public static String daysBetween(Date last,Date now)
	{
		if(last != null)
		{
			Calendar cal = Calendar.getInstance();
			cal.setTime(last);
			long lastTime = cal.getTimeInMillis();
			cal.setTime(now);
			long nowTime = cal.getTimeInMillis();       
	        long between_days=(nowTime - lastTime) / ( 1000 * 3600 * 24 );  
	        return String.valueOf(between_days); 
		}
		else
		{
			return "0";
		}
		
	}
	
	/**
	 * 
	 * @param last 前一个日期
	 * @param now  后一个日期
	 * @return 两个日期相差的分钟数
	 */
	public static long MinuteBetween(Date last,Date now)
	{
		if(last != null)
		{
			Calendar cal = Calendar.getInstance();
			cal.setTime(last);
			long lastTime = cal.getTimeInMillis();
			cal.setTime(now);
			long nowTime = cal.getTimeInMillis();       
	        long between_mins=(nowTime - lastTime) / ( 1000 * 60 );  
	        return between_mins; 
		}
		else
		{
			return 0l;
		}
		
	}
	
	
	/**
	 * @param dataStr eg:2015-10-01
	 * @return Date eg:Thu Oct 01 16:46:18 CST 2015
	 */
	public static Date StringToDateWithoutHour(String dataStr)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		Date temp = null;
		try
		{
			temp = sdf.parse(dataStr);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return temp;  
	}
	
	/**
	 * @param dataStr eg:2015-10-01
	 * @return Date eg:Thu Oct 01 16:46:18 CST 2015
	 */
	public static Date StringToDate(String dataStr)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		Date temp = null;
		try
		{
			temp = sdf.parse(dataStr);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return temp;  
	}
	
	/**
	 * @param Date eg:Thu Oct 01 16:46:18 CST 2015
	 * @return String eg:2015-10-01 12:39:52
	 */
	public static String DateToString(Date date)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		return sdf.format(date); 
	}
	
	/**
	 * @param Date eg:Thu Oct 01 16:46:18 CST 2015
	 * @return String eg:2015-10-01 
	 */
	public static String DateToStringNoHour(Date date)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		return sdf.format(date); 
	}
	
	
	public static String DateToStringNoMinute(Date date)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		return sdf.format(date); 
	}
	
	
	
	
	public static String getDateOnlyYearMonthDay(String dataStr)
	{
		String res = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		Date temp = null;
		try
		{
			temp = sdf.parse(dataStr);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		res = sdf.format(temp);
		return res;  
	}
}
