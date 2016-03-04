package com.u4f.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.u4f.dao.ParkDao;
import com.u4f.model.Park;

public class GetAroundServlet extends HttpServlet {

	
	public GetAroundServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		System.out.println("ok");
		double myLati=Double.parseDouble(request.getParameter("latitude"));
		double myLng=Double.parseDouble(request.getParameter("longtitude"));
		String date = request.getParameter("date");
		
		List<Park> list=new ArrayList<Park>();
		
		ParkDao dao=new ParkDao();
		//list=dao.getNearScenerySpot(myLng,myLati);
		list=dao.getNearScenerySpotDao(myLati,myLng,date);
		//list=dao.getAllScenerySpot();
	
		JSONArray array = JSONArray.fromObject(list);
//		for(int i=0;i<list.size();i++){
//			//System.out.println(list.get(i));
//		}
		if(array.size()!=0){
			out.print(array);
		}
		out.flush();
		out.close();

	}

	
	
	public void init() throws ServletException {
		// Put your code here
	}

}
