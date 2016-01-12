package com.u4f.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.u4f.dao.FacilityDao;
import com.u4f.model.Facility;

public class FindFacility extends HttpServlet
{

	public FindFacility()
	{
		super();
	}

	
	public void destroy()
	{
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		int scenerySpotId=0;
		if(request.getParameter("scenerySpotId")!=null)
		    scenerySpotId=Integer.parseInt(request.getParameter("scenerySpotId"));
		int facilityType=0;
		if(request.getParameter("facilityType")!=null)
		    facilityType=Integer.parseInt(request.getParameter("facilityType"));
		FacilityDao dao=new FacilityDao();
		List<Facility> facilities=dao.findFacilitys(scenerySpotId, facilityType);
		JSONArray array = JSONArray.fromObject(facilities);
		System.out.println(facilities);
		if(array.size()!=0){
			out.print(array);
		}
		out.flush();
		out.close();
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

	}

	
	public void init() throws ServletException
	{
		// Put your code here
	}

}
