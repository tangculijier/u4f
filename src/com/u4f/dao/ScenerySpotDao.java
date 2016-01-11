package com.u4f.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.u4f.model.ScenerySpot;
import com.u4f.model.TravelNote;
import com.u4f.tools.DBTools;
import com.u4f.tools.MapDistance;

public class ScenerySpotDao
{

	public List<ScenerySpot> getAllScenerySpotDAO()
	{
		ScenerySpotDao dao = new ScenerySpotDao();
		List<ScenerySpot> spots = DBTools.getAllScenerySpot();
		return spots;

				
		

	}

	public List<ScenerySpot> getNearScenerySpotDao(Double latitude,Double longtitude)
	{
		
		String raidus = "1000";

		Map<String, String> map = new HashMap<String, String>();
		String lati = latitude + "";
		String longti = longtitude + "";
		map = MapDistance.getAround(lati, longti, raidus);

		double minLat = MapDistance.take_effect_number(Double.parseDouble(map
				.get("minLat")),6);
		double maxLat = MapDistance.take_effect_number(Double.parseDouble(map
				.get("maxLat")),6);
		double minLong = MapDistance.take_effect_number(Double.parseDouble(map
				.get("minLng")),6);
		double maxLong = MapDistance.take_effect_number(Double.parseDouble(map
				.get("maxLng")),6);

		System.out.println("minlat:" + minLat + ",maxLat:" + maxLat
				+ ",minLong:" + minLong + ",maxLng:" + maxLong);

		// String
		// sql="select * from ScenerySpot where ScenerySpotLat between ? and ? and ScenerySpotLong between ? and ? ";
		String sql = "select * from ScenerySpot where ScenerySpotLat between "
				+ minLat + " and " + maxLat + " and ScenerySpotLong between "
				+ minLong + " and " + maxLong;
		System.out.println(sql);
		
		List<ScenerySpot> spots = 	DBTools.getNearScenerySpot(latitude,longtitude,sql);
	
	
		return spots;
	}

}