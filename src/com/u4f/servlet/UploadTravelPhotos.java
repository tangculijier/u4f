package com.u4f.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
   
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class UploadTravelPhotos extends HttpServlet
{

	
	public UploadTravelPhotos()
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

		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		// 为解析类提供配置信息
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 创建解析类的实例
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// 开始解析
		sfu.setFileSizeMax(1024 * 400);
		// 每个表单域中数据会封装到一个对应的FileItem对象上
		try
		{
			List<FileItem> items = sfu.parseRequest(request);
			// 区分表单域
			for (int i = 0; i < items.size(); i++)
			{
				FileItem item = items.get(i);
				// isFormField为true，表示这不是文件上传表单域
				if (!item.isFormField())
				{
					ServletContext sctx = getServletContext();
					// 获得存放文件的物理路径
					// upload下的某个文件夹 得到当前在线的用户 找到对应的文件夹

					String path = sctx.getRealPath("/upload");
					System.out.println(path);
					// 获得文件名
					String fileName = item.getName();
					System.out.println(fileName);
					// 该方法在某些平台(操作系统),会返回路径+文件名
					fileName = fileName
							.substring(fileName.lastIndexOf("/") + 1);
					File file = new File(path + "\\" + fileName);
					if (!file.exists())
					{
						item.write(file);
						// 将上传图片的名字记录到数据库中

						//response.sendRedirect("/ok.html");
						System.out.println("ok");
					}
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		out.flush();
		out.close();
	}

	public void init() throws ServletException
	{
		// Put your code here
	}

}
