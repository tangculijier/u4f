package com.u4f.model;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.List;

public class TravelNote {

	private int travelNoteId;
	private int userId;
	private int ScenerySpotId;
	private String travelNoteTitle;
	private String travelNoteContent;
	private Timestamp publicTime;
	private List<Blob>  travelPhotos;
	
	public List<Blob> getTravelPhotos()
	{
		return travelPhotos;
	}
	public void setTravelPhotos(List<Blob> travelPhotos)
	{
		this.travelPhotos = travelPhotos;
	}
	public int getTravelNoteId() {
		return travelNoteId;
	}
	public void setTravelNoteId(int travelNoteId) {
		this.travelNoteId = travelNoteId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getScenerySpotId() {
		return ScenerySpotId;
	}
	public void setScenerySpotId(int scenerySpotId) {
		ScenerySpotId = scenerySpotId;
	}
	public String getTravelNoteTitle() {
		return travelNoteTitle;
	}
	public void setTravelNoteTitle(String travelNoteTitle) {
		this.travelNoteTitle = travelNoteTitle;
	}
	public String getTravelNoteContent() {
		return travelNoteContent;
	}
	public void setTravelNoteContent(String travelNoteContent) {
		this.travelNoteContent = travelNoteContent;
	}
	public Timestamp getPublicTime() {
		return publicTime;
	}
	public void setPublicTime(Timestamp publicTime) {
		this.publicTime = publicTime;
	}
	@Override
	public String toString()
	{
		return "TravelNote [travelNoteId=" + travelNoteId + ", userId="
				+ userId + ", ScenerySpotId=" + ScenerySpotId
				+ ", travelNoteTitle=" + travelNoteTitle
				+ ", travelNoteContent=" + travelNoteContent + ", publicTime="
				+ publicTime + ", travelPhotos=" + travelPhotos + "]";
	}
	
	
	
	
	
}
