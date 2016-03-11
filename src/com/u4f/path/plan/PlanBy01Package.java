package com.u4f.path.plan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.u4f.dao.DBTools;
import com.u4f.model.Path;
import com.u4f.model.Project;

public class PlanBy01Package
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		PlanBy01Package p  = new PlanBy01Package();
		p.getsovle("11:00:00",60,13);

	}
	
	public  void getsovle(String startTime, int playTime, int parkId)
	{
		DBTools db = new DBTools();
		List<Project> projects = new ArrayList<Project>();
		projects.add(new Project());
		projects.addAll(db.findAllProject(13));
		List<Path> paths = db.findAllPaths(13);
		int[][] matrix = makeMatrix(projects, paths);
		System.out.println("---------------");
		this.Knapsack(projects, playTime);
//		List<Project> result = 
//		for(Project p :result)
//		{
//			System.out.print(p.getProjectCode()+" ");
//		}
//		return result;
	}
	
	public  void Knapsack(List<Project> projects,int playTime)
	{
		//List<Project> result = new ArrayList<Project>();
		int maxWeight = playTime;
		int n = projects.size();
		int[][] dp = new int[n][maxWeight+1];//第一行与第一列初始化都为0
		int maxValue  = 0 ;
		
		for(int i  = 1 ; i < n;i++)
		{
			Project p = projects.get(i);
			int pWeight = p.getProjectStayTime();//项目的weight即就是他的消耗时间
			for(int w = 1 ; w <= maxWeight ;w++)//w为当前的时间
			{
				HashSet<Project> set = new HashSet<Project>();
				if(pWeight > w)
				{
					dp[i][w] = dp[i-1][w];//它就等于前一个的value
					set.add(projects.get(i-1));
				}
				else
				{
					dp[i][w] = Math.max(dp[i-1][w - pWeight] + p.getProjectPop(),  dp[i-1][w]);
					set.add(projects.get(i));
				}
//				if(dp[i][w] > maxValue)
//				{
//					maxValue = dp[i][w] ; 
//				}
//				else if (dp[i][w] < maxValue)
//				{ 
//					set.clear();
//				}
				System.out.print("dp[i][w]="+dp[i][w]);
				for(Project p2 :set)
				{
					System.out.print(p2.getProjectCode()+" ");
				}
				System.out.println();
				
			}
		}
		printPackage(projects,dp);
		System.out.println("maxValue="+maxValue);
//		return projects;
//		for(Project p :set)
//		{
//			System.out.println(p.getProjectCode()+" ");
//		}
		
	}
	
	public static void printPackage(List<Project> projects, int[][] dp)
	{
		System.out.print("   ");
		for(int i = 0; i < dp[0].length;i++)
		{
			if(i < 10)
			{
				System.out.print("0"+i+" ");
			}
			else
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i = 0; i < dp.length;i++)
		{
			//System.out.println("i="+i);
			System.out.print(projects.get(i).getProjectCode()+" ");

			for(int j = 0 ; j < dp[i].length;j++)
			{
			
				System.out.print(dp[i][j]+"  ");
			}
			System.out.println();
		}
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
}
