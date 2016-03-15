package com.u4f.path.plan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.u4f.dao.DBTools;
import com.u4f.model.Path;
import com.u4f.model.Project;

public class PlanBy01Package
{

	
	public  List<Project> getsovle(String startTime, int playTime, int parkId)
	{
		DBTools db = new DBTools();
		List<Project> projects = new ArrayList<Project>();
		//projects.add(new Project());
		projects.addAll(db.findAllProject(13));
//		List<Path> paths = db.findAllPaths(13);
//		int[][] matrix = makeMatrix(projects, paths);
//		System.out.println("---------------");
		
		List<Project> result = this.Knapsack(projects, playTime);
		for(Project p :result)
		{
			System.out.print(p.getProjectName()+" ");
		}
		System.out.println();
		System.out.println("可以玩"+result.size());
		return result;
	}
	
	public  List<Project> Knapsack(List<Project> projects,int playTime)
	{
		int maxWeight = playTime;
		int n = projects.size();
		int[][] dp = new int[n][maxWeight+1];//第一行与第一列初始化都为0
		int maxValue  = 0 ;
		int maxX = 0;
		int maxY = 0;
		for(int i  = 1 ; i < n;i++)
		{
			Project p = projects.get(i);
			int pWeight = p.getProjectStayTime();//项目的weight即就是他的消耗时间
			for(int w = 1 ; w <= maxWeight ;w++)//w为当前的时间
			{
				if(pWeight > w)//如果这个项目的weight 大于当前 w
				{
					dp[i][w] = dp[i-1][w];//它就等于前一个的value
				}
				else
				{
					//动态规划
					dp[i][w] = Math.max(dp[i-1][w - pWeight] + p.getProjectPop(),  dp[i-1][w]);
				}
				if(dp[i][w] > maxValue)//找出最大值
				{
					maxValue = dp[i][w] ; 
					maxX = i ;//记录最大值下标
					maxY = w;
//					System.out.print("max="+maxValue+" i="+i+" w="+w);
				}

			}
		}
//		printPackage(projects,dp);
		System.out.println("maxValue="+maxValue);
		return findPath(projects, dp, maxX, maxY);//找出点并且返回点
		
	}
	
	public List<Project> findPath(List<Project> projects,int[][] dp,int maxX,int maxY)
	{
		List<Project> result = new ArrayList<Project>();
		result.add(projects.get(0));//添加入口
		int[] x = new int[dp.length];
		for(int i  = maxX ; i > 0 ;i--)
		{
			if(dp[i][maxY] == dp[i-1][maxY] )//说明dp[maxX]它的重量没有被算进去
			{
				x[i] = 0;
			}
			else
			{
				x[i] = 1;
				result.add(projects.get(i));
				maxY -= projects.get(i).getProjectStayTime();
			}
		}
		System.out.println("x="+Arrays.toString(x));
		return result;
		
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
