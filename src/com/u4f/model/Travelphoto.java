package com.u4f.model;


public class TravelPhoto
{

	private int travelPhotoId;
	private int travelNoteId;
	private String photoName;
	private String imageURL;
	
	
	public String getPhotoName()
	{
		return photoName;
	}
	public void setPhotoName(String photoName)
	{
		this.photoName = photoName;
	}
	public String getImageURL()
	{
		return imageURL;
	}
	public void setImageURL(String imageURL)
	{
		this.imageURL = imageURL;
	}
	public int getTravelPhotoId()
	{
		return travelPhotoId;
	}
	public void setTravelPhotoId(int travelPhotoId)
	{
		this.travelPhotoId = travelPhotoId;
	}
	public int getTravelNoteId()
	{
		return travelNoteId;
	}
	public void setTravelNoteId(int travelNoteId)
	{
		this.travelNoteId = travelNoteId;
	}

	
	
}
