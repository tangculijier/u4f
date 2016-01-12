package com.u4f.dao;


import java.util.List;

import com.u4f.model.TravelNote;
import com.u4f.model.User;
import com.u4f.tools.DBTools;

public class TravelNoteDao
{

	public List<TravelNote> getTravelNoteDao(int scenerySpotId)
	{
		List<TravelNote> notes = DBTools.getTravelNote(scenerySpotId);
	
		return notes;
	}
	
	public List<String> getPhotosByTravelNoteIdDao(int travelNoteId)
	{
		List<String> photos = DBTools.getPhotosByTravelNoteId(travelNoteId);
		
		return photos;
	}

	public void uploadTravelNote(TravelNote note){
		DBTools.insertTravelNote(note);
	}

	public User findUserById(int userId)
	{
		User user=DBTools.findUserById(userId);
		return user;
	}
}
