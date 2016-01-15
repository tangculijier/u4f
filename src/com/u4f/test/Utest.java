package com.u4f.test;

import java.sql.Connection;

import org.junit.Test;

import com.u4f.dao.DBTools;
import com.u4f.tools.MapDistance;

public class Utest {
	static Connection conn=null;
	
	//@Test
	public void testConn(){
	
		conn=DBTools.getConn();
		System.out.println("sss");
		
		
	}
	//@Test
	public void testDistance(){
		System.out.println("DSD");
		String lat1="34.257072";
		String lat2="34.257070";
		String long1="108.990022";
		String long2="108.990020";
		String str=MapDistance.getDistance(lat1, long1, lat2, long2);
		System.out.println(str);
	}
	
	@Test
	public void testA(){
		
		System.out.println("===========os.name:"+System.getProperties().getProperty("os.name")); 
	}
	
	
}
