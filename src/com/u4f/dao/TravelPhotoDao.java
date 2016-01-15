package com.u4f.dao;

import com.u4f.model.TravelPhoto;

public class TravelPhotoDao
{

	public boolean uploadTravelPhoto(TravelPhoto photo){
		 return DBTools.insertTravelPhoto(photo);
		
	}
	
}
