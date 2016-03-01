package com.u4f.model;

public class PlayPath
{
	
	private int playPathId;
	private int parkId;
	/**
	 * 路径的字符串 eg:"01010010101010010001"
	 */
	private String pathStr;
	/**
	 * 路径的拥有者
	 */
	private int userId;
	/**
	 * 路径上传时间
	 */
	private String playTime;
	
	/**
	 * 路径所属哪一簇
	 */
	private int clusterId;
	
	public int getClusterId()
	{
		return clusterId;
	}
	public void setClusterId(int clusterId)
	{
		this.clusterId = clusterId;
	}
	public int getPlayPathId()
	{
		return playPathId;
	}
	public void setPlayPathId(int playPathId)
	{
		this.playPathId = playPathId;
	}
	public int getParkId()
	{
		return parkId;
	}
	public void setParkId(int parkId)
	{
		this.parkId = parkId;
	}
	public String getPathStr()
	{
		return pathStr;
	}
	public void setPathStr(String pathStr)
	{
		this.pathStr = pathStr;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public String getPlayTime()
	{
		return playTime;
	}
	public void setPlayTime(String playTime)
	{
		this.playTime = playTime;
	}

}
