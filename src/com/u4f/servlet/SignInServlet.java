package com.u4f.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.u4f.dao.SignatureDao;
import com.u4f.model.Signature;
import com.u4f.tools.DateUtil;

public class SignInServlet extends HttpServlet
{

	
	public SignInServlet()
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("");
		int userId=0;
		if(request.getParameter("userId")!=null)
			userId=Integer.parseInt(request.getParameter("userId"));
	    int sceneryId=0;
	    if(request.getParameter("sceneryId")!=null)
		sceneryId=Integer.parseInt(request.getParameter("sceneryId"));
		
	    double longtitude=0;
	    if(request.getParameter("longtitude")!=null)
	    longtitude=Double.parseDouble(request.getParameter("longtitude"));
	    
	    double latitude=0;
	    if(request.getParameter("latitude")!=null)
        latitude=Double.parseDouble(request.getParameter("latitude"));
		
		
		SignatureDao dao=new SignatureDao();
		boolean res=false;
		if(dao.isInSignScope(longtitude,latitude,sceneryId)){
			System.out.println("servlet: 签到范围内");
			Signature s=new Signature();
			s.setSceneryId(sceneryId);
			s.setUserId(userId);
			s.setSignatureLng(longtitude);
			s.setSignatureLati(latitude);
			s.setSignatureTime(DateUtil.getNowTime());

			res=dao.insertIntoSignature(s);
		}
		out.print(res);
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
