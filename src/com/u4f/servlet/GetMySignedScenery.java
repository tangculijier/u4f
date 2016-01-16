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
import com.u4f.model.Scenery;
import com.u4f.model.ScenerySpot;
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
		int userId=0;
		if(request.getParameter("userId")!=null)
			userId=Integer.parseInt(request.getParameter("userId"));
		int scenerySpotId=0;
		if(request.getParameter("scenerySpotId")!=null)
			scenerySpotId=Integer.parseInt(request.getParameter("scenerySpotId"));
		SignatureDao dao=new SignatureDao();
		List<Scenery> list=new ArrayList<Scenery>();
		list=dao.getMySignedScenery(userId,scenerySpotId);
		JSONArray array = JSONArray.fromObject(list);
		System.out.println(list);
		if(array.size()!=0){
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
