package com.u4f.dao;

import java.util.List;

import com.u4f.model.Scenery;

public class SceneryDao
{

	 public List<Scenery> findAllScenery(int scenerySpotId){
		
		 return DBTools.findAllScenery(scenerySpotId);
	 }
}
