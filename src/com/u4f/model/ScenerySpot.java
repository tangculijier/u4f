package com.u4f.model;

public class ScenerySpot
{
	/**
	 * 景点id
	 */
	private int scenerySpotId;
	/**
	 * 景点名字 如：兴庆公园
	 */
	private String scenerySpotName;
	/**
	 * 景点地址 如：西安市碑林区咸宁西路111号
	 */
	private String scenerySpotAddress;
	/**
	 * 景点纬度 如：34.1343
	 */
	private double scenerySpotLat;
	/**
	 * 景点经度 如：108.3456
	 */
	private double scenerySpotLong;
	/**
	 * 所属城市id
	 */
	private int belongCityId;
	/**
	 * 景点开放时间 如：早8:30-12:30 晚12:00  可为null
	 */
	private String scenerySpotOpenTime;
	/**
	 * 景点门票信息 如：学生票半价30元 可为null
	 */
	private String scenerySpotTicket;
	/**
	 * 景点交通信息 如：45路、108路 可为null
	 */
	private String scenerySpotTrans;
	/**
	 * 景点标签1 如：公园
	 */
	private String scenerySpotLab1;
	private String scenerySpotLab2;
	private String scenerySpotLab3;
	/**
	 * 景点图片
	 */
	private String scenerySpotPicture;
	
	/**
	 * 景点与当前用户之间的距离 如：100
	 */
	
	private String scenerySpotDistance;	
	
	
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
		return scenerySpotId;
	}
	public void setScenerySpotId(int scenerySpotId)
	{
		this.scenerySpotId = scenerySpotId;
	}
	public String getScenerySpotName()
	{
		return scenerySpotName;
	}
	public void setScenerySpotName(String scenerySpotName)
	{
		this.scenerySpotName = scenerySpotName;
	}
	public String getScenerySpotAddress()
	{
		return scenerySpotAddress;
	}
	public void setScenerySpotAddress(String scenerySpotAddress)
	{
		this.scenerySpotAddress = scenerySpotAddress;
	}
	public double getScenerySpotLat()
	{
		return scenerySpotLat;
	}
	public void setScenerySpotLat(double scenerySpotLat)
	{
		this.scenerySpotLat = scenerySpotLat;
	}
	public double getScenerySpotLong()
	{
		return scenerySpotLong;
	}
	public void setScenerySpotLong(double scenerySpotLong)
	{
		this.scenerySpotLong = scenerySpotLong;
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
		return scenerySpotOpenTime;
	}
	public void setScenerySpotOpenTime(String scenerySpotOpenTime) {
		this.scenerySpotOpenTime = scenerySpotOpenTime;
	}
	public String getScenerySpotTicket()
	{
		return scenerySpotTicket;
	}
	public void setScenerySpotTicket(String scenerySpotTicket)
	{
		this.scenerySpotTicket = scenerySpotTicket;
	}
	public String getScenerySpotTrans()
	{
		return scenerySpotTrans;
	}
	public void setScenerySpotTrans(String scenerySpotTrans)
	{
		this.scenerySpotTrans = scenerySpotTrans;
	}
	public String getScenerySpotLab1()
	{
		return scenerySpotLab1;
	}
	public void setScenerySpotLab1(String scenerySpotLab1)
	{
		this.scenerySpotLab1 = scenerySpotLab1;
	}
	public String getScenerySpotLab2()
	{
		return scenerySpotLab2;
	}
	public void setScenerySpotLab2(String scenerySpotLab2)
	{
		this.scenerySpotLab2 = scenerySpotLab2;
	}
	public String getScenerySpotLab3()
	{
		return scenerySpotLab3;
	}
	public void setScenerySpotLab3(String scenerySpotLab3)
	{
		this.scenerySpotLab3 = scenerySpotLab3;
	}
	public String getScenerySpotPicture()
	{
		return scenerySpotPicture;
	}
	public void setScenerySpotPicture(String scenerySpotPicture)
	{
		this.scenerySpotPicture = scenerySpotPicture;
	}
	@Override
	public String toString() {
		return "ScenerySpot [ScenerySpotId=" + scenerySpotId
				+ ", ScenerySpotName=" + scenerySpotName
				+ ", ScenerySpotAddress=" + scenerySpotAddress
				+ ", ScenerySpotLat=" + scenerySpotLat + ", ScenerySpotLong="
				+ scenerySpotLong + ", belongCityId=" + belongCityId
				+ ", ScenerySpotTicket=" + scenerySpotTicket
				+ ", ScenerySpotTrans=" + scenerySpotTrans
				+ ", ScenerySpotLab1=" + scenerySpotLab1 + ", ScenerySpotLab2="
				+ scenerySpotLab2 + ", ScenerySpotLab3=" + scenerySpotLab3
				+ ", ScenerySpotPicture=" + scenerySpotPicture
				+ ", scenerySpotDistance=" + scenerySpotDistance + "]";
	
	}
	
	
}
