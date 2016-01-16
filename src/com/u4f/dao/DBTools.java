package com.u4f.dao;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.u4f.model.Facility;
import com.u4f.model.Scenery;
import com.u4f.model.ScenerySpot;
import com.u4f.model.Signature;
import com.u4f.model.SignedSpot;
import com.u4f.model.TravelNote;
import com.u4f.model.TravelPhoto;
import com.u4f.model.User;
import com.u4f.tools.DateUtil;
import com.u4f.tools.MapDistance;
import com.u4f.tools.SystemUtil;

	
public class DBTools
{
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	private static final String DataBase_NAME = "travel";
	private static final String DataBase_USER = "root";
	
	
	private static final String DataBase_PASSWORD =SystemUtil.getMySqlPwd();

	public static Connection getConn()
	{
		try
		{

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel?useUnicode=true&characterEncoding=utf-8", DataBase_USER,DataBase_PASSWORD);
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
				int id = rs.getInt("scenerySpotId");
				String name = rs.getString("scenerySpotName");
				String adress = rs.getString("scenerySpotAddress");
				double scenerySpotLat = rs.getDouble("scenerySpotLat");
				double scenerySpotLong = rs.getDouble("scenerySpotLong");
				int belongCityId = rs.getInt("belongCityId");
				String scenerySpotTicket = rs.getString("scenerySpotTicket");
				String scenerySpotTrans = rs.getString("scenerySpotTrans");
				String scenerySpotLab1 = rs.getString("scenerySpotLab1");
				String scenerySpotLab2 = rs.getString("scenerySpotLab2");
				String scenerySpotLab3 = rs.getString("scenerySpotLab3");
				String scenerySpotPicture=rs.getString("scenerySpotPicture");

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
	public static boolean insertTravelNote(TravelNote note)
	{
		boolean res = false;
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
			int updateRow  = ps.executeUpdate();
			if(updateRow != 0)
			{
				res = true;
				System.out.println("upload success!");
			}
			else
			{	
				System.out.println("upload falied!");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			close();
		}
		return res;
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

/*
 * 根据类型以及所在景区查找当前景区内的所有餐厅，厕所，商店。
 */
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

/*
 * 在游记中上传照片
 */
	public static boolean insertTravelPhoto(TravelPhoto photo)
	{
		boolean res=false;
		String sql="insert into travelPhoto(travelNoteId,photoName,image) values(?,?,?)";
		System.out.println(sql);
		try{
			conn=getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, photo.getTravelNoteId());
			
			ps.setString(2,photo.getPhotoName());
			ps.setString(3, photo.getImageURL());
			int updateRow=ps.executeUpdate();
			if(updateRow>0){
				res = true;
				System.out.println("upload photo success!");
			}
			else
			{	
				System.out.println("upload photo falied!");
			}
			}catch(Exception e)
			{
				e.printStackTrace();
			}finally{
				close();
			}
		
		return res;
	}

	public static Scenery findSceneryById(int sceneryId){
		
		String sql="select * from scenery where sceneryId="+sceneryId;
		conn=getConn();
		Scenery s=new Scenery();
		try
		{
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				//int sceneRyId=rs.getInt("sceneryId");
				String sceneryName=rs.getString("sceneryName");
				double sceneryLng=Double.parseDouble(rs.getString("sceneryLng"));
				double sceneryLati=Double.parseDouble(rs.getString("sceneryLati"));
				String sceneryDescribe="";
				if(rs.getString("sceneryDescribe")!=null)
				sceneryDescribe=rs.getString("sceneryDescribe");	
				
				
				s.setSceneryDescribe(sceneryDescribe);
				s.setSceneryId(sceneryId);
				s.setSceneryName(sceneryName);
				s.setSceneryLng(sceneryLng);
				s.setSceneryLati(sceneryLati);
				
				
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			close();
		}	
		return s;
	}
/*
 * 判断用户是否在某景点的签到范围内
 */
	public static boolean isInSignScope(double longtitude, double latitude,int sceneryId)
	{
		//设定景点范围距离为100米
		double fixDistance=100;
		boolean res=false;
		Scenery s=findSceneryById(sceneryId);
//	  System.out.println("latitude:"+latitude+",longtitude:"+longtitude);
			double lng2=s.getSceneryLng();
			double lati2=s.getSceneryLati();
	//	System.out.println("lati2:"+lati2+",lng2:"+lng2);
			
		String distance=MapDistance.getDistance(latitude+"", longtitude+"", s.getSceneryLati()+"", s.getSceneryLng()+"");
		System.out.println("distance:"+distance);
		//如果结果返回千米
		if(distance.indexOf("k")!=-1){
			res=false;
		}
		else
		{
		//结果返回为米, 去掉单位进行比较
		distance=distance.substring(0,distance.length()-1);
		if(Double.parseDouble(distance)>fixDistance){
			System.out.println("用户不在当前景点范围内，不能签到");
			res= false;
		}else{
			System.out.println("用户在当前景点范围内，可以签到");
			res=true;
		}
		}
		return res;
	}
	public static boolean insertIntoSignature(Signature s){
		boolean res=false;
		String sql="insert into signature(signatureTime,signatureLng,signatureLati,userId,sceneryId) values(?,?,?,?,?)";
		try{
			conn=getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1,s.getSignatureTime());
			ps.setString(2, s.getSignatureLng()+"");
			ps.setString(3, s.getSignatureLati()+"");
			ps.setInt(4, s.getUserId());
			ps.setInt(5, s.getSceneryId());
			
		    int updateRow=ps.executeUpdate();
			if(updateRow>0){
				System.out.println("插入成功");
				res=true;
			}
			else{
				System.out.println("插入失败");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			close();
		}
		return res;
	}

/*
 * 得到某景区内所有景点
 */
	public static List<Scenery> findAllScenery(int scenerySpotId)
	{
		List<Scenery> ss=new ArrayList<Scenery>();
		String sql="select * from scenery where scenerySpotId="+scenerySpotId;
		conn=getConn();
		try{
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				int sceneryId=rs.getInt("sceneryId");
				String sceneryName=rs.getString("sceneryName");
				double sceneryLng=Double.parseDouble(rs.getString("sceneryLng"));
				double sceneryLati=Double.parseDouble(rs.getString("sceneryLati"));
				String sceneryDescribe="";
				if(rs.getString("sceneryDescribe")!=null)
				sceneryDescribe=rs.getString("sceneryDescribe");	
				
				Scenery s=new Scenery();
				s.setSceneryId(sceneryId);
				s.setSceneryDescribe(sceneryDescribe);
				s.setSceneryName(sceneryName);
				s.setSceneryLng(sceneryLng);
				s.setSceneryLati(sceneryLati);
				s.setScenerySpotId(scenerySpotId);
				
				ss.add(s);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
		return ss;
	}

	/*
	 * 得到用户签到过的所有景区
	 */
	public static List<SignedSpot> FindMySignedScenerySpot(int userId)
	{
		String sql="select count(*) as count,sceneryspot.*,signature.signatureTime from signature,scenery,sceneryspot where signature.sceneryId=scenery.sceneryId and scenery.scenerySpotId=sceneryspot.scenerySpotId and signature.userId="+userId;
		conn=getConn();
		List<SignedSpot> spots = new ArrayList<SignedSpot>();
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next())
			{   int count=rs.getInt("count");
				int id = rs.getInt("ScenerySpotId");
				String name =rs.getString("ScenerySpotName");
				String time=DateUtil.getDateOnlyYearMonthDay(rs.getString("signature.signatureTime"));
				
				String scenerySpotPicture=rs.getString("scenerySpotPicture");

				SignedSpot spot = new SignedSpot();
				
				spot.setSpotId(id);
				spot.setSpotName(name);
				spot.setSpotAvatar(scenerySpotPicture);
                spot.setSignedTime(time);
                spot.setSignedCounts(count);
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


	public static List<Scenery> FindMySignedScenery(int userId,int scenerySpotId)
	{
		String sql="select scenery.* from signature,scenery where signature.sceneryId=scenery.sceneryId and signature.userId="+userId+" and scenery.scenerySpotId="+scenerySpotId+" order by signature.signatureTime DESC";
		System.out.println(sql);
		conn=getConn();
		List<Scenery>  ss=new ArrayList<Scenery>();
		
		try
		{
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				int sceneryId=rs.getInt("sceneryId");
				String sceneryName=rs.getString("sceneryName");
				double sceneryLng=Double.parseDouble(rs.getString("sceneryLng"));
				double sceneryLati=Double.parseDouble(rs.getString("sceneryLati"));
				String sceneryDescribe="";
				if(rs.getString("sceneryDescribe")!=null)
				sceneryDescribe=rs.getString("sceneryDescribe");	
				
				Scenery s=new Scenery();
				s.setSceneryDescribe(sceneryDescribe);
				s.setSceneryId(sceneryId);
				s.setSceneryName(sceneryName);
				s.setSceneryLng(sceneryLng);
				s.setSceneryLati(sceneryLati);
				s.setScenerySpotId(scenerySpotId);
				ss.add(s);
								
			}			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			close();
		}	
		
		return ss;
		
	}


	public static boolean isSigned(int userId, int sceneryId)
	{
		boolean res=false;
		String sql="select * from signature where userId="+userId+" and sceneryId="+sceneryId;
		conn=getConn();
		
		try
		{
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Signature s=new Signature();
				s.setSceneryId(rs.getInt("sceneryId"));
				s.setSignatureId(rs.getInt("signatureId"));
				s.setSignatureLati(rs.getDouble("signatureLati"));
				s.setSignatureLng(rs.getDouble("signatureLng"));
				s.setSignatureTime(rs.getString("signatureTime"));
				s.setUserId(userId);
				System.out.println(s);
				res=true;
			}			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			close();
		}	
		return res;
	}
}
