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
	// ScenerySpotDao dao=new ScenerySpotDao ();
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	public List<ScenerySpot> getAllScenerySpot()
	{
		ScenerySpotDao dao = new ScenerySpotDao();
		String sql = "select * from ScenerySpot where ScenerySpotLat>34.2566";// and
																				// ScenerySpotLat<34.256700002761306
		conn = DBTools.getConn(conn);
		List<ScenerySpot> spots = new ArrayList<ScenerySpot>();
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next())
			{
				int id = rs.getInt("ScenerySpotId");
				String name = rs.getString("ScenerySpotName");
				String adress = rs.getString("ScenerySpotAddress");
				double scenerySpotLat = rs.getDouble("ScenerySpotLat");
				double scenerySpotLong = rs.getDouble("ScenerySpotLong");
				int belongCityId = rs.getInt("belongCityId");
				String scenerySpotTicket = rs.getString("ScenerySpotTicket");
				String scenerySpotTrans = rs.getString("ScenerySpotTrans");
				String scenerySpotLab1 = rs.getString("ScenerySpotLab1");
				String scenerySpotLab2 = rs.getString("ScenerySpotLab2");
				String scenerySpotLab3 = rs.getString("ScenerySpotLab3");
				// String ScenerySpotPicture=rs.getString("");

				ScenerySpot spot = new ScenerySpot();
				spot.setBelongCityId(belongCityId);
				spot.setScenerySpotAddress(adress);
				spot.setBelongCityId(belongCityId);
				spot.setScenerySpotId(id);
				spot.setScenerySpotLab1(scenerySpotLab1);
				spot.setScenerySpotLab2(scenerySpotLab2);
				spot.setScenerySpotLab3(scenerySpotLab3);
				spot.setScenerySpotTicket(scenerySpotTicket);
				spot.setScenerySpotLat(scenerySpotLat);
				spot.setScenerySpotLong(scenerySpotLong);
				spot.setScenerySpotName(name);
				spot.setScenerySpotTrans(scenerySpotTrans);

				spots.add(spot);

			}

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			DBTools.closeConn(conn);
			DBTools.close(rs);
			DBTools.close(ps);

		}
		return spots;

	}

	public List<ScenerySpot> getNearScenerySpot(Double latitude,
			Double longtitude)
	{
		
		String raidus = "1000";

		List<ScenerySpot> spots = new ArrayList<ScenerySpot>();

		Map<String, String> map = new HashMap<String, String>();
		String lati = latitude + "";
		String longti = longtitude + "";
		map = MapDistance.getAround(lati, longti, raidus);

		double minLat = MapDistance.take_effect_number(Double.parseDouble(map
				.get("minLat")));
		double maxLat = MapDistance.take_effect_number(Double.parseDouble(map
				.get("maxLat")));
		double minLong = MapDistance.take_effect_number(Double.parseDouble(map
				.get("minLng")));
		double maxLong = MapDistance.take_effect_number(Double.parseDouble(map
				.get("maxLng")));

		System.out.println("minlat:" + minLat + ",maxLat:" + maxLat
				+ ",minLong:" + minLong + ",maxLng:" + maxLong);

		conn = DBTools.getConn(conn);
		// String
		// sql="select * from ScenerySpot where ScenerySpotLat between ? and ? and ScenerySpotLong between ? and ? ";
		String sql = "select * from ScenerySpot where ScenerySpotLat between "
				+ minLat + " and " + maxLat + " and ScenerySpotLong between "
				+ minLong + " and " + maxLong;
		System.out.println(sql);

		try
		{
			System.out.println("aaa");
			ps = conn.prepareStatement(sql);
			System.out.println("bbb");
			rs = ps.executeQuery();
			System.out.println("rs=" + rs);
			while (rs.next())
			{
				// System.out.println("bbb");
				int id = rs.getInt("ScenerySpotId");
				String name = rs.getString("ScenerySpotName");
				String adress = rs.getString("ScenerySpotAddress");
				double scenerySpotLat = rs.getDouble("ScenerySpotLat");
				double scenerySpotLong = rs.getDouble("ScenerySpotLong");
				int belongCityId = rs.getInt("belongCityId");
				String scenerySpotTicket = rs.getString("ScenerySpotTicket");
				String scenerySpotTrans = rs.getString("ScenerySpotTrans");
				String scenerySpotLab1 = rs.getString("ScenerySpotLab1");
				String scenerySpotLab2 = rs.getString("ScenerySpotLab2");
				String scenerySpotLab3 = rs.getString("ScenerySpotLab3");
				// String ScenerySpotPicture=rs.getString("");

				ScenerySpot spot = new ScenerySpot();
				spot.setBelongCityId(belongCityId);
				spot.setScenerySpotAddress(adress);
				spot.setBelongCityId(belongCityId);
				spot.setScenerySpotId(id);
				spot.setScenerySpotLab1(scenerySpotLab1);
				spot.setScenerySpotLab2(scenerySpotLab2);
				spot.setScenerySpotLab3(scenerySpotLab3);
				spot.setScenerySpotTicket(scenerySpotTicket);
				spot.setScenerySpotLat(scenerySpotLat);
				spot.setScenerySpotLong(scenerySpotLong);
				spot.setScenerySpotName(name);
				spot.setScenerySpotTrans(scenerySpotTrans);

				// String la=spot.getScenerySpotLat()+"";
				// String lb=spot.getScenerySpotLong()+"";
				double distance = Double.parseDouble(MapDistance.getDistance(
						latitude + "", longtitude + "",
						spot.getScenerySpotLat() + "",
						spot.getScenerySpotLong() + ""));
				System.out.println("distance:" + distance);
				spot.setScenerySpotDistance(distance);
				spots.add(spot);
				System.out.println("ccc");
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			DBTools.closeConn(conn);
			DBTools.close(rs);
			DBTools.close(ps);

		}
		return spots;
	}

	public List<TravelNote> getTravelNote(int ScenerySpotId)
	{
		List<TravelNote> notes = new ArrayList<TravelNote>();
		ScenerySpotDao dao = new ScenerySpotDao();
		conn = DBTools.getConn(conn);
		String sql = "select * from travelNote where scenerySpotId="
				+ ScenerySpotId;
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next())
			{
				int travelNoteId = rs.getInt("travelNoteId");
				int userId=rs.getInt("userId");
				String travelNoteTitle=rs.getString("travelNoteTitle");
				String travelNoteContent=rs.getString("travelNoteContent");
				Timestamp publicTime=rs.getTimestamp("publicTime");
				TravelNote note=new TravelNote();
				
				note.setTravelNoteId(travelNoteId);
				note.setUserId(userId);
				note.setTravelNoteTitle(travelNoteTitle);
				note.setTravelNoteContent(travelNoteContent);
				note.setPublicTime(publicTime);
				
				note.setTravelPhotos(dao.getPhotos(note.getTravelNoteId()));
				notes.add(note);
				
			}
			

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			DBTools.closeConn(conn);
			DBTools.close(rs);
			DBTools.close(ps);
		}
		return notes;
	}
	
	public List<Blob> getPhotos(int travelNoteId)
	{
		List<Blob> photos = new ArrayList<Blob>();
		String sql = "select image from travelPhoto where travelNoteId="
				+ travelNoteId;
		conn = DBTools.getConn(conn);
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next())
			{
				Blob image = rs.getBlob("image");
				photos.add(image);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			DBTools.closeConn(conn);
			DBTools.close(rs);
			DBTools.close(ps);

		}
		return photos;
	}

}
