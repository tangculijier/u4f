package com.u4f.model;

import java.sql.Blob;

public class ScenerySpot
{
	/**
	 * 景点id
	 */
	private int ScenerySpotId;
	/**
	 * 景点名字 如：兴庆公园
	 */
	private String ScenerySpotName;
	/**
	 * 景点地址 如：西安市碑林区咸宁西路111号
	 */
	private String ScenerySpotAddress;
	/**
	 * 景点纬度 如：34.1343
	 */
	private double ScenerySpotLat;
	/**
	 * 景点经度 如：108.3456
	 */
	private double ScenerySpotLong;
	/**
	 * 所属城市id
	 */
	private int belongCityId;
	/**
	 * 景点开放时间 如：早8:30-12:30 晚12:00  可为null
	 */
	private String ScenerySpotOpenTime;
	/**
	 * 景点门票信息 如：学生票半价30元 可为null
	 */
	private String ScenerySpotTicket;
	/**
	 * 景点交通信息 如：45路、108路 可为null
	 */
	private String ScenerySpotTrans;
	/**
	 * 景点标签1 如：公园
	 */
	private String ScenerySpotLab1;
	private String ScenerySpotLab2;
	private String ScenerySpotLab3;
	/**
	 * 景点图片
	 */
	private Blob ScenerySpotPicture;
	private String scenerySpotDistance;	
	/**
	 * 景点与当前用户之间的距离 如：100
	 */
	public String getScenerySpotDistance()
	{
		return scenerySpotDistance;
	}
	public void setScenerySpotDistance(String scenerySpotDistance)
	{
		this.scenerySpotDistance = scenerySpotDistance;
	}
	public int getScenerySpotId()
	{
		return ScenerySpotId;
	}
	public void setScenerySpotId(int scenerySpotId)
	{
		ScenerySpotId = scenerySpotId;
	}
	public String getScenerySpotName()
	{
		return ScenerySpotName;
	}
	public void setScenerySpotName(String scenerySpotName)
	{
		ScenerySpotName = scenerySpotName;
	}
	public String getScenerySpotAddress()
	{
		return ScenerySpotAddress;
	}
	public void setScenerySpotAddress(String scenerySpotAddress)
	{
		ScenerySpotAddress = scenerySpotAddress;
	}
	public double getScenerySpotLat()
	{
		return ScenerySpotLat;
	}
	public void setScenerySpotLat(double scenerySpotLat)
	{
		ScenerySpotLat = scenerySpotLat;
	}
	public double getScenerySpotLong()
	{
		return ScenerySpotLong;
	}
	public void setScenerySpotLong(double scenerySpotLong)
	{
		ScenerySpotLong = scenerySpotLong;
	}
	public int getBelongCityId()
	{
		return belongCityId;
	}
	public void setBelongCityId(int belongCityId)
	{
		this.belongCityId = belongCityId;
	}
	public String getScenerySpotOpenTime() {
		return ScenerySpotOpenTime;
	}
	public void setScenerySpotOpenTime(String scenerySpotOpenTime) {
		ScenerySpotOpenTime = scenerySpotOpenTime;
	}
	public String getScenerySpotTicket()
	{
		return ScenerySpotTicket;
	}
	public void setScenerySpotTicket(String scenerySpotTicket)
	{
		ScenerySpotTicket = scenerySpotTicket;
	}
	public String getScenerySpotTrans()
	{
		return ScenerySpotTrans;
	}
	public void setScenerySpotTrans(String scenerySpotTrans)
	{
		ScenerySpotTrans = scenerySpotTrans;
	}
	public String getScenerySpotLab1()
	{
		return ScenerySpotLab1;
	}
	public void setScenerySpotLab1(String scenerySpotLab1)
	{
		ScenerySpotLab1 = scenerySpotLab1;
	}
	public String getScenerySpotLab2()
	{
		return ScenerySpotLab2;
	}
	public void setScenerySpotLab2(String scenerySpotLab2)
	{
		ScenerySpotLab2 = scenerySpotLab2;
	}
	public String getScenerySpotLab3()
	{
		return ScenerySpotLab3;
	}
	public void setScenerySpotLab3(String scenerySpotLab3)
	{
		ScenerySpotLab3 = scenerySpotLab3;
	}
	public Blob getScenerySpotPicture()
	{
		return ScenerySpotPicture;
	}
	public void setScenerySpotPicture(Blob scenerySpotPicture)
	{
		ScenerySpotPicture = scenerySpotPicture;
	}
	@Override
	public String toString() {
		return "ScenerySpot [ScenerySpotId=" + ScenerySpotId
				+ ", ScenerySpotName=" + ScenerySpotName
				+ ", ScenerySpotAddress=" + ScenerySpotAddress
				+ ", ScenerySpotLat=" + ScenerySpotLat + ", ScenerySpotLong="
				+ ScenerySpotLong + ", belongCityId=" + belongCityId
				+ ", ScenerySpotTicket=" + ScenerySpotTicket
				+ ", ScenerySpotTrans=" + ScenerySpotTrans
				+ ", ScenerySpotLab1=" + ScenerySpotLab1 + ", ScenerySpotLab2="
				+ ScenerySpotLab2 + ", ScenerySpotLab3=" + ScenerySpotLab3
				+ ", ScenerySpotPicture=" + ScenerySpotPicture
				+ ", scenerySpotDistance=" + scenerySpotDistance + "]";
	

	
	}
	
	
}
