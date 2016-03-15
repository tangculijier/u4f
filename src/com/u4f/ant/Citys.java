package com.u4f.ant;

import java.util.List;

import com.u4f.model.Project;
import com.u4f.tools.MapDistance;


/**
 * ≥« –¿‡
 */
public class Citys {

	private List<Project> projects;
	private int[][] distance ;

	public Citys(List<Project> projects)
	{
		this.projects = projects;
		distance = new int[projects.size()][projects.size()];
	}
	public void initDis() 
	{
		for(int i = 0 ; i < projects.size() ;i++)
		{
			for(int j = 0 ; j < projects.size() ;j++)
			{
				Project p1 = projects.get(i);
				Project p2 = projects.get(j);

				distance[i][j] = distance[j][i] = 
					MapDistance.getDistanceByM(p1.getProjectLati(),p1.getProjectLng(),p2.getProjectLati(),p2.getProjectLng());
			}
		
		}
	}
		
	public int[][] getDistance() {
		return distance;
	}
	
	
	public List<Project> getProjects()
	{
		return projects;
	}

	public void setProjects(List<Project> projects)
	{
		this.projects = projects;
	}
	public  void printSimMaxtri(String[] paths,int[][] distance2)
	{
		System.out.println("æ‡¿Îæÿ’Û");
		System.out.print("    ");
		for(int i = 0 ; i < paths.length;i++)
		{
			System.out.print("\t"+paths[i]);
		}
		System.out.println("");
		for(int i = 0 ; i < distance2.length;i++)
		{
			System.out.print(paths[i]);
			for(int j = 0;j < distance2[i].length;j++)
			{
				System.out.print("\t"+distance2[i][j]);
			}
			System.out.println();

		}
	}
}
