package com.u4f.path.plan;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.u4f.dao.DBTools;
import com.u4f.model.Path;
import com.u4f.model.Project;
import com.u4f.model.Route;

public class RounterPlan
{

	public static Set<List<Project>> set ;
	public static void main(String[] args)
	{
		DBTools db = new DBTools();
		List<Project> projects = db.findAllProject(13);
		List<Path> paths = db.findAllPaths(13);
		int[][] matrix = makeMatrix(projects, paths);
		System.out.println("---------------");
		
		RounterPlan test = new RounterPlan();
		
		set = new HashSet<List<Project>>();
		
		List<Route> pathList = new ArrayList<Route>();
		List<Project> plannNow = new ArrayList<Project>();
		plannNow.add(projects.get(0));
		test.addNext(projects,plannNow,matrix);
//		for (String str : set) 
//		{
//			int sum = 0;
//			for(int i =0 ;i <str.length();i++)
//			{
//				char ch = str.charAt(i);
//				switch(ch)
//				{
//					case 'A1':
//						sum+=100;
//						break;
//					case 'B1':
//						sum+=20;
//						break;
//					case 'C1':
//						sum+=30;
//						break;
//					case 'D1':
//						sum+=30;
//						break;
//						default:
//							sum+=50;
//							break;
//				}
//				
//			}
//			pathList.add(new Route(str, sum));
//		     // System.out.println(str+" score="+sum);
//		}
//		Collections.sort(pathList,new Comparator<Route>()
//		{
//
//			public int compare(Route p1, Route p2) 
//			{
//				int p1Score = p1.getSumScore();
//				int p2score = p2.getSumScore();
//				
//				return p1Score > p2score ? -1 : 1;
//			}
//		});
//
//		for (Route p :pathList)
//		{  
//			 System.out.println("Route = " + p.getPath() + ", score = " + p.getSumScore());  
//
//		}

		

	}
	

	public  void addNext(List<Project> allProjects, List<Project> planningNow,int[][] matrix)
	{
		//获取起始点 比如 "gate"
		Project beginProject = planningNow.get(0);
		Project nowLastProject = planningNow.get(planningNow.size()-1);
		
		List<Project> plannResult = new ArrayList<Project>();
		plannResult.addAll(planningNow);
		
		int begin = getIndex(allProjects,nowLastProject);	
			for(int j = 0 ;j < matrix[begin].length;j++)
			{
				if(matrix[begin][j] == 1 )
				{
					Project nextProject = allProjects.get(j);
					//这个点和初始点相同则结束
					if(nextProject.getProjectId() == beginProject.getProjectId())
					{
						plannResult.add(nextProject);
						printRounter(plannResult);
						set.add(plannResult);
						plannResult = planningNow;
						continue;
					}
					else if(!isContainsProject(planningNow,nextProject))
					{
						List<Project> plannNextVertex = new ArrayList<Project>();
						plannNextVertex.addAll(planningNow);
						plannNextVertex.add(nextProject);
						addNext(allProjects,plannNextVertex,matrix);
					}
				}
					
			}
		
	}


	private static void printRounter(List<Project> plannRouter)
	{
		System.out.print("path=");
		for(Project p:plannRouter)
		{
			System.out.print(p.getProjectCode()+"-");
		}
		System.out.println();
	}
	public static int getIndex(List<Project> projects, Project beginProject)
	{
		int index = 0;
		for(int i = 0; i< projects.size();i++)
		{
			if(beginProject.getProjectId() == projects.get(i).getProjectId())
			{
				index = i;
				return index;
			}
		}
		return index;
	}
	
	
	public static int[][] makeMatrix(List<Project> projects,List<Path> paths)
	{
		int[][] matrix = new int[projects.size()][projects.size()];
		System.out.print("   ");
		for(Project p :projects)
		{
			//System.out.println(p.getProjectId()+" code="+p.getProjectCode()+" name="+p.getProjectName()+" time="+p.getProjectTime());
			System.out.print(p.getProjectCode()+" ");
		}
		for(Path p :paths)
		{
			matrix[p.getPathFrom()-1][p.getPathTo()-1] = 1;
			matrix[p.getPathTo()-1][p.getPathFrom()-1] = 1;
			//System.out.println(p.getPathId()+" from="+p.getPathFrom()+" to="+p.getPathTo());
			
		}
		System.out.println();
		
		
		for(int i = 0; i < matrix.length;i++)
		{
			System.out.print(projects.get(i).getProjectCode()+" ");
			for(int j = 0 ; j < matrix[i].length;j++)
			{
			
				System.out.print(matrix[i][j]+"  ");
			}
			System.out.println();
		}
		return matrix;
	}
	
	public static boolean isContainsProject(List<Project> projects,Project target)
	{
		boolean res = false;
		for(Project p :projects)
		{
			if(p.getProjectId() == target.getProjectId())
			{
				res = true;
				return res;
			}
		}
		return res;
		
	}
	
	public static void print(int[][] matrix)
	{
		for(int i = 0; i < matrix.length;i++)
		{

			for(int j = 0 ; j < matrix[i].length;j++)
			{
			
				System.out.print(matrix[i][j]+"  ");
			}
			System.out.println();
		}
	}
	
	
}
