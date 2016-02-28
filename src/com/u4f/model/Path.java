package com.u4f.model;

public class Path
{
	private int pathId;
	private int pathFrom;
	private int pathTo;
	public Path(int pathId, int pathFrom, int pathTo)
	{
		super();
		this.pathId = pathId;
		this.pathFrom = pathFrom;
		this.pathTo = pathTo;
	}
	public int getPathId()
	{
		return pathId;
	}
	public void setPathId(int pathId)
	{
		this.pathId = pathId;
	}
	public int getPathFrom()
	{
		return pathFrom;
	}
	public void setPathFrom(int pathFrom)
	{
		this.pathFrom = pathFrom;
	}
	public int getPathTo()
	{
		return pathTo;
	}
	public void setPathTo(int pathTo)
	{
		this.pathTo = pathTo;
	}

	
}
