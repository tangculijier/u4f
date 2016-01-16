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
import com.u4f.model.ScenerySpot;
import com.u4f.model.Signature;
import com.u4f.model.SignedSpot;
import com.u4f.tools.MyConst;

public class GetMySignedScenerySpot extends HttpServlet
{

	/**
	 * Constructor of the object.
	 */
	public GetMySignedScenerySpot()
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
		int	userId=request.getParameter("userId") == null ? MyConst.USERID_DEFAULT : Integer.parseInt(request.getParameter("userId"));

		SignatureDao dao=new SignatureDao();
		List<SignedSpot> list=new ArrayList<SignedSpot>();
		list=dao.getMySignedScenerySpot(userId);
		JSONArray array = JSONArray.fromObject(list);
		System.out.println(list);
		if(array.size()!=0)
		{
			out.print(array);
		}
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException
	{
		// Put your code here
	}

}
