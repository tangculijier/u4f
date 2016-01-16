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

import com.u4f.dao.SceneryDao;
import com.u4f.model.Scenery;

public class GetAllSceneryByScenerySpotId extends HttpServlet
{

	/**
	 * Constructor of the object.
	 */
	public GetAllSceneryByScenerySpotId()
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
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		int scenerySpotId=0;
		if(request.getParameter("scenerySpotId")!=null){
			scenerySpotId=Integer.parseInt(request.getParameter("scenerySpotId"));
		}
		SceneryDao dao=new SceneryDao();
		List<Scenery> ss=new ArrayList<Scenery>();
		ss=dao.findAllScenery(scenerySpotId);
		JSONArray array = JSONArray.fromObject(ss);
		if(array.size()!=0){
			out.print(array);
		}
		//out.print(ss);
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException
	{
		// Put your code here
	}

}
