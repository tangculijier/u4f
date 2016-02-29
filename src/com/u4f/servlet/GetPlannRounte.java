package com.u4f.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.u4f.dao.PlanningDao;
import com.u4f.model.Project;

public class GetPlannRounte extends HttpServlet
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
	
		String startTime = request.getParameter("startTime");
		int playTime = Integer.parseInt(request.getParameter("playTime"));
		int parkId = Integer.parseInt(request.getParameter("parkId"));
		
		System.out.println(" startTime="+startTime +" playTime="+playTime+" parkId="+parkId);
		
		PlanningDao dao = new PlanningDao();
		List<Project> planRounteResult = dao.getPlanningRoute(startTime,playTime,parkId);
		
		out.print("ok");
		out.flush();
		out.close();
	}

}
