package com.u4f.model;

import java.sql.Blob;

public class Travelphoto
{

	private int travelPhotoId;
	private int travelNoteId;
	private Blob image;
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
	public Blob getImage()
	{
		return image;
	}
	public void setImage(Blob image)
	{
		this.image = image;
	}
	
	
}
