package com.u4f.model;
/*
 * 游乐设置
 * 
 */
public class Project
{
	
	public Project()
	{
		super();

	}
	public Project(int projectId)
	{
		super();
		this.projectId = projectId;
	}
	private int projectId;
	private int parkId;
	private String projectCode;
	private String projectName;
	private double projectTime;
	private double projectLng;
	private double projectLati;
	private String projectType;
	private int projectPop;
	private String projectDescribe;
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
	public double getProjectTime()
	{
		return projectTime;
	}
	public void setProjectTime(double projectTime)
	{
		this.projectTime = projectTime;
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
	
}
