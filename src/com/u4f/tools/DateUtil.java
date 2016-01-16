package com.u4f.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil
{

	public static String getNowTime()
	{
		java.util.Date utilDate = new java.util.Date();  
		java.sql.Date nowDay = new java.sql.Date(utilDate.getTime());  
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(nowDay);  
	}
	
//	public static Date getDate(String time)
//	{
//		//java.util.Date utilDate = new java.util.Date();  
//		//java.util.Date nowD = (Date)time; 
//		Date sdf=null;
//		try
//		{
//			sdf = new SimpleDateFormat("yyyy-MM-dd").parse(time);
//		} catch (ParseException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return sdf;  
//	}
//	
	
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
