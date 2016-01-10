package com.u4f.model;

import java.sql.Blob;

public class ScenerySpot
{
	//hah
	private int ScenerySpotId;
	private String ScenerySpotName;
	private String ScenerySpotAddress;
	private double ScenerySpotLat;
	private double ScenerySpotLong;
	private int belongCityId;
	private double ScenerySpotTicket;
	private String ScenerySpotTrans;
	private String ScenerySpotLab1;
	private String ScenerySpotLab2;
	private String ScenerySpotLab3;
	private Blob ScenerySpotPicture;
	private double scenerySpotDistance;
	public double getScenerySpotDistance()
	{
		return scenerySpotDistance;
	}
	public void setScenerySpotDistance(double scenerySpotDistance)
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
	public double getScenerySpotTicket()
	{
		return ScenerySpotTicket;
	}
	public void setScenerySpotTicket(double scenerySpotTicket)
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
