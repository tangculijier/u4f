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
import com.u4f.tools.MyConst;

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
		
		int	userId=request.getParameter("userId") == null ? MyConst.USERID_DEFAULT  : Integer.parseInt(request.getParameter("userId"));
		int	sceneryId=request.getParameter("sceneryId") == null ? 1 : Integer.parseInt(request.getParameter("sceneryId"));
		double  longtitude=request.getParameter("longtitude") == null? 0 :Double.parseDouble(request.getParameter("longtitude"));
	    double  latitude=request.getParameter("latitude") == null? 0 :Double.parseDouble(request.getParameter("latitude"));

		SignatureDao dao=new SignatureDao();
		
		/*
		 *  0是已经签到 1是成功签到 2是签到失败 3是距离太远
		 */
		int res = 2;
		// 判断用户是否已经签到
		if (dao.isSigned(userId, sceneryId))
		{
			// 用户已经签到
			res = 0;

		} else
		{

			if (dao.isInSignScope(longtitude, latitude, sceneryId))
			{
				System.out.println("servlet: 签到范围内");
				Signature s = new Signature();
				s.setSceneryId(sceneryId);
				s.setUserId(userId);
				s.setSignatureLng(longtitude);
				s.setSignatureLati(latitude);
				s.setSignatureTime(DateUtil.getNowTime());

				if (dao.insertIntoSignature(s))
				{
					res = 1; // 成功签到
				} else
				{
					res = 2;
				}
			}
			else
			{
				res = 3;
			}
		}
		System.out.print(res);
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
