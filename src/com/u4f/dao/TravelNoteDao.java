package com.u4f.dao;


import java.util.List;

import com.u4f.model.TravelNote;
import com.u4f.model.User;

public class TravelNoteDao
{

	public List<TravelNote> getTravelNote(int scenerySpotId)
	{
		List<TravelNote> notes = DBTools.getTravelNote(scenerySpotId);
	
		return notes;
	}
	
	public List<String> getPhotosByTravelNoteId(int travelNoteId)
	{
		List<String> photos = DBTools.getPhotosByTravelNoteId(travelNoteId);
		
		return photos;
	}

	public boolean uploadTravelNote(TravelNote note){
		return DBTools.insertTravelNote(note);
	}

	public User findUserById(int userId)
	{
		User user=DBTools.findUserById(userId);
		return user;
	}
}
