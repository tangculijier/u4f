package com.u4f.dao;

import java.util.List;

import com.u4f.model.Project;
import com.u4f.model.Park;
import com.u4f.model.Signature;
import com.u4f.model.SignedSpot;

public class SignatureDao
{

	public boolean isInSignScope(double longtitude, double latitude,
			int sceneryId)
	{
		
		return DBTools.isInSignScope(longtitude,latitude,sceneryId);
	}

 public boolean insertIntoSignature(Signature s){
	 
	 return DBTools.insertIntoSignature(s);
 }

public List<SignedSpot> getMySignedPark(int userId)
{
	
	return DBTools.FindMySignedPark(userId);
}

public List<Project> getMySignedProjects(int userId,int projectId)
{
	// TODO Auto-generated method stub
	return DBTools.FindMySignedProject(userId,projectId);
}

public boolean isSigned(int userId, int projectId)
{
	
	return DBTools.isSigned(userId,projectId);
}
	
}
