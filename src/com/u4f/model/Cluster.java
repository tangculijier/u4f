package com.u4f.model;

import java.util.List;

public class Cluster
{
	/**
	 * 类簇id
	 */
	private int clusterId;
	/**
	 * 聚类中心点的id值
	 */
	private int centerId;
	
	/**
	 * 聚类中心点的id值
	 */
	private String playPathStr;
	

	/**
	 * 类簇的数量
	 */
	private int clusterNumber;
	/**
	 * 根据聚类中心点的id值恢复出来的游玩项目路径
	 */
	private List<Project> playProject;
	
	private int parkId;
	public int getParkId()
	{
		return parkId;
	}
	public void setParkId(int parkId)
	{
		this.parkId = parkId;
	}
	public int getClusterId()
	{
		return clusterId;
	}
	public void setClusterId(int clusterId)
	{
		this.clusterId = clusterId;
	}
	public int getCenterId()
	{
		return centerId;
	}
	public void setCenterId(int centerId)
	{
		this.centerId = centerId;
	}
	public int getClusterNumber()
	{
		return clusterNumber;
	}
	public void setClusterNumber(int clusterNumber)
	{
		this.clusterNumber = clusterNumber;
	}
	public List<Project> getPlayProject()
	{
		return playProject;
	}
	public void setPlayProject(List<Project> playProject)
	{
		this.playProject = playProject;
	}
	public String getPlayPathStr()
	{
		return playPathStr;
	}
	public void setPlayPathStr(String playPathStr)
	{
		this.playPathStr = playPathStr;
	}
	
}
