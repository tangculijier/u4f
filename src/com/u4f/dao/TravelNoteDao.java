package com.u4f.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.u4f.model.TravelNote;
import com.u4f.model.User;
import com.u4f.tools.DBTools;

public class TravelNoteDao
{
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	public List<TravelNote> getTravelNote(int scenerySpotId)
	{
		List<TravelNote> notes = new ArrayList<TravelNote>();
		TravelNoteDao dao = new TravelNoteDao();
		conn = DBTools.getConn(conn);
//		String sql = "select * from travelNote where scenerySpotId="
//				+ ScenerySpotId;
		String sql="select user.userId,user.username,user.level,travelNote.travelNoteId,travelNote.userId,travelNote.travelNoteTitle," +
				"travelNote.travelNoteContent,DATE_FORMAT(travelNote.publicTime,'%Y-%m-%d') as time" +
				" from user,travelNote " +
		"where user.userId=travelNote.userId and travelNoteId in(select travelNoteId from travelNote where ScenerySpotId="+scenerySpotId+")";
		System.out.println(sql);
		
		try
		{
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next())
			{
				int travelNoteId = rs.getInt("travelNote.travelNoteId");
				System.out.println("....id..."+travelNoteId);
				int userId=rs.getInt("userId");
				int level=rs.getInt("user.level");
				System.out.println("...level.."+level);
				
				String name=rs.getString("user.username");
				
				
				System.out.println("...usrename.."+name);
				String travelNoteTitle=rs.getString("travelNote.travelNoteTitle");
				System.out.println("...title.."+travelNoteTitle);
				String travelNoteContent=rs.getString("travelNote.travelNoteContent");
				System.out.println("...content.."+travelNoteContent);
				String publicTime=rs.getString("time");
				System.out.println("...publictime.."+publicTime);
				
				TravelNote note=new TravelNote();
				
				note.setTravelNoteId(travelNoteId);
				note.setScenerySpotId(scenerySpotId);
				note.setTravelNoteTitle(travelNoteTitle);
				note.setTravelNoteContent(travelNoteContent);
				note.setPublicTime(publicTime);
				
				note.setTravelPhotos(dao.getPhotos(note.getTravelNoteId()));
				User user=new User();
				user.setUserId(userId);
				user.setLevel(level);
				user.setUsername(name);
			
				
				
				System.out.println("...test..");
				
				
				
				note.setUser(user);
				notes.add(note);
				
			}
			

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			DBTools.close(conn, ps, rs);
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
			//DBTools.close(conn, ps, rs);
		}
		return photos;
	}

}
