package com.huang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.u4f.dao.DBTools;
import com.u4f.dao.SignatureDao;
import com.u4f.model.Cluster;
import com.u4f.model.Project;

public class GetSimUtil
{
	public static void main(String[] args)
	{
//		float len = samePathPercent("abcdfhjkeilmy", "opquvrtcdwxilzn");
//		System.out.println("青春-合家欢"+len);
//		float len1 = samePathPercent("abcdfhjkeilmy", "prsbcdfhklzym");
//		System.out.println("青春-情侣"+len1);
//		float len3 = samePathPercent("abcdfhjkeilmy", "oquvrstcwxln");
//		System.out.println("青春-合家欢"+len3);
		
		//String[] path1 = {"bcdefg","hijkqg","xlmopg","hijdefg","bcdjkqg","lxmondefg","hijdefgpomxl","lxmondjih","bcdjnopg","bcdefgpomxl"};
		//String[] path2 = {"bcdjkqg","hijkqg","lxmondefg","hijdefg","bcdefg","xlmopg","hijdefgpomxl","lxmondjih","bcdjnopg","bcdefgpomxl"};
		String[] test = {"110","011"};
		printSimMaxtri(test);
		DBTools db = new DBTools();
		
		SignatureDao dao=new SignatureDao();
		List<Project> list=new ArrayList<Project>();
		list=dao.getMySignedProjects(2, 13);
		for(Project p : list)
		{
			System.out.print(p.getProjectName()+"-");
		}
		System.out.println();
		List<Project> allProject = db.getAllProject(13);
		for(Project p : allProject)
		{
			System.out.print(p.getProjectName()+"-");
		}
		System.out.println();
		System.out.println(to01String(list,allProject));
	
	}

	/**
	 * 
	 * @param ProjectsPath 路径项目集合
	 * @param allProject 所有该公园的所有项目
	 */
	public static String to01String(List<Project> ProjectsPath,List<Project> allProject)
	{
		StringBuffer sb = new StringBuffer(256);
		int i = 0;//用来循环所有项目的指针
		int j = 0;//用来循环路径的指针 
		while(i < allProject.size() )
		{
			Project p  = allProject.get(i);
			Project pathBy = ProjectsPath.get(j);
			if(p.getProjectId() == pathBy.getProjectId())
			{
				sb.append("1");
				j++;
			}
			else
			{
				sb.append("0");
			}
			i++;
		}
		return sb.toString();
	}
	
	


	public static float GetJaccardSimilarity(String path1, String path2) 
	{
		if(path1.length() != path2.length())
		{
			return 0f;//不是同一个公园的路径则无法比较
		}
		int projectsLegth = path1.length();//公园总项目数 杰卡德系数的并集
		int M11 = 0;//path1与path2都是1的维度的个数
		int M10 = 0;//path1是1，path2是0 的维度的个数
		int M01 = 0;//path1是0，path2是1的维度的个数
		for(int i = 0 ;i < projectsLegth;i++)
		{
			char ch1 = path1.charAt(i);
			char ch2 = path2.charAt(i);
			if(ch1 == '1' && ch2 == '1')//如果同时为1则说明都走过这条路 
			{
				M11++;
			}
			else if(ch1 == '1' && ch2 == '0')//如果同时为1则说明都走过这条路 
			{
				M10++;
			}
			else if(ch1 == '0' && ch2 == '1')//如果同时为1则说明都走过这条路 
			{
				M01++;
			}
		}
		
		float res = (float)M11 / (float)(M11+M10+M01);//最后的相似度
		return res;
		
		}
	
	public static void printSimMaxtri(String[] paths)
	{
		System.out.println("相似度矩阵");
		System.out.print("    ");
		for(int i = 0 ; i < paths.length;i++)
		{
			System.out.print("\t"+paths[i]);
		}
		System.out.println("");
		for(int i = 0 ; i < paths.length;i++)
		{
			System.out.print(paths[i]);
			float sum = 0f;
			for(int j = 0;j < paths.length;j++)
			{
				float sim = GetJaccardSimilarity(paths[i], paths[j]);
				sum = (float) MyMath.add(sum, sim);
				System.out.print("\t"+sim);
			}
			System.out.print("  sum="+sum);
			System.out.println();

		}
	}

}
