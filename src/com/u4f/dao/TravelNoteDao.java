package com.u4f.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.u4f.model.TravelNote;
import com.u4f.tools.DBTools;

public class TravelNoteDao
{
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	public List<TravelNote> getTravelNote(int ScenerySpotId)
	{
		List<TravelNote> notes = new ArrayList<TravelNote>();
		TravelNoteDao dao = new TravelNoteDao();
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
			DBTools.close(conn, ps, rs);
		}
		return photos;
	}

}
