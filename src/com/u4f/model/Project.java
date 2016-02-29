package com.u4f.model;
/*
 * 游乐设置
 * 
 */
public class Project
{
	
	
	private int projectId;
	private int parkId;
	private String projectCode;
	private String projectName;
	private int projectStayTime;
	private double projectLng;
	private double projectLati;
	private String projectType;
	private int projectPop;
	private String projectDescribe;
	private String projectOpenTime;
	private int parkZoneId; 

	public Project()
	{
		super();

	}
	public Project(int projectId)
	{
		super();
		this.projectId = projectId;
	}
	
	public int getProjectId()
	{
		return projectId;
	}
	public void setProjectId(int projectId)
	{
		this.projectId = projectId;
	}
	public int getParkId()
	{
		return parkId;
	}
	public void setParkId(int parkId)
	{
		this.parkId = parkId;
	}
	public int getProjectStayTime()
	{
		return projectStayTime;
	}
	public void setProjectStayTime(int projectStayTime)
	{
		this.projectStayTime = projectStayTime;
	}
	public String getProjectOpenTime()
	{
		return projectOpenTime;
	}
	public void setProjectOpenTime(String projectOpenTime)
	{
		this.projectOpenTime = projectOpenTime;
	}
	public String getProjectCode()
	{
		return projectCode;
	}
	public void setProjectCode(String projectCode)
	{
		this.projectCode = projectCode;
	}
	public String getProjectName()
	{
		return projectName;
	}
	public void setProjectName(String projectName)
	{
		this.projectName = projectName;
	}
	public double getProjectLng()
	{
		return projectLng;
	}
	public void setProjectLng(double projectLng)
	{
		this.projectLng = projectLng;
	}
	public double getProjectLati()
	{
		return projectLati;
	}
	public void setProjectLati(double projectLati)
	{
		this.projectLati = projectLati;
	}
	public String getProjectType()
	{
		return projectType;
	}
	public void setProjectType(String projectType)
	{
		this.projectType = projectType;
	}
	public int getProjectPop()
	{
		return projectPop;
	}
	public void setProjectPop(int projectPop)
	{
		this.projectPop = projectPop;
	}
	public String getProjectDescribe()
	{
		return projectDescribe;
	}
	public void setProjectDescribe(String projectDescribe)
	{
		this.projectDescribe = projectDescribe;
	}
	
	public int getParkZoneId()
	{
		return parkZoneId;
	}


	public void setParkZoneId(int parkZoneId)
	{
		this.parkZoneId = parkZoneId;
	}
	
}
