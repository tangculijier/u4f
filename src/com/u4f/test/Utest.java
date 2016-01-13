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
	@Test
	public void testDistance(){
		System.out.println("DSD");
		String lat1="34.249385";
		String lat2="34.257119";
		String long1="108.993403";
		String long2="108.989982";
		String str=MapDistance.getDistance(lat1, long1, lat2, long2);
		System.out.println(str);
	}
}
