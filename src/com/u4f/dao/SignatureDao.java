package com.u4f.dao;

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
	
}
