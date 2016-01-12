package com.u4f.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.u4f.dao.TravelNoteDao;
import com.u4f.model.TravelNote;
import com.u4f.model.User;

public class UploadTravelNote extends HttpServlet
{

	
	public UploadTravelNote()
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int scenerySpotId = 0;
		if (request.getParameter("scenerySpotId") != null)
			scenerySpotId = Integer.parseInt(request
					.getParameter("scenerySpotId"));

		int userId = 0;
		if (request.getParameter("userId") != null)
		{
			userId = Integer.parseInt(request.getParameter("userId"));
		}
		System.out.println("userId:"+userId);
		String travelNoteContent = request.getParameter("travelNoteContent");
		System.out.println("travelNoteContent:"+travelNoteContent);
		
		//List<String> travelNotePhotos = request.getParameter("travelNotePhotos");
		
		Timestamp publicTime =(Timestamp)request.getSession().getAttribute("publicTime");
		System.out.println("publicTime:"+publicTime);
       String travelNoteTitle=request.getParameter("travelNoteTitle");
       
		TravelNoteDao dao = new TravelNoteDao();
		TravelNote note = new TravelNote();
		note.setUserId(userId);
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
		note.setPublicTime(format.format(publicTime));
		note.setScenerySpotId(scenerySpotId);
		note.setTravelNoteContent(travelNoteContent);
		note.setTravelNoteTitle(travelNoteTitle);
		
		//User user = new User();
		// 查找user相关信息

		//user = dao.findUserById(userId);
System.out.println(note.getUserId()+","+note.getPublicTime()+","+note.getScenerySpotId()+","+note.getTravelNoteContent()+
		","+note.getTravelNoteTitle());
		dao.uploadTravelNote(note);

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
