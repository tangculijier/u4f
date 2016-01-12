package com.u4f.model;

public class Facility
{
	private int facilityId;
	private String facilityName;
	private double facilityLng;
	private double facilityLati;
	private int facilityType;
	private int scenerySpotId;

	public int getScenerySpotId()
	{
		return scenerySpotId;
	}

	public void setScenerySpotId(int scenerySpotId)
	{
		this.scenerySpotId = scenerySpotId;
	}

	public int getFacilityId()
	{
		return facilityId;
	}

	public void setFacilityId(int facilityId)
	{
		this.facilityId = facilityId;
	}

	public String getFacilityName()
	{
		return facilityName;
	}

	public void setFacilityName(String facilityName)
	{
		this.facilityName = facilityName;
	}

	public double getFacilityLng()
	{
		return facilityLng;
	}

	public void setFacilityLng(double facilityLng)
	{
		this.facilityLng = facilityLng;
	}

	public double getFacilityLati()
	{
		return facilityLati;
	}

	public void setFacilityLati(double facilityLati)
	{
		this.facilityLati = facilityLati;
	}

	public int getFacilityType()
	{
		return facilityType;
	}

	public void setFacilityType(int facilityType)
	{
		this.facilityType = facilityType;
	}

	@Override
	public String toString()
	{
		return "Facility [facilityId=" + facilityId + ", facilityName="
				+ facilityName + ", facilityLng=" + facilityLng
				+ ", facilityLati=" + facilityLati + ", facilityType="
				+ facilityType + ", scenerySpotId=" + scenerySpotId + "]";
	}
	
	

}
