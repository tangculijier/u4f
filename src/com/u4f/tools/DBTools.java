package com.u4f.tools;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.u4f.model.Facility;
import com.u4f.model.ScenerySpot;
import com.u4f.model.TravelNote;
import com.u4f.model.User;

	
public class DBTools
{
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	private static final String DataBase_NAME = "travel";
	private static final String DataBase_USER = "root";
	private static final String DataBase_PASSWORD = "";

	public static Connection getConn()
	{
		try
		{

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DataBase_NAME, DataBase_USER,DataBase_PASSWORD);
			System.out.println("连接数据库成功");
		} catch (Exception se)
		{
			System.out.println("fail");
			se.printStackTrace();
		}
		return conn;
	}


	public static void close()
	{

		if (conn != null)
		{
			try
			{
				conn.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if (ps != null)
		{
			try
			{
				ps.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if (rs != null)
		{
			try
			{
				rs.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public static List<ScenerySpot> getAllScenerySpot()
	{
		if(conn == null)
		{
			conn = getConn();
		}
		List<ScenerySpot> spots  = new ArrayList<ScenerySpot>();
		String sql = "select * from ScenerySpot where ScenerySpotLat>34.2566";
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
			close();
		}
		return spots;
	}
	
	/**
	 * 根据当前位置得到所有的附近景点信息
	 */
	
	public static List<ScenerySpot>  getNearScenerySpot(Double latitude, Double longtitude, String sql)
	{
		List<ScenerySpot> spots = new ArrayList<ScenerySpot>();
		
	
		try
		{
			conn = getConn();
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
				String scenerySpotPicture=rs.getString("ScenerySpotPicture");

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
				spot.setScenerySpotPicture(scenerySpotPicture);
				// String la=spot.getScenerySpotLat()+"";
				// String lb=spot.getScenerySpotLong()+"";
				String distance =MapDistance.getDistance(
						latitude + "", longtitude + "",
						spot.getScenerySpotLat() + "",
						spot.getScenerySpotLong() + "");
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
			close();

		}
		return spots;
	}
	
	
	/**
	 * 根据景点id返回所有攻略信息
	 */
	public static List<TravelNote> getTravelNote(int scenerySpotId)
	{
		String sql="select user.userId,user.username,user.level,travelNote.travelNoteId,travelNote.userId,travelNote.travelNoteTitle," +
				"travelNote.travelNoteContent,DATE_FORMAT(travelNote.publicTime,'%Y-%m-%d') as time" +
				" from user,travelNote " +
		"where user.userId=travelNote.userId and travelNoteId in(select travelNoteId from travelNote where ScenerySpotId="+scenerySpotId+")";
		System.out.println(sql);
		
		List<TravelNote> notes  = new ArrayList<TravelNote>();
		try
		{
			conn = getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next())
			{
				TravelNote note=new TravelNote();
				
				int travelNoteId = rs.getInt("travelNote.travelNoteId");
				String travelNoteTitle=rs.getString("travelNote.travelNoteTitle");
				String travelNoteContent=rs.getString("travelNote.travelNoteContent");
				String publicTime=rs.getString("time");
				note.setTravelNoteId(travelNoteId);
				note.setScenerySpotId(scenerySpotId);
				note.setTravelNoteTitle(travelNoteTitle);
				note.setTravelNoteContent(travelNoteContent);
				note.setPublicTime(publicTime);
				
				int userId=rs.getInt("userId");
				int level=rs.getInt("user.level");
				String userName=rs.getString("user.username");	
				User user=new User();
				user.setUserId(userId);
				user.setLevel(level);
				user.setUsername(userName);
				note.setUser(user);
				
				List<String> photos = getPhotosByTravelNoteId(travelNoteId);
				
				note.setTravelPhotos(photos);
				
				notes.add(note);
			}
			

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			close();
		}
		return notes;
	}
	
	/**
	 * 根据攻略的id返回攻略所有的图片
	 */
	public static List<String> getPhotosByTravelNoteId(int travelNoteId)
	{
		List<String> photos = new ArrayList<String>();
		String sql = "select image from travelPhoto where travelNoteId="+ travelNoteId;
		System.out.println(sql);
		try
		{
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				String image = rs.getString("image");
				photos.add(image);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			//DBTools.close();
		}
		return photos;
	}

    // 上传攻略
	public static void insertTravelNote(TravelNote note)
	{
		String sql="insert into travelNote(userId,travelNoteTitle,travelNoteContent,publicTime,scenerySpotId) values(?,?,?,?,?)";
		System.out.println(sql);
		try{
			conn=getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, note.getUserId());
			ps.setString(2, note.getTravelNoteTitle());
			ps.setString(3, note.getTravelNoteContent());
			ps.setString(4, note.getPublicTime());
			ps.setInt(5, note.getScenerySpotId());
			System.out.println(sql);
			ps.execute();
			System.out.println("upload success!");
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			close();
		}
	}

   //根据用户名查找用户
	public static User findUserById(int userId)
	{
		String sql="select * from user where userId="+userId;
		User user=new User();
		try
		{
			conn = getConn();
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user.setLevel(rs.getInt("level"));
				user.setUsername(rs.getString("username"));
			}		
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			close();
		}	
		
		return user;
	}


	public static List<Facility> findFacilitys(int id, int type)
	{
		String sql="select * from facility where scenerySpotId="+id+" and facilityType="+type;
		System.out.println(sql);
		List<Facility> list=new ArrayList<Facility>();
		conn=getConn();
		try{
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				int facilityId=rs.getInt("facilityId");
				String facilityName=rs.getString("facilityName");
				double facilityLng=rs.getDouble("facilityLng");
			   double facilityLati=rs.getDouble("facilityLati");
			   
			   Facility f=new Facility();
			   f.setFacilityId(facilityId);
			   f.setFacilityName(facilityName);
			   f.setFacilityLng(facilityLng);
			   f.setFacilityLati(facilityLati);
			   f.setFacilityType(type);
			   f.setScenerySpotId(id);
			   list.add(f);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
		
		return list;
	}

}
