package com.u4f.model;

public class Route {

	String path;
	int sumScore;
	public Route(String path, int sumScore) {
		super();
		this.path = path;
		this.sumScore = sumScore;
	}
	
	public String getPath()
	{
		return path;
	}
	public void setPath(String path)
	{
		this.path = path;
	}
	public int getSumScore()
	{
		return sumScore;
	}
	public void setSumScore(int sumScore)
	{
		this.sumScore = sumScore;
	}
}
