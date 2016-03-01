package com.u4f.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.u4f.model.Park;
import com.u4f.model.Path;
import com.u4f.model.Project;
import com.u4f.model.Route;
import com.u4f.path.plan.RounterPlan;
import com.u4f.tools.DateUtil;

public class CopyOfPlanningDao
{
	public static void main(String[] args)
	{
		CopyOfPlanningDao dao = new CopyOfPlanningDao();
		List<Project> planRounteResult = dao.getPlanningRoute("11:00:00",60*8,13);
		//canPlayOverInOpenTime("11:00:00", 61, "11:21:00-12:00:00");
	}
	public static Set<List<Project>> set ;
	public static int out = 0 ;
	/**
	 * 
	 * @param startTime 开始玩的时间 eg:11:21:00
	 * @param playTime 预多久mins eg:339min
	 * @param parkId 哪个公园id玩 eg:13
	 * @return
	 */
	public List<Project> getPlanningRoute(String startTime, int playTime, int parkId)
	{
		DBTools db = new DBTools();
		List<Project> projects = db.findAllProject(parkId);
		List<Path> paths = db.findAllPaths(parkId);
		int[][] matrix = makeMatrix(projects, paths);
		System.out.println("---------------");
		long start=System.currentTimeMillis();   //获取开始时间   
		 
		set = new HashSet<List<Project>>();
		
		List<Project> plannNow = new ArrayList<Project>();
		plannNow.add(projects.get(0));
		this.addNext(startTime,playTime,projects,plannNow,matrix);
		//System.out.println("一共路径"+set.size()+"条");
		 long endTime=System.currentTimeMillis(); //获取结束时间   
		 System.out.println("程序运行时间： "+(endTime-start)/1000/60+"min");
		return null;
		
	}
	
	/**
	 * 
	 * @param startTime 开始玩的时间 比如：12:00:00  动态变化
	 * @param playTime 
	 * @param allProjects 项目集合 不变
	 * @param planningNow 现在已经规划的路线 动态变化
	 * @param matrix 项目路线矩阵 不变
	 * @param islastPlay 
	 */
	public  void addNext(String startTime, int playTime, List<Project> allProjects, List<Project> planningNow,int[][] matrix)
	{
		//获取起始点 比如 "gate"
		Project beginProject = planningNow.get(0);
		Project nowLastProject = planningNow.get(planningNow.size()-1);
		
		List<Project> plannResult = new ArrayList<Project>();
		plannResult.addAll(planningNow);
		
		int begin = getIndex(allProjects,nowLastProject);	
			for(int j = 0 ;j < matrix[begin].length;j++)
			{
				if(matrix[begin][j] == 1 )//如果有路
				{
					Project nextProject = allProjects.get(j);//得到下一个规划的点
					int projectStayMins = nextProject.getProjectStayTime();
					//判断这个是否能在规定时间内玩完
					boolean canPlayOver = canPlayOverInOpenTime(startTime,projectStayMins , nextProject.getProjectOpenTime());
					if(canPlayOver == true && playTime >= 0)
					{
						//System.out.println("playTime="+playTime);
						//这个点和初始点相同则结束
						if(nextProject.getProjectId() == beginProject.getProjectId())
						{
							plannResult.add(nextProject);
							printRounter(plannResult);
							set.add(plannResult);
							plannResult = planningNow;
							continue;
						}//如果这个点是通路但是还没走到 就加进来
						else if(!isContainsProject(planningNow,nextProject))
						{
							List<Project> plannNextVertex = new ArrayList<Project>();
							plannNextVertex.addAll(planningNow);
							nextProject.setPass(false);
							plannNextVertex.add(nextProject);
							String nextStartTime = DateUtil.addMins(DateUtil.StringToDate(DateUtil.getNowTimeWithoutHourAndMin()+startTime),projectStayMins);
							addNext(nextStartTime,playTime -projectStayMins ,allProjects,plannNextVertex,matrix);
							
							List<Project> plannNextVertexNoPlay = new ArrayList<Project>();
							plannNextVertexNoPlay.addAll(planningNow);
							//Project pass = nextProject;
							//pass.setPass(true);
							nextProject.setPass(true);
							plannNextVertexNoPlay.add(nextProject);
							addNext(startTime,playTime ,allProjects,plannNextVertexNoPlay,matrix);

						}
					}
				}
					
			}
		
	}
	
	/**
	 * 
	 * @param startTime 开始玩的时间 比如：11:00:00
	 * @param projectStayTime 玩项目需要的时间: 比如20min
	 * @param projectOpenTime 项目的开放时间 比如：10:00:00-12:00:00
	 * @return 11:00:00加20min是否在12:00:00之前结束
	 */
	public static boolean canPlayOverInOpenTime(String startTime, int projectStayTime,String projectOpenTime)
	{
		
		boolean res = false;
		String[] openTime =projectOpenTime.split("-");//项目开放时间由-间隔开
		//得到的当前的日期 eg：2016-02-29 以便后面与13:21:30这种时间拼凑成Date格式
		String nowTimeStr = DateUtil.getNowTimeWithoutHourAndMin();
		Date open = DateUtil.StringToDate(nowTimeStr+openTime[0]);//项目开始时间
		Date close = DateUtil.StringToDate(nowTimeStr+openTime[1]);//项目结束时间
		
		Date startDate = DateUtil.StringToDate(nowTimeStr+startTime);//开始玩的时间
		String endStr = DateUtil.addMins(startDate, projectStayTime);//开始玩的时间+项目时间 eg：13:21:30
		Date hopeEnd = DateUtil.StringToDate(nowTimeStr+endStr);//期待的结束时间
		//System.out.println("hopeEnd="+hopeEnd);
		
	  	long overTime = DateUtil.MinuteBetween(hopeEnd, close);//期待的结束时间和项目结束时间比较
		//System.out.println("overTime="+overTime);
		if(overTime >= 0)//可以在合理的时间内玩完
		{
			res = true;
		}
		return res;
		  
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
	
	
	private static void printRounter(List<Project> plannRouter)
	{
		System.out.print("path"+(out++)+"=");
		for(Project p:plannRouter)
		{
			System.out.print(p.getProjectCode()+""+p.isPass()+"-");
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
	
}
