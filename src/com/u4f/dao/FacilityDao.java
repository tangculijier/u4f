package com.u4f.dao;

import java.util.ArrayList;
import java.util.List;

import com.u4f.model.Facility;

public class FacilityDao
{

	public List<Facility> findFacilitys(int scenerySpotId,int type){
		List<Facility> facilities=new ArrayList<Facility>();
		 facilities=DBTools.findFacilitys(scenerySpotId,type);
		 return facilities;
	}
}
