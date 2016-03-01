package com.u4f.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.u4f.dao.DBTools;
import com.u4f.model.Cluster;
import com.u4f.model.Project;

public class GetPathCluster extends HttpServlet
{

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		int parkId = Integer.parseInt(request.getParameter("parkId"));
		DBTools db = new DBTools();
		//得到聚类路线
		List<Cluster> listCluster = db.getParkClusterPaths(13);
		//得到所有该公园的所有项目
		List<Project> allProject = db.getAllProject(13);
		for(Cluster c:listCluster)
		{
			List<Project> walkProjects = new ArrayList<Project>();
			//循环这个路径表示  如果有1则把allProject的第i个加进路径
			char[] pathChar = c.getPlayPathStr().toCharArray();//getPlayPathStr是诸如0000101010
			for(int i = 0 ;i < pathChar.length;i++)
			{
				if(pathChar[i] == '1')
				{
					walkProjects.add(allProject.get(i));
				}
			}
			c.setPlayProject(walkProjects);
		}
		JSONArray array = JSONArray.fromObject(listCluster);
		if(array.size()!=0)
		{
			out.print(array);
		}
		out.flush();
		out.close();
	}
	 public  static void main(String[] args)  
	    {  
		 
	    }

}
