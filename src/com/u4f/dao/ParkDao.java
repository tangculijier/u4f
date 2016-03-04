package com.u4f.dao;

import java.util.Collections;
import java.util.Comparator;
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

	public List<Park> getNearScenerySpotDao(Double latitude,Double longtitude, String date)
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
				+ minLong + " and " + maxLong  ;//" and parkopentime.parkDate = '" +date +"'";
		
		System.out.println(sql);
		
		List<Park> spots = 	DBTools.getNearPark(latitude,longtitude,sql);
		Collections.sort(spots, new Comparator<Park>()
				{
					//按照距离排序
					public int compare(Park o1, Park o2)
					{
						//去掉后面Km 暂时没考虑m的情况
						String o1distanceStr = o1.getParkDistance().substring(0,o1.getParkDistance().length()-2);
						String o2distanceStr = o2.getParkDistance().substring(0,o2.getParkDistance().length()-2);

						double o1Distance = Double.parseDouble(o1distanceStr);
						double o2Distance = Double.parseDouble(o2distanceStr);
						return o1Distance > o2Distance ? 1 : -1;
					}
					
				});
	
		return spots;
	}

}