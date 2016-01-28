package com.u4f.model;

public class SignedSpot
{

	private int spotId;
	private String spotName;
	private String spotAvatar;
	private String signedTime;
	private int signedCounts;
	public int getSpotId()
	{
		return spotId;
	}
	public void setSpotId(int spotId)
	{
		this.spotId = spotId;
	}
	public String getSpotName()
	{
		return spotName;
	}
	public void setSpotName(String spotName)
	{
		this.spotName = spotName;
	}
	public String getSpotAvatar()
	{
		return spotAvatar;
	}
	public void setSpotAvatar(String spotAvatar)
	{
		this.spotAvatar = spotAvatar;
	}
	public String getSignedTime()
	{
		return signedTime;
	}
	public void setSignedTime(String signedTime)
	{
		this.signedTime = signedTime;
	}
	public int getSignedCounts()
	{
		return signedCounts;
	}
	public void setSignedCounts(int count)
	{
		this.signedCounts = count;
	}
	@Override
	public String toString()
	{
		return "SignedSpot [spotId=" + spotId + ", spotName=" + spotName
				+ ", spotAvatar=" + spotAvatar + ", signedTime=" + signedTime
				+ ", signedCounts=" + signedCounts + "]";
	}
	
	
	
}
