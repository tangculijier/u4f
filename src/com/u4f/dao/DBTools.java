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

import com.u4f.model.Cluster;
import com.u4f.model.Facility;
import com.u4f.model.Path;
import com.u4f.model.Project;
import com.u4f.model.Park;
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
		//	System.out.println("连接数据库成功");
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
	public static List<Park> getAllScenerySpot()
	{
		if(conn == null)
		{
			conn = getConn();
		}
		List<Park> list  = new ArrayList<Park>();
		String sql = "select * from park where parkLat > 34.2566";
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next())
			{
				int id = rs.getInt("parkId");
				String name = rs.getString("parkName");
				String adress = rs.getString("parkName");
				double Lat = rs.getDouble("parkLat");
				double Long = rs.getDouble("parkLng");
				int belongCityId = rs.getInt("belongCityId");
				String Ticket = rs.getString("parkTicket");
				String Trans = rs.getString("parkTrans");
				String parkIntroduction = rs.getString("parkIntroduction");
				// String ScenerySpotPicture=rs.getString("");

				Park park = new Park();
				park.setParkId(id);
				park.setParkName(name);
				park.setBelongCityId(belongCityId);
				park.setParkAdress(adress);
			
				park.setParkIntroduction(parkIntroduction);
				park.setParkTicket(Ticket);
				park.setParkLati(Lat);
				park.setParkLng(Long);
			
				park.setParkTrans(Trans);

				list.add(park);

			}

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{			
			close();
		}
		return list;
	}
	
	/**
	 * 根据当前位置得到所有的附近景点信息
	 */
	
	public static List<Park>  getNearPark(Double latitude, Double longtitude, String sql)
	{
		List<Park> list = new ArrayList<Park>();
		
	
		try
		{
			conn = getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next())
			{
				int id = rs.getInt("parkId");
				String name = rs.getString("parkName");
				String adress = rs.getString("parkAddress");
				double parkLat = rs.getDouble("parkLat");
				double parkLong = rs.getDouble("parkLng");
				int belongCityId = rs.getInt("belongCityId");
				String parkTicket = rs.getString("parkTicket");
				String parkTrans = rs.getString("parkTrans");
				String parkIntrouction = rs.getString("parkIntroduction");
				String parkPicture=rs.getString("parkPicture");
				String parkOpenTime=rs.getString("parkOpenTime");
				String openTime=rs.getString("openTime");
				String closeTime=rs.getString("closeTime");

				Park park = new Park();
				park.setParkId(id);
				park.setParkName(name);
				park.setBelongCityId(belongCityId);
				park.setParkAdress(adress);
			
				park.setParkIntroduction(parkIntrouction);
				park.setParkTicket(parkTicket);
				park.setParkLati(parkLat);
				park.setParkLng(parkLong);
				park.setParkPicture(parkPicture);
				park.setParkTrans(parkTrans);
				park.setParkOpenTime(parkOpenTime);
				park.setParkTodayOpenTime(openTime+"-"+closeTime);

				// String la=spot.getScenerySpotLat()+"";
				// String lb=spot.getScenerySpotLong()+"";
				String distance =MapDistance.getDistance(
						latitude + "", longtitude + "",
						park.getParkLati() + "",
						park.getParkLng() + "");
				park.setParkDistance(distance);
				//System.out.println(park);
				list.add(park);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			close();

		}
		return list;
	}
	
	
	/**
	 * 根据景点id返回所有攻略信息
	 */
	public static List<TravelNote> getTravelNote(int parkId)
	{
		String sql="select user.userId,user.username,user.level,travelNote.travelNoteId,travelNote.userId,travelNote.travelNoteTitle," +
				"travelNote.travelNoteContent,DATE_FORMAT(travelNote.publicTime,'%Y-%m-%d') as time" +
				" from user,travelNote " +
		"where user.userId=travelNote.userId and travelNoteId in(select travelNoteId from travelNote where parkId = "+parkId+")";
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
				note.setParkId(parkId);
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
		//System.out.println(sql);
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
		String sql="insert into travelNote(userId,travelNoteTitle,travelNoteContent,publicTime,parkId) values(?,?,?,?,?)";
		System.out.println(sql);
		try{
			conn=getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, note.getUserId());
			ps.setString(2, note.getTravelNoteTitle());
			ps.setString(3, note.getTravelNoteContent());
			ps.setString(4, note.getPublicTime());
			ps.setInt(5, note.getParkId());
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
		String sql="select * from facility where parkId="+id+" and facilityType="+type;
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
			   f.setparkId(id);
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

	public static Project findProjectsById(int parkId){
		
		String sql="select * from project where parkId="+parkId;
		conn=getConn();
		Project s=new Project();
		try
		{
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				int projectId=rs.getInt("projectId");
				String projectName=rs.getString("projectName");
				double projectLng=Double.parseDouble(rs.getString("projectLng"));
				double projectLati=Double.parseDouble(rs.getString("projectLati"));
				String projectDescribe="";
				if(rs.getString("projectDescribe")!=null)
					projectDescribe=rs.getString("projectDescribe");	
				String projectPictureURL=rs.getString("projectPictureURL");
				
				s.setProjectId(projectId);
				s.setProjectDescribe(projectDescribe);
				s.setParkId(parkId);
				s.setProjectName(projectName);
				s.setProjectLng(projectLng);
				s.setProjectLati(projectLati);
				s.setProjectPictureURL(projectPictureURL);
				
				
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
		Project s= findProjectsById(sceneryId);
//	  System.out.println("latitude:"+latitude+",longtitude:"+longtitude);
			double lng2=s.getProjectLng();
			double lati2=s.getProjectLati();
	//	System.out.println("lati2:"+lati2+",lng2:"+lng2);
			
		String distance=MapDistance.getDistance(latitude+"", longtitude+"", s.getProjectLati()+"", s.getProjectLng()+"");
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
	public static boolean insertIntoSignature(Signature s)
	{
		boolean res=false;
		String sql="insert into signature(signatureTime,signatureLng,signatureLati,userId,projectId) values(?,?,?,?,?)";
		try{
			conn=getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1,s.getSignatureTime());
			ps.setString(2, s.getSignatureLng()+"");
			ps.setString(3, s.getSignatureLati()+"");
			ps.setInt(4, s.getUserId());
			ps.setInt(5, s.getprojectId());
			
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

	public static List<Project> findAllScenery(int parkId)
	{
		List<Project> ss=new ArrayList<Project>();
		String sql="select * from project where parkId="+parkId;
		conn=getConn();
		try{
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				int projectId=rs.getInt("projectId");
				String projectName=rs.getString("projectName");
				String projectCode = rs.getString("projectCode");
				double projectStayTime=Double.parseDouble(rs.getString("projectStayTime"));
				double projectLng=Double.parseDouble(rs.getString("projectLng"));
				double projectLati=Double.parseDouble(rs.getString("projectLati"));
				String projectType = rs.getString("projectType");
				int projectPop =rs.getInt("projectPop");
				String projectOpenTime = rs.getString("projectOpenTime");
				String projectDescribe="";
				if(rs.getString("projectDescribe")!=null)
				projectDescribe=rs.getString("projectDescribe");	
				int parkZoneId =rs.getInt("parkZoneId");
				Project s=new Project();
				s.setProjectId(projectId);
				s.setProjectCode(projectCode);
				s.setProjectStayTime(projectStayTime);
				s.setProjectDescribe(projectDescribe);
				s.setProjectName(projectName);
				s.setProjectLng(projectLng);
				s.setProjectLati(projectLati);
				s.setParkId(parkId);
				s.setProjectOpenTime(projectOpenTime);
				s.setProjectPop(projectPop);
				
				ss.add(s);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
		return ss;
	}
 */
	/*
	 * 得到用户签到过的所有景区
	 */
	public static List<SignedSpot> FindMySignedPark(int userId)
	{
		String sql="select count(*) as count,park.*,signature.signatureTime from signature,park,project where signature.projectId=project.projectId and project.parkId=park.parkId and signature.userId="+userId+" group by parkId";
		conn=getConn();
		System.out.println(sql);
		List<SignedSpot> spots = new ArrayList<SignedSpot>();
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next())
			{   int count=rs.getInt("count");
				int id = rs.getInt("parkId");
				String name =rs.getString("parkName");
				String time=DateUtil.getDateOnlyYearMonthDay(rs.getString("signature.signatureTime"));
				
				String parkPicture=rs.getString("parkPicture");

				SignedSpot spot = new SignedSpot();
				
				spot.setSpotId(id);
				spot.setSpotName(name);
				spot.setSpotAvatar(parkPicture);
                spot.setSignedTime(time);
                spot.setSignedCounts(count);
                
                System.out.println(spot);
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


	public static List<Project> FindMySignedProject(int userId,int parkId)
	{
		String sql="select project.* from signature,project where signature.projectId=project.projectId and signature.userId="+userId+" and project.parkId="+parkId+" order by signature.signatureTime ASC";
		System.out.println(sql);
		conn=getConn();
		List<Project>  ss=new ArrayList<Project>();
		
		try
		{
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				int projectId=rs.getInt("projectId");
				String projectName=rs.getString("projectName");
				double projectLng=Double.parseDouble(rs.getString("projectLng"));
				double projectLati=Double.parseDouble(rs.getString("projectLati"));
				String projectDescribe="";
				if(rs.getString("projectDescribe")!=null)
				projectDescribe=rs.getString("projectDescribe");	
				String projectPictureURL=rs.getString("projectPictureURL");

				Project s=new Project();
				s.setProjectDescribe(projectDescribe);
				s.setProjectId(projectId);
				s.setProjectName(projectName);
				s.setProjectLng(projectLng);
				s.setProjectLati(projectLati);
				s.setProjectPictureURL(projectPictureURL);
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


	public static boolean isSigned(int userId, int projectId)
	{
		boolean res=false;
		String sql="select * from signature where userId="+userId+" and projectId="+projectId;
		conn=getConn();
		
		try
		{
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Signature s=new Signature();
				s.setprojectId(rs.getInt("projectId"));
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
	

	public static List<Project> getAllProject(int parkId)
	{
		return findAllProject(parkId);
		
	}
/*
 * 得到某景区内所有项目
 */
	public static List<Project> findAllProject(int parkId)
	{
		List<Project> ss=new ArrayList<Project>();
		String sql="select * from project where parkId="+parkId;
		conn=getConn();
		try{
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				int projectId=rs.getInt("projectId");
				String projectName=rs.getString("projectName");
				String projectCode = rs.getString("projectCode");
				int projectStayTime=rs.getInt("projectStayTime");
				double projectLng=Double.parseDouble(rs.getString("projectLng"));
				double projectLati=Double.parseDouble(rs.getString("projectLati"));
				String projectType = rs.getString("projectType");
				int projectPop =rs.getInt("projectPop");
				String projectOpenTime = rs.getString("projectOpenTime");
				String projectDescribe="";
				if(rs.getString("projectDescribe")!=null)
				projectDescribe=rs.getString("projectDescribe");	
				int parkZoneId =rs.getInt("parkZoneId");
				String projectPictureURL=rs.getString("projectPictureURL");
			
				Project s=new Project();
				s.setProjectId(projectId);
				s.setProjectCode(projectCode);
				s.setProjectStayTime(projectStayTime);
				s.setProjectDescribe(projectDescribe);
				s.setProjectName(projectName);
				s.setProjectLng(projectLng);
				s.setProjectLati(projectLati);
				s.setParkId(parkId);
				s.setProjectOpenTime(projectOpenTime);
				s.setProjectPop(projectPop);
				s.setParkZoneId(parkZoneId);
				s.setProjectPictureURL(projectPictureURL);
				ss.add(s);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
		return ss;
	}
	
	public static List<Path> findAllPaths(int parkId)
	{
		List<Path> list=new ArrayList<Path>();
		String sql="select * from path where parkId="+parkId;
		conn=getConn();
		try{
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				
				int pathId=rs.getInt("pathId");
				int pathFrom=rs.getInt("pathFrom");
				int pathTo=rs.getInt("pathTo");
				Path p = new Path(pathId, pathFrom, pathTo);
				list.add(p);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}
	
	
	public void insertTravle(String userName,String travle) throws SQLException
	{
			conn=getConn();
			String sql="insert into user(username,level) values(?,1)";
			
				ps=conn.prepareStatement(sql);
				ps.setString(1,userName);
				ps.executeUpdate();
				System.out.println("userName="+userName);
				String sql2="select userId from user where username='"+userName+"'";
				ps=conn.prepareStatement(sql2);
				rs=ps.executeQuery();
				if(rs.next())
				{
					int userId = rs.getInt("userId");
					System.out.println("userId"+rs.getInt("userId"));
					String insert="insert into travelnote(userId,travelNoteContent,publicTime,ScenerySpotId) values(?,?,?,?)";
					ps=conn.prepareStatement(insert);
					ps.setInt(1,userId);
					ps.setString(2,travle);
					ps.setString(3,DateUtil.getNowTime());
					ps.setString(4, "13");
					int updateRow=ps.executeUpdate();
					if(updateRow>0)
					{
						System.out.println("插入成功");
					}
					else
					{
						System.out.println("插入失败");
					}
					
				}
				
			

		
	}


	public List<Cluster> getParkClusterPaths(int parkId)
	{
		List<Cluster> list=new ArrayList<Cluster>();
		String sql="select cluster.*,playpath.pathStr from cluster,playpath where cluster.centerId = playpath.playPathId  and cluster.parkId="+parkId;
		conn=getConn();
		try{
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				
				int clusterId=rs.getInt("clusterId");
				String pathStr=rs.getString("pathStr");
				int clusterNumber=rs.getInt("clusterNumber");
				Cluster c = new Cluster();
				c.setClusterId(clusterId);
				c.setClusterNumber(clusterNumber);
				c.setPlayPathStr(pathStr);
				list.add(c);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}

	/**
	public static boolean update( )
	{
		boolean res=false;
		String sql="update project_copy set projectId=projectId-100 where projectId >= 0";
		System.out.println(sql);
		try{
			conn=getConn();
			ps = conn.prepareStatement(sql);
			int updateRow=ps.executeUpdate();
			if(updateRow>0){
				res = true;
				System.out.println("upload  success!");
			}
			else
			{	
				System.out.println("upload  falied!");
			}
			}catch(Exception e)
			{
				e.printStackTrace();
			}finally{
				close();
			}
		
		return res;
	}
	*/

}
