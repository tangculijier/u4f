package com.u4f.tools;

import java.text.SimpleDateFormat;

public class DateUtil
{

	public static String getNowTime()
	{
		java.util.Date utilDate = new java.util.Date();  
		java.sql.Date nowDay = new java.sql.Date(utilDate.getTime());  
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(nowDay);  
	}
}
