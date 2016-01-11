package com.u4f.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;


import com.u4f.dao.TravelNoteDao;
import com.u4f.model.TravelNote;

public class GetTravelNote extends HttpServlet
{

	
	public GetTravelNote()
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

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int scenerySpotId=Integer.parseInt(request.getParameter("scenerySpotId"));
		TravelNoteDao dao=new TravelNoteDao();
		List<TravelNote> notes=dao.getTravelNoteDao(scenerySpotId);
		JSONArray array = JSONArray.fromObject(notes);
		for(int i=0;i<notes.size();i++)
		{
			System.out.println(notes.get(i).getTravelNoteId()+"....."+notes.get(i).getTravelNoteTitle()+"....."+notes.get(i).getTravelNoteContent());
		}
		if(array.size()!=0)
		{
			out.print(array);
		}
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		
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
