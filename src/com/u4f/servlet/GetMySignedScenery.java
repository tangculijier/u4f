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

import com.u4f.dao.SignatureDao;
import com.u4f.model.Project;
import com.u4f.model.Park;
import com.u4f.tools.MyConst;
/*
 * 得到用户签到过的所有小景点
 */
public class GetMySignedScenery extends HttpServlet
{

	/**
	 * Constructor of the object.
	 */
	public GetMySignedScenery()
	{
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy()
	{
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int	userId=request.getParameter("userId") == null ? MyConst.USERID_DEFAULT  : Integer.parseInt(request.getParameter("userId"));
		int	projectId=request.getParameter("scenerySpotId") == null ? 1 : Integer.parseInt(request.getParameter("scenerySpotId"));
		SignatureDao dao=new SignatureDao();
		List<Project> list=new ArrayList<Project>();
		list=dao.getMySignedProjects(userId, projectId);
		JSONArray array = JSONArray.fromObject(list);
		for(Project p :list)
		{
			System.out.print(p.getProjectId()+" ");
		}
		if(array.size()!=0)
		{
			out.print(array);
		}
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException
	{
		// Put your code here
	}

}
