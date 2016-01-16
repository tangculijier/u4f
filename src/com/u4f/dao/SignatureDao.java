package com.u4f.dao;

import java.util.List;

import com.u4f.model.Scenery;
import com.u4f.model.ScenerySpot;
import com.u4f.model.Signature;

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

public List<ScenerySpot> getMySignedScenerySpot(int userId)
{
	
	return DBTools.FindMySignedScenerySpot(userId);
}

public List<Scenery> getMySignedScenery(int userId,int scenerySpotId)
{
	// TODO Auto-generated method stub
	return DBTools.FindMySignedScenery(userId,scenerySpotId);
}

public boolean isSigned(int userId, int sceneryId)
{
	
	return DBTools.isSigned(userId,sceneryId);
}
	
}
