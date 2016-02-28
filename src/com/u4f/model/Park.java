package com.u4f.model;

public class Park
{
	/**
	 * 景点id
	 */
	private int parkId;
	/**
	 * 景点名字 如：兴庆公园
	 */
	private String parkName;
	/**
	 * 景点地址 如：西安市碑林区咸宁西路111号
	 */
	private String parkAddress;
	/**
	 * 景点经度 如：108.3456
	 */
	private double parkLng;
	
	/**
	 * 景点纬度 如：34.1343
	 */
	private double parkLati;
	/**
	 * 所属城市id
	 */
	private int belongCityId;
	/**
	 * 景点开放时间 如：早8:30-12:30 晚12:00  可为null
	 */
	private String parkOpenTime;
	/**
	 * 景点门票信息 如：学生票半价30元 可为null
	 */
	private String parkTicket;
	/**
	 * 景点交通信息 如：45路、108路 可为null
	 */
	private String parkTrans;
	/**
	 * 景点 如：公园
	 */
	private String parkIntroduction;
	/**
	 * 景点图片
	 */
	private String parkPicture;
	
	/**
	 * 景点与当前用户之间的距离 如：100
	 */
	
	private String parkDistance;

	public int getParkId()
	{
		return parkId;
	}

	public void setParkId(int parkId)
	{
		this.parkId = parkId;
	}

	public String getParkName()
	{
		return parkName;
	}

	public void setParkName(String parkName)
	{
		this.parkName = parkName;
	}

	public String getParkAdress()
	{
		return parkAddress;
	}

	public void setParkAdress(String parkAdress)
	{
		this.parkAddress = parkAdress;
	}

	public double getParkLng()
	{
		return parkLng;
	}

	public void setParkLng(double parkLng)
	{
		this.parkLng = parkLng;
	}

	public double getParkLati()
	{
		return parkLati;
	}

	public void setParkLati(double parkLati)
	{
		this.parkLati = parkLati;
	}

	public int getBelongCityId()
	{
		return belongCityId;
	}

	public void setBelongCityId(int belongCityId)
	{
		this.belongCityId = belongCityId;
	}

	public String getParkOpenTime()
	{
		return parkOpenTime;
	}

	public void setParkOpenTime(String parkOpenTime)
	{
		this.parkOpenTime = parkOpenTime;
	}

	public String getParkTicket()
	{
		return parkTicket;
	}

	public void setParkTicket(String parkTicket)
	{
		this.parkTicket = parkTicket;
	}

	public String getParkTrans()
	{
		return parkTrans;
	}

	public void setParkTrans(String parkTrans)
	{
		this.parkTrans = parkTrans;
	}

	public String getParkIntroduction()
	{
		return parkIntroduction;
	}

	public void setParkIntroduction(String parkIntroduction)
	{
		this.parkIntroduction = parkIntroduction;
	}

	public String getParkPicture()
	{
		return parkPicture;
	}

	public void setParkPicture(String parkPicture)
	{
		this.parkPicture = parkPicture;
	}

	public String getParkDistance()
	{
		return parkDistance;
	}

	public void setParkDistance(String parkDistance)
	{
		this.parkDistance = parkDistance;
	}	
	
	
	
	
}
