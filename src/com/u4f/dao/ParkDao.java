package com.u4f.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.u4f.model.Park;
import com.u4f.tools.MapDistance;

public class ParkDao
{

	public List<Park> getAllScenerySpotDAO()
	{
		ParkDao dao = new ParkDao();
		List<Park> spots = DBTools.getAllScenerySpot();
		return spots;	

	}

	public List<Park> getNearScenerySpotDao(Double latitude,Double longtitude)
	{
		
		String raidus = "2000000";

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
//		String sql = "select * from park where parkLat between "
//				+ minLat + " and " + maxLat + " and parkLng between "
//				+ minLong + " and " + maxLong;
		String sql = "select park.*,parkopentime.* from park, parkopentime where park.parkId=parkopentime.parkId and park.parkLat between "
				+ minLat + " and " + maxLat + " and park.parkLng between "
				+ minLong + " and " + maxLong;
		
		System.out.println(sql);
		
		List<Park> spots = 	DBTools.getNearPark(latitude,longtitude,sql);
	
	
		return spots;
	}

}