package com.u4f.path.plan;

import java.util.List;

import com.u4f.ant.ACO;
import com.u4f.ant.Citys;
import com.u4f.model.Project;

public class PlanController
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		PlanController controller = new PlanController();
		List<Project> planProjects = controller.getSolve("11:00:00",60*5,13);
		ACO aco = new ACO();  
		Citys citys = new Citys(planProjects);
        aco.run(1000,20,citys);  
        aco.ReportResult();  
	}

	public List<Project> getSolve(String startTime, int playTime, int parkId)
	{
		PlanBy01Package p  = new PlanBy01Package();
		return p.getsovle(startTime,playTime,parkId);
	}
}
