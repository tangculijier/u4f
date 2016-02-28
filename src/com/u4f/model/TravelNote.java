package com.u4f.model;


import java.util.List;

public class TravelNote {

	private int travelNoteId;
	private int userId;
	private User user;
	private int parkId;
	private String travelNoteTitle;
	private String travelNoteContent;
	private String publicTime;
	private List<String>  travelPhotosURL;
	
	public List<String> getTravelPhotos()
	{
		return travelPhotosURL;
	}
	public void setTravelPhotos(List<String> travelPhotos)
	{
		this.travelPhotosURL = travelPhotos;
	}
	public int getTravelNoteId() {
		return travelNoteId;
	}
	public void setTravelNoteId(int travelNoteId) {
		this.travelNoteId = travelNoteId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getParkId() {
		return parkId;
	}
	public void setParkId(int parkId) {
		parkId = parkId;
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
	public String getPublicTime() {
		return publicTime;
	}
	public void setPublicTime(String publicTime) {
		this.publicTime = publicTime;
	}
	@Override
	public String toString()
	{
		return "TravelNote [travelNoteId=" + travelNoteId + ", user="
				+ user + ", parkId=" + parkId
				+ ", travelNoteTitle=" + travelNoteTitle
				+ ", travelNoteContent=" + travelNoteContent + ", publicTime="
				+ publicTime + ", travelPhotos=" + travelPhotosURL + "]";
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
}
