package com.u4f.dao;

import java.util.List;

import com.u4f.model.Project;

public class SceneryDao
{

	 public List<Project> findAllScenery(int scenerySpotId){
		
		 return DBTools.findAllProject(scenerySpotId);
	 }
}
